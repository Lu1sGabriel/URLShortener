package luis.goes.urlshortener.shared.utils;

import java.util.Arrays;
import java.util.stream.Collectors;

public final class NameFormatter {

    private NameFormatter() {
    }

    public static String format(String name) {
        return Arrays.stream(name.trim().split("\\s+"))
                .map(word -> Character.toUpperCase(word.charAt(0)) + word.substring(1).toLowerCase())
                .collect(Collectors.joining(" "));
    }

}