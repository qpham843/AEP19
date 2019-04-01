package edu.berkeley.aep;

import java.util.List;

public class BestableComparer {
    public Bestable[] unsorted;
    public BestableComparer(Bestable... unsorted) {
        this.unsorted = unsorted;
    }

    public Bestable getBest() {
        var best = unsorted[0];
        for (Bestable cur: unsorted) {
            if (cur.betterThan(best)) {
                best = cur;
            }
        }
        return best;
    }

    public Bestable[] getSorted() {
        return recursiveSort(new Bestable[unsorted.length], unsorted);
    }

    public Bestable[] recursiveSort(Bestable[] sorted, Bestable[] toBeSorted) {
        return unsorted;
    }
}
