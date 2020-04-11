package com.infectapp.domain.repository


/**
 *
 *
 * @author <a href="mailto:jorgevguerra@hotmail.com">Jorge Valiño Guerra</a>
 */
interface LocalStorageRepository {

    fun saveInfectedByUser(username : String)

    fun getInfectedByUser() : String
}