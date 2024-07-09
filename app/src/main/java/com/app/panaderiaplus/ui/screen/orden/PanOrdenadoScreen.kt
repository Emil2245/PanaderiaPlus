package com.app.panaderiaplus.ui.screen.orden

import androidx.annotation.DrawableRes
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.painter.BitmapPainter
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.app.panaderiaplus.R
import com.app.panaderiaplus.ui.component.AppDivider
import com.app.panaderiaplus.ui.component.Counter
import com.app.panaderiaplus.ui.screen.orden.model.PanOrdenadoState
import com.app.panaderiaplus.data.order.PanOrdenado
import java.math.BigDecimal

@Composable
fun CargandoPanScreen() {
    Box(modifier = Modifier.fillMaxSize()) {
        CircularProgressIndicator(
            color = MaterialTheme.colorScheme.primary,
            modifier = Modifier
                .align(Alignment.Center)
                .size(36.dp)
        )
    }
}

@ExperimentalAnimationApi
@Composable
fun MostrarPanCorrectoScreen(
    panOrdenadoState: PanOrdenadoState,
    viewModel: PanOrdenadoViewModel,
    onBack: () -> Unit
) {
    Column {
        AppBarWithOrderSummary(
            totalPrice = panOrdenadoState.totalPrice,
            onBackClick = onBack
        )
        Surface {
            LazyColumn {
                items(items = panOrdenadoState.listaPanes) { pan ->
                    Column {
                        OrdenarPanItem(
                            panOrdenado = pan,
                            onAdded = { viewModel.addPan(pan.id) },
                            onRemoved = { viewModel.removePan(pan.id) }
                        )
                        AppDivider(PaddingValues(start = 84.dp))
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun AppBar(
    onBackClick: () -> Unit
) {
    TopAppBar(
        title = {
            Text(
                text = "Selecciona tu orden:",
                style = MaterialTheme.typography.bodySmall.copy(
                    color = MaterialTheme.colorScheme.onPrimary
                )
            )
        },
        navigationIcon = {
            IconButton(onClick = onBackClick) {
                Icon(
                    painter = BitmapPainter(ImageBitmap.imageResource(id = R.drawable.ic_arrow_back_white)),
                    contentDescription = stringResource(R.string.action_back),
                    tint = MaterialTheme.colorScheme.onPrimary
                )
            }
        }
    )
}

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun OrdenarPanItem(
    panOrdenado: PanOrdenado,
    onAdded: () -> Unit,
    onRemoved: () -> Unit
) {
    Row(
        modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
    ) {
        Logo(panOrdenado.imageUrl)
        Column(
            modifier = Modifier.weight(1f)
                .padding(horizontal = 4.dp)
        ) {
            Text(
                text = panOrdenado.name,
                style = MaterialTheme.typography.bodySmall,
                modifier = Modifier.padding(bottom = 4.dp)
                    .fillMaxWidth()
            )
            Text(
                text = panOrdenado.ingredients,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                style = MaterialTheme.typography.bodyMedium
            )
        }
        Column(modifier = Modifier.width(90.dp)) {
            Text(
                modifier = Modifier
                    .padding(bottom = 4.dp)
                    .fillMaxWidth(),
                text = "€ ${panOrdenado.price}",
                style = MaterialTheme.typography.titleMedium.copy(textAlign = TextAlign.Right)
            )
            Counter(
                value = panOrdenado.count,
                onIncrease = onAdded,
                onDecrease = onRemoved
            )
        }
    }
}

@Composable
private fun Logo(
    @DrawableRes logoId: Int,
    modifier: Modifier = Modifier
) {
    Surface(
        modifier = modifier
            .size(72.dp)
            .padding(8.dp),
        shape = CircleShape,
        color = Color(0xFFFAFAFA)
    ) {
        Image(
            modifier = Modifier.size(64.dp),
            painter = BitmapPainter(ImageBitmap.imageResource(id = logoId)),
            contentDescription = null
        )
    }
}

@ExperimentalAnimationApi
@Composable
private fun AppBarWithOrderSummary(
    totalPrice: BigDecimal,
    onBackClick: () -> Unit
) {
    Surface(
        color = MaterialTheme.colorScheme.primary,
    ) {
        Column {
            AppBar {
                onBackClick()
            }
            Row(modifier = Modifier.padding(8.dp)) {
                Text(
                    text = "Total cost",
                    modifier = Modifier.weight(1f),
                    style = MaterialTheme.typography.bodySmall.copy(
                        color = MaterialTheme.colorScheme.onPrimary
                    )
                )
                Text(
                    text = "€ $totalPrice",
                    style = MaterialTheme.typography.bodySmall.copy(
                        color = MaterialTheme.colorScheme.onPrimary
                    )
                )
            }
        }
    }
}


