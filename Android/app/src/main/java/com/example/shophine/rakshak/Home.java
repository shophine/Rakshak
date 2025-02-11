package com.example.shophine.rakshak;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.VolleyError;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Home extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener{
    TextView textView, predictedPrice;
    ProgressDialog progressDialog;
    SharedPreferences preferences;
    List<String> cList, coList, rList;
    List<Centres> centresList;
    List<Commodity> commoditiesList;
    List<Region> regionList;
    String date, centre, commodity, price, region, country, centreCategory = "AGARTALA", commodityCategory = "Milk", regionCategory;
    Spinner regionSpinner, commoditySpinner, centerSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

    }

        @Override
        public void onBackPressed () {
            DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
            if (drawer.isDrawerOpen(GravityCompat.START)) {
                drawer.closeDrawer(GravityCompat.START);
            } else {
                super.onBackPressed();
            }
        }

        @Override
        public boolean onCreateOptionsMenu (Menu menu){
            // Inflate the menu; this adds items to the action bar if it is present.
            getMenuInflater().inflate(R.menu.home, menu);
            return true;
        }

        @Override
        public boolean onOptionsItemSelected (MenuItem item){
            // Handle action bar item clicks here. The action bar will
            // automatically handle clicks on the Home/Up button, so long
            // as you specify a parent activity in AndroidManifest.xml.
            int id = item.getItemId();

            //noinspection SimplifiableIfStatement
            if (id == R.id.logout) {
                finish();
            /*return true;*/
            }

            return super.onOptionsItemSelected(item);
        }

        @SuppressWarnings("StatementWithEmptyBody")
        @Override
        public boolean onNavigationItemSelected (MenuItem item){
            // Handle navigation view item clicks here.
            int id = item.getItemId();

            if (id == R.id.cropSuggestion) {

                CropSuggestion cropSuggestion = new CropSuggestion();
                getSupportFragmentManager().beginTransaction().replace(R.id.content, cropSuggestion).commit();

            } else if (id == R.id.cropPrice) {
                CropPrice cropPrice = new CropPrice();
                getSupportFragmentManager().beginTransaction().replace(R.id.content, cropPrice).commit();

            } else if (id == R.id.sowingDate) {
                SowingDate sowingDate = new SowingDate();
                getSupportFragmentManager().beginTransaction().replace(R.id.content, sowingDate).commit();

            } else if (id == R.id.contribute) {
                Contribute contribute = new Contribute();
                getSupportFragmentManager().beginTransaction().replace(R.id.content, contribute).commit();

            } else if (id == R.id.chatbot) {
                Chatbot chatbot = new Chatbot();
                getSupportFragmentManager().beginTransaction().replace(R.id.content, chatbot).commit();

            } else if (id == R.id.nearbyCentre) {
                progressDialog = new ProgressDialog(this);
                progressDialog.setTitle("Fetching data!");
                progressDialog.setMessage("Loading!! Please Wait...");
                progressDialog.show();


                //make api call

                Maps maps = new Maps();


                getSupportFragmentManager().beginTransaction().replace(R.id.content, maps).commit();

            }

            DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
            drawer.closeDrawer(GravityCompat.START);
            return true;
        }
}
