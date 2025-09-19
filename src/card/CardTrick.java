package card;

import java.util.Random;

/**
 * A class that fills a magic hand of 7 cards with random Card Objects
 * and then checks if a hard-coded lucky card (2 of Clubs) is in the hand.
 * To be used in ICE 1.
 *
 * @author srinivsi
 * @modifier Muhammad Abdullah Waseem, Student ID: 991783641
 * @date 2025-09-18
 */
public class CardTrick {
    
    public static void main(String[] args) {
        Random rand = new Random();
        Card[] magicHand = new Card[7];
        
        // Fill magicHand with 7 random cards
        for (int i = 0; i < magicHand.length; i++) {
            Card c = new Card();
            c.setValue(1 + rand.nextInt(13)); // random value 1..13
            c.setSuit(Card.SUITS[rand.nextInt(Card.SUITS.length)]); // random suit
            magicHand[i] = c;
        }
        
        // Hard-coded lucky card: 2 of Clubs
        Card luckyCard = new Card();
        luckyCard.setValue(2);
        luckyCard.setSuit("Clubs");
        System.out.println("Lucky Card is: " + luckyCard.getValue() + " of " + luckyCard.getSuit());
        
        // Search magicHand for luckyCard
        boolean found = false;
        for (Card c : magicHand) {
            if (c.getValue() == luckyCard.getValue() &&
                c.getSuit().equalsIgnoreCase(luckyCard.getSuit())) {
                found = true;
                break;
            }
        }
        
        // Report result
        if (found) {
            System.out.println("WIN! The lucky card is in the magic hand! 🎉");
        } else {
            System.out.println("LOSE! The lucky card is not in the magic hand. ❌");
        }
    }
}
