package com.rpn.iiucstudy

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.PreferenceDataStoreFactory
import androidx.datastore.preferences.core.Preferences
import com.rpn.iiucstudy.presentation.utils.Type
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.internal.SynchronizedObject
import kotlinx.coroutines.internal.synchronized
import okio.Path.Companion.toPath

interface Platform {
    val name: String
}


expect fun getPlatform(): Platform
expect fun getType(): Type


expect fun getRandomId(): String

expect fun shareLink(url: String)

expect fun dataStorePreferences(): DataStore<Preferences>

object AppSettings {
    private lateinit var dataStore: DataStore<Preferences>

    @OptIn(InternalCoroutinesApi::class)
    private val lock = SynchronizedObject()

    @OptIn(InternalCoroutinesApi::class)
    fun getDataStore(producerPath: () -> String): DataStore<Preferences> {
        return synchronized(lock) {
            if (::dataStore.isInitialized) {
                dataStore
            } else {
                PreferenceDataStoreFactory.createWithPath(
                    produceFile = {
                        producerPath().toPath()
                    }
                ).also { dataStore = it }
            }
        }
    }
}
