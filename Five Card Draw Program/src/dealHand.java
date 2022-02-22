//dealHand consists of the poker hand strength algorithm (evaluateHand function)
import java.util.Collections;
public class dealHand {
	private Player you;
	
	public dealHand(createDeck gameDeck){	
		
		//creates a player (you) that holds the five cards you have been dealt
		you = new Player(gameDeck.addCard(gameDeck), //give first card
				gameDeck.addCard(gameDeck),  //give second card
				gameDeck.addCard(gameDeck),  //give third card
				gameDeck.addCard(gameDeck),  //give fourth card
				gameDeck.addCard(gameDeck)); //give fifth card
		
		//checks the dealt hand
//		for(int i = 0; i < 5; i++) {
//			System.out.println(you.getHandArrayList().get(i));
//		}
	}
	
	/*straight flush returns 8
	 *four of a kind returns 7
	 *full house returns 6
	 *flush  returns 5
	 *straight returns 4
	 *Three of a Kind returns 3
	 *Two Pair returns 2
	 *One Pair returns 1
	 *high card returns 0 
	 */
	public int evaluateHand(Player player){
		
		//sort cards by rank
		for(int x=0; x<=4; x++){
			for(int y=0; y<=4; y++){
				if(player.getHandArrayList().get(x).getRankEnum().ordinal() > player.getHandArrayList().get(y).getRankEnum().ordinal())
					Collections.swap(player.getHandArrayList(), x, y);
			}
		}
		
		//get ordinals ints from card enums
		int firstCardRankOrdinal = player.getHandArrayList().get(0).getRankEnum().ordinal();
		int secondCardRankOrdinal = player.getHandArrayList().get(1).getRankEnum().ordinal();
		int thirdCardRankOrdinal = player.getHandArrayList().get(2).getRankEnum().ordinal();
		int fourthCardRankOrdinal = player.getHandArrayList().get(3).getRankEnum().ordinal();
		int fifthCardRankOrdinal = player.getHandArrayList().get(4).getRankEnum().ordinal();
		
		int firstCardSuitOrdinal = player.getHandArrayList().get(0).getSuitEnum().ordinal();
		int secondCardSuitOrdinal = player.getHandArrayList().get(1).getSuitEnum().ordinal();
		int thirdCardSuitOrdinal = player.getHandArrayList().get(2).getSuitEnum().ordinal();
		int fourthCardSuitOrdinal = player.getHandArrayList().get(3).getSuitEnum().ordinal();
		int fifthCardSuitOrdinal = player.getHandArrayList().get(4).getSuitEnum().ordinal();
		
		//the following is a bunch of if else statements 
		//that cover all possible winning hands and the permutations
		//for where the pairs appear in the hand..
		
		//checks for straight flush returns 8
		if((firstCardRankOrdinal == secondCardRankOrdinal + 1) &&
			   (firstCardRankOrdinal == thirdCardRankOrdinal + 2)  &&
			    (firstCardRankOrdinal == fourthCardRankOrdinal + 3)  &&
			    firstCardRankOrdinal == fifthCardRankOrdinal + 4 &&
			    firstCardSuitOrdinal == secondCardSuitOrdinal &&
			    secondCardSuitOrdinal == thirdCardSuitOrdinal &&
			    thirdCardSuitOrdinal == fourthCardSuitOrdinal &&
			    fourthCardSuitOrdinal == fifthCardSuitOrdinal){
					
					player.setHandScore(8);
					System.out.println("You have: Straight Flush");
					return 8;
					
				}
		//checks if first card was Ace to check straight as a low card
		else if(firstCardRankOrdinal == 12 && (firstCardRankOrdinal == secondCardRankOrdinal + 9) &&
				   firstCardRankOrdinal == thirdCardRankOrdinal + 10  &&
				    firstCardRankOrdinal == fourthCardRankOrdinal + 11  &&
				    firstCardRankOrdinal == fifthCardRankOrdinal + 12 &&
				    firstCardSuitOrdinal == secondCardSuitOrdinal &&
				    secondCardSuitOrdinal == thirdCardSuitOrdinal &&
				    thirdCardSuitOrdinal == fourthCardSuitOrdinal &&
				    fourthCardSuitOrdinal == fifthCardSuitOrdinal){
					
					player.setHandScore(8);
					System.out.println("You have: Straight Flush");
					return 8;
		}
		
		//check for four of a kind return 7
		else if((firstCardRankOrdinal == secondCardRankOrdinal) &&
				   (firstCardRankOrdinal == thirdCardRankOrdinal)  &&
				    (firstCardRankOrdinal == fourthCardRankOrdinal)){
			
			player.setHandScore(7);
			System.out.println("You have: Four of a Kind");
			return 7;
		}
		else if ((secondCardRankOrdinal == thirdCardRankOrdinal) &&
				   (secondCardRankOrdinal == fourthCardRankOrdinal)  &&
				    (secondCardRankOrdinal == fifthCardRankOrdinal)){
			
			player.setHandScore(7);
			System.out.println("You have: Four of a Kind");
			return 7;
		}
		//check for Full House 3 pairs then 2 pair
		else if((firstCardRankOrdinal == secondCardRankOrdinal) &&
				   (firstCardRankOrdinal == thirdCardRankOrdinal) &&
				   (fourthCardRankOrdinal == fifthCardRankOrdinal) &&
				   (firstCardRankOrdinal != fifthCardRankOrdinal)){
			
			player.setHandScore(6);
			System.out.println("You have: Full House");
			return 6;
		}
		//check for Full House 2 and 3...
		else if((firstCardRankOrdinal == secondCardRankOrdinal) &&
				   (thirdCardRankOrdinal == fourthCardRankOrdinal) &&
				   (thirdCardRankOrdinal == fifthCardRankOrdinal) &&
				   (firstCardRankOrdinal != fifthCardRankOrdinal)){
			
			player.setHandScore(6);
			System.out.println("You have: Full House");
			return 6;
		}
		//check for flush. return 5
		else if(firstCardSuitOrdinal == secondCardSuitOrdinal
				&& thirdCardSuitOrdinal == fourthCardSuitOrdinal && 
				fourthCardSuitOrdinal == fifthCardSuitOrdinal &&
				firstCardSuitOrdinal == thirdCardSuitOrdinal &&
				firstCardSuitOrdinal == fourthCardSuitOrdinal &&
				thirdCardSuitOrdinal == fifthCardSuitOrdinal){
			
			player.setHandScore(5);
			System.out.println("You have: Flush");
			return 5;
		}
		//check for straight. return 4
		else if((firstCardRankOrdinal == secondCardRankOrdinal + 1) &&
				   (firstCardRankOrdinal == thirdCardRankOrdinal + 2)  &&
				    (firstCardRankOrdinal == fourthCardRankOrdinal + 3)  &&
				    firstCardRankOrdinal == fifthCardRankOrdinal + 4){
			
			player.setHandScore(4);
			System.out.println("You have: Straight");
			return 4;
		}
		//check for a straight with an ace
		else if(firstCardRankOrdinal == 12 && (firstCardRankOrdinal == secondCardRankOrdinal + 9) &&
				   firstCardRankOrdinal == thirdCardRankOrdinal + 10  &&
				    firstCardRankOrdinal == fourthCardRankOrdinal + 11  &&
				    firstCardRankOrdinal == fifthCardRankOrdinal + 12){
	
			player.setHandScore(4);
			System.out.println("You have: Straight");
			return 4;
		}
		//Three of a Kind on 1st 3 cards returns 3
		else if(firstCardRankOrdinal == secondCardRankOrdinal &&
				secondCardRankOrdinal == thirdCardRankOrdinal){
			//System.out.println("Three of a kind on 1st 3 cards");
			
			player.setHandScore(3);
			System.out.println("You have: Three of a Kind");
			return 3;
		}
		//Three of a Kind on 2nd 3 cards returns 3
		else if(secondCardRankOrdinal == thirdCardRankOrdinal &&
				thirdCardRankOrdinal == fourthCardRankOrdinal)
		{			
			player.setHandScore(3);
			System.out.println("You have: Three of a Kind");
			return 3;
		}
		//Three of a Kind on last 3 cards - returns 3
		else if(thirdCardRankOrdinal == fourthCardRankOrdinal &&
				fourthCardRankOrdinal == fifthCardRankOrdinal)
		{		
			player.setHandScore(3);
			System.out.println("You have: Three of a Kind");
			return 3;
		}
		//check for Two Pair on 1st 2 card pair and 2nd 2 card pair
		else if(firstCardRankOrdinal == secondCardRankOrdinal &&
				thirdCardRankOrdinal == fourthCardRankOrdinal &&
				firstCardRankOrdinal != thirdCardRankOrdinal){
			
			player.setHandScore(2);
			System.out.println("You have: Two Pair");
			return 2;
		}
		//check for Two Pair on 2nd pair of cards and last pair of cards
		else if(secondCardRankOrdinal == thirdCardRankOrdinal &&
				fourthCardRankOrdinal == fifthCardRankOrdinal &&
				firstCardRankOrdinal >= secondCardRankOrdinal){
			
			player.setHandScore(2);
			System.out.println("You have: Two Pair");
			return 2;
		}
		//check for Two Pair on 1st pair of cards and last pair of cards
		else if(firstCardRankOrdinal == secondCardRankOrdinal &&
				fourthCardRankOrdinal == fifthCardRankOrdinal &&
				thirdCardRankOrdinal >= fourthCardRankOrdinal){
			
			player.setHandScore(2);
			System.out.println("You have: Two Pair");
			return 2;
		}
		//One Pair on 1st 2 cards
		else if(firstCardRankOrdinal == secondCardRankOrdinal &&
				firstCardRankOrdinal != thirdCardRankOrdinal && 
				firstCardRankOrdinal != fourthCardRankOrdinal && 
				firstCardRankOrdinal != fifthCardRankOrdinal){
			
			player.setHandScore(1);
			System.out.println("You have: One Pair");
			return 1;
		}
		//One Pair on 2nd 2 cards
		else if(secondCardRankOrdinal == thirdCardRankOrdinal &&
				firstCardRankOrdinal != secondCardRankOrdinal && 
				fourthCardRankOrdinal != secondCardRankOrdinal && 
				fifthCardRankOrdinal != secondCardRankOrdinal){
			
			player.setHandScore(1);
			System.out.println("You have: One Pair");
			return 1;
		}
		//One Pair on 3rd 2 cards
		else if(thirdCardRankOrdinal == fourthCardRankOrdinal &&
				thirdCardRankOrdinal != firstCardRankOrdinal && 
				thirdCardRankOrdinal != secondCardRankOrdinal && 
				thirdCardRankOrdinal != fifthCardRankOrdinal){
			
			player.setHandScore(1);
			System.out.println("You have: One Pair");
			return 1;
		}
		//One Pair on 4th 2 card pair
		else if(fourthCardRankOrdinal == fifthCardRankOrdinal &&
				fourthCardRankOrdinal != firstCardRankOrdinal && 
				fourthCardRankOrdinal != secondCardRankOrdinal && 
				fourthCardRankOrdinal != thirdCardRankOrdinal){
			
			player.setHandScore(1);
			System.out.println("You have: One Pair");
			return 1;
		}
		else{
			player.setHandScore(0);
			System.out.println("You have: High Card");
			return 0;
		}
	}
	
	//shows your current hand and then evalutes the strength of your dealt hand
	public void currentHand(createDeck gameDeck) {
		System.out.print("Your hand: ");
		you.showCards();
		System.out.println();
		you.setHandScore(this.evaluateHand(you));
	}
}
