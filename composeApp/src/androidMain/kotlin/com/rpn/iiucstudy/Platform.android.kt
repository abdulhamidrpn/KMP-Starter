package com.rpn.iiucstudy

import android.content.Intent
import android.os.Build
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import com.rpn.iiucstudy.data.utils.Constants
import com.rpn.iiucstudy.presentation.utils.Type
import java.util.UUID

class AndroidPlatform : Platform {
    override val name: String = "Android ${Build.VERSION.SDK_INT}"
}

actual fun getPlatform(): Platform = AndroidPlatform()


actual fun getType(): Type {
    return Type.Mobile
}

actual fun getRandomId(): String {
    return UUID.randomUUID().toString()
}

actual fun shareLink(url: String) {
    val sendIntent = Intent(Intent.ACTION_SEND).apply {
        putExtra(Intent.EXTRA_TEXT, url)
        type = "text/plain"
    }
    val shareIntent = Intent.createChooser(sendIntent, "Share Link")
    ContextUtils.context.startActivity(shareIntent)

}

actual fun dataStorePreferences(): DataStore<Preferences> {
    val context = ContextUtils.context
    return AppSettings.getDataStore(
        producerPath = {
            context.filesDir.resolve(Constants.dataStoreFileName).absolutePath
        }
    )
}
