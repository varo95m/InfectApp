package com.infectapp.data.db.entities

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.ForeignKey.CASCADE

/**
 *
 *
 * @author <a href="mailto:jorgevguerra@hotmail.com">Jorge Valiño Guerra</a>
 */

@Entity(tableName = SaveInfectedByUserDbData.TABLE_NAME,
        primaryKeys = [SaveInfectedByUserDbData.USERNAME]
//        foreignKeys = [ForeignKey(
//                entity = SaveInfectedByUserDbData::class,
//                parentColumns = [SaveInfectedByUserDbData.REF],
//                childColumns = [SaveInfectedByUserDbData.POLICE],
//                onDelete = CASCADE
//        )]
)
data class SaveInfectedByUserDbData(

        @ColumnInfo(name = SaveInfectedByUserDbData.USERNAME)
        val username : String

) {

    //////////////////////////TABLE///////////////////////////

    companion object {
        const val TABLE_NAME = "save_infected_by_user"
        const val USERNAME = "username"
    }

    //////////////////////////////////////////////////////////



}