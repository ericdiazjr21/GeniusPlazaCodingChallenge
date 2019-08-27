package ericdiaz.program.geniusplazacodingchallenge.view.recyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import ericdiaz.program.geniusplazacodingchallenge.R;
import ericdiaz.program.geniusplazacodingchallenge.model.User;

public class UsersAdapter extends RecyclerView.Adapter<UsersViewHolder> {

    private User[] users;

    @NonNull
    @Override
    public UsersViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.users_item_view, parent, false);
        return new UsersViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UsersViewHolder holder, int position) {
        holder.onBind(users[position]);
    }

    @Override
    public int getItemCount() {
        return users == null ? 0 : users.length;
    }

    public void setData(User[] users) {
        this.users = users;
        notifyDataSetChanged();
    }
}
