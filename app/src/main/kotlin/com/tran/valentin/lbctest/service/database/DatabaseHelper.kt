package com.tran.valentin.lbctest.service.database

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.util.Log
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper
import com.j256.ormlite.support.ConnectionSource
import com.j256.ormlite.table.TableUtils
import com.tran.valentin.lbctest.service.model.Album
import java.sql.SQLException


class DatabaseHelper(private val context: Context) :
    OrmLiteSqliteOpenHelper(context, DB_NAME, null, DB_VERSION) {
    companion object {
        private const val DB_NAME = "lbc.db"
        private const val DB_VERSION = 1
        private const val TAG = "Database"

        @Volatile
        private var INSTANCE: DatabaseHelper? = null

        fun getInstance(context: Context): DatabaseHelper =
            INSTANCE ?: synchronized(this) { initialize(context).also { INSTANCE = it } }

        private fun initialize(context: Context): DatabaseHelper {
            return DatabaseHelper(context)
        }
    }

    override fun onCreate(
        sqLiteDatabase: SQLiteDatabase?,
        connectionSource: ConnectionSource?
    ) {
        try {
            TableUtils.createTable(connectionSource, Album::class.java)
        } catch (e: SQLException) {
            Log.e(TAG, "Error creating table", e)
        }
    }

    override fun onUpgrade(
        sqLiteDatabase: SQLiteDatabase?,
        connectionSource: ConnectionSource?,
        i: Int,
        i2: Int
    ) {
        try {
            TableUtils.dropTable<Album, Any>(getConnectionSource(), Album::class.java, true)
        } catch (e: SQLException) {
            Log.e(TAG, "Error dropping table", e)
        }
    }
}