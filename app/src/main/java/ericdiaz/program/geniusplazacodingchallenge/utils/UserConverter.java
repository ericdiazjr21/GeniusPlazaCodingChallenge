package ericdiaz.program.geniusplazacodingchallenge.utils;

import androidx.annotation.NonNull;

import ericdiaz.program.geniusplazacodingchallenge.model.NewUser;
import ericdiaz.program.geniusplazacodingchallenge.model.User;

public final class UserConverter {

    public static final String DEFAULT_PROFILE_IMAGE_URL = "https://www.google.com/url?sa=i&source=images&cd=&ved=2ahUKEwi3v5qLoKTkAhXidd8KHZaSCUEQjRx6BAgBEAQ&url=https%3A%2F%2Fcomicvine.gamespot.com%2Fforums%2Fbattles-7%2Froxas-kh2fm-vs-sasuke-uchiha-taka-1506935%2F&psig=AOvVaw0CB2CaIYwVy3glStlkyg6u&ust=1567036512391375";

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
