package com.aor.numbers;

import jdk.internal.org.jline.terminal.impl.LineDisciplineTerminal;
import java.util.ArrayList;
import java.util.List;


interface GenericListFilter {
    boolean accept(Integer number);
}
// Implement the PositiveFilter class
class PositiveFilter implements GenericListFilter {
    @Override
    public boolean accept(Integer number) {
        return number > 0;
    }
}

// Implement the DivisibleByFilter class
class DivisibleByFilter implements GenericListFilter {
    int divisor;

    public DivisibleByFilter(int divisor) {
        this.divisor = divisor;
    }

    @Override
    public boolean accept(Integer number) {
        return number % divisor == 0;
    }
}
public class ListFilterer {
    GenericListFilter filter;

    public ListFilterer(GenericListFilter filter) {
        this.filter = filter;
    }

    public List<Integer> filter(List<Integer> list) {
        List<Integer> filteredList = new ArrayList<>();
        for (Integer number : list) {
            if (filter.accept(number)) {
                filteredList.add(number);
            }
        }
        return filteredList;
    }
}
