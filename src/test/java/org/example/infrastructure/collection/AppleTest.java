package org.example.infrastructure.collection;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.TreeSet;

@ExtendWith(MockitoExtension.class)
class AppleTest {
    @Test
    void testSort() {
        Apple hongfushi = new Apple("hongfushi", 200, LocalDateTime.of(2024, 5, 20, 15, 5));
        Apple guoguang = new Apple("guoguang", 200, LocalDateTime.of(2024, 5, 20, 15, 5));
        System.out.println(hongfushi.compareTo(guoguang));
    }
    @Test
    void testTreeSet() {
        Apple hongfushi = new Apple("hongfushi", 100, LocalDateTime.of(2024, 5, 20, 15, 5));
        Apple guoguang = new Apple("guoguang", 200, LocalDateTime.of(2024, 5, 20, 15, 5));
        Apple green = new Apple("green", 300, LocalDateTime.of(2024, 4, 30, 10, 10));

        List<Apple> apples = Arrays.asList(hongfushi, guoguang, green);
        TreeSet<Apple> appleTreeSet = new TreeSet<>(apples);
        appleTreeSet.forEach(e -> System.out.println(e.toString()));
    }
}