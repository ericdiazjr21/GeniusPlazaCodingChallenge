package ericdiaz.program.geniusplazacodingchallenge.model;

import com.google.gson.annotations.SerializedName;

public final class UsersResponse {

    @SerializedName("page")
    private final int pageNumber;

    @SerializedName("per_page")
    private final int resultsPerPage;

    @SerializedName("total")
    private final int totalResults;

    @SerializedName("total_pages")
    private final int totalPages;

    @SerializedName("data")
    private final User[] users;

    public UsersResponse(int pageNumber, int resultsPerPage, int totalResults, int totalPages, User[] users) {
        this.pageNumber = pageNumber;
        this.resultsPerPage = resultsPerPage;
        this.totalResults = totalResults;
        this.totalPages = totalPages;
        this.users = users;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public int getResultsPerPage() {
        return resultsPerPage;
    }

    public int getTotalResults() {
        return totalResults;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public User[] getUsers() {
        return users;
    }
}
