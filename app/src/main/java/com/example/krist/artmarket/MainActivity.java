package com.example.krist.artmarket;

import android.database.Cursor;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import MenuFragments.ChildCreativity;
import MenuFragments.Frame;
import MenuFragments.HobbiFragment;
import MenuFragments.MainFragment;
import MenuFragments.Sculpture;
import MenuFragments.Zhivop_i_Graphica_Fragment;
import asavin.mvp.App;


public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener,SearchView.OnQueryTextListener {
    private CardView MasterClass;
    private CardView ArtSale;
    RecyclerView recyclerView;
   // android.app.FragmentTransaction fTrans;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        recyclerView = (RecyclerView) findViewById(R.id.hintsRView);
        recyclerView.setHasFixedSize(true);

        LinearLayoutManager verticalLayoutmanager
                = new LinearLayoutManager(MainActivity.this, LinearLayoutManager.VERTICAL, false);

        GridLayoutManager lLayout = new GridLayoutManager(getBaseContext(),2);
        recyclerView.setLayoutManager(verticalLayoutmanager);
//чтобы по-умолчанию запускалась главная страничка
       OpenFragment(new MainFragment());



    }

    //Обработчик события нажатия на CardView на главной странице



    //метод открытия нужного фрагмента

    public void OpenFragment(Fragment f)//на вход как параметр подается название фрагмента (java класса)
    {
        if (f != null) {

            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.content_frame, f).addToBackStack("1").commit();}
    }
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);

        MenuItem menuItemSearch = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView)
                MenuItemCompat.getActionView(menuItemSearch);


//        ((App)getApplicationContext()).getDaoSession().getDatabase().rawQuery("",new String[]{}).get;
        searchView.setOnQueryTextListener(this);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // нажатие на кнопки в тулбаре
        Fragment fragment = null;
        int id = item.getItemId();

        //Корзина (кнопка в тулбаре)
        if (id == R.id.action_settings) {
            OpenFragment(new BasketFull());
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    //нажатие на пункты меню в Navigation Drawer
    public boolean onNavigationItemSelected(MenuItem item) {

        Fragment fragment = null;
        int id = item.getItemId();

        if (id == R.id.nav_main) {
            OpenFragment(new MainFragment());

        } else if (id == R.id.nav_zhivop_graphica) {
            OpenFragment(new Zhivop_i_Graphica_Fragment());

        } else if (id == R.id.nav_hobbi) {
            OpenFragment(new HobbiFragment());

        } else if (id == R.id.nav_child_creativity) {
            OpenFragment(new ChildCreativity());

        } /*else if (id == R.id.nav_creativity_set) {
            OpenFragment(new CreativitySet());

        } */else if (id == R.id.nav_frame) {
            OpenFragment(new Frame());
        } else if (id == R.id.nav_sculpture) {
            OpenFragment(new Sculpture());
        }



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        searchText((newText));
        return false;
    }
    public void searchText(String text){
        if (!text.equals(""))
            recyclerView.setAdapter(new SearchAdapter(this,text));
        else
            recyclerView.setAdapter(null);

    }
}
