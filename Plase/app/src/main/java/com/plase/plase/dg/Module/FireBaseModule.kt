package com.plase.plase.dg.Module

import com.google.firebase.firestore.FirebaseFirestore
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import dagger.hilt.android.scopes.ViewScoped
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(ViewModelComponent::class)
class FireBaseModule {

    @ViewModelScoped
    @Provides
    fun getFireBaseStore(): FirebaseFirestore {
        return FirebaseFirestore.getInstance()
    }

}