package com.app.panaderiaplus.data.order

import com.app.panaderiaplus.data.FuentePanes
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class PanOrdenadoRepository(
    private val fuentePanes: FuentePanes,
    private val panOrdenadoMapper: PanOrdenadoMapper
) : IPanOrdenadoRepository {
    companion object {
        const val MIN_VALUE = 0
        const val MAX_VALUE = 99
    }

    private val panes = mutableListOf<PanOrdenado>()

    override suspend fun listarPanes(): Flow<List<PanOrdenado>> {
        return flow {
            if (panes.isEmpty()) {
                panes.addAll(
                    panOrdenadoMapper.map(fuentePanes.getPanesRegistrados())
                )
            }
            emit(panes)
        }
    }

    override suspend fun add(panId: Long): Flow<Boolean> {
        return flow {
            val index = panes.indexOfFirst { it.id == panId }
            val result = if (index > -1) {
                val pan = panes[index]
                val newValue =
                    if (pan.count == MAX_VALUE) MAX_VALUE else pan.count + 1
                panes[index] = pan.copy(count = newValue)
                true
            } else {
                false
            }
            emit(result)
        }
    }

    override suspend fun remove(panId: Long): Flow<Boolean> {
        return flow {
            val index = panes.indexOfFirst { it.id == panId }
            val result = if (index > -1) {
                val pan = panes[index]
                val newValue =
                    if (pan.count == MIN_VALUE) MIN_VALUE else pan.count - 1
                panes[index] = pan.copy(count = newValue)
                true
            } else {
                false
            }
            emit(result)
        }
    }
}
