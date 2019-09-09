package ericdiaz.program.geniusplazacodingchallenge.viewmodel.di;

import androidx.annotation.NonNull;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import ericdiaz.program.geniusplazacodingchallenge.repository.UsersRepository;
import ericdiaz.program.geniusplazacodingchallenge.utils.PaginationManager;
import ericdiaz.program.geniusplazacodingchallenge.viewmodel.UsersViewModel;

@Module
public class ViewModelModule {

    @Provides
    @Singleton
    UsersViewModel providesUsersViewModel(@NonNull final UsersRepository usersRepository,
                                          @NonNull final PaginationManager paginationManager) {
        return new UsersViewModel(usersRepository, paginationManager);
    }

    @Provides
    @Singleton
    PaginationManager providesPaginationManager() {
        return new PaginationManager();
    }
}
