/*
 * Java - Algorithms
 * 
 * https://github.com/egalli64/jaal
 */
package com.example.jaal.m2.s06;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNullPointerException;

import org.junit.jupiter.api.Test;

class QuicksortTest {
    @Test
    void plainPlain() {
        int[] data = { 107, 101, 100, 102, 105, 104, 103, 106 };
        int[] expected = { 100, 101, 102, 103, 104, 105, 106, 107 };

        Quicksort.plain(data);
        assertThat(data).isEqualTo(expected);
    }

    @Test
    void plainOrdered() {
        int[] data = { 100, 101, 102, 103, 104, 105, 106, 107 };
        int[] expected = { 100, 101, 102, 103, 104, 105, 106, 107 };

        Quicksort.plain(data);
        assertThat(data).isEqualTo(expected);
    }

    @Test
    void plainEmpty() {
        int[] data = {};
        int[] expected = {};

        Quicksort.plain(data);
        assertThat(data).isEqualTo(expected);
    }

    @Test
    void plainNull() {
        assertThatNullPointerException().isThrownBy(() -> Quicksort.plain(null));
    }
}
