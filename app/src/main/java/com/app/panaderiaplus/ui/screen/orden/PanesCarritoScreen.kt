// PanesCarritoScreen.kt

package com.app.panaderiaplus.ui.screen.orden

import android.util.Log
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
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
import com.app.panaderiaplus.data.order.PanOrdenado
import com.app.panaderiaplus.ui.component.AppDivider
import com.app.panaderiaplus.ui.component.Counter
import com.app.panaderiaplus.ui.screen.orden.model.PanOrdenadoState
import com.app.panaderiaplus.ui.theme.Purple40
import java.math.BigDecimal

private val PAN_IMAGE_SIZE = 88.dp

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
    onBack: () -> Unit,
    onProceedToQR: () -> Unit,
    onProceedToCajaQR: () -> Unit
) {
    Column {
        BarraPrecioTotal(
            totalPrice = panOrdenadoState.totalPrice,
            onBackClick = onBack,
            onProceedToQR = onProceedToQR,
            onProceedToCajaQR = onProceedToCajaQR
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

@OptIn(ExperimentalAnimationApi::class)
@Composable
private fun BarraPrecioTotal(
    totalPrice: BigDecimal,
    onBackClick: () -> Unit,
    onProceedToQR: () -> Unit,
    onProceedToCajaQR: () -> Unit
) {
    Surface(
        color = MaterialTheme.colorScheme.primary,
    ) {
        Column {
            AppBar(onBackClick)
            Row(modifier = Modifier.padding(vertical = 4.dp, horizontal = 10.dp)) {
                Text(
                    text = "Total de compra:",
                    modifier = Modifier.weight(2f),
                    style = MaterialTheme.typography.titleMedium.copy(
                        color = MaterialTheme.colorScheme.onPrimary
                    )
                )
                Text(
                    text = "$ ${String.format("%.2f", totalPrice)}",
                    style = MaterialTheme.typography.titleMedium.copy(
                        color = MaterialTheme.colorScheme.onPrimary
                    )
                )
            }
            Row(modifier = Modifier.padding(8.dp)) {
                Button(
                    onClick = onProceedToQR,
                    shape = RoundedCornerShape(16.dp),
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxWidth()
                        .padding(end = 4.dp),
                    colors = ButtonDefaults.buttonColors(Purple40)
                ) {
                    Text(
                        text = "Pagar con Tarjeta",
                        style = MaterialTheme.typography.titleMedium,
                        color = MaterialTheme.colorScheme.onPrimary,
                    )
                }
                Button(
                    onClick = onProceedToCajaQR,
                    shape = RoundedCornerShape(16.dp),
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxWidth()
                        .padding(start = 4.dp),
                    colors = ButtonDefaults.buttonColors(Purple40)
                ) {
                    Text(
                        text = "Pagar en Caja",
                        style = MaterialTheme.typography.titleMedium,
                        color = MaterialTheme.colorScheme.onPrimary,
                    )
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppBar(onBackClick: () -> Unit) {
    TopAppBar(
        title = {
            Text(
                text = "",
                style = MaterialTheme.typography.titleLarge.copy(
                    color = MaterialTheme.colorScheme.onPrimary
                )
            )
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primary,
            titleContentColor = MaterialTheme.colorScheme.onPrimary
        ),
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
        modifier = Modifier
            .padding(top = 8.dp, bottom = 8.dp, end = 8.dp)
    ) {
        Surface(
            modifier = Modifier
                .size(PAN_IMAGE_SIZE)
                .padding(5.dp),
            shape = CircleShape,
            color = Color(0xFFFAFAFA)
        ) {
            Image(
                painter = BitmapPainter(ImageBitmap.imageResource(id = panOrdenado.imageUrl)),
                modifier = Modifier.fillMaxSize(),
                contentDescription = null
            )
        }
        Column(
            modifier = Modifier
                .weight(1f)
                .padding(horizontal = 4.dp)
        ) {
            Text(
                text = panOrdenado.name,
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier
                    .padding(bottom = 4.dp, top = 2.dp, end = 8.dp)
                    .fillMaxWidth()
            )
            Text(
                text = panOrdenado.ingredients,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                style = MaterialTheme.typography.bodyLarge
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
