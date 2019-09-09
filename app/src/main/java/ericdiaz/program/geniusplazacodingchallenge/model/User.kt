package ericdiaz.program.geniusplazacodingchallenge.model

import com.google.gson.annotations.SerializedName

data class User(
        @SerializedName("id")
        val userId: Int,
        @SerializedName("email")
        val emailAddress: String,
        @SerializedName("first_name")
        val firstName: String,
        @SerializedName("last_name")
        val lastName: String,
        @SerializedName("avatar")
        val photoUrl: String) {

    companion object {
        val EMPTY_USER = User(0, "empty", "empty", "empty", "empty")
    }
}
