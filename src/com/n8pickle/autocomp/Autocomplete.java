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
        int first = 0;
        int last = terms.length - 1;
        int middle;
          while (first <= last)
          {
              middle = (first + last) / 2;
              if(terms[middle].compareTo(new Term(prefix, 0))  == 0)
                  return linearSearch(terms, middle, prefix);
              else if (terms[middle].compareTo(new Term(prefix, 0)) < 0 )
                  last = middle;
              else
                  first = middle;
          }
          return new Term[1];
    }

    // Return the number of terms that start with the given prefix.
    public int numberOfMatches(String prefix) {
            return allMatches(prefix).length;
    }

    private Term[] linearSearch(Term[] middle, int mid, String prefix) {
        boolean left = false;
        boolean right = false;
        int searchBreadth = middle.length / 2;
        Term[] matches = new Term[10];
        matches[0] = middle[mid];
        int i = 1;
        while (!left && searchBreadth >= i) {
            if(middle[mid - i].compareTo(new Term(prefix, 0)) == 0) {
                if(i + 1 == matches.length) {
                    matches = Arrays.copyOf(matches, matches.length*2);
                }
                matches[i] = middle[mid - i];
                i++;
            } else {
                left = true;
            }
        }
        int j = 1;
        while (!right && searchBreadth >= j) {
            if(middle[mid - j].compareTo(new Term(prefix, 0)) == 0) {
                if(i + j + 1 == matches.length) {
                    matches = Arrays.copyOf(matches, matches.length*2);
                }
                matches[i + j] = middle[mid + j];
                j++;
            } else {
                right = true;
            }
        }
        Arrays.sort(matches, Term.byReverseWeightOrder());
        return matches;
    }
}
