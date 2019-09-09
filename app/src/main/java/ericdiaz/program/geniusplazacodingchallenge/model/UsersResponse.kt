package ericdiaz.program.geniusplazacodingchallenge.model

import com.google.gson.annotations.SerializedName

data class UsersResponse(
        @SerializedName("page")
        private val pageNumber: Int,
        @SerializedName("per_page")
        private val resultsPerPage: Int,
        @SerializedName("total")
        private val totalResults: Int,
        @SerializedName("total_pages")
        val totalPages: Int,
        @SerializedName("data")
        val users: List<User>)
