package org.andsopt.android.yes24ticket.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import org.andsopt.android.yes24ticket.data.service.DummyService
import org.andsopt.android.yes24ticket.data.service.TicketingService
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ServiceModule {

    @Provides
    @Singleton
    fun provideDummyService(retrofit: Retrofit): DummyService =
        retrofit.create(DummyService::class.java)

    @Provides
    @Singleton
    fun providesTicketingService(retrofit: Retrofit): TicketingService =
        retrofit.create(TicketingService::class.java)
}
