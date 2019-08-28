package ericdiaz.program.geniusplazacodingchallenge.utils;

import androidx.annotation.NonNull;

import ericdiaz.program.geniusplazacodingchallenge.model.NewUser;
import ericdiaz.program.geniusplazacodingchallenge.model.User;

/**
 * A Class to converter from NewUser Objects to User Objects
 * <p>
 * Created 8/28/19
 *
 * @author Eric Diaz
 */

public final class UserConverter {

    public static final String DEFAULT_PROFILE_IMAGE_URL = "https://img.photobucket.com/albums/v16/FoxxLaverinth/random/cutieitachismall.jpg";

    private UserConverter() {
    }

    public static User convertNewUserToSimpleUser(@NonNull final NewUser newUser) {
        if (newUser != null) {
            return new User(newUser.getUserId(), newUser.getEmailAddress(), newUser.getFirstName(), newUser.getLastName(), DEFAULT_PROFILE_IMAGE_URL);
        } else {
            return User.EMPTY_USER;
        }
    }
}
