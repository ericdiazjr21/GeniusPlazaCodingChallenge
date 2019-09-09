package ericdiaz.program.geniusplazacodingchallenge.view.di;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import ericdiaz.program.geniusplazacodingchallenge.view.recyclerview.UsersAdapter;
import io.reactivex.disposables.CompositeDisposable;

@Module
public class ViewModule {

    @Provides
    @Singleton
    UsersAdapter providesUserAdapter() {
        return new UsersAdapter();
    }

    @Provides
    CompositeDisposable providesCompositeDisposable() {
        return new CompositeDisposable();
    }
}
