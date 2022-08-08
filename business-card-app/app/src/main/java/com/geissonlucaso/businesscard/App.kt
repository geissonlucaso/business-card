package com.geissonlucaso.businesscard

import android.app.Application
import com.geissonlucaso.businesscard.data.AppDatabase
import com.geissonlucaso.businesscard.data.BusinessCardRepository

class App : Application() {
    val database by lazy { AppDatabase.getDatabase(this) }
    val repository by lazy { BusinessCardRepository(database.businessDao()) }
}