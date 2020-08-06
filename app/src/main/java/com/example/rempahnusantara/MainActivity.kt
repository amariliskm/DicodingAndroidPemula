package com.example.rempahnusantara

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var rvRempah: RecyclerView
    private var list: ArrayList<Rempah> = arrayListOf()
    private var title = "Halaman Utama"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setActionBarTitle(title)

        rvRempah = findViewById(R.id.rv_rempah)
        rvRempah.setHasFixedSize(true)

        list.addAll(DataRempah.listData)
        showRecyclerList()
    }

    private fun showRecyclerList() {
        rvRempah.layoutManager = LinearLayoutManager(this)
        val listRempahAdapter = listRempahAdapter(list)
        rvRempah.adapter = listRempahAdapter

        listRempahAdapter.setOnItemClickCallback(object : listRempahAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Rempah) {
                showSelectedRempah(data)
            }
        })

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        setMode(item.itemId)
        return super.onOptionsItemSelected(item)
    }

    private fun setMode(selectedMode: Int) {
        when (selectedMode) {
            R.id.masukAbout->{
                val moveIntent = Intent(this@MainActivity, ActivityAbout::class.java)
                startActivity(moveIntent)
            }
        }
    }

    private fun setActionBarTitle(title: String) {
        if (supportActionBar != null) {
            (supportActionBar as ActionBar).title = title
        }
    }

    private fun showSelectedRempah(rempah: Rempah) {
        Toast.makeText(this, "Kamu memilih " + rempah.name, Toast.LENGTH_SHORT).show()
    }

}