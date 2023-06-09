package com.plcoding.cleanarchitecturenoteapp.di

import android.app.Application
import androidx.room.Room
import com.plcoding.cleanarchitecturenoteapp.data.local.database.AppDatabase
import com.plcoding.cleanarchitecturenoteapp.data.local.database.DictonaryDao
import com.plcoding.cleanarchitecturenoteapp.data.local.remote.DictonaryApi
import com.plcoding.cleanarchitecturenoteapp.data.repository.DataRepositotyImpl
import com.plcoding.cleanarchitecturenoteapp.domain.repository.DataRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideDatabaseBuilder(app:Application):AppDatabase{
        return Room.databaseBuilder(
            app,
            AppDatabase::class.java, "dictonary"
        ).createFromAsset("database/dictonary.db").build()
    }
    @Provides
    @Singleton
    fun provideLessonDao(appDatabase: AppDatabase):DictonaryDao{
        return appDatabase.dictonaryDao();
    }
    @Provides
    @Singleton
    fun provideRepository(dao: DictonaryDao,api:DictonaryApi):DataRepository{
        return DataRepositotyImpl(dao,api);
    }

    @Provides
    @Singleton
    fun provideInstanceDictonay():DictonaryApi{
        return Retrofit.Builder()
            .baseUrl(DictonaryApi.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(DictonaryApi::class.java)
    }
}