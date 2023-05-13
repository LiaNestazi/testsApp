package com.example.testsapp.sealed

import androidx.compose.runtime.snapshots.SnapshotStateList
import com.example.testsapp.models.Message
import com.example.testsapp.models.Test

sealed class DataState {
    object Success: DataState()
    object Failure: DataState()
    object Loading: DataState()
    object Empty: DataState()
}