package ericdiaz.program.geniusplazacodingchallenge.view;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import ericdiaz.program.geniusplazacodingchallenge.R;
import ericdiaz.program.geniusplazacodingchallenge.view.recyclerview.UsersAdapter;
import ericdiaz.program.geniusplazacodingchallenge.viewmodel.UsersViewModel;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;

public class ViewUsersActivity extends AppCompatActivity {

    private static final String TAG = "ViewUsersActivity";
    private Disposable disposable;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_users_layout);

        UsersViewModel usersViewModel = new ViewModelProvider.NewInstanceFactory().create(UsersViewModel.class);

        RecyclerView userRecyclerView = findViewById(R.id.users_recycler_view);
        userRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        UsersAdapter usersAdapter = new UsersAdapter();
        userRecyclerView.setAdapter(usersAdapter);

        disposable = usersViewModel.getUsers(1)
          .observeOn(AndroidSchedulers.mainThread())
          .subscribe(usersResponse -> {
                Log.d(TAG, "onCreate: " + usersResponse.getPageNumber());
                usersAdapter.setData(usersResponse.getUsers());
            },
            throwable -> Log.d(TAG, "accept: " + throwable.toString()),
            () -> Log.d(TAG, "run: Flowable complete"));

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        disposable.dispose();
    }
}
