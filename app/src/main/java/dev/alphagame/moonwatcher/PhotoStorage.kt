package dev.alphagame.moonwatcher

import android.content.Context

object PhotoStorage {
    fun getLastSavedPath(context: Context): String {
        // TODO: Track this using SharedPreferences or file metadata
        return "/sdcard/Moonwatcher/fake_2025-05-16.jpg"
    }
}
