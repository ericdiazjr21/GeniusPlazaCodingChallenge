package ericdiaz.program.geniusplazacodingchallenge.model

import com.google.gson.annotations.SerializedName

class UsersResponse(@field:SerializedName("page")
                    private val pageNumber: Int,
                    @field:SerializedName("per_page")
                    private val resultsPerPage: Int,
                    @field:SerializedName("total")
                    private val totalResults: Int,
                    @field:SerializedName("total_pages")
                    val totalPages: Int,
                    @field:SerializedName("data")
                    val users: List<User>)
