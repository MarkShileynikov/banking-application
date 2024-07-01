package com.example.bankingapplication.prefs

import android.content.Context
import javax.inject.Inject

class PrefsDataSourceImpl @Inject constructor(private val context: Context) : PrefsDataSource {
    override fun isFirstLaunch(): Boolean {
        val prefs = context.getSharedPreferences(
            firstLaunchPrefs, Context.MODE_PRIVATE
        )
        return prefs.getBoolean(isFirstLaunchKey, false)
    }

    override fun setFirstLaunch(isFirstLaunch: Boolean) {
        val prefs = context.getSharedPreferences(
            firstLaunchPrefs, Context.MODE_PRIVATE
        )
        with(prefs.edit()) {
            putBoolean(isFirstLaunchKey, isFirstLaunch)
            apply()
        }
    }

    companion object {
        const val firstLaunchPrefs = "first_launch_prefs"
        const val isFirstLaunchKey = "is_first_launch"
    }
}

interface PrefsDataSource {
    fun isFirstLaunch(): Boolean
    fun setFirstLaunch(isFirstLaunch: Boolean)
}