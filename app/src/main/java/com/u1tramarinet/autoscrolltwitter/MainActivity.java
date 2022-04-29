package com.u1tramarinet.autoscrolltwitter;

import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.u1tramarinet.autoscrolltwitter.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);

        NavController navController = findNavController();
        appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);

        navController.addOnDestinationChangedListener(new NavController.OnDestinationChangedListener() {
            @Override
            public void onDestinationChanged(
                    @NonNull NavController navController,
                    @NonNull NavDestination navDestination,
                    @Nullable Bundle arguments) {
                boolean showOption = false;
                boolean showFab = false;
                final @IdRes int fabActionId;
//                @DrawableRes int fabIconId = androidx.preference.R.drawable.abc_ic_star_black_16dp;
                if (arguments != null) {
                    showOption = arguments.getBoolean(getString(R.string.argument_show_option), true);
                    showFab = arguments.getBoolean(getString(R.string.argument_show_fab), false);
                    fabActionId = arguments.getInt(getString(R.string.argument_fab_action_id), R.id.action_to_PostFragment);
                } else {
                    fabActionId = R.id.action_to_PostFragment;
                }
                binding.fab.setVisibility((showFab) ? View.VISIBLE : View.GONE);
                binding.fab.setOnClickListener(v -> navController.navigate(fabActionId));
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        NavController navController = findNavController();
        return NavigationUI.onNavDestinationSelected(item, navController)
                || super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = findNavController();
        return NavigationUI.navigateUp(navController, appBarConfiguration)
                || super.onSupportNavigateUp();
    }

    private NavController findNavController() {
        return Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
    }
}