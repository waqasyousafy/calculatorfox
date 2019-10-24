package com.code4rox.calculatorfox;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.BundleCompat;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.code4rox.calculatorfox.ui.dashboard.DashboardFragment;
import com.code4rox.calculatorfox.ui.home.HomeFragment;
import com.code4rox.calculatorfox.ui.notifications.NotificationsFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class bottom_navigation extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {
    ActionBar abr;
    Bundle bndle = new Bundle();
    public BottomNavigationView navView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_navigation);
        navView = findViewById(R.id.navigation);

        abr = getSupportActionBar();
        if (abr != null) {
            abr.setTitle("Gallery");
        }

        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.faragment_container);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);
        loadFragment(new HomeFragment());
        navView.setOnNavigationItemSelectedListener(this);


    }

    public boolean loadFragment(Fragment fragment) {
        if (fragment != null) {
            bndle.putString("title","Actvity Data");
            fragment.setArguments(bndle);
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.faragment_container, fragment)
                    .commit();
            return true;
        }
        return false;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        Fragment fm = null;

        switch (menuItem.getItemId()) {
            case R.id.navigation_home:
                fm = new HomeFragment();
                if (abr != null) {
                    abr.setTitle("Gallery");
                }
                break;
            case R.id.navigation_dashboard:
                fm = new DashboardFragment();
                if (abr != null) {
                    abr.setTitle("Dashboard");
                }

                break;
            case R.id.navigation_notifications:
                fm = new NotificationsFragment();
                if (abr != null) {
                    abr.setTitle("Notifications");
                }

                break;
        }
        return loadFragment(fm);
    }
}
