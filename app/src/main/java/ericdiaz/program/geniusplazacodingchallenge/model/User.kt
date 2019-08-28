package ericdiaz.program.geniusplazacodingchallenge.model

import com.google.gson.annotations.SerializedName

class User(@field:SerializedName("id")
           private val userId: Int,
           @field:SerializedName("email")
           val emailAddress: String,
           @field:SerializedName("first_name")
           val firstName: String,
           @field:SerializedName("last_name")
           val lastName: String,
           @field:SerializedName("avatar")
           val photoUrl: String) {
    companion object {

        val EMPTY_USER = User(0, "empty", "empty", "empty", "empty")
    }
}
