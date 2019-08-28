package ericdiaz.program.geniusplazacodingchallenge.repository;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import ericdiaz.program.geniusplazacodingchallenge.network.UserService;

@Module
public class RepositoryModule {

    @Provides
    @Singleton
    UsersRepository providesUsersRepository(UserService userService) {
        return new UsersRepository(userService);
    }
}
