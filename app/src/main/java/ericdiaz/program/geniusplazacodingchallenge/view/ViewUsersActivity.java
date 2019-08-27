package ericdiaz.program.geniusplazacodingchallenge.view;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import ericdiaz.program.geniusplazacodingchallenge.R;
import ericdiaz.program.geniusplazacodingchallenge.utils.PaginationManager;
import ericdiaz.program.geniusplazacodingchallenge.view.recyclerview.UsersAdapter;
import ericdiaz.program.geniusplazacodingchallenge.viewmodel.UsersViewModel;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;

public class ViewUsersActivity extends AppCompatActivity implements PaginationManager.OnScrollReachedBottomListener {

    private static final String TAG = "ViewUsersActivity";
    private Disposable disposable;
    private UsersAdapter usersAdapter;
    private PaginationManager paginationManager;
    private UsersViewModel usersViewModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_users_layout);

        usersViewModel = new ViewModelProvider.NewInstanceFactory().create(UsersViewModel.class);
        paginationManager = new PaginationManager(this);

        RecyclerView userRecyclerView = findViewById(R.id.users_recycler_view);
        userRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        usersAdapter = new UsersAdapter();
        userRecyclerView.setAdapter(usersAdapter);

        userRecyclerView.setOnScrollChangeListener((v, scrollX, scrollY, oldScrollX, oldScrollY) ->
          paginationManager.scrollReachedBottomCalculator(
            userRecyclerView.computeVerticalScrollExtent(),
            userRecyclerView.computeVerticalScrollOffset(),
            userRecyclerView.computeVerticalScrollRange()));

        loadData(usersViewModel, paginationManager, usersAdapter);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        disposable.dispose();
        paginationManager.tearDown();
    }

    private void loadData(UsersViewModel usersViewModel, PaginationManager paginationManager, UsersAdapter usersAdapter) {
        disposable = usersViewModel.getUsers(paginationManager.getPageNumber())
          .observeOn(AndroidSchedulers.mainThread())
          .subscribe(usersResponse -> {
                paginationManager.setTotalPages(usersResponse.getTotalPages());
                paginationManager.updateNextPageNumber();
                usersAdapter.setData(usersResponse.getUsers());
            },
            throwable -> Log.d(TAG, "accept: " + throwable.toString()),
            () -> Log.d(TAG, "run: Flowable complete"));
    }

    @Override
    public void loadMoreData() {
        loadData(usersViewModel, paginationManager, usersAdapter);
    }
}
