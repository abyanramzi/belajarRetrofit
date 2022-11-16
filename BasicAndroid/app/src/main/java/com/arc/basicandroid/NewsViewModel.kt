package com.arc.basicandroid

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.arc.basicandroid.network.Api
import kotlinx.coroutines.launch

class NewsViewModel: ViewModel() {
    init {
        getListNews()
    }
    fun getListNews(){
        viewModelScope.launch {
            val response = Api.newsApiService.getTopHeadlines()
            val article = response.aricles

            article.forEach {
                Log.e("Response", it.toString())
            }
        }
    }
}