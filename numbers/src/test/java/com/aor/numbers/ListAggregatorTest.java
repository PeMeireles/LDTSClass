package com.aor.numbers;

import jdk.internal.org.jline.terminal.impl.LineDisciplineTerminal;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class ListAggregatorTest {
    @BeforeEach
    public void helper() {
        List<Integer> list = Arrays.asList(1,2,4,2,5);

    }
    @Test
    public void Bug_report_7263 () {
        List<Integer> list = Arrays.asList(-1,-4,-5);

        ListAggregator aggregator = new ListAggregator();
        int max = aggregator.max(list);

        Assertions.assertEquals(-1,max);

    }
    @Test
    public void sum() {
        List<Integer> list = Arrays.asList(1,2,4,2,5);

        ListAggregator aggregator = new ListAggregator();
        int sum = aggregator.sum(list);

        Assertions.assertEquals(14, sum);
    }

    @Test
    public void max() {
        List<Integer> list = Arrays.asList(1,2,4,2,5);

        ListAggregator aggregator = new ListAggregator();
        int max = aggregator.max(list);

        Assertions.assertEquals(5, max);
    }

    @Test
    public void min() {
        List<Integer> list = Arrays.asList(1,2,4,2,5);

        ListAggregator aggregator = new ListAggregator();
        int min = aggregator.min(list);

        Assertions.assertEquals(1, min);
    }
    class Stub implements GenericListDeduplicator{
        @Override
        public List<Integer> deduplicate(List<Integer> list) {
            return null;
        }
    }
    @Test
    public void disct_bug_8726 () {
        List<Integer> list = Arrays.asList(1,2,4,2);

        //ListDeduplicator deduplicator = new ListDeduplicator();
        ListAggregator aggregator = new ListAggregator();
        int distinct = aggregator.distinct(Arrays.asList(1, 2, 4, 2), new Stub());

        //ListAggregator aggregator = new ListAggregator();int distinct = aggregator.distinct(Arrays.asList(1, 2, 4, 2), deduplicator);
        //int distinct = aggregator.distinct(list);

        Assertions.assertEquals(3,distinct);
    }
    @Test
    public void distinct() {
        List<Integer> list = Arrays.asList(1,2,4,2,5);

        ListAggregator aggregator = new ListAggregator();
        int distinct = aggregator.distinct(list, new Stub());

        Assertions.assertEquals(4, distinct);
    }
}
