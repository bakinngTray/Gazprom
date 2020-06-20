package com.example.gazprom;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;
import android.widget.Toolbar;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity
{
    NavigationView nav;
    ActionBarDrawerToggle toggle;
    DrawerLayout drawerLayout;
    Fragment fragment_profile = new Fr_Profile();
    Fragment fragment_create = new Fr_CreateIdea();
    Fragment fragment_notice = new Fr_NoticeIdea();
    FragmentTransaction fTr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final androidx.appcompat.widget.Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        nav=(NavigationView)findViewById(R.id.nav_menu);
        drawerLayout=(DrawerLayout)findViewById(R.id.drawer);

        toggle=new ActionBarDrawerToggle(this, drawerLayout,toolbar, R.string.Open, R.string.Close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        nav.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem)
            {
                fTr = getSupportFragmentManager().beginTransaction();

                switch (menuItem.getItemId())
                {
                    case R.id.main_menu_profile:
                        toolbar.setTitle(R.string.menu_profile);
                        fTr.replace(R.id.fr_Main, fragment_profile);
                        fTr.addToBackStack(null);
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                    case R.id.main_menu_create_idea:
                        toolbar.setTitle(R.string.menu_create_idea);
                        fTr.replace(R.id.fr_Main, fragment_create);
                        fTr.addToBackStack(null);
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                    case R.id.main_menu_notice_idea:
                        toolbar.setTitle(R.string.menu_notice_idea);
                        fTr.replace(R.id.fr_Main, fragment_notice);
                        fTr.addToBackStack(null);
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                    case R.id.main_menu_exit:
                        finishAffinity();
                        break;
                }

                fTr.commit();
                return true;
            }
        });

        fTr = getSupportFragmentManager().beginTransaction();

        fTr.add(R.id.fr_Main, fragment_profile).commit();
    }
}