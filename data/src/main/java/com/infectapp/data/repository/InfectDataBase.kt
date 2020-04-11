package com.infectapp.data.repository

import androidx.room.Database
import androidx.room.RoomDatabase
import com.infectapp.data.db.dao.InfectedByUserDao
import com.infectapp.data.db.entities.SaveInfectedByUserDbData


/**
 *
 * <p>
 * Copyright (C) 2019, Babel Sistemas de Información. All rights reserved.
 * </p>
 *
 * @author <a href="mailto:jorge.valino@babel.es">Jorge Valiño Guerra</a>
 */
@Database(
    entities = [
        SaveInfectedByUserDbData::class
    ],
    version = 1,
    exportSchema = true
)
abstract class InfectDataBase : RoomDatabase() {
    abstract fun infectedByUserDao(): InfectedByUserDao
}