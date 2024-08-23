package com.rpn.iiucstudy

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import com.rpn.iiucstudy.data.utils.Constants
import com.rpn.iiucstudy.presentation.utils.Type
import java.awt.Toolkit
import java.awt.datatransfer.StringSelection
import java.io.File
import java.util.UUID


actual fun getType(): Type = Type.Desktop


actual fun getRandomId(): String {
    return UUID.randomUUID().toString()
}

actual fun shareLink(url: String) {
    val clipboard = Toolkit.getDefaultToolkit().systemClipboard
    clipboard.setContents(StringSelection(url), null)
}

actual fun dataStorePreferences(): DataStore<Preferences> {
    return AppSettings.getDataStore {
        Constants.dataStoreFileName
    }
}
