package ericdiaz.program.geniusplazacodingchallenge.view;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import ericdiaz.program.geniusplazacodingchallenge.R;
import ericdiaz.program.geniusplazacodingchallenge.model.NewUser;
import ericdiaz.program.geniusplazacodingchallenge.utils.PaginationManager;
import ericdiaz.program.geniusplazacodingchallenge.view.constants.ViewConstants;
import ericdiaz.program.geniusplazacodingchallenge.view.recyclerview.UsersAdapter;
import ericdiaz.program.geniusplazacodingchallenge.viewmodel.UsersViewModel;
import io.reactivex.Completable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Activity for viewing existing users from network
 * <p>
 * Created: 8/26/19
 *
 * @author Eric Diaz
 */
public final class ViewUsersActivity extends AppCompatActivity
  implements PaginationManager.OnScrollReachedBottomListener {

    @BindView(R.id.users_recycler_view)
    RecyclerView userRecyclerView;
    private UsersAdapter usersAdapter;
    private UsersViewModel usersViewModel;
    private PaginationManager paginationManager;
    private CompositeDisposable compositeDisposable = new CompositeDisposable();
    private static final String TAG = "ViewUsersActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_users_layout);
        ButterKnife.bind(this);
        
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
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {

            if (data != null && data.getExtras() != null) {

                NewUser newUser = (NewUser) data.getExtras().get(ViewConstants.NEW_USER);

                if (newUser != null) {

                    compositeDisposable.add(

                      usersViewModel.createUser(newUser)

                        .observeOn(AndroidSchedulers.mainThread())

                        .subscribe(user -> {

                              usersAdapter.addData(user);

                              userRecyclerView.scrollToPosition(0);
                          },

                          throwable -> Log.d(TAG, "accept: " + throwable.toString())));
                }
            }
        }
    }

    @Override
    public void loadMoreData() {
        loadData(usersViewModel, paginationManager, usersAdapter);
    }

    @OnClick(R.id.add_user_fab)
    void startAddNewUserActivity() {
        Intent addUserIntent = new Intent(ViewUsersActivity.this, AddUserActivity.class);
        startActivityForResult(addUserIntent, ViewConstants.ADD_USER_REQUEST_CODE);
    }

    private void initializeRecyclerView() {
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
