package com.n8pickle.autocomp;

import java.util.Comparator;

public class BinarySearchDeluxe {
    // Return the index of the first key in a[] that equals the search key, or -1 if no such key.
    public static <Key> int firstIndexOf(Key[] a, Key key, Comparator<Key> comparator) {
        int first = 0;
        int last = a.length - 1;
        int index = -1;
        int mid;

        while(first < last) {
            mid = ( first + last ) / 2;
            if (comparator.compare(a[mid], key) == 0) {
                index = mid;
                last = mid - 1;
            } else if (comparator.compare(a[mid], key) < 0) {
                first = mid + 1;
            } else {
                last = mid - 1;
            }
        }
        return index;

    }

    // Return the index of the last key in a[] that equals the search key, or -1 if no such key.
    public static <Key> int lastIndexOf(Key[] a, Key key, Comparator<Key> comparator) {
        int first = 0;
        int last = a.length - 1;
        int index = -1;
        int mid;

        while(first <= last) {
            mid = ( first + last ) / 2;
            if (comparator.compare(a[mid], key) == 0) {
                index = mid;
                first = mid + 1;
            } else if (comparator.compare(a[mid], key) < 0) {
                last = mid - 1;
            } else {
                first = mid + 1;
            }
        }
        return index;
    }
}
