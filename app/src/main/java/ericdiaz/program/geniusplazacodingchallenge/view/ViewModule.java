package ericdiaz.program.geniusplazacodingchallenge.view;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import ericdiaz.program.geniusplazacodingchallenge.utils.PaginationManager;
import ericdiaz.program.geniusplazacodingchallenge.view.recyclerview.UsersAdapter;
import io.reactivex.disposables.CompositeDisposable;

@Module
public class ViewModule {

    @Provides
    @Singleton
    PaginationManager providesPaginationManager() {
        return new PaginationManager();
    }

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
