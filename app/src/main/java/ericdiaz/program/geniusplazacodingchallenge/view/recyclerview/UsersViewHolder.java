package ericdiaz.program.geniusplazacodingchallenge.view.recyclerview;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import ericdiaz.program.geniusplazacodingchallenge.R;
import ericdiaz.program.geniusplazacodingchallenge.model.User;

class UsersViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.user_picture_image_view)
    ImageView userPictureImageView;
    @BindView(R.id.user_first_name_text_view)
    TextView userFirstNameTextView;
    @BindView(R.id.user_last_name_text_view)
    TextView userLastNameTextView;

    UsersViewHolder(@NonNull View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }


    void onBind(@NonNull final User user) {
        Picasso.get().load(user.getPhotoUrl()).into(userPictureImageView);
        userFirstNameTextView.setText(user.getFirstName());
        userLastNameTextView.setText(user.getLastName());
    }
}
