package egy;

import java.util.Scanner;

public class MainFile {

	public static void main(String[] args) throws InterruptedException {
		System.out.println("");
		LoadData logo = new LoadData();
		logo.loadFile("super-gnu.txt");
		Thread.sleep(3000);
		logo.loadFile("baratok-kozt-logo.txt");
		Scanner scanner = new Scanner(System.in);
		System.out.println("Indításhoz nyomjon ENTER billentyűt.");
		String enter = scanner.nextLine();
		System.out.println("Pakli megkeverése...");
		Thread.sleep(1500);
		System.out.println("Lapok szétosztása...");
		Thread.sleep(2500);
		System.out.println("Sok szerencsét!");
		Thread.sleep(1000);
		System.out.println(
				"____________________________________________________________________________________________");
		Deck deck = new Deck();
		deck.cardList.add(new Card("Berényi András", 9, 3, 1));
		deck.cardList.add(new Card("Berényi Miklós", 1, 9, 7));
		deck.cardList.add(new Card("Szentmihályi Zsófia", 6, 2, 7));
		deck.cardList.add(new Card("Berényi Attila", 3, 8, 5));
		deck.cardList.add(new Card("Kertész Géza", 3, 3, 5));
		deck.cardList.add(new Card("Kertész Vilmos", 8, 4, 3));
		deck.cardList.add(new Card("Magdi Anyus", 10, 10, 9));
		deck.cardList.add(new Card("Magdi Anyus szelleme", 10, 10, 10));
		deck.cardList.add(new Card("Bartha Zsolt", 1, 6, 6));
		deck.cardList.add(new Card("Holmann Hanna", 4, 6, 3));
		deck.cardList.add(new Card("Bartha Krisztián", 9, 6, 4));
		deck.cardList.add(new Card("Berényi Claudia", 4, 7, 9));
		deck.cardList.add(new Card("Egressy \"Tóni\" Antal", 2, 9, 6));
		deck.cardList.add(new Card("Nádor Kinga", 5, 6, 7));
		deck.cardList.add(new Card("Balogh Nóra", 6, 6, 6));
		deck.cardList.add(new Card("Berényi Zsuzsa", 7, 6, 8));
		deck.cardList.add(new Card("Berényi Kata", 5, 2, 5));
		deck.cardList.add(new Card("Berényi Dániel", 3, 6, 1));
		deck.cardList.add(new Card("Nagy Tóbiás & (F)Asztalos Kristóf", 7, 7, 6));
		deck.cardList.add(new Card("Illés Vanda", 2, 6, 8));
		deck.cardList.add(new Card("Illés Péter", 1, 10, 7));
		deck.cardList.add(new Card("Illés Júlia", 6, 7, 10));
		deck.cardList.add(new Card("Bokros Gizi", 3, 5, 8));
		deck.cardList.add(new Card("Bartha Linda", 4, 7, 6));
		deck.cardList.add(new Card("Bokros Ádám", 7, 8, 6));
		deck.cardList.add(new Card("Fekete Alíz", 2, 6, 8));
		deck.cardList.add(new Card("Fekete Luca", 10, 3, 5));
		deck.cardList.add(new Card("Cheng", 6, 7, 6));
		deck.cardList.add(new Card("Berci", 10, 9, 9));
		deck.cardList.add(new Card("Berényi Balázs", 3, 8, 7));
		deck.cardList.add(new Card("A pincér", 1, 1, 1));
		deck.cardList.add(new Card("Novák László", 6, 8, 3));

		Hand hand = new Hand();
		Card card = new Card();
		hand.getCards(deck.cardList);
		hand.getAICards(deck.cardList);
		int currentMyCard = 0;
		int currentAICard = 0;
		int round = 1;
		while (hand.cardsInHand.size() > 0 && hand.cardsInHand.size() <= 32) {
			// while (round <= 30) {
			System.out.println(round + ". kör.				Player-Gép: " + hand.cardsInHand.size() + "-"
					+ hand.aiCards.size() + ".");
			System.out.println(
					"____________________________________________________________________________________________");
			Card myCard = hand.showCard(hand.cardsInHand, 0);
			System.out.println("");
			int inp = hand.chooseSkill();
			System.out.println(
					"____________________________________________________________________________________________");
			System.out.println("Ellenfél lapja:");
			Thread.sleep(1500);
			System.out.println("");
			Card AICard = hand.showCard(hand.aiCards, 0);
			hand.showWinner(inp);
			if (currentMyCard >= hand.cardsInHand.size() - 1 && hand.cardsInHand.size() > 0) {
				currentMyCard = 0;
			} else {
				currentMyCard++;
			}
			if (currentAICard >= hand.aiCards.size() - 1 && hand.aiCards.size() > 0) {
				currentAICard = 0;
			} else {
				currentAICard++;
			}
			round++;
			System.out.println(
					"____________________________________________________________________________________________");
			Thread.sleep(1000);
		}
		if (hand.cardsInHand.size() > hand.aiCards.size()) {
			logo.loadFile("nyertel-logo.txt");
		} else if (hand.cardsInHand.size() == hand.aiCards.size()) {
			logo.loadFile("dontetlen-logo.txt");
		} else if (hand.cardsInHand.size() < hand.aiCards.size()) {
			logo.loadFile("vesztettel-logo.txt");
		}
		System.out.println("				Köszönjük a játékot!");
		System.out.println("");
		System.exit(0);

	}

}
