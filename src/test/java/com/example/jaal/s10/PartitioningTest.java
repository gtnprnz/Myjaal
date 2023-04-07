/*
 * Java - Algorithms
 * 
 * https://github.com/egalli64/jaal
 */
package com.example.jaal.s10;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.assertThatNullPointerException;

import org.junit.jupiter.api.Test;

class PartitioningTest {
    @Test
    void pivotLeftPlain() {
        int pivot = 6;
        int[] values = { pivot, 1, 8, 5, 7, 0, 9, 3, -1, -3, 18, 10, 2 };
        int expected = 7;

        int actual = Partitioning.pivotLeft(values);
        assertThat(actual).isEqualTo(expected);
        for (int i = 0; i < actual; i++) {
            assertThat(values[i]).isLessThanOrEqualTo(pivot);
        }

        for (int i = actual; i < values.length; i++) {
            assertThat(values[i]).isGreaterThanOrEqualTo(pivot);
        }
    }

    @Test
    void pivotLeftDuplicates() {
        int pivot = 6;
        int[] values = { pivot, 1, 8, 5, 7, 1, 9, 3, 5, 3, 8, 7, 2, 6 };
        int expected = 8;

        int actual = Partitioning.pivotLeft(values);
        assertThat(actual).isEqualTo(expected);
        for (int i = 0; i < actual; i++) {
            assertThat(values[i]).isLessThanOrEqualTo(pivot);
        }

        for (int i = actual; i < values.length; i++) {
            assertThat(values[i]).isGreaterThanOrEqualTo(pivot);
        }
    }

    @Test
    void pivotLeftNull() {
        assertThatNullPointerException().isThrownBy(() -> Partitioning.pivotLeft(null));
    }

    @Test
    void pivotLeftEmpty() {
        assertThatExceptionOfType(ArrayIndexOutOfBoundsException.class)
                .isThrownBy(() -> Partitioning.pivotLeft(new int[] {}));
    }

    @Test
    void pivotGivenPlain() {
        int pivotPos = 4;
        int pivot = 6;
        int[] values = { 7, 1, 8, 5, pivot, 0, 9, 3, -1, -3, 18, 10, 2 };
        int expected = 7;

        int actual = Partitioning.pivotGiven(values, pivotPos);
        assertThat(actual).isEqualTo(expected);
        for (int i = 0; i < actual; i++) {
            assertThat(values[i]).isLessThanOrEqualTo(pivot);
        }

        for (int i = actual; i < values.length; i++) {
            assertThat(values[i]).isGreaterThanOrEqualTo(pivot);
        }
    }

    @Test
    void pivotGivenDuplicates() {
        int pivotPos = 4;
        int pivot = 6;
        int[] values = { 7, 1, 8, 5, pivot, 1, 9, 3, 5, 3, 8, 7, 2, 6 };
        int expected = 8;

        int actual = Partitioning.pivotGiven(values, pivotPos);
        assertThat(actual).isEqualTo(expected);
        for (int i = 0; i < actual; i++) {
            assertThat(values[i]).isLessThanOrEqualTo(pivot);
        }

        for (int i = actual; i < values.length; i++) {
            assertThat(values[i]).isGreaterThanOrEqualTo(pivot);
        }
    }

    @Test
    void pivotGivenNull() {
        assertThatNullPointerException().isThrownBy(() -> Partitioning.pivotGiven(null, 0));
    }

    @Test
    void pivotGivenEmpty() {
        assertThatExceptionOfType(ArrayIndexOutOfBoundsException.class)
                .isThrownBy(() -> Partitioning.pivotGiven(new int[] {}, 0));
    }
    

    @Test
    void pivotGivenBadPosition() {
        assertThatExceptionOfType(ArrayIndexOutOfBoundsException.class)
                .isThrownBy(() -> Partitioning.pivotGiven(new int[] {42}, 42));
    }
}
