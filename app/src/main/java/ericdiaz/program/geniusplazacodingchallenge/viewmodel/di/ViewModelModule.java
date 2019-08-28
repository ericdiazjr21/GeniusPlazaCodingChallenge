package ericdiaz.program.geniusplazacodingchallenge.viewmodel.di;

import androidx.annotation.NonNull;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import ericdiaz.program.geniusplazacodingchallenge.repository.UsersRepository;
import ericdiaz.program.geniusplazacodingchallenge.viewmodel.UsersViewModel;

@Module
public class ViewModelModule {

    @Provides
    @Singleton
    UsersViewModel providesUsersViewModel(@NonNull final UsersRepository usersRepository) {
        return new UsersViewModel(usersRepository);
    }
}
