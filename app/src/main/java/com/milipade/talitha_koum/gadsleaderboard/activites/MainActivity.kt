package com.milipade.talitha_koum.gadsleaderboard.activites

import android.content.Intent
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import com.milipade.talitha_koum.gadsleaderboard.R
import com.milipade.talitha_koum.gadsleaderboard.adapters.ScreenPagerAdapter


import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var viewPager: ViewPager
    private lateinit var tabLayout: TabLayout
    private lateinit var screenPagerAdapter: ScreenPagerAdapter
    private lateinit var submitForm: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        screenPagerAdapter = ScreenPagerAdapter(supportFragmentManager)

        viewPager = findViewById(R.id.pager)
        tabLayout = findViewById(R.id.tab_layout)
        submitForm = findViewById(R.id.toolbarbtn)
        viewPager.adapter = screenPagerAdapter
        val intent = Intent(this, SubmitActivity::class.java)


        submitForm.setOnClickListener { view ->

            startActivity(intent)
        }
    }

    /*override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }*/

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}
