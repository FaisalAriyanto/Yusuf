package pkp.mobile.faisal.fabianpos.Activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import pkp.mobile.faisal.fabianpos.FragmentMasters.MasterFloorsFragment;
import pkp.mobile.faisal.fabianpos.FragmentMasters.MasterTablesFragment;
import pkp.mobile.faisal.fabianpos.Fragments.CloseCahsFragment;
import pkp.mobile.faisal.fabianpos.Fragments.GantiPasswordFragment;
import pkp.mobile.faisal.fabianpos.Fragments.MasterDataFragment;
import pkp.mobile.faisal.fabianpos.Fragments.MejaFragment;
import pkp.mobile.faisal.fabianpos.Fragments.OrderFragment;
import pkp.mobile.faisal.fabianpos.Fragments.SyncFragment;
import pkp.mobile.faisal.fabianpos.R;
import pkp.mobile.faisal.fabianpos.Models.TableModel;

public class MainActivityAdmin extends AppCompatActivity
        implements
        NavigationView.OnNavigationItemSelectedListener,
        CloseCahsFragment.OnFragmentInteractionListener,
        GantiPasswordFragment.OnFragmentInteractionListener,
        MasterDataFragment.OnFragmentInteractionListener,
        OrderFragment.OnFragmentInteractionListener,
        SyncFragment.OnFragmentInteractionListener,
        MasterFloorsFragment.OnFragmentInteractionListener,
        MasterTablesFragment.OnFragmentInteractionListener,
        MejaFragment.OnListFragmentInteractionListener{



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_admin);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout_admin);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.content_frame, new MejaFragment())
                .addToBackStack(null)
                .commit();

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout_admin);
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
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        android.support.v4.app.Fragment fragment = null;

        if (id == R.id.nav_order) {
            fragment = new MejaFragment();
        } else if (id == R.id.nav_close_cash) {
            fragment = new CloseCahsFragment();
        } else if (id == R.id.nav_ganti_password) {
            fragment = new GantiPasswordFragment();
        } else if (id == R.id.nav_master) {
            fragment = new MasterDataFragment();
        } else if (id == R.id.nav_sync) {
            fragment = new SyncFragment();
        } else if (id == R.id.nav_logout) {
            finish();
            startActivity(new Intent(getApplicationContext(), LoginActivity.class));
        }

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.content_frame, fragment)
                .addToBackStack(null)
                .commit();


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout_admin);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    @Override
    public void onListFragmentInteraction(TableModel item) {

    }
}
