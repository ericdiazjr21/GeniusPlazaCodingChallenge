package ericdiaz.program.geniusplazacodingchallenge.di;

import javax.inject.Singleton;

import dagger.Component;
import ericdiaz.program.geniusplazacodingchallenge.network.di.NetworkModule;
import ericdiaz.program.geniusplazacodingchallenge.repository.di.RepositoryModule;
import ericdiaz.program.geniusplazacodingchallenge.view.di.ViewModule;
import ericdiaz.program.geniusplazacodingchallenge.view.ViewUsersActivity;
import ericdiaz.program.geniusplazacodingchallenge.viewmodel.di.ViewModelModule;

@Singleton
@Component(modules = {
  NetworkModule.class,
  RepositoryModule.class,
  ViewModelModule.class,
  ViewModule.class
})
public interface AppComponent {

    void inject(ViewUsersActivity viewUsersActivity);
}
