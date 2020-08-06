package com.example.rempahnusantara

import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class ActivityAbout  : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)
        val actionbar = supportActionBar
        actionbar!!.title = "About Me"
        actionbar.setDisplayHomeAsUpEnabled(true)


        var fotoku:ImageView = findViewById(R.id.img_item_photo_me)
        val foto = R.drawable.me

        Glide.with(this)
            .load(foto)
            .apply(RequestOptions().override(350, 550))
            .into(fotoku)

    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}

