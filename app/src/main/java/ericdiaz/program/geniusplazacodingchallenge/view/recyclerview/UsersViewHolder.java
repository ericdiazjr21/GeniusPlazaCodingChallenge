package ericdiaz.program.geniusplazacodingchallenge.view.recyclerview;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import ericdiaz.program.geniusplazacodingchallenge.R;
import ericdiaz.program.geniusplazacodingchallenge.model.User;

public class UsersViewHolder extends RecyclerView.ViewHolder {

    private ImageView userPictureImageView;
    private TextView userFirstNameTextView;
    private TextView userLastNameTextView;

    public UsersViewHolder(@NonNull View itemView) {
        super(itemView);
        userPictureImageView = itemView.findViewById(R.id.user_picture_image_view);
        userFirstNameTextView = itemView.findViewById(R.id.user_first_name_text_view);
        userLastNameTextView = itemView.findViewById(R.id.user_last_name_text_view);
    }


    public void onBind(@NonNull final User user) {
        Picasso.get().load(user.getPhotoUrl()).into(userPictureImageView);
        userFirstNameTextView.setText(user.getFirstName());
        userLastNameTextView.setText(user.getLastName());
    }
}
