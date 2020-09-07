package com.rabross.acnh.core.fragment

import androidx.fragment.app.Fragment
import dagger.MapKey
import kotlin.reflect.KClass

@Target(AnnotationTarget.FUNCTION)
@MapKey
annotation class FragmentKey(val value: KClass<out Fragment>)