package ericdiaz.program.geniusplazacodingchallenge.network;

import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * A Retrofit implementation class for connecting to the network
 * <p>
 * Created : 8/26/19
 *
 * @author Eric Diaz
 */

public final class RetrofitServiceGenerator {

    private static final String BASE_URL = "https://reqres.in";
    private static Retrofit singleInstance;

    private static Retrofit getRetrofit() {
        if (singleInstance == null) {
            singleInstance = new Retrofit.Builder()
              .baseUrl(BASE_URL)
              .addConverterFactory(GsonConverterFactory.create())
              .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
              .build();
        }
        return singleInstance;
    }
}
