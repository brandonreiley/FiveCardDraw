/*not much of dealHand and Player is mine, I found a poker hand
 *strength algorithm that needed the Player class so I then had to 
 *connect my card and createDeck class to each.
 */
public class Main {
	public static void main(String[] args) {
			createDeck pokerDeck = new createDeck();
			dealHand hand = new dealHand(pokerDeck);
			//deck gets shuffled right after the deck arraylist is filled with card objects in createDeck class
			System.out.println("Shuffling ... Shuffling ... Shuffling ...\n");
			hand.currentHand(pokerDeck);
			
	}
}
