package ericdiaz.program.geniusplazacodingchallenge.utils;

import java.util.concurrent.TimeUnit;

import io.reactivex.Completable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

public class PaginationManager {

    private OnScrollReachedBottomListener listener;
    private CompositeDisposable compositeDisposable = new CompositeDisposable();
    private int pageNumber = 1;
    private int totalPages = 0;

    public PaginationManager(OnScrollReachedBottomListener listener) {
        this.listener = listener;
    }

    public void setTotalPages(final int totalPages) {
        this.totalPages = totalPages;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    private boolean arePagesAvailable() {
        return totalPages >= pageNumber;
    }

    public void scrollReachedBottomCalculator(int extent, int offSet, int range) {
        compositeDisposable.add(Completable.fromAction(() -> {
            if ((extent + offSet) == range) {
                if (arePagesAvailable()) {
                    listener.loadMoreData();
                }
            }
        }).subscribeOn(Schedulers.computation())
          .delay(1000, TimeUnit.MILLISECONDS)
          .subscribe());
    }

    public void updateNextPageNumber() {
        if (this.pageNumber <= totalPages) this.pageNumber++;
    }

    public void tearDown() {
        compositeDisposable.dispose();
    }

    public interface OnScrollReachedBottomListener {
        void loadMoreData();
    }

}
