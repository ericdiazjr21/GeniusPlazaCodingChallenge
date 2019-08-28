package ericdiaz.program.geniusplazacodingchallenge.utils;

import androidx.annotation.NonNull;

/**
 * A simple String checker class
 * <p>
 * Created : 8/27/19
 *
 * @author Eric Diaz
 */

public final class StringChecker {

    private StringChecker() {
    }

    public static boolean isEmpty(@NonNull final String input) {
        return input.equals("") || input == null;
    }
}
