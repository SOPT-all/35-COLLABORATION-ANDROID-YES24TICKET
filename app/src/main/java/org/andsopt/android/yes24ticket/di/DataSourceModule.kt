package org.andsopt.android.yes24ticket.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import org.andsopt.android.yes24ticket.data.datasource.remote.DummyRemoteDataSource
import org.andsopt.android.yes24ticket.data.datasource.remote.HomeRemoteDataSource
import org.andsopt.android.yes24ticket.data.datasourceImpl.remote.DummyRemoteDataSourceImpl
import org.andsopt.android.yes24ticket.data.datasourceImpl.remote.HomeResmoteDataSourceImpl
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DataSourceModule {
    @Binds
    @Singleton
    abstract fun bindsDummyRemoteDataSource(dummyRemoteDataSourceImpl: DummyRemoteDataSourceImpl): DummyRemoteDataSource

    @Binds
    @Singleton
    abstract fun bindsHomeRemoteDataSource(homeRemoteDataSourceImpl: HomeResmoteDataSourceImpl): HomeRemoteDataSource
}
