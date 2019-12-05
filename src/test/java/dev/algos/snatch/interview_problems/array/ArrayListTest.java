package dev.algos.snatch.interview_problems.array;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class ArrayListTest {

    @ParameterizedTest
    @MethodSource("listProvider")
    @DisplayName("Add elements to Array list")
    void addElements(ArrayList<Integer> arrayList) {
        assertThat(arrayList.size(), is(10));
        arrayList.add(11);
        assertThat(arrayList.size(), is(11));
    }

    @ParameterizedTest
    @MethodSource("listProvider")
    @DisplayName("Get elements from Array list")
    void getElements(ArrayList<Integer> arrayList) {
        assertEquals(8, arrayList.get(8));
        assertThrows(IndexOutOfBoundsException.class, () -> arrayList.get(10));
    }

    @ParameterizedTest
    @MethodSource("listProvider")
    @DisplayName("Remove elements from Array list")
    void removeElements(ArrayList<Integer> arrayList) {
        assertEquals(10, arrayList.size());

        arrayList.remove(0);

        assertEquals(1, arrayList.get(0));
        assertEquals(9, arrayList.size());
        assertThrows(IndexOutOfBoundsException.class, () -> arrayList.remove(9));

        arrayList.remove(8);

        assertEquals(8, arrayList.size());
    }

    @Test
    @DisplayName("Array List Instance with negative initial capacity")
    void arrayListWithInitialCapacity() {
        assertThrows(IllegalArgumentException.class, () -> new ArrayList<>(-1));
    }

    static Stream<Arguments> listProvider() {
        final ArrayList<Integer> instance = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            instance.add(i);
        }
        return Stream.of(arguments(instance));
    }

}
