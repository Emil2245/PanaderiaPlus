package com.app.panaderiaplus.ui.screen.pan_detalles

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.painter.BitmapPainter
import androidx.compose.ui.graphics.painter.ColorPainter
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.app.panaderiaplus.R
import com.app.panaderiaplus.ui.screen.pan_detalles.model.PanDetallesState

@Composable
fun MostarPanDetallesCargandoScreen() {
    // TODO: implement it
}

@Composable
fun MostrarPanDetallesCorrectoScreen(
    onBack: () -> Unit,
    panDetalleState: PanDetallesState,
    viewModel: PanDetallesViewModel
) {
    PanDetallesScreenUI(
        onBack = onBack,
        panDetallesState = panDetalleState,
        viewModel = viewModel
    )
}

@Composable
fun ShowErrorPanDetallesScreen() {
    // TODO
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun PanDetallesScreenUI(
    onBack: () -> Unit,
    panDetallesState: PanDetallesState,
    viewModel: PanDetallesViewModel
) {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.surface)
    )

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(220.dp)
            .paint(
                painter = if (isSystemInDarkTheme()) {
                    ColorPainter(Color.White)
                } else {
                    ColorPainter(MaterialTheme.colorScheme.primary)
                },
                alpha = 0.95f
            )
    )

    TopAppBar(
        title = { },
        navigationIcon = {
            IconButton(
                onClick = { onBack() }
            ) {
                Icon(
                    painter = BitmapPainter(image = ImageBitmap.imageResource(id = R.drawable.ic_arrow_back_white)),
                    contentDescription = stringResource(R.string.action_back),
                    tint = if (isSystemInDarkTheme()) {
                        Color.Black
                    } else {
                        MaterialTheme.colorScheme.onPrimary
                    }
                )
            }
        }
    )

    Image(
        modifier = Modifier
            .size(180.dp),
        painter = BitmapPainter(ImageBitmap.imageResource(id = R.drawable.americano_small)),
        contentDescription = null
    )

    FloatingActionButton(
        shape = CircleShape,
        onClick = {
            viewModel.changeFavouriteState(panDetallesState.panes)
        }
    ) {
        Icon(
            painter = BitmapPainter(
                ImageBitmap.imageResource(
                    if (panDetallesState.panes.isFavourite) {
                        R.drawable.ic_favorite_white
                    } else {
                        R.drawable.ic_favorite_border_white
                    }
                )
            ),
            contentDescription = if (panDetallesState.panes.isFavourite) {
                stringResource(R.string.mark_as_favorite)
            } else {
                stringResource(R.string.unmark_as_favorite)
            },
            tint = MaterialTheme.colorScheme.onSecondary
        )
    }

    Text(
        text = panDetallesState.panes.name,
        style = MaterialTheme.typography.bodyLarge.copy(MaterialTheme.colorScheme.onSurface),

    )

    Text(
        text = panDetallesState.panes.description,
        style = MaterialTheme.typography.bodySmall.copy(
            color = MaterialTheme.colorScheme.onSurface,
            textAlign = TextAlign.Justify
        ),
        modifier = Modifier
            .alpha(0.54f)
    )

    Text(
        text = panDetallesState.panes.ingredients,
        style = MaterialTheme.typography.bodySmall.copy(
            color = MaterialTheme.colorScheme.onSurface,
            textAlign = TextAlign.Justify
        ),
        modifier = Modifier
            .alpha(0.54f)
    )

}
