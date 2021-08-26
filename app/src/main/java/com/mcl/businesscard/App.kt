package com.mcl.businesscard

import android.app.Application
import com.mcl.businesscard.data.AppDatabase
import com.mcl.businesscard.data.BusinessCardRepository

class App : Application() {
    private val database by lazy { AppDatabase.getDatabase(this) }
    val repository by lazy { BusinessCardRepository(database.businessDao()) }
}