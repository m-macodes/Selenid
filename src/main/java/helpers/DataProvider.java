package helpers;

import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

public class DataProvider {
    public static Stream<Arguments> searchParam() {
        return Stream.of(
                Arguments.of("Электроника", "Смартфоны", "Apple", "iPhone")
                //Arguments.of("Электроника", "Смартфоны", "Google", "Pixel")
//                Arguments.of("Электроника", "Смартфоны", "HONOR", "HONOR"),
//                Arguments.of("Электроника", "Смартфоны", "HUAWEI", "HUAWEI"),
//                Arguments.of("Электроника", "Смартфоны", "Nokia", "Nokia"),
//                Arguments.of("Электроника", "Смартфоны", "OnePlus", "OnePlus"),
//                Arguments.of("Электроника", "Смартфоны", "OPPO", "OPPO"),
//                Arguments.of("Электроника", "Смартфоны", "realme", "realme"),
//                Arguments.of("Электроника", "Смартфоны", "Samsung", "Samsung"),
//                Arguments.of("Электроника", "Смартфоны", "vivo", "vivo"),
//                Arguments.of("Электроника", "Смартфоны", "Xiaomi", "Xiaomi"),
//                Arguments.of("Электроника", "Смартфоны", "ZTE", "ZTE")
        );
    }
}
