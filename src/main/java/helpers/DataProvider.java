package helpers;

import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

public class DataProvider {
    public static Stream<Arguments> searchParam() {
        return Stream.of(
                Arguments.of("Электроника", "Смартфоны", "Apple", "iPhone")
        );
    }
}
