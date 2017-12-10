package asavin.mvp.view.fragments;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

/**
 * Created by 1 on 10.12.2017.
 */

public class BrandDialogFilter extends DialogFragment {
    private RecyclerView mRecyclerView;

    public BrandDialogFilter(RecyclerView.Adapter adapter) {
        this.adapter = adapter;
    }

    RecyclerView.Adapter adapter;


    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) { 
        mRecyclerView = new RecyclerView(getContext());
        // you can use LayoutInflater.from(getContext()).inflate(...) if you have xml layout
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecyclerView.setAdapter(adapter);
        return new AlertDialog.Builder(getActivity())
                .setTitle("Filter")
                .setView(mRecyclerView)
                .setPositiveButton(android.R.string.ok,
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int whichButton) {
                                dismiss();
                            }
                        }
                ).create();
    }
}