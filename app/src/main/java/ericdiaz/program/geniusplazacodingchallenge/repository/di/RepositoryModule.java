package ericdiaz.program.geniusplazacodingchallenge.repository.di;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import ericdiaz.program.geniusplazacodingchallenge.network.UserService;
import ericdiaz.program.geniusplazacodingchallenge.repository.UsersRepository;

@Module
public class RepositoryModule {

    @Provides
    @Singleton
    UsersRepository providesUsersRepository(UserService userService) {
        return new UsersRepository(userService);
    }
}
