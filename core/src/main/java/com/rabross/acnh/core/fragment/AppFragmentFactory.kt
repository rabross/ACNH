package com.rabross.acnh.core.fragment

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import dagger.Reusable
import javax.inject.Inject
import javax.inject.Provider

typealias FragmentMap = Map<Class<out Fragment>, @JvmSuppressWildcards Provider<Fragment>>

@Reusable
class AppFragmentFactory
@Inject constructor(private val fragmentMap: FragmentMap) : FragmentFactory() {

    override fun instantiate(classLoader: ClassLoader, className: String): Fragment {
        val fragmentClass = loadFragmentClass(classLoader, className)
        return fragmentMap[fragmentClass]?.get() ?: return super.instantiate(classLoader, className)
    }
}
