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
            double weightA = a.weight;
            double weightB = b.weight;
            if (weightA > weightB)
                return -1;
            else if (weightA < weightB)
                return 1;
            return 0;
        };
    }

    // Compare the terms in lexicographic order but using only the first r characters of each query.
    public static Comparator<Term> byPrefixOrder(int r) {
        return (a, b) -> {
            if (a.query.length() < r && b.query.length() < r)
                return a.query.compareTo(b.query);
            else if (a.query.length() < r)
                return a.query.compareTo(b.query.substring(0, r-1));
            else if (b.query.length() < r)
                return a.query.substring(0, r-1).compareTo(b.query);
            return a.query.substring(0, r-1).compareTo(b.query.substring(0, r-1));
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

//        int shortest;
//        if (that.query.length() > this.query.length())
//            shortest = this.query.length();
//        else
//            shortest = that.query.length();
//
//        for(int i = 0; i < shortest - 1; i++) {
//            char a = Character.toLowerCase(this.query.charAt(i));
//            char b = Character.toLowerCase(that.query.charAt(i));
//            if (a > b) {
//                return 1;
//            } else if (b > a) {
//                return -1;
//            }
//        }
//        return 0;
    }

    // Return a string representation of the term in the following format:
    // the weight, followed by a tab, followed by the query.
    public String toString() {
        return weight + "   " + query;
    }

}
