package dev.alphagame.moonwatcher

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.Toast

class MoonwatcherReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        val action = intent.action ?: return
        Log.d("Moonwatcher", "Received intent: $action")

        when (action) {
            ACTION_CAPTURE -> {
                val iso = intent.getIntExtra(EXTRA_ISO, -1)
                val exposure = intent.getIntExtra(EXTRA_EXPOSURE, -1)
                val focus = intent.getBooleanExtra(EXTRA_FOCUS, false)

                Toast.makeText(context, "Capturing (ISO=$iso Exposure=$exposure Focus=$focus)", Toast.LENGTH_SHORT).show()

                CameraController.capture(context, iso, exposure, focus)
            }

            ACTION_FOCUS -> {
                Toast.makeText(context, "Focusing camera", Toast.LENGTH_SHORT).show()
                CameraController.focus(context)
            }

            ACTION_STATUS -> {
                val lastPath = PhotoStorage.getLastSavedPath(context)
                Log.i("Moonwatcher", "Last Photo: $lastPath")
            }
        }
    }

    companion object {
        const val ACTION_CAPTURE = "dev.alphagame.moonwatcher.CAPTURE"
        const val ACTION_FOCUS = "dev.alphagame.moonwatcher.FOCUS"
        const val ACTION_STATUS = "dev.alphagame.moonwatcher.STATUS"

        const val EXTRA_ISO = "iso"
        const val EXTRA_EXPOSURE = "exposure"
        const val EXTRA_FOCUS = "focus"
    }
}
