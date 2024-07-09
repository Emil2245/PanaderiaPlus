package com.app.panaderiaplus.ui.screen.panes_base

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.painter.BitmapPainter
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.app.panaderiaplus.data.PanesBD
import com.app.panaderiaplus.ui.component.Favourite
import com.app.panaderiaplus.ui.screen.panes_base.mapper.PanItemMapper
import com.app.panaderiaplus.ui.screen.panes_base.model.PanItem

@Preview
@Composable
fun Preview_DetailedListItem() {
    MaterialTheme() {
        val mapper = PanItemMapper()
        val pan = mapper.map(
            PanesBD().getPanesRegistrados().first()
        )
        PanDetalladoItem(pan) {}
    }
}

@Composable
fun PanDetalladoItem(
    pan: PanItem,
    onFavouriteStateChanged: (PanItem) -> Unit
) {
    val favouriteState = remember { mutableStateOf(pan.isFavourite) }

    Card {
        Column {
            Box(
                modifier = Modifier.height(250.dp)
                    .fillMaxWidth()
                    .background(MaterialTheme.colorScheme.secondary)
                    .padding(8.dp)
            ) {
                Favourite(
                    state = favouriteState,
                    modifier = Modifier.align(Alignment.TopEnd).alpha(0.78f),
                    onValueChanged = {
                        onFavouriteStateChanged(pan)
                        favouriteState.value = !favouriteState.value
                    },
                    tint = MaterialTheme.colorScheme.onPrimary
                )
                Image(
                    painter = BitmapPainter(ImageBitmap.imageResource(id = pan.imageUrl)),
                    modifier = Modifier.align(Alignment.Center)
                        .size(500.dp),
                    contentDescription = null
                )
                Text(
                    modifier = Modifier.align(Alignment.BottomStart),
                    text = pan.name,
                    style = MaterialTheme.typography.headlineSmall.copy(
                        color = MaterialTheme.colorScheme.onPrimary
                    )
                )
            }
            Text(
                text = pan.description,
                overflow = TextOverflow.Ellipsis,
                maxLines = 3,
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.padding(8.dp)
                    .alpha(0.54f)
            )
        }
    }
}
