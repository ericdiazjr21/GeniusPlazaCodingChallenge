package ericdiaz.program.geniusplazacodingchallenge.repository;

import androidx.annotation.NonNull;

import javax.inject.Inject;

import ericdiaz.program.geniusplazacodingchallenge.model.NewUser;
import ericdiaz.program.geniusplazacodingchallenge.model.UsersResponse;
import ericdiaz.program.geniusplazacodingchallenge.network.UserService;
import io.reactivex.Flowable;
import io.reactivex.Single;

/**
 * A repository for conducting network call to User API
 * <p>
 * Created 8/26/19
 *
 * @author Eric Diaz
 */

public final class UsersRepository {

    @Inject
    UserService userService;

    UsersRepository(@NonNull final UserService userService) {
        this.userService = userService;
    }

    public Flowable<UsersResponse> getUsers(final int pageNumber) {

        return userService.getUsers(pageNumber);
    }

    public Single<NewUser> createUser(@NonNull final String email,
                                      @NonNull final String firstName,
                                      @NonNull final String lastName) {

        return userService.createUser(email, firstName, lastName);
    }
}
