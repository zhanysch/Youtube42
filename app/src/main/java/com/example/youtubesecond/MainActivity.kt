package com.example.youtubesecond

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.youtubesecond.data.remote.RetrofitBuilder
import com.google.android.youtube.player.YouTubeBaseActivity
import com.google.android.youtube.player.YouTubeInitializationResult
import com.google.android.youtube.player.YouTubePlayer
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : YouTubeBaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        RetrofitBuilder.getService()?.getPopularVideos("AIzaSyC8HaYLDmL2XdTobBMoml-qBBR3hgvFIWc", "mostPopular")

        val listener = object : YouTubePlayer.OnInitializedListener{
            override fun onInitializationSuccess(p0: YouTubePlayer.Provider?, youTubePlayer: YouTubePlayer?, p2: Boolean) {
                youTubePlayer?.loadVideo("HalMzk1FFM0")

            }

            override fun onInitializationFailure(p0: YouTubePlayer.Provider?, p1: YouTubeInitializationResult?) {

            }

        }
        play.initialize("AIzaSyC8HaYLDmL2XdTobBMoml-qBBR3hgvFIWc", listener)
    }
    //AIzaSyC8HaYLDmL2XdTobBMoml-qBBR3hgvFIWc
}