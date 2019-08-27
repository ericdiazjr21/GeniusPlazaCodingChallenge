package ericdiaz.program.geniusplazacodingchallenge.view;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import ericdiaz.program.geniusplazacodingchallenge.R;
import ericdiaz.program.geniusplazacodingchallenge.utils.PaginationManager;
import ericdiaz.program.geniusplazacodingchallenge.view.recyclerview.UsersAdapter;
import ericdiaz.program.geniusplazacodingchallenge.viewmodel.UsersViewModel;
import io.reactivex.Completable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

/**
 *
 */
public class ViewUsersActivity extends AppCompatActivity
  implements PaginationManager.OnScrollReachedBottomListener {

    private static final String TAG = "ViewUsersActivity";
    private CompositeDisposable compositeDisposable = new CompositeDisposable();
    private UsersViewModel usersViewModel;
    private RecyclerView userRecyclerView;
    private UsersAdapter usersAdapter;
    private PaginationManager paginationManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_users_layout);

        usersViewModel = new ViewModelProvider.NewInstanceFactory().create(UsersViewModel.class);

        paginationManager = new PaginationManager(this);

        initializeRecyclerView();

        initializePaginationListener();

        loadData(usersViewModel, paginationManager, usersAdapter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        compositeDisposable.dispose();
        paginationManager.dispose();
    }

    @Override
    public void loadMoreData() {
        loadData(usersViewModel, paginationManager, usersAdapter);
    }

    private void initializeRecyclerView() {
        userRecyclerView = findViewById(R.id.users_recycler_view);
        userRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        usersAdapter = new UsersAdapter();
        userRecyclerView.setAdapter(usersAdapter);
    }

    /**
     * PaginationManager relies on RecyclerView's ScrollChangeListener to
     * read changes in scroll position as frequently as possible.
     * The watchScrollPosition method takes in the reading of the Scrollbar
     * and computes whether another network call should be made.
     */

    private void initializePaginationListener() {
        userRecyclerView.setOnScrollChangeListener((v, scrollX, scrollY, oldScrollX, oldScrollY) ->

          compositeDisposable.add(Completable.fromAction(() ->

            paginationManager.watchScrollPosition(

              userRecyclerView.computeVerticalScrollExtent(),

              userRecyclerView.computeVerticalScrollOffset(),

              userRecyclerView.computeVerticalScrollRange()))

            .subscribeOn(Schedulers.io())

            .subscribe(() -> {
            }, throwable -> Log.d(TAG, "accept: " + throwable.toString()))));
    }

    private void loadData(@NonNull final UsersViewModel usersViewModel,
                          @NonNull final PaginationManager paginationManager,
                          @NonNull final UsersAdapter usersAdapter) {
        compositeDisposable.add(usersViewModel.getUsers(paginationManager.getCurrentPageNumber())

          .observeOn(AndroidSchedulers.mainThread())

          .subscribe(usersResponse -> {

                paginationManager.setTotalPages(usersResponse.getTotalPages());

                usersAdapter.addData(usersResponse.getUsers());
            },
            throwable -> Log.d(TAG, "accept: " + throwable.toString()),

            () -> Log.d(TAG, "run: Flowable complete")));
    }
}
