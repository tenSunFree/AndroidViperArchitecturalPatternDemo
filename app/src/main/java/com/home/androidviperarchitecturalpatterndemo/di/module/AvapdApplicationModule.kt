package com.home.androidviperarchitecturalpatterndemo.di.module

import android.content.Context
import dagger.Module
import dagger.Provides

/**
 * 透過Module, 讓dependency之間產生無形連結的方法
 * Module就像一個工廠一樣, 我們統一在Module裡生產相關的dependency
 */
@Module
class AvapdApplicationModule(private val context: Context) {

    /**
     * Provides是專門為了生產dependency的Method
     */
    @Provides
    fun providesContext(): Context = context
}