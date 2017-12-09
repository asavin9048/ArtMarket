package asavin.mvp.view.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.widget.ArrayAdapter;

import java.util.List;

/**
 * Created by 1 on 09.12.2017.
 */

public class FilterBrandsAdapter extends ArrayAdapter {

    public FilterBrandsAdapter(@NonNull Context context, int resource, @NonNull List objects) {
        super(context, resource, objects);
    }

}
