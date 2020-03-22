package com.infectapp.data.repository

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.UserProfileChangeRequest
import com.google.firebase.firestore.FirebaseFirestore
import com.infectapp.domain.model.InfectedUserModel
import com.infectapp.data.COLLECTION_USERS
import com.infectapp.data.FIELD_USER
import com.infectapp.domain.INT_ZERO
import com.infectapp.domain.fromDateToddMMYY
import com.infectapp.domain.model.RequestCreateAccountModel
import com.infectapp.domain.model.RequestLoginModel
import com.infectapp.domain.model.UserModel
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

class ApiMrRepository : Repository {

    private val mAuth = FirebaseAuth.getInstance()
    private val db = FirebaseFirestore.getInstance()
    override suspend fun createAccount(requestCreateAccountModel: RequestCreateAccountModel) {
        mAuth.createUserWithEmailAndPassword(requestCreateAccountModel.email, requestCreateAccountModel.password).addOnSuccessListener {
            mAuth.currentUser?.uid?.let { Uid ->
                val user = requestCreateAccountModel.registerModel.copy(
                        creationDate = Date().fromDateToddMMYY()
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

    override suspend fun getInfectedList() : List<InfectedUserModel> {
        return listOf() //.toDomainModel()
    }
}