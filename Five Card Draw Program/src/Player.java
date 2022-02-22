//player class
//includes the show card function which prints the current hand given

import java.util.ArrayList;

public class Player {
	protected ArrayList <Card> hand; //array list of of cards to hold  players hand
	protected int handScore; //an int that will represent the 'power' of the hand. used with evaluateHand() in hands.java
	protected int playerNumber;
	
	//creates a hand arraylist that will hold the five card hand
	public Player(Card FirstCard, Card SecondCard,
			Card ThirdCard, Card FourthCard, Card FifthCard){
		hand = new ArrayList <Card>();
		
		//each card is added to arraylist one by one
		hand.add(FirstCard);
		hand.add(SecondCard);
		hand.add(ThirdCard);
		hand.add(FourthCard);
		hand.add(FifthCard);
		
		this.handScore = -1;
	}
	
	//prints the hand you are dealt
	public void showCards(){
		for(int i = 0; i <= 4; i++) {
			System.out.print(hand.get(i).getRankChar() + "" + hand.get(i).getSuitChar() + " ");
		}
		System.out.println();
	} 
	
	//getters and setters for the current hand strength
	public ArrayList <Card> getHandArrayList(){
		return this.hand;
	}

	public int getHandScore() {
		return handScore;
	}

	public void setHandScore(int handScore) {
		this.handScore = handScore;
	}
}
