package com.example.mad_20012011036_dhangarmittal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnPlay: FloatingActionButton =findViewById(R.id.btn_play)
        val btnStop:FloatingActionButton=findViewById(R.id.btn_stop)
        val btnNext:FloatingActionButton=findViewById(R.id.btn_next)
        val btnPrevious:FloatingActionButton=findViewById(R.id.btn_previous)
        val txtSong: TextView =findViewById(R.id.song_text)
        txtSong.text ="No Song Playing"
        var i=0
        btnPlay.setOnClickListener {
            txtSong.text="Song"
            play()
            if(i==0)
            {
                btnPlay.setImageResource(android.R.drawable.ic_media_pause)
                i=1
            }
            else{
                btnPlay.setImageResource(android.R.drawable.ic_media_play)
                i=0
            }

        }
        btnStop.setOnClickListener {
            txtSong.text="No Song Playing"
            stop()
            if(i==1)
            {
                btnPlay.setImageResource(android.R.drawable.ic_media_play)
                i=0
            }
        }

        btnNext.setOnClickListener {

        }
        btnPrevious.setOnClickListener {

        }
    }
    private fun play()
    {
        Intent(applicationContext,MediaService::class.java).putExtra(MediaService.DATA_KEY,MediaService.DATA_VALUE).apply {
            startService(this)
        }
    }
    fun stop()
    {
        Intent(applicationContext,MediaService::class.java).apply {
            stopService(this)

    }
}
    }