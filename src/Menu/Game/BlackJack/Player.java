package Menu.Game.BlackJack;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Menu.Game.BlackJack.Card;

public class Player implements Comparable<Player>{
	/**
	 * 
	 */
	int bourse;
	String name;
	int echelon;
	List<Card> hand = new ArrayList<Card>();
	List<Card> croupier = new ArrayList<Card>();

	public Player(String name){
		this.name = name;
	}

	/**
	 * @param bourse
	 * @param name
	 * @param echelon
	 */
	public Player(int bourse, String name, int echelon) {
		this(name);
		this.bourse = bourse;
		this.echelon = echelon;
	}


	/**
	 * @return
	 */
	public int getBourse() {
		return bourse;
	}


	/**
	 * @return
	 */
	public String getName() {
		return name;
	}


	/**
	 * @return
	 */
	public int getEchelon() {
		return echelon;
	}


	/**
	 * @param score
	 */
	public void setScore(int score) {
		this.bourse = score;
	}

	public int totalOfHand() {
		int calcul = 0;
		for(int idx = 0; idx < this.hand.size(); idx ++) {
			calcul = calcul + hand.get(idx).getRank().points;
		}
		return calcul;
	}

	public int totalOfCroupier() {
		int calcul = 0;
		for(int idx = 0; idx < this.croupier.size(); idx ++) {
			calcul = calcul + croupier.get(idx).getRank().points;
		}
		return calcul;
	}

	
	public int bet(Scanner sc) throws UnvalidBet {
		System.out.println("Entrez votre mise : ");
		int coins = sc.nextInt();
		if (coins <= this.bourse && coins > 0) {
			return coins;
		}
		
		throw new UnvalidBet();
		
	}

	@Override
	public int compareTo(Player arg0) {
		return arg0.bourse - this.bourse;
	}

	@Override
	public String toString() {
		return name + ", bourse = " + bourse ;
	}

	public void setBourse(int bourse) {
		this.bourse = bourse;

	}

	public void setEchelon(int echelon) {
		this.echelon = echelon;
	}

	public List<Card> getHand() {
		return hand;
	}

	public void setHand(List<Card> hand) {
		this.hand = hand;
	}

	public void bourseLose(int coins) {
		this.setBourse(this.getBourse() - coins);
	}

	public void bourseWin(int coins) {
		this.setBourse(this.getBourse() + coins);
	}


}
