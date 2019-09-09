package ericdiaz.program.geniusplazacodingchallenge.model

import com.google.gson.annotations.SerializedName

import java.io.Serializable

data class NewUser(
        @SerializedName("id")
        val userId: Int,
        @SerializedName("email")
        val emailAddress: String,
        @SerializedName("first_name")
        val firstName: String,
        @SerializedName("last_name")
        val lastName: String,
        @SerializedName("createdAt")
        val timeCreated: String?) : Serializable
