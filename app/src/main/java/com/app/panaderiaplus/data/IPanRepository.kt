package com.app.panaderiaplus.data

import kotlinx.coroutines.flow.Flow

interface IPanRepository {

    suspend fun listarPanes(): Flow<List<Pan>>

    suspend fun getPan(id: Long): Flow<Pan?>

    suspend fun updateFavouriteState(id: Long, newFavouriteState: Boolean): Flow<Boolean>
}
