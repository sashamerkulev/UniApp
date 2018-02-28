package ru.merkulyevsasha.uniapp.presentation;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.FrameLayout;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import dagger.android.AndroidInjection;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.HasSupportFragmentInjector;
import ru.merkulyevsasha.uniapp.R;
import ru.merkulyevsasha.uniapp.presentation.commons.DrawerToolbarCombinator;
import ru.merkulyevsasha.uniapp.presentation.commons.FragmentHelper;
import ru.merkulyevsasha.uniapp.presentation.commons.FragmentRouter;

public class MainActivity extends AppCompatActivity
        implements FragmentRouter, HasSupportFragmentInjector, DrawerToolbarCombinator,
        NavigationView.OnNavigationItemSelectedListener {

    @Inject DispatchingAndroidInjector<Fragment> fragmentInjector;

    @BindView(R.id.frame_container) FrameLayout fragmentContainer;
    @BindView(R.id.nav_view) NavigationView navigationView;
    @BindView(R.id.drawer_layout) DrawerLayout drawer;

    private Unbinder binder;
    private FragmentHelper fragmentHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        binder = ButterKnife.bind(this);
        navigationView.setNavigationItemSelectedListener(this);

        if (savedInstanceState == null) {
            fragmentHelper = new FragmentHelper(getSupportFragmentManager(), FragmentHelper.NOTICE_TAG);
            fragmentHelper.activateFragmentByTag();
            navigationView.setCheckedItem(R.id.nav_notice);
        }

    }

    @Override
    protected void onDestroy() {
        binder.unbind();
        super.onDestroy();
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        // Handle navigation view item clicks here.
        activateFragment(fragmentHelper.getTagFragmentByMenuItemId(item.getItemId()));
        closeDrawer(() -> drawer.closeDrawer(GravityCompat.START));
        return true;
    }

    @Override
    public AndroidInjector<Fragment> supportFragmentInjector() {
        return fragmentInjector;
    }

    @Override
    public void connectToolbar(Toolbar toolbar) {
        if (toolbar != null) {
            setSupportActionBar(toolbar);
            ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(MainActivity.this, drawer,
                    toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
            drawer.addDrawerListener(toggle);
            toggle.syncState();
        }
    }

    public void activateFragment(String tag) {
        fragmentHelper.activateFragmentByTag(tag, null);
    }

    private void closeDrawer(Runnable runnable) {
        new Handler(getMainLooper()).postDelayed(runnable, 300);
    }
}
