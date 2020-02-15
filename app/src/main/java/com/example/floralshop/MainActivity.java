package com.example.floralshop;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{


    public DrawerLayout drawerLayout;
    public NavigationView navView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setHomeAsUpIndicator(R.drawable.menu);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        navView = (NavigationView)findViewById(R.id.nav_view);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

        navView.setNavigationItemSelectedListener(this);

    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        Fragment fragment = null;

        switch (menuItem.getItemId()) {
            case R.id.menu_seccion_1:
                fragment = new Perfil();
                //Toast.makeText(this.getApplicationContext(),"Click Perfil",Toast.LENGTH_LONG).show();
                break;
            case R.id.menu_seccion_2:
                fragment = new Pedido();
                Toast.makeText(this.getApplicationContext(),"Click Pedido",Toast.LENGTH_LONG).show();
                break;
        }

        if (fragment!=null){
            getSupportFragmentManager().beginTransaction().replace(R.id.content_frame, fragment).commit();
        }

        getSupportActionBar().setTitle(menuItem.getTitle());
        drawerLayout.closeDrawers();

        return false;
    }
}
