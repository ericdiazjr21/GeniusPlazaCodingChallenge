package ericdiaz.program.geniusplazacodingchallenge.model

import com.google.gson.annotations.SerializedName

import java.io.Serializable

class NewUser(@field:SerializedName("id")
              val userId: Int,
              @field:SerializedName("email")
              val emailAddress: String,
              @field:SerializedName("first_name")
              val firstName: String,
              @field:SerializedName("last_name")
              val lastName: String,
              @field:SerializedName("createdAt")
              val timeCreated: String?) : Serializable {

    override fun toString(): String {
        return "NewUser{" +
                "userId=" + userId +
                ", emailAddress='" + emailAddress + '\''.toString() +
                ", firstName='" + firstName + '\''.toString() +
                ", lastName='" + lastName + '\''.toString() +
                ", timeCreated='" + timeCreated + '\''.toString() +
                '}'.toString()
    }
}
