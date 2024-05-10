package com.irfan.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.MapKey
import javax.inject.Inject
import javax.inject.Provider
import kotlin.reflect.KClass

//@Suppress("UNCHECKED_CAST")
//class DaggerViewModelProviderFactory @Inject constructor(
//    private val viewModelProviders: Map<Class<out ViewModel>, Provider<ViewModelProvider>>
//) : ViewModelProvider.Factory {
//    override fun <T : ViewModel> create(modelClass: Class<T>): T {
//        return try {
//            viewModelProviders[modelClass]?.get() as T
//        } catch (e: Exception) {
//            e.printStackTrace()
//            throw Exception("ViewModel  Provider is not found")
//        }
//    }
//}
//
//
//
//@MustBeDocumented
//@Target(AnnotationTarget.FUNCTION, AnnotationTarget.PROPERTY_GETTER, AnnotationTarget.PROPERTY_SETTER)
//@Retention(AnnotationRetention.RUNTIME)
//@MapKey
//annotation class ViewModelKey(val value: KClass<out ViewModel>)