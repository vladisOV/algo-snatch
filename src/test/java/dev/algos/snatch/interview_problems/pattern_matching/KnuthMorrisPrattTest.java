package dev.algos.snatch.interview_problems.pattern_matching;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class KnuthMorrisPrattTest {

    @Test
    void test() {
        KnuthMorrisPratt kmp = new KnuthMorrisPratt();
//        assertTrue(kmp.kmp("adsgwadsxdsgwadsgz", "dsgwadsgz"));
        assertTrue(kmp.kmp("aabaaabaaac", "aabaaac"));
    }

    @Test
    void testTable() {
        KnuthMorrisPratt kmp = new KnuthMorrisPratt();
        assertEquals(new int[]{0, 0, 0, 0, 0, 1, 2, 3}, kmp.buildTable("dsgwadsgz"));
    }

    @Test
    void testTableKT() {
        KnuthMorrisPrattKT kmp = new KnuthMorrisPrattKT();
//        assertEquals(new int[]{0,0,0,0,0,1,2,3}, kmp.buildTable("dsgwadsgz"));
        assertEquals(new int[]{0, 0, 0, 0, 0, 1, 2, 3}, kmp.buildTable("AAACAAAAAC"));
    }
}
