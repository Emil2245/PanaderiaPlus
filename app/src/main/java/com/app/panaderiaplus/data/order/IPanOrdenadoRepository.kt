package com.app.panaderiaplus.data.order

import kotlinx.coroutines.flow.Flow

interface IPanOrdenadoRepository {

    suspend fun listarPanes(): Flow<List<PanOrdenado>>

    suspend fun add(panId: Long): Flow<Boolean>

    suspend fun remove(panId: Long): Flow<Boolean>
}
