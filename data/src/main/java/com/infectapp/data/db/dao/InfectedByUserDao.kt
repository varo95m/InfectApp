package com.infectapp.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.infectapp.data.db.entities.SaveInfectedByUserDbData


/**
 *
 *
 * @author <a href="mailto:jorgevguerra@hotmail.com">Jorge Valiño Guerra</a>
 */

@Dao
interface InfectedByUserDao : BaseDbDao<SaveInfectedByUserDbData> {

    @Query("SELECT * FROM ${SaveInfectedByUserDbData.TABLE_NAME} ")
    fun getAll() : SaveInfectedByUserDbData


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    override fun insert(vararg entity: SaveInfectedByUserDbData)

}