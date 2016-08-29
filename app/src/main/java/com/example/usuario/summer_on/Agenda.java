package com.example.usuario.summer_on;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

/**
 * Created by Usuario on 22/08/2016.
 */
public class Agenda extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

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

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_marcar) {
            Intent intent = new Intent(this,MarcarHorario.class);
            startActivity(intent);
            // Handle the camera action
        } else if (id == R.id.nav_agenda) {
            Intent intent1 = new Intent(this,Agenda.class);
            startActivity(intent1);
        } else if (id == R.id.nav_promocoes) {
            Intent intent2 = new Intent(this,Promocoes.class);
            startActivity(intent2);
        } else if (id == R.id.nav_sobre) {
            Intent intent3 = new Intent(this,QuemSomos.class);
            startActivity(intent3);
        } else if (id == R.id.nav_settings) {
            Intent intent4 = new Intent(this,Configuracoes.class);
            startActivity(intent4);
        } else if (id == R.id.nav_share) {
            Intent intent5 = new Intent(Intent.ACTION_SEND);
            intent5.setType("text/plain");
            intent5.putExtra(Intent.EXTRA_TEXT, "https://m.facebook.com/summer4on/");
            startActivity(intent5);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
