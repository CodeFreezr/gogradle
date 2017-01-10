package com.github.blindpirate.gogradle.support

import com.github.blindpirate.gogradle.GogradleModule
import com.github.blindpirate.gogradle.core.InjectionHelper
import com.google.inject.Guice
import com.google.inject.Injector
import org.gradle.api.internal.project.ProjectInternal
import org.gradle.internal.reflect.Instantiator
import org.junit.Before
import org.mockito.Mock

abstract class GogradleModuleSupport {
    @Mock
    Instantiator instantiator
    @Mock
    ProjectInternal project

    Injector injector

    @Before
    void initInjector() {
        injector = Guice.createInjector(new GogradleModule(project, instantiator))
        InjectionHelper.INJECTOR_INSTANCE = injector
        injector.injectMembers(this)
    }
}
