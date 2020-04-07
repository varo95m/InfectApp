package com.infectapp.data.repository

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.UserProfileChangeRequest
import com.google.firebase.firestore.FirebaseFirestore
import com.infectapp.data.COLLECTION_NEWS
import com.infectapp.data.COLLECTION_USERS
import com.infectapp.data.FIELD_CREATION_DATE
import com.infectapp.data.FIELD_USER
import com.infectapp.domain.INT_ZERO
import com.infectapp.domain.fromDateToddMMYY
import com.infectapp.domain.model.*
import com.infectapp.domain.repository.Repository
import java.util.*

/**
 * <p>
 * Copyright (c) 2019, Babel Sistemas de Información. All rights reserved.
 * </p>
 *
 * @author <a href=“mailto:alvaro.montero@babel.es”>Alvaro Montero</a>
 *
 * Date: 2019-11-17
 */

class ApiInfectAppRepository : Repository {

    private val mAuth = FirebaseAuth.getInstance()
    private val db = FirebaseFirestore.getInstance()
    override suspend fun createAccount(requestCreateAccountModel: RequestCreateAccountModel) {
        mAuth.createUserWithEmailAndPassword(requestCreateAccountModel.email, requestCreateAccountModel.password).addOnSuccessListener {
            mAuth.currentUser?.uid?.let { Uid ->
                val user = requestCreateAccountModel.registerModel.copy(
                        creationDate = Date().fromDateToddMMYY(),
                        usersInfected = listOf(InfectedByUserModel(
                                username = "alvaro",
                                date = "04/04/2020"
                        ), InfectedByUserModel(
                                username = "otro",
                                date = "04/04/2020"
                        ))
                )
                db.collection(COLLECTION_USERS).document(Uid).set(user).addOnSuccessListener {
                    mAuth.currentUser?.apply {
                        this.updateProfile(UserProfileChangeRequest.Builder().setDisplayName(email).build())
                        sendEmailVerification().addOnSuccessListener {
                            requestCreateAccountModel.listener.invoke(true)
                        }
                    }
                }.addOnFailureListener {
                    requestCreateAccountModel.listener.invoke(false)
                    mAuth.currentUser?.delete()
                }
            } ?: requestCreateAccountModel.listener.invoke(false)
        }.addOnFailureListener {
            requestCreateAccountModel.listener.invoke(false)
        }
    }

    override suspend fun login(requestLoginModel: RequestLoginModel) {
        mAuth.signInWithEmailAndPassword(requestLoginModel.username, requestLoginModel.password).addOnSuccessListener {
            requestLoginModel.listener.invoke(true)
        }.addOnFailureListener {
            db.collection(COLLECTION_USERS).whereEqualTo(FIELD_USER, requestLoginModel.username).get().addOnCompleteListener {
                if (it.isSuccessful) {
                    it.result?.documents?.let {
                        if (it.isNotEmpty()) {
                            it[INT_ZERO].toObject(UserModel::class.java)?.let { UserModel ->
                                mAuth.signInWithEmailAndPassword(UserModel.email, requestLoginModel.password).addOnSuccessListener {
                                    requestLoginModel.listener.invoke(true)
                                }.addOnFailureListener {
                                    requestLoginModel.listener.invoke(false)
                                }
                            }
                        } else {
                            requestLoginModel.listener.invoke(false)
                        }
                    }
                }
            }.addOnFailureListener {
                requestLoginModel.listener.invoke(false)
            }
        }
    }

    override suspend fun getInfectedList(requestUserList: RequestUserList) {
        val userList = mutableListOf<InfectedUserModel>()
        db.collection(COLLECTION_USERS).get().addOnSuccessListener {
            for (document in it) {
                userList.add(document.toObject(InfectedUserModel::class.java))
            }
            requestUserList.listener.invoke(userList)
        }
    }

    override suspend fun getTotalInfected(requestTotalInfectedModel: RequestTotalInfectedModel) {
        db.collection(COLLECTION_USERS).get().addOnSuccessListener {
            requestTotalInfectedModel.listener.invoke(it.size())
        }
    }

    override suspend fun getCurrentUser(requestCurrentUser: RequestCurrentUser) {
        mAuth.currentUser?.let {
            db.collection(COLLECTION_USERS).document(it.uid).get().addOnSuccessListener {
                it.toObject(InfectedUserModel::class.java)?.let { CurrentUser ->
                    requestCurrentUser.listener.invoke(CurrentUser)
                }
            }.addOnFailureListener {
                requestCurrentUser.errorListener.invoke(Unit)
            }
        }
    }

    override suspend fun getInfectedAtDay(requestInfectedAtDay: RequestInfectedAtDay) {
        db.collection(COLLECTION_USERS).whereEqualTo(FIELD_CREATION_DATE, Date().fromDateToddMMYY()).get().addOnSuccessListener {
            requestInfectedAtDay.listener.invoke(it.size())
        }
    }

    override suspend fun getNewsList(requestNewsList: RequestNewsList) {
        val newsList = mutableListOf<NewModel>()
        db.collection(COLLECTION_NEWS).get().addOnSuccessListener {
            for (document in it) {
                newsList.add(document.toObject(NewModel::class.java))
            }
            requestNewsList.listener.invoke(newsList)
        }
    }
}