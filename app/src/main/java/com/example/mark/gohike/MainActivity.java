package com.example.mark.gohike;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
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
import android.os.Parcel;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import javax.security.auth.login.LoginException;


public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private static final String TAG = "MainActivity";
    private RecyclerView mRecyclerView;
    private RecyclerViewAdapter mAdapter;
    final ArrayList<Path> paths = new ArrayList<>();

    private ArrayList getData(Context c) {

/*
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference trailsRootRef = database.getReference("trails");

        Path Maliovitsa2 = new Path();
        Maliovitsa2.setName(c.getString(R.string.maliovitsa_name));
        Maliovitsa2.setRating(4.3);
        Maliovitsa2.setLength(35543L);
        Maliovitsa2.setDifficulty(c.getString(R.string.difficulty_hard));
        Maliovitsa2.setImage(R.mipmap.maliovica);

*/
/*
        trailsRootRef.child(Maliovitsa2.getName()).updateChildren(Maliovitsa2.toMap()).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {

            }
        });


        trailsRootRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
               if(dataSnapshot.exists()) {
                   for(DataSnapshot dschild : dataSnapshot.getChildren()) {
                       Path path = dataSnapshot.getValue(Path.class);
                       paths.add(path);
                       Log.i(TAG, "onDataChange: " + dschild.getValue());
                   }
               }
               else {
                   Log.i(TAG, "onDataChange"+ !dataSnapshot.exists());
               }

            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });

*/


        Path Maliovitsa = new Path("Мальовица", String.valueOf(R.string.maliovitsa_description), "Лесен",
                "4.3/5", "8 км", R.mipmap.maliovica);
        paths.add(Maliovitsa);

        Path RilaPath = new Path("Връх Мусала", String.valueOf(R.string.musala_description), "Среден",
        "4.7/5", "14.1 км", R.mipmap.rila34);
        paths.add(RilaPath);

        Path SevenRilaLakes = new Path("Седемте Рилски езера",String.valueOf(R.string.sedemezera_description),
                "Лесен", "3.8/5", "9.5 км", R.mipmap.sevenlakes);
        paths.add(SevenRilaLakes);

        Path GoldenBridges = new Path("Златните мостове", String.valueOf(R.string.zlatnitemostove_description),
                "Лесен", "4.1/5","6.3 км", R.mipmap.goldenbridges);
        paths.add(GoldenBridges);

        return paths;
    }

    private void setNavigationViewListner() {
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getData(getApplicationContext());

//drawerLayout

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);



        // Get a handle to the RecyclerView.
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        // Create an adapter and supply the data to be displayed.
        mAdapter = new RecyclerViewAdapter(this, getData(getApplicationContext()));
        // Connect the adapter with the RecyclerView.
        mRecyclerView.setAdapter(mAdapter);
        // Give the RecyclerView a default layout manager.
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));



        mRecyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(this, mRecyclerView ,new RecyclerItemClickListener.OnItemClickListener() {
                    @Override public void onItemClick(View view, int position) {
                        startPathActivity(view, position);
                    }

                    @Override public void onLongItemClick(View view, int position) {

                    }
                })
        );



/*

        Map<String, Object> map;
        map = new HashMap<>();
        map.put("blalba", "balbal");

        myRef.updateChildren(map, new DatabaseReference.CompletionListener() {
            @Override
            public void onComplete(DatabaseError databaseError, DatabaseReference databaseReference) {

                Log.e(TAG, "test"+databaseError );
            }
        });
*/
/*
        Path RilaPath = new Path();
        RilaPath.setName("Връх Мусала");
        RilaPath.setRating(3.8);
        RilaPath.setDifficulty(getString(R.string.difficulty_medium));
        RilaPath.setLength(5115L);
        RilaPath.setDescription("Very good path");
        RilaPath.setImage(R.mipmap.rila34);
        paths.add(RilaPath);

        Path SevenRilaLakes = new Path();
        SevenRilaLakes.setName("7те Рилски езера");
        SevenRilaLakes.setRating(4.7);
        SevenRilaLakes.setDifficulty(c.getString(R.string.difficulty_easy));
        SevenRilaLakes.setLength(31213L);
        SevenRilaLakes.setDescription("sedem ezera");
        SevenRilaLakes.setImage(R.mipmap.sevenlakes);
        paths.add(SevenRilaLakes);

        Path GoldenBridges = new Path();
        GoldenBridges.setName("Златните мостове");
        GoldenBridges.setRating(4.2);
        GoldenBridges.setLength(3115L);
        GoldenBridges.setDifficulty("Лесна");
        GoldenBridges.setImage(R.mipmap.goldenbridges);
        paths.add(GoldenBridges);

        return paths;
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

    public void startPathActivity(View view, int position) {
        Intent intent = new Intent(this, ScrollingActivity.class);
        intent.putExtra("Path sent", paths.get(position));
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
            Intent i = new Intent(this, MapActivity.class);
            startActivity(i);
            return false;
        } else if (id == R.id.nav_recorder) {
            return false;
        }   else if (id == R.id.nav_profile) {
            return false;
        } else if (id == R.id.nav_share) {
            return false;
        } else if (id == R.id.nav_send) {
            return false;
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
