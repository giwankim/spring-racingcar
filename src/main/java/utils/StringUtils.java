package utils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringUtils {

  public static final String COMMA_DELIMITER = ",";

  private StringUtils() {
  }

  public static List<String> split(String text) {
    return Arrays.stream(text.split(COMMA_DELIMITER))
        .map(String::trim)
        .collect(Collectors.toList());
  }
}
