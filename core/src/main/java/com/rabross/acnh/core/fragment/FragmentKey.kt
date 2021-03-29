package com.rabross.acnh.core.fragment

import androidx.fragment.app.Fragment
import dagger.MapKey
import kotlin.reflect.KClass

typealias FragmentValue = KClass<out Fragment>

@Target(AnnotationTarget.FUNCTION)
@MapKey
annotation class FragmentKey(val value: FragmentValue)