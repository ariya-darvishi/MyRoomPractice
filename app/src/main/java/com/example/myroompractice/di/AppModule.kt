package com.example.myroompractice.di

import android.content.Context
import androidx.room.Room
import com.example.myroompractice.data.SchoolDatabase
import com.example.myroompractice.utlis.Constants.DATABASE_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Singleton
    @Provides
    fun provideSchoolDatabase(
        @ApplicationContext context: Context
    ) = Room.databaseBuilder(
        context,
        SchoolDatabase::class.java,
        DATABASE_NAME
    ).build()


}