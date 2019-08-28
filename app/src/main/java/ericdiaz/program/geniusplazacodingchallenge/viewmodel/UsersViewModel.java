package ericdiaz.program.geniusplazacodingchallenge.viewmodel;

import androidx.annotation.NonNull;

import javax.inject.Inject;

import ericdiaz.program.geniusplazacodingchallenge.model.NewUser;
import ericdiaz.program.geniusplazacodingchallenge.model.User;
import ericdiaz.program.geniusplazacodingchallenge.model.UsersResponse;
import ericdiaz.program.geniusplazacodingchallenge.repository.UsersRepository;
import ericdiaz.program.geniusplazacodingchallenge.utils.UserConverter;
import io.reactivex.Flowable;
import io.reactivex.Single;

/**
 * A ViewModel for computation and relaying information between repository layer
 * and view layer
 * <p>
 * Created: 8/26/19
 *
 * @author Eric Diaz
 */

public class UsersViewModel {

    @Inject
    UsersRepository usersRepository;

    public UsersViewModel(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public Flowable<UsersResponse> getUsers(final int pageNumber) {
        return usersRepository.getUsers(pageNumber);
    }

    public Single<User> createUser(@NonNull final NewUser newUser) {
        return usersRepository
          .createUser(
            newUser.getEmailAddress(),
            newUser.getFirstName(),
            newUser.getLastName())

          .map(UserConverter::convertNewUserToSimpleUser);
    }
}
