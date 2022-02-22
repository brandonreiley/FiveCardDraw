import java.util.ArrayList;
import java.util.Collections;

/*create deck class is where an arraylist of type card
 * is filled with cards and is then shuffled 
 * by calling a shuffle method in Collections
 */
public class createDeck {
	ArrayList<Card> deck = new ArrayList<Card>();
	int cardCount = 51; //0-51 = 52 card deck

	public createDeck() {
		
		//fills deck with cards in order from 2-ace of each suit
		for (Card.Suit suit : Card.Suit.values()) {
			for (Card.Rank rank : Card.Rank.values()) {
				deck.add(new Card(suit, rank));
			}
		}
		
		//checks the pre-shuffled deck
//		for(int i = 0; i < deck.size(); i++) {
//			System.out.println(deck.get(i).toString());
//		}
		
		//the shuffle method
		Collections.shuffle(deck);
		
		//checks the post shuffled deck
//		for(int i = 0; i < deck.size(); i++) {
//			System.out.println(deck.get(i).toString());
//		}
	}
	
	//draws a card from the arraylist and gives it to the user
	//removes the card from the arraylist
	//function is called five times in handStength
	public Card addCard(createDeck deck){
		Card newCard = this.deck.get(getCardCount());
		this.deck.remove(this.cardCount);
		this.setCardCount(this.getCardCount() - 1);
				
		return newCard;
	}
	
	//sets num of cards dealt count
	public void setCardCount(int cardCount) {
		this.cardCount = cardCount;
	}

	//gets the num of cards dealt count
	public int getCardCount() {
		return cardCount;
	}
}