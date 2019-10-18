package com.n8pickle.autocomp;

import java.util.Arrays;
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
                System.out.println("smaller");
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

//    public static void main(String[] args) {
//        Term[] terms = {new Term("abcd", 0), new Term("bbbb", 0),
//                new Term("abca", 0), new Term("bbbb", 0), new Term("abcd", 0),
//                new Term("cccc", 0), new Term("aaaa", 0),new Term("bbbb", 0),
//                new Term("aaaa", 0), new Term("aaaa", 0), new Term("bbbb", 0)};
//        Arrays.sort(terms, Term.byPrefixOrder(4));
//        for (Term t: terms){
//            System.out.println(t.toString());
//        }
//        int firstIndex = firstIndexOf(terms, new Term("dddd", 0), Term.byPrefixOrder(4));
//        System.out.println(firstIndex);
//        int lastIndex = lastIndexOf(terms, new Term("dddd", 0), Term.byPrefixOrder(4));
//        System.out.println(lastIndex);
//    }
}
