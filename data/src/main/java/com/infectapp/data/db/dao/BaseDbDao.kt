package com.infectapp.data.db.dao

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Update

/**
 *
 *
 * @author <a href="mailto:jorgevguerra@hotmail.com">Jorge Valiño Guerra</a>
 */

interface BaseDbDao<T> {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(vararg entity: T)

    @Update
    fun update(vararg entity: T)

    @Delete
    fun delete(entity: T)
}