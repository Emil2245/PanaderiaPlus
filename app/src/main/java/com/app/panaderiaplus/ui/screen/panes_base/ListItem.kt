package com.app.panaderiaplus.ui.screen.panes_base

import androidx.compose.foundation.Image
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.painter.BitmapPainter
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.app.panaderiaplus.data.PanesBD
import com.app.panaderiaplus.ui.component.AppDivider
import com.app.panaderiaplus.ui.component.Favourite
import com.app.panaderiaplus.ui.screen.panes_base.mapper.PanItemMapper
import com.app.panaderiaplus.ui.screen.panes_base.model.PanItem

private val PAN_IMAGE_SIZE = 72.dp

@Preview
@Composable
fun PreviewListItem() {
    val mapper = PanItemMapper()
    val pan = mapper.map(
        PanesBD().getPanesRegistrados()[5]
    )
    CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {
        MaterialTheme {
            ListarPanItem(
                pan = pan,
                onFavouriteStateChanged = {}
            )
        }
    }
}

@Composable
fun ListaPan(
    pan: PanItem,
    onFavouriteStateChanged: (PanItem) -> Unit
) {
    Column {
        ListarPanItem(
            pan = pan,
            onFavouriteStateChanged = { onFavouriteStateChanged(it) }
        )
        AppDivider(PaddingValues(start = PAN_IMAGE_SIZE))
    }
}

@Composable
fun ListarPanItem(
    pan: PanItem,
    onFavouriteStateChanged: (PanItem) -> Unit
) {
    val favouriteState = remember { mutableStateOf(pan.isFavourite) }
    val favouriteIconColor = if (isSystemInDarkTheme()) {
        MaterialTheme.colorScheme.onPrimary
    } else {
        MaterialTheme.colorScheme.primary
    }

    Row {
        Surface(
            modifier = Modifier.size(PAN_IMAGE_SIZE)
                .padding(8.dp),
            shape = CircleShape,
            color = Color(0xFFFAFAFA)
        ) {
            Image(
                painter = BitmapPainter(ImageBitmap.imageResource(id = pan.imageUrl)),
                modifier = Modifier.fillMaxSize(),
                contentDescription = null
            )
        }
        Box(
            modifier = Modifier.fillMaxWidth()
                .weight(1f)
        ) {
            Column {
                Text(
                    text = pan.name,
                    modifier = Modifier.padding(top = 8.dp, end = 8.dp),
                    style = TextStyle(fontSize = 24.sp),
                    color = MaterialTheme.colorScheme.onSurface,
                    maxLines = 1
                )
                Text(
                    text = pan.ingredients,
                    modifier = Modifier.padding(end = 8.dp)
                        .alpha(0.54f),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurface
                )
            }
        }

        Favourite(
            state = favouriteState,
            onValueChanged = {
                onFavouriteStateChanged(pan)
                favouriteState.value = !favouriteState.value
            },
            tint = favouriteIconColor
        )
    }
}
