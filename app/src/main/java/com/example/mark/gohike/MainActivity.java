package com.example.mark.gohike;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;

import com.example.mark.gohike.dummy.Path;
import com.example.mark.gohike.dummy.RecyclerViewAdapter;

import java.util.ArrayList;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private RecyclerView mRecyclerView;
    private RecyclerViewAdapter mAdapter;

    private ArrayList getData() {
        ArrayList<Path> paths = new ArrayList<>();

        Path Maliovitsa = new Path();
        Maliovitsa.setName(String.valueOf(R.string.maliovitsa_name));
        Maliovitsa.setRating(R.integer.maliovitsa_rating);
        Maliovitsa.setLength(String.valueOf(R.string.maliovitsa_length));
        Maliovitsa.setDifficulty(String.valueOf(R.string.difficulty_hard));
        paths.add(Maliovitsa);

        Path RilaPath = new Path();
        RilaPath.setName("RilaPath");
        RilaPath.setRating(5);
        RilaPath.setDifficulty(String.valueOf(R.string.difficulty_easy));
        RilaPath.setDescription("Very good path");
        RilaPath.setImage(R.drawable.rila34);
        paths.add(RilaPath);

        Path SevenRilaLakes = new Path();
        SevenRilaLakes.setName("7 Rila lakes");
        SevenRilaLakes.setRating(4.5);
        SevenRilaLakes.setDifficulty("Medium");
        SevenRilaLakes.setDescription("sedem ezera");
        SevenRilaLakes.setImage(R.drawable.sevenlakes);
        paths.add(SevenRilaLakes);



        return paths;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

//paths


        // Get a handle to the RecyclerView.
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerview);
// Create an adapter and supply the data to be displayed.
        mAdapter = new RecyclerViewAdapter(this, getData());
// Connect the adapter with the RecyclerView.
        mRecyclerView.setAdapter(mAdapter);
// Give the RecyclerView a default layout manager.
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

      /*  ListView lv= (ListView) findViewById(R.id.lv);
        ListViewAdapter adapter=new ListViewAdapter(this,getData());
        lv.setAdapter(adapter);
        */
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

    public void startPathActivity(View view) {
        Intent intent = new Intent(this, PathActivity.class);
        startActivity(intent);
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

        if (id == R.id.nav_map) {
            // Handle the camera action
        } else if (id == R.id.nav_recorder) {
            Toast.makeText(this, "nav_recorder", Toast.LENGTH_SHORT).show();
            Log.i("tag", "onNavigationItemSelected: ");

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_profile) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
