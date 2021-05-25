package com.example.noteapprezzaarsdy

import android.content.Context
import android.provider.ContactsContract
import android.room.Database
import android.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Note::class], exportSchema = false, version = 1)
abstract class AppDatabase : RoomDatabase(){
    abstract  fun noteDao() : NoteDao

        companion object{

        private const val DB_NAME = "NOTE_DB"
        private var instance = AppDatabase? = null

        fun getInstance(context: Context): AppDatabase? {
            if (instance == null){
                synchronized(AppDatabase::class) {
                    instance = Room
                        .databaseBuilder(
                                context,
                                AppDatabase::class.java,
                                DB_NAME
                        )
                        .build()
                }
            }
            return instance
        }
    }
}