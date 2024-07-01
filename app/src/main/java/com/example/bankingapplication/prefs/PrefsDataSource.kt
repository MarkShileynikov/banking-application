package com.example.bankingapplication.prefs

import android.content.Context
import javax.inject.Inject

class PrefsDataSourceImpl @Inject constructor(private val context: Context) : PrefsDataSource {
    override fun isFirstLaunch(): Boolean {
        val prefs = context.getSharedPreferences(
            sessionPrefs, Context.MODE_PRIVATE
        )
        return prefs.getBoolean(isFirstLaunchKey, false)
    }

    override fun setFirstLaunch(isFirstLaunch: Boolean) {
        val prefs = context.getSharedPreferences(
            sessionPrefs, Context.MODE_PRIVATE
        )
        with(prefs.edit()) {
            putBoolean(isFirstLaunchKey, isFirstLaunch)
            apply()
        }
    }

    override fun setCurrentUser(userId: Int) {
        val prefs = context.getSharedPreferences(
            sessionPrefs, Context.MODE_PRIVATE
        )
        with(prefs.edit()) {
            putInt(userIdKey, userId)
            apply()
        }
    }

    override fun fetchCurrentUser(): Int {
        val prefs = context.getSharedPreferences(
            sessionPrefs, Context.MODE_PRIVATE
        )
        return prefs.getInt(userIdKey, 0)
    }

    companion object {
        const val sessionPrefs = "session_prefs"
        const val isFirstLaunchKey = "is_first_launch"
        const val userIdKey = "user_id"
    }
}

interface PrefsDataSource {

    fun isFirstLaunch(): Boolean

    fun setFirstLaunch(isFirstLaunch: Boolean)

    fun setCurrentUser(userId: Int)

    fun fetchCurrentUser(): Int
}