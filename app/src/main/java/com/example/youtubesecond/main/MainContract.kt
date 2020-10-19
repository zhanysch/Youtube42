package com.example.youtubesecond.main

import com.example.youtubesecond.data.LifeCycle

interface MainContract {

    interface View{
        fun showMessage(text : String)  // для view появлен в mainActivity
    }

    interface Presenter: LifeCycle<View>{
        fun loadVideos() // сначала это вводитс в contractore

    }
}