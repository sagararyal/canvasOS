package com.getisolated.canvasos

import android.app.Application
import android.content.ComponentCallbacks2

class App : Application() {
    /**
     * The home screen stays in memory while other apps play (KeeperService keeps it ahead of them), so it
     * gives back what it can rebuild: Android asks when the home screen leaves the front or memory runs short.
     */
    override fun onTrimMemory(level: Int) {
        super.onTrimMemory(level)
        // RUNNING_LOW and every level above it, UI_HIDDEN and the background ones included.
        if (level >= ComponentCallbacks2.TRIM_MEMORY_RUNNING_LOW) {
            AppRepo.trimTiles()
            LiquidGlass.trim()
        }
    }
}
