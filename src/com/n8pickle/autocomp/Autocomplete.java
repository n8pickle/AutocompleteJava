package com.n8pickle.autocomp;

import java.util.Arrays;

public class Autocomplete {
    private Term[] terms;
    // Initialize the data structure from the given array of terms.
    public Autocomplete(Term[] terms) {
    this.terms = terms;
    }

    // Return all terms that start with the given prefix, in descending order of weight.
    public Term[] allMatches(String prefix) {
        Arrays.sort(terms, Term.byPrefixOrder(prefix.length()));
        int start = BinarySearchDeluxe.firstIndexOf(terms, new Term(prefix, 0),
                Term.byPrefixOrder(prefix.length()));
        int end = BinarySearchDeluxe.lastIndexOf(terms, new Term(prefix, 0),
                Term.byPrefixOrder(prefix.length()));
        Term[] result = Arrays.copyOfRange(terms, start, end);
        Arrays.sort(terms, Term.byReverseWeightOrder());
        return result;
    }

    // Return the number of terms that start with the given prefix.
    public int numberOfMatches(String prefix) {
            return allMatches(prefix).length;
    }

}
