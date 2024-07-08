package com.app.panaderiaplus

import android.app.Application
import com.app.panaderiaplus.di.dataModule
import com.app.panaderiaplus.di.mapperModule
import com.app.panaderiaplus.di.viewModelModule
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

@ExperimentalCoroutinesApi
class PanaderiaPlusApp : Application() {

    override fun onCreate() {
        super.onCreate()
        initDI()
    }

    private fun initDI() {
        startKoin {
            androidLogger(Level.ERROR)
            androidContext(this@PanaderiaPlusApp)
            modules(
                listOf(
                    dataModule,
                    mapperModule,
                    viewModelModule
                )
            )
        }
    }
}
