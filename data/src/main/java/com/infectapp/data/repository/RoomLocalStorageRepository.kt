package com.infectapp.data.repository

import android.content.Context
import androidx.room.Room
import com.infectapp.data.BuildConfig
import com.infectapp.data.db.entities.toDbModel
import com.infectapp.domain.repository.LocalStorageRepository


/**
 *
 *
 * @author <a href="mailto:jorgevguerra@hotmail.com">Jorge Valiño Guerra</a>
 */
class RoomLocalStorageRepository(
    private val context: Context
) : LocalStorageRepository {

    val db: InfectDataBase by lazy {
        val build = Room.databaseBuilder(
            context.applicationContext,
            InfectDataBase::class.java,
            BuildConfig.DB_NAME
        )
            .allowMainThreadQueries()
        build.build()
    }

    override fun saveInfectedByUser(username: String) {
        db.infectedByUserDao().insert(username.toDbModel())
    }

    override fun getInfectedByUser(): String {
        return db.infectedByUserDao().getAll().username
    }


}