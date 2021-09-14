package cards;

import java.util.ArrayList;

public class DeckOfCards {

	public static void main(String[] args) {
		
		Player player[] = new Player[4];
		String suits[] = {"Clubs","Daimonds","Heart","Spades"};
		String rank[] = {"2","3","4","5","6","7","8","9","10","Jack","Queen","King","Ace"};
		
		String card[]= new String[52];
		
		for(int i=0;i<suits.length;i++) {
			for(int j=0;j<rank.length;j++) {
				card[rank.length*i+j]=rank[j]+ " " +suits[i];
			}
		}
		
		ArrayList<Integer> cardList = new ArrayList<Integer>();
		for(int i=0;i<4;i++) {
			System.out.println("\nPlayer " + (i+1) +" has got the cards:");
			player[i]  = new Player();
			int j=0;
			while(j<9) {
				int randomValue= (int)(Math.random() * card.length);
				if(cardList.contains(randomValue)==false) {
					player[i].cards.add(card[randomValue]);
					cardList.add(randomValue);
					j++;
				}
			}
			player[i].cards.print();
			System.out.println();
		}
	}

}





