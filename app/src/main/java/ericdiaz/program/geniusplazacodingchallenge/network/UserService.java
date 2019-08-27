package ericdiaz.program.geniusplazacodingchallenge.network;

import ericdiaz.program.geniusplazacodingchallenge.model.NewUser;
import ericdiaz.program.geniusplazacodingchallenge.model.UsersResponse;
import io.reactivex.Flowable;
import io.reactivex.Single;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * A service interface for Retrofit to contact User API
 * <p>
 * Created 8/26/19
 *
 * @author Eric Diaz
 */
public interface UserService {

    String PATH = "api/users";

    @GET(PATH)
    Flowable<UsersResponse> getUsers(@Query("page") int pageNumber);

    @POST(PATH)
    @FormUrlEncoded
    Single<NewUser> createUser(@Field("email") String email,
                               @Field("first_name") String firstName,
                               @Field("last_name") String lastName);
}
