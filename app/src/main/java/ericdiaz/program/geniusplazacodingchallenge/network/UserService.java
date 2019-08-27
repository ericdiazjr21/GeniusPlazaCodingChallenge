package ericdiaz.program.geniusplazacodingchallenge.network;

import ericdiaz.program.geniusplazacodingchallenge.model.UsersResponse;
import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface UserService {

    @GET("api/users")
    Flowable<UsersResponse> getUsers(@Query("page") int page);
}
