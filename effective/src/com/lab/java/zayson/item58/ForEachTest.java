package com.lab.java.zayson.item58;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

public class ForEachTest {
    static enum Suit {CLUB, DIAMOND, HEART, SPADE,}

    static enum Rank {ACE, DEUCE, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING,}

    static Collection<Suit> suits = Arrays.asList(Suit.values());
    static Collection<Rank> ranks = Arrays.asList(Rank.values());

    @Test
    @DisplayName("카드 만드는 과정에서 발생할 수 있는 버그")
    void 카드_만드는_과정에서_발생할_수_있는_버그() {
        List<Card> deck = new ArrayList<>();

        for (Iterator<Suit> i = suits.iterator(); i.hasNext(); ) {
            for (Iterator<Rank> j = ranks.iterator(); j.hasNext(); ) {
                // i.next가 되는 시점에서 인덱스를 넘어가버린다. -> NoSuchElementException 발생
                deck.add(new Card(i.next(), j.next()));
            }
        }
    }
}
