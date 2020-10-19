package com.example.youtubesecond.main

import android.util.Log
import com.example.youtubesecond.data.remote.RetrofitBuilder
import com.google.android.youtube.player.internal.v
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch

class MainPresenter: MainContract.Presenter {

    private var view: MainContract.View? = null
    private val job = Job()
    private val scope = CoroutineScope(job)

    override fun loadVideos() {  // после написан назван функц в контрактор, это функц появл в презент через имплемент
        scope.launch {
            runCatching {
                val result = RetrofitBuilder.getService()
                    ?.getPopularVideos( "mostPopular") // запрос в интернет // тут нету ключа т.к подставили ключ в класс APikeyInterceptor
                  view?.showMessage("Ehoo")
            }.onFailure {
                Log.e("error","${it.localizedMessage}") // log.e пишет на красном об ошибке
            }
        }
    }

    override fun bind(v: MainContract.View) {
        this.view = v
    }

    override fun unbind() {
        scope.cancel()
        view = null
    }
}