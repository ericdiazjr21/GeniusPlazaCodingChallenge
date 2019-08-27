package ericdiaz.program.geniusplazacodingchallenge.network;

import ericdiaz.program.geniusplazacodingchallenge.model.UsersResponse;
import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * A service interface for Retrofit to contact User API
 * <p>
 * Created 8/26/19
 *
 * @author Eric Diaz
 */
public interface UserService {

    @GET("api/users")
    Flowable<UsersResponse> getUsers(@Query("page") int pageNumber);
}
