package ericdiaz.program.geniusplazacodingchallenge.viewmodel;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;

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

public class UsersViewModel extends ViewModel {

    private UsersRepository usersRepository;

    public UsersViewModel() {
        usersRepository = new UsersRepository();
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
