package com.example.youtubesecond.data

interface LifeCycle <V> {
    fun bind(v:V)
    fun unbind()
}