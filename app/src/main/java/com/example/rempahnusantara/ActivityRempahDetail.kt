package com.example.rempahnusantara

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.activity_rempah_detail.*

class ActivityRempahDetail : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rempah_detail)
        val actionbar = supportActionBar
        actionbar!!.title = "Detail Rempah"

        actionbar.setDisplayHomeAsUpEnabled(true)

        val tvSetName:TextView = findViewById(R.id.tv_set_nama)
        val tvSetKhasiat :TextView = findViewById(R.id.tv_set_khasiat)
        val tvSetHarga : TextView = findViewById(R.id.tv_set_harga)
        val tvSetDesk :TextView = findViewById(R.id.tv_set_desk)
        val tvSetImg : ImageView = findViewById(R.id.tv_set_img)

        val name = intent.getStringExtra(EXTRA_NAME)
        val khasiat = intent.getStringExtra(EXTRA_KHASIAT)
        val harga = intent.getStringExtra(EXTRA_HARGA)
        val desk = intent.getStringExtra(EXTRA_DETAIL)
        val img = intent.getStringExtra(EXTRA_FOTO)

        tvSetName.text = name
        tvSetKhasiat.text = khasiat
        tvSetHarga.text = harga
        tvSetDesk.text = desk
        Glide.with(this)
            .load(img)
            .apply(RequestOptions())
            .into(tvSetImg)

    
    }

    companion object {
        const val EXTRA_NAME = "extra_name"
        const val EXTRA_KHASIAT = "extra_khasiat"
        const val EXTRA_HARGA = "extra_harga"
        const val EXTRA_DETAIL = "extra_detail"
        const val EXTRA_FOTO = "extra_foto"
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}