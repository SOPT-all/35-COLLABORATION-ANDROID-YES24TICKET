package org.andsopt.android.yes24ticket.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import org.andsopt.android.yes24ticket.data.repositoryImpl.CategoryRepositoryImpl
import org.andsopt.android.yes24ticket.data.repositoryImpl.DummyRepositoryImpl
import org.andsopt.android.yes24ticket.data.repositoryImpl.HomeRepositoryImpl
import org.andsopt.android.yes24ticket.data.repositoryImpl.TicketingRepositoryImpl
import org.andsopt.android.yes24ticket.domain.repository.CategoryRepository
import org.andsopt.android.yes24ticket.domain.repository.DummyRepository
import org.andsopt.android.yes24ticket.domain.repository.HomeRepository
import org.andsopt.android.yes24ticket.domain.repository.TicketingRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    @Singleton
    abstract fun bindsDummyRepository(repositoryImpl: DummyRepositoryImpl): DummyRepository

    @Binds
    @Singleton
    abstract fun bindsHomeRepository(repositoryImpl: HomeRepositoryImpl): HomeRepository

    @Binds
    @Singleton
    abstract fun bindsCategoryRepository(repositoryImpl: CategoryRepositoryImpl): CategoryRepository

    @Binds
    @Singleton
    abstract fun bindsTicketingRepository(repositoryImpl: TicketingRepositoryImpl): TicketingRepository
}
