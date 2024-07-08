package com.app.panaderiaplus.di

import com.app.panaderiaplus.data.FuentePanes
import com.app.panaderiaplus.data.IPanRepository
import com.app.panaderiaplus.data.PanesBD
import com.app.panaderiaplus.data.PanRepository
import com.app.panaderiaplus.data.order.IPanOrdenadoRepository
import com.app.panaderiaplus.data.order.PanOrdenadoMapper
import com.app.panaderiaplus.data.order.PanOrdenadoRepository
import com.app.panaderiaplus.ui.screen.pan_detalles.PanDetallesViewModel
import com.app.panaderiaplus.ui.screen.pan_detalles.mapper.PanDetallesMapper
import com.app.panaderiaplus.ui.screen.panes_base.PanViewModel
import com.app.panaderiaplus.ui.screen.panes_base.mapper.PanItemMapper
import com.app.panaderiaplus.ui.screen.orden.PanOrdenadoViewModel
import com.app.panaderiaplus.ui.screen.orden.mapper.PanOrdenadoUIMapper
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val dataModule = module {
    factory<FuentePanes> { PanesBD() }
    single<IPanRepository> { PanRepository }
    single<IPanOrdenadoRepository> {
        PanOrdenadoRepository(
            fuentePanes = get(),
            panOrdenadoMapper = get()
        )
    }
}

val mapperModule = module {
    factory { PanItemMapper() }
    factory { PanDetallesMapper() }
    factory { PanOrdenadoUIMapper() }

    factory { PanOrdenadoMapper() }
}

val viewModelModule = module {
    viewModel {
        PanOrdenadoViewModel(
            repository = get()
        )
    }
    viewModel {
        PanViewModel(
            repository = get(),
            mapper = get()
        )
    }
    viewModel {
        PanDetallesViewModel(
            repository = get(),
            mapper = get()
        )
    }
}
