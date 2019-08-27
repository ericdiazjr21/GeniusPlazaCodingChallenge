package ericdiaz.program.geniusplazacodingchallenge.repository;

import ericdiaz.program.geniusplazacodingchallenge.model.UsersResponse;
import ericdiaz.program.geniusplazacodingchallenge.network.RetrofitServiceGenerator;
import io.reactivex.Flowable;

public final class UsersRepository {

    public Flowable<UsersResponse> getUsers(final int page) {
        return RetrofitServiceGenerator.getUserService().getUsers(page);
    }
}
