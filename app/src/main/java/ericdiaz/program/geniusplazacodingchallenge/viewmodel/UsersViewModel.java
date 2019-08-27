package ericdiaz.program.geniusplazacodingchallenge.viewmodel;

import androidx.lifecycle.ViewModel;

import ericdiaz.program.geniusplazacodingchallenge.model.UsersResponse;
import ericdiaz.program.geniusplazacodingchallenge.repository.UsersRepository;
import io.reactivex.Flowable;

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
}
