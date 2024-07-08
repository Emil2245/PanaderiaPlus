package com.app.panaderiaplus.data

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf

object PanRepository : IPanRepository {
    private val panes: MutableList<Pan> = initPanes()

    override suspend fun listarPanes(): Flow<List<Pan>> {
        return flowOf(panes)
    }

    override suspend fun getPan(id: Long): Flow<Pan?> {
        return flowOf(
            panes.firstOrNull { it.id == id }
        )
    }

    override suspend fun updateFavouriteState(id: Long, newFavouriteState: Boolean): Flow<Boolean> {
        return flow {
            val position = panes.indexOfFirst { it.id == id }
            val result = if (position > -1) {
                val pan = panes.first { it.id == id }
                val nuevoPan = pan.copy(isFavourite = newFavouriteState)
                panes.remove(pan)
                panes.add(position, nuevoPan)
                true
            } else {
                false
            }
            emit(result)
        }
    }

    private fun initPanes(): MutableList<Pan> {
        return PanesBD().getPanesRegistrados() as MutableList<Pan>
    }
}
