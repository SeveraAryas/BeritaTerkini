package id.severa.beritaterkini.di

import android.content.Context
import id.severa.beritaterkini.data.NewsRepository
import id.severa.beritaterkini.data.local.NewsDatabase
import id.severa.beritaterkini.data.remote.ApiConfig

object Injection {
    fun provideRepository(context: Context): NewsRepository {
        val apiService = ApiConfig.getApiService()
        val database = NewsDatabase.getInstance(context)
        val dao = database.newsDao()
        return NewsRepository.getInstance(apiService, dao)
    }
}