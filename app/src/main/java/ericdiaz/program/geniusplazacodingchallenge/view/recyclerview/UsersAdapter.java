package ericdiaz.program.geniusplazacodingchallenge.view.recyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import ericdiaz.program.geniusplazacodingchallenge.R;
import ericdiaz.program.geniusplazacodingchallenge.model.User;

public class UsersAdapter extends RecyclerView.Adapter<UsersViewHolder> {

    private final List<User> users = new ArrayList<>();

    @NonNull
    @Override
    public UsersViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.users_item_view, parent, false);
        return new UsersViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UsersViewHolder holder, int position) {
        holder.onBind(users.get(position));
    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    public void addData(List<User> users) {
        this.users.addAll(users);
        notifyItemRangeInserted(this.users.size() - 1, users.size());
    }
}
