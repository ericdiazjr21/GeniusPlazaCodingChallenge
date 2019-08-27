package ericdiaz.program.geniusplazacodingchallenge.repository;

import ericdiaz.program.geniusplazacodingchallenge.model.UsersResponse;
import ericdiaz.program.geniusplazacodingchallenge.network.RetrofitServiceGenerator;
import io.reactivex.Flowable;

/**
 * A repository for conducting network call to User API
 * <p>
 * Created 8/26/19
 *
 * @author Eric Diaz
 */

public final class UsersRepository {

    public Flowable<UsersResponse> getUsers(final int pageNumber) {
        return RetrofitServiceGenerator.getUserService().getUsers(pageNumber);
    }
}
