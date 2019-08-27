package ericdiaz.program.geniusplazacodingchallenge.utils;

import androidx.annotation.NonNull;

import java.util.concurrent.TimeUnit;

import io.reactivex.Completable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * A Pagination Manager to orchestrate logic for loading more data
 * from the network.
 * <p>
 * Created : 8/27/29
 *
 * @author Eric Diaz
 */

public final class PaginationManager {

    /**
     * PaginationManager defaults to at least 1 page, Errors are handled by
     * network if this is inconsistent with network state.
     */

    private int totalPages = 1;
    private int currentPageNumber = 1;
    private Disposable disposable;
    private final OnScrollReachedBottomListener scrollListener;

    public PaginationManager(@NonNull final OnScrollReachedBottomListener scrollListener) {
        this.scrollListener = scrollListener;
    }

    /**
     * This method tracks the position of the RecyclerView's Scrollbar to
     * decide when it should load more information. it'll load more data
     * if scroll position has reached the bottom and there is more
     * data available to load from the network.
     *
     * @param extent from RecyclerView calculation of scrollbar
     * @param offSet from RecyclerView calculation of scrollbar
     * @param range  from RecyclerView calculation of scrollbar
     */

    public void watchScrollPosition(final int extent,
                                    final int offSet,
                                    final int range) {
        disposable = Completable.fromAction(() -> {

            if (isScrollAtBottom(extent, offSet, range) && arePagesAvailable()) {

                updateCurrentPageNumberToNext();

                scrollListener.loadMoreData();
            }
        }).subscribeOn(Schedulers.computation())

          .delay(1000, TimeUnit.MILLISECONDS)

          .subscribe();
    }

    /**
     * @param totalPages - set at initial load
     */

    public void setTotalPages(final int totalPages) {
        this.totalPages = totalPages;
    }

    private void updateCurrentPageNumberToNext() {
        if (this.currentPageNumber <= totalPages) this.currentPageNumber++;
    }

    public int getCurrentPageNumber() {
        return this.currentPageNumber;
    }

    public void dispose() {
        disposable.dispose();
    }

    private boolean isScrollAtBottom(final int extent,
                                     final int offSet,
                                     final int range) {
        return extent + offSet == range;
    }

    private boolean arePagesAvailable() {
        return totalPages > currentPageNumber;
    }

    public interface OnScrollReachedBottomListener {

        void loadMoreData();
    }

}
