package com.app.panaderiaplus.ui.screen.panes_base

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.painter.BitmapPainter
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.app.panaderiaplus.R
import com.app.panaderiaplus.ui.screen.panes_base.model.PanItem
import com.app.panaderiaplus.ui.screen.panes_base.model.PanState
import com.app.panaderiaplus.ui.screen.panes_base.model.DisplayingOptions

@Composable
fun MostrarPanCargandoScreen() {
    // TODO: implement it
}

@Composable
fun MostrarPanesCorrectosScreen(
    panState: PanState,
    viewModel: PanViewModel,
    panOrdenadoMenuItem: () -> Unit,
    panSeleccionado: (PanItem) -> Unit
) {
    PanesScreenUI(
        panState = panState,
        viewModel = viewModel,
        panOrdenadoMenuItem,
        panSeleccionado
    )
}

@Composable
fun MostrarErrorPanScreen() {
    // TODO: implement it
}

@Composable
fun PanesScreenUI(
    panState: PanState,
    viewModel: PanViewModel,
    panOrdenadoMenuItem: () -> Unit,
    panSeleccionado: (PanItem) -> Unit
) {
    Surface {
        Column {
            BarraSuperior(
                panState.displayingOption,
                onChangeDisplayOption = { viewModel.changeDisplayingOption() },
                panesOrdenadosMenuItem = { panOrdenadoMenuItem() }
            )
            ListaPan(
                panState = panState,
                panSeleccionado = { pan -> panSeleccionado(pan) },
                onFavouriteStateChanged = { viewModel.changeFavouriteState(it) }
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BarraSuperior(
    displayingOption: DisplayingOptions,
    onChangeDisplayOption: () -> Unit,
    panesOrdenadosMenuItem: () -> Unit
) {
    TopAppBar(
        title = {
            Text(
                text = "Panaderia Plus",
                style = MaterialTheme.typography.titleLarge.copy(
                    color = MaterialTheme.colorScheme.onPrimary
                )
            )
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primary,
            titleContentColor = MaterialTheme.colorScheme.onPrimary
        ),
        actions = {
            IconButton(
                onClick = { onChangeDisplayOption() }
            ) {
                Icon(
                    painter = BitmapPainter(
                        ImageBitmap.imageResource(id = if (displayingOption == DisplayingOptions.CARDS) R.drawable.ic_list_white else R.drawable.ic_extended_list_white)
                    ),
                    contentDescription = stringResource(R.string.action_show_detailed_cards),
                    tint = MaterialTheme.colorScheme.onPrimary
                )
            }
            IconButton(
                onClick = { panesOrdenadosMenuItem() }
            ) {
                Icon(
                    painter = BitmapPainter(ImageBitmap.imageResource(id = R.drawable.ic_order_white)),
                    tint = MaterialTheme.colorScheme.onPrimary,
                    contentDescription = stringResource(R.string.action_order_pan)
                )
            }
        },
    )
}

@Composable
fun ListaPan(
    panState: PanState,
    panSeleccionado: (PanItem) -> Unit,
    onFavouriteStateChanged: (PanItem) -> Unit
) {
    LazyColumn {
        items(items = panState.panes) { pan ->
            Box(
                modifier = Modifier.clickable(
                    onClick = {
                        panSeleccionado(pan)
                    }
                )
            ) {
                if (panState.displayingOption == DisplayingOptions.CARDS) {
                    Box(modifier = Modifier.padding(8.dp)) {
                        PanDetalladoItem(
                            pan = pan,
                            onFavouriteStateChanged = { onFavouriteStateChanged(it) }
                        )
                    }
                } else {
                    ListaPan(
                        pan = pan,
                        onFavouriteStateChanged = { onFavouriteStateChanged(it) }
                    )
                }
            }
        }
    }
}
