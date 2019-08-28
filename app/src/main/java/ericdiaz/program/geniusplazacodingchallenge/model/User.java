package ericdiaz.program.geniusplazacodingchallenge.model;

import com.google.gson.annotations.SerializedName;

public final class User {

    public static final User EMPTY_USER = new User(0, "empty", "empty", "empty", "empty");

    @SerializedName("id")
    private final int userId;

    @SerializedName("email")
    private final String emailAddress;

    @SerializedName("first_name")
    private final String firstName;

    @SerializedName("last_name")
    private final String lastName;

    @SerializedName("avatar")
    private final String photoUrl;

    public User(int userId, String emailAddress, String firstName, String lastName, String photoUrl) {
        this.userId = userId;
        this.emailAddress = emailAddress;
        this.firstName = firstName;
        this.lastName = lastName;
        this.photoUrl = photoUrl;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }
}
