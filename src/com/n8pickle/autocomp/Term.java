package com.n8pickle.autocomp;

import java.util.Comparator;

public class Term implements Comparable<Term> {
    private String query;
    private double weight;
    // Initialize a term with the given query string and weight.
    public Term(String query, double weight) {
        this.query = query;
        this.weight = weight;
    }

    // Compare the terms in descending order by weight.
    public static Comparator<Term> byReverseWeightOrder() {
        return (a, b) -> {
            return ((Double)b.weight).compareTo((Double)a.weight);
        };
    }

    // Compare the terms in lexicographic order but using only the first r characters of each query.
    public static Comparator<Term> byPrefixOrder(int r) {
        return (a, b) -> {
            String aFormatted = a.query;
            String bFormatted = b.query;
            if(aFormatted.length() > r){
                 aFormatted = aFormatted.substring(0, r);
            }
            if (bFormatted.length() > r){
                bFormatted = bFormatted.substring(0, r);
            }
           return aFormatted.compareTo(bFormatted);
        };
    }

    // Compare the terms in lexicographic order by query.
    public int compareTo(Term that) {
        int comp = this.query.compareTo(that.query);
        if(comp > 0)
            return 1;
        else if (comp < 0)
            return -1;
        else
            return 0;
    }

    // Return a string representation of the term in the following format:
    // the weight, followed by a tab, followed by the query.
    public String toString() {
        return weight + "   " + query;
    }

}
