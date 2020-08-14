package com.rabross.acnh.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject
import javax.inject.Provider
import javax.inject.Singleton

typealias ViewModelMap = Map<Class<out ViewModel>, @JvmSuppressWildcards Provider<ViewModel>>

@Singleton
class ViewModelFactory @Inject constructor(private val viewModels: ViewModelMap) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
       return  viewModels[modelClass]?.get() as T
    }
}