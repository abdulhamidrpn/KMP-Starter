package com.rpn.iiucstudy

import com.rpn.iiucstudy.presentation.utils.Type
import platform.UIKit.UIDevice
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences

class IOSPlatform: Platform {
    override val name: String = UIDevice.currentDevice.systemName() + " " + UIDevice.currentDevice.systemVersion
}

actual fun getPlatform(): Platform = IOSPlatform()





actual fun getType(): Type {
    return Type.Mobile
}

actual fun getRandomId(): String {
    return NSUUIID.UUIDString()
}

actual fun shareLink(url: String) {
    val currentViewController = UIApplication.sharedApplication().keyWindow?.rootViewController
    val activityViewController = UIActivityViewController(listOf(url), null)
    currentViewController?.presentViewController(
        viewControllerToPresent = activityViewController,
        animated = true,
        completion = null
    )
}


actual fun dataStorePreferences(): DataStore<Preferences> {
    return AppSettings.getDataStore(
        producerPath = {
            val documentDirectory: NSURL? = NSFileManager.defaultManager.URLForDirectory(
                directory = NSDocumentDirectory,
                inDomain = NSUserDomainMask,
                appropriateForURL = null,
                create = false,
                error = null,
            )
            requireNotNull(documentDirectory).path + "/${Constants.dataStoreFileName}"
        })
}
