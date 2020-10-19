package com.example.youtubesecond.main

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.youtubesecond.R
import com.example.youtubesecond.data.remote.RetrofitBuilder
import com.google.android.youtube.player.YouTubeBaseActivity
import com.google.android.youtube.player.YouTubeInitializationResult
import com.google.android.youtube.player.YouTubePlayer
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : YouTubeBaseActivity(), MainContract.View {

    private var presenter : MainPresenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenter = MainPresenter()
        presenter?.bind(this)
        presenter?.loadVideos()

        val listener = object : YouTubePlayer.OnInitializedListener{
            override fun onInitializationSuccess(p0: YouTubePlayer.Provider?, youTubePlayer: YouTubePlayer?, p2: Boolean) {
                youTubePlayer?.loadVideo("KQ6zr6kCPj8")
            }

            override fun onInitializationFailure(p0: YouTubePlayer.Provider?, p1: YouTubeInitializationResult?) {
                Log.d("gdgfgdf","sdgsdgsgs")
            }
        }
        play.initialize("AIzaSyC8HaYLDmL2XdTobBMoml-qBBR3hgvFIWc", listener)
    }
    //AIzaSyC8HaYLDmL2XdTobBMoml-qBBR3hgvFIWc

    override fun onDestroy() {
        super.onDestroy()
        presenter?.unbind()
    }

    override fun showMessage(text: String) {
        runOnUiThread {  // тоесть тоаст будет в главном потоке
            Toast.makeText(applicationContext,text, Toast.LENGTH_LONG).show()
        }
    }


}