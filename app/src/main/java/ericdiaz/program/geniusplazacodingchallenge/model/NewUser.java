package ericdiaz.program.geniusplazacodingchallenge.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public final class NewUser implements Serializable {

    @SerializedName("id")
    private final int userId;

    @SerializedName("email")
    private final String emailAddress;

    @SerializedName("first_name")
    private final String firstName;

    @SerializedName("last_name")
    private final String lastName;

    @SerializedName("createdAt")
    private final String timeCreated;

    public NewUser(int userId, String emailAddress, String firstName, String lastName, String timeCreated) {
        this.userId = userId;
        this.emailAddress = emailAddress;
        this.firstName = firstName;
        this.lastName = lastName;
        this.timeCreated = timeCreated;
    }

    public int getUserId() {
        return userId;
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

    public String getTimeCreated() {
        return timeCreated;
    }

    @Override
    public String toString() {
        return "NewUser{" +
          "userId=" + userId +
          ", emailAddress='" + emailAddress + '\'' +
          ", firstName='" + firstName + '\'' +
          ", lastName='" + lastName + '\'' +
          ", timeCreated='" + timeCreated + '\'' +
          '}';
    }
}
