package org.andsopt.android.yes24ticket.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import org.andsopt.android.yes24ticket.data.service.CategoryService
import org.andsopt.android.yes24ticket.data.service.DummyService
import org.andsopt.android.yes24ticket.data.service.HomeService
import org.andsopt.android.yes24ticket.data.service.TicketService
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ServiceModule {
    @Provides
    @Singleton
    fun providesDummyService(retrofit: Retrofit): DummyService =
        retrofit.create(DummyService::class.java)

    @Provides
    @Singleton
    fun providesHomeService(retrofit: Retrofit): HomeService =
        retrofit.create(HomeService::class.java)

    @Provides
    @Singleton
    fun providesCategoryService(retrofit: Retrofit): CategoryService =
        retrofit.create(CategoryService::class.java)

    @Provides
    @Singleton
    fun providesTicketService(retrofit: Retrofit): TicketService =
        retrofit.create(TicketService::class.java)
}
