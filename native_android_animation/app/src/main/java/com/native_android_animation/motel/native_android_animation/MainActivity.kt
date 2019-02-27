package com.native_android_animation.motel.native_android_animation

import android.net.Uri
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*
import android.support.v4.app.Fragment


class MainActivity : AppCompatActivity(), AnimationFragment.OnFragmentInteractionListener, SecondFragment.OnFragmentInteractionListener, NavigationView.OnNavigationItemSelectedListener {
    override fun onFragmentInteraction(uri: Uri) {

    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        val toggle = ActionBarDrawerToggle(
                this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

        nav_view.setCheckedItem(R.id.animation_fragment)

        nav_view.setNavigationItemSelectedListener(this)

        val fragmentManager = supportFragmentManager.beginTransaction()

        fragmentManager
                .replace(R.id.main_content_frame, AnimationFragment::class.java.newInstance() as Fragment)
                .commit()

    }


    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        var fragment: Fragment? = null
        var fragmentClass: Class<*>? = null

        when (item.itemId) {
            R.id.animation_fragment -> {
                fragmentClass = AnimationFragment::class.java
            }
            R.id.second_fragment -> {
                fragmentClass = SecondFragment::class.java
            }
        }

        try {
            fragment = fragmentClass?.newInstance() as Fragment
        } catch (e: Exception) {
            e.printStackTrace()
        }


        val fragmentManager = supportFragmentManager
        fragmentManager.beginTransaction().replace(R.id.main_content_frame, fragment).commit()

        item.setChecked(true)
        setTitle(item.getTitle())


        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }
}
