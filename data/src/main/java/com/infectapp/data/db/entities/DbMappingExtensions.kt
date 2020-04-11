package com.infectapp.data.db.entities


/**
 *
 *
 * @author <a href="mailto:jorgevguerra@hotmail.com">Jorge Valiño Guerra</a>
 */
fun String.toDbModel(): SaveInfectedByUserDbData {
    return SaveInfectedByUserDbData(
        username = this
    )
}