package com.example.lifecycleawarecomponents

import android.util.Log
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner

internal class MyLocationListener(
    private val lifecycle: Lifecycle,
    private val callback: (String) -> Unit
) : DefaultLifecycleObserver {

    init {
        lifecycle.addObserver(this)
    }

    private var enabled = false

    override fun onStart(owner: LifecycleOwner) {
        Log.d("MainActivity", "MyLocationListener onStart")
        if (enabled) {
            // connect
            callback.invoke("chiatura")
        }
    }

    fun enable() {
        enabled = true
        if (lifecycle.currentState.isAtLeast(Lifecycle.State.STARTED)) {
            // connect if not connected
        }
    }

    override fun onStop(owner: LifecycleOwner) {
        Log.d("MainActivity", "MyLocationListener onStop")

        // disconnect if connected
    }
}