package edu.farmingdale.bcs421.bcs421_f22_w6_fragmentsdemo

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity

const val SHAREDPREF_FILENAME = "MYSHAREDPREF_FILE"

fun Context.getPreferences(): SharedPreferences =
	getSharedPreferences(SHAREDPREF_FILENAME, AppCompatActivity.MODE_PRIVATE)

