package egy;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Hand {

	int myCounter = 0;
	int AICounter = 0;

	ArrayList<Card> cardsInHand = new ArrayList<Card>();
	ArrayList<Card> aiCards = new ArrayList<Card>();

	public void getCards(ArrayList<Card> cardList) {
		Random random = new Random();
		int counter = 1;
		while (counter <= 16) {
			int rand = random.nextInt(cardList.size());
			Card randomCard = cardList.get(rand);
			if (!cardsInHand.contains(randomCard)) {
				cardsInHand.add(randomCard);
				counter++;
			}
		}
	}

	public void getAICards(ArrayList<Card> cardList) {
		int counter = 1;
		while (counter <= 16) {
			for (Card card : cardList) {
				if (!cardsInHand.contains(card)) {
					aiCards.add(card);
					counter++;
				}
			}
		}
	}

	public void printIn(ArrayList<Card> cList) {
		for (Card c : cList) {
			System.out.println(c.nev);
		}
	}

	public Card showCard(ArrayList<Card> cList, int i) {
		System.out.println(cList.get(i).nev + "\nIgazmondás: " + cList.get(i).igazMondas + "\nBalhézás: "
				+ cList.get(i).balhezas + "\nFéltékenység: " + cList.get(i).feltekenyseg);
		return cList.get(i);
	}

	public int chooseSkill() {
		Scanner input = new Scanner(System.in);
		System.out.println("Válassz egy tulajdonságot. (Igazmondás: [1]; Balhézás: [2]; Féltékenység: [3])");
		int inp = 0;
		while (inp > 3 || inp < 1) {
			inp = input.nextInt();
			if (inp > 3 || inp < 1) {
				System.err.println("1-3 közötti számot adj meg!!!");
			}

		}
		return inp;
	}

	public int showWinner(int inp) {
		if (inp == 1) {
			Card card = cardsInHand.get(0);
			Card AICard = aiCards.get(0);
			card.compareIgazMondas(AICard);
			if (cardsInHand.get(0).roundWinner == 2) {
				aiCards.remove(AICard);
				cardsInHand.add(AICard);
				cardsInHand.remove(card);
				cardsInHand.add(card);
			} else if (cardsInHand.get(0).roundWinner == 1) {
				cardsInHand.remove(card);
				aiCards.add(card);
				aiCards.remove(AICard);
				aiCards.add(AICard);
			} else {
				aiCards.remove(AICard);
				aiCards.add(AICard);
				cardsInHand.remove(card);
				cardsInHand.add(card);
			}
			return cardsInHand.get(0).igazMondas;
		} else if (inp == 2) {
			Card card = cardsInHand.get(0);
			Card AICard = aiCards.get(0);
			card.compareBalhezas(AICard);
			if (cardsInHand.get(0).roundWinner == 2) {
				aiCards.remove(AICard);
				cardsInHand.add(AICard);
				cardsInHand.remove(card);
				cardsInHand.add(card);
			} else if (cardsInHand.get(0).roundWinner == 1) {
				cardsInHand.remove(card);
				aiCards.add(card);
				aiCards.remove(AICard);
				aiCards.add(AICard);
			} else {
				aiCards.remove(AICard);
				aiCards.add(AICard);
				cardsInHand.remove(card);
				cardsInHand.add(card);
			}
			return cardsInHand.get(0).balhezas;
		} else if (inp == 3) {
			Card card = cardsInHand.get(0);
			Card AICard = aiCards.get(0);
			card.compareFeltekenyseg(AICard);
			if (cardsInHand.get(0).roundWinner == 2) {
				aiCards.remove(AICard);
				cardsInHand.add(AICard);
				cardsInHand.remove(card);
				cardsInHand.add(card);
			} else if (cardsInHand.get(0).roundWinner == 1) {
				cardsInHand.remove(card);
				aiCards.add(card);
				aiCards.remove(AICard);
				aiCards.add(AICard);
			} else {
				aiCards.remove(AICard);
				aiCards.add(AICard);
				cardsInHand.remove(card);
				cardsInHand.add(card);
			}
			return cardsInHand.get(0).feltekenyseg;
		}
		return 1;
	}

}
