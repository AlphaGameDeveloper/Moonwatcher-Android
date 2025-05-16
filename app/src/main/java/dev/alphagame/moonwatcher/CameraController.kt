package dev.alphagame.moonwatcher

import android.content.Context
import android.util.Log

object CameraController {
    fun capture(context: Context, iso: Int, exposure: Int, focus: Boolean) {
        // TODO: Use CameraX/Camera2 to capture a photo
        Log.d("Moonwatcher", "Capturing photo (ISO=$iso, Exposure=$exposure, Focus=$focus)")
        // Simulate saving and log path
        Log.i("Moonwatcher", "Saved: /sdcard/Moonwatcher/fake_2025-05-16.jpg")
    }

    fun focus(context: Context) {
        // TODO: Autofocus handling
        Log.d("Moonwatcher", "Focusing camera")
    }
}
