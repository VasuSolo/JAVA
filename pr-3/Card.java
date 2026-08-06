import java.util.Objects;

class Card {
    private String rank;
    private String suit;

    public Card(String rank, String suit) {
        if (rank == null || suit == null) {
            throw new IllegalArgumentException("Rank and suit cannot be null");
        }
        this.rank = rank;
        this.suit = suit;
    }

    public String toString() {
        return rank + " of " + suit;
    }

    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!(obj instanceof Card))
            return false;

        Card other = (Card) obj;
        return rank.equals(other.rank) && suit.equals(other.suit);
    }

    public int hashCode() {
        return Objects.hash(rank, suit);
    }
}

public class Driver {
    public static void main(String[] args) {

        Card[] cards = {
            new Card("Ace", "Spades"),
            new Card("King", "Hearts"),
            new Card("Queen", "Diamonds"),
            new Card("Ace", "Spades"),
            new Card("Jack", "Clubs")
        };

        for (int i = 0; i < cards.length; i++) {
            for (int j = 0; j < i; j++) {
                if (cards[i].equals(cards[j])) {
                    System.out.println("Duplicate found: " + cards[i]);
                    return;
                }
            }
        }
    }
}