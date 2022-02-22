
/*the card class creates the rank and suit
 * objects, then gives the rank and suit
 * their appropriate constants for poker
 * through the use of enums
 */
public class Card {
	 Rank rank;
	 Suit suit;
	
	//card suit and rank constructor
	public Card(Suit suit, Rank rank) {
		this.rank = rank;
		this.suit = suit;
		
	}
	
	//gives the card rank variable a constant (2- ace)
	public static enum Rank{
		TWO('2'), THREE('3'), FOUR('4'), FIVE('5'), SIX('6'), SEVEN('7'), EIGHT('8'),
		NINE('9'), TEN('T'), JACK('J'), QUEEN('Q'), KING('K'), ACE('A');
		
		char rankChar;
		
		Rank(char rankChar){
			this.rankChar = rankChar;
		}
		
		public void setRankChar(char rankChar) {
			this.rankChar = rankChar;
		}

		public char getRankChar() {
			return this.rankChar;
		}
	}
	
	//gives the card suit variable a constant
	public static enum Suit{
		HEARTS("♥​"), CLUBS("♣​"), SPADES("♠​"), DIAMONDS("♦​");
		
		String suitChar;
		
		Suit(String suitChar){
			this.suitChar = suitChar;
		}
		
		public void setSuitChar(String suitChar) {
			this.suitChar = suitChar;
		}
		
		public String getSuitChar(){
			return suitChar;
		}
	}
	
	//gets the enums chars
	public char getRankChar(){
		return this.rank.rankChar;
	}
	
	public String getSuitChar(){
		return this.suit.suitChar;
	}
	
	
	//sets and gets the rank and suit enums
	public void setRankEnum(Rank rank){
		this.rank.equals(rank);
	}
	
	public Rank getRankEnum(){
		return this.rank;
	}
	
	public void setSuitEnum(Suit suit){
		this.suit.equals(suit);
	}
	
	public Suit getSuitEnum(){
		return this.suit;
	}
	
	public String toString() {
		return this.getRankChar() + this.getSuitChar();
	}
}
