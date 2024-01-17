package com.aor.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class ListFiltererTest {
    @Test
    public void posfiltertest () {
        PositiveFilter positiveFilter = new PositiveFilter();
        ListFilterer listFilterer = new ListFilterer(positiveFilter);

        List<Integer> inputList = Arrays.asList(-1, 0, 1, 2, 3, 4);
        List<Integer> filteredList = listFilterer.filter(inputList);

        List<Integer> expectedList = Arrays.asList(1, 2, 3, 4);
        Assertions.assertEquals(expectedList, filteredList);
    }
    public void divfiltertest () {
        DivisibleByFilter divisibleByFilter = new DivisibleByFilter(2);
        ListFilterer listFilterer = new ListFilterer(divisibleByFilter);

        List<Integer> inputList = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> filteredList = listFilterer.filter(inputList);

        List<Integer> expectedList = Arrays.asList(2, 4, 6);
        Assertions.assertEquals(expectedList, filteredList);
    }

}


