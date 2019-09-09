package ericdiaz.program.geniusplazacodingchallenge.viewmodel;

import androidx.annotation.NonNull;

import javax.inject.Inject;

import ericdiaz.program.geniusplazacodingchallenge.model.NewUser;
import ericdiaz.program.geniusplazacodingchallenge.model.User;
import ericdiaz.program.geniusplazacodingchallenge.model.UsersResponse;
import ericdiaz.program.geniusplazacodingchallenge.repository.UsersRepository;
import ericdiaz.program.geniusplazacodingchallenge.utils.PaginationManager;
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
    @Inject
    PaginationManager paginationManager;

    public UsersViewModel(@NonNull final UsersRepository usersRepository,
                          @NonNull final PaginationManager paginationManager) {
        this.usersRepository = usersRepository;
        this.paginationManager = paginationManager;
    }

    public Flowable<UsersResponse> getUsers() {
        return usersRepository.getUsers(getCurrentPageNumber())
          .doOnNext(
            usersResponse -> setTotalNumberOfPages(usersResponse.getTotalPages()));
    }

    public Single<User> createUser(@NonNull final NewUser newUser) {
        return usersRepository
          .createUser(
            newUser.getEmailAddress(),
            newUser.getFirstName(),
            newUser.getLastName())

          .map(UserConverter::convertNewUserToSimpleUser);
    }

    public void setPaginationManagerScrollListener(
      @NonNull final PaginationManager.OnScrollReachedBottomListener listener) {
        paginationManager.setScrollListener(listener);
    }

    public void watchScrollPosition(final int extent,
                                    final int offSet,
                                    final int range) {
        paginationManager.watchScrollPosition(extent, offSet, range);
    }

    private int getCurrentPageNumber() {
        return paginationManager.getCurrentPageNumber();
    }

    private void setTotalNumberOfPages(final int numberOfPages) {
        paginationManager.setTotalPages(numberOfPages);
    }


}
