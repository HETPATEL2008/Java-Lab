package com.het.practicalthree;

import java.util.Objects;

class Card {

    private String rank;
    private String suit;

    public Card(String rank, String suit) {
        this.rank = rank;
        this.suit = suit;
    }

    @Override
    public String toString() {
        return rank + " of " + suit;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return Objects.equals(rank, card.rank) && Objects.equals(suit, card.suit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rank, suit);
    }
}

public class DuplicateCardChecker {

    public static void main(String[] args) {

        Card[] cards = {
                new Card("Ace", "Spades"),
                new Card("King", "Hearts"),
                new Card("Queen", "Clubs"),
                new Card("Ace", "Spades"),
                new Card("Jack", "Diamonds")
        };

        for (int i = 0; i < cards.length; i++) {

            boolean found = false;

            for (int j = 0; j < i; j++) {

                if (cards[i].equals(cards[j])) {
                    found = true;
                    break;
                }
            }

            if (found) {
                System.out.println("Duplicate found: " + cards[i]);
                break; // Prints only the first duplicate
            }
        }
    }
}
