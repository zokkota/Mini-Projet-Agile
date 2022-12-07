package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import Menu.Game.BlackJack.Card;
import Menu.Game.BlackJack.Color;
import Menu.Game.BlackJack.Player;
import Menu.Game.BlackJack.Rank;


public class PlayerTest {

	@Test
	public void createPlayer() {
		Player player = new Player(100,"test",1);
		assertEquals(player.getName(),"test");
		assertEquals(player.getBourse(), 100);
		assertEquals(player.getEchelon(), 1);
	}
	
	
	
	 @Test
	 public void handTest() {
		 Player player = new Player(100,"test",1);
		 List<Card> list = new ArrayList<Card>();
		 list.add(new Card(Rank.CINQ, Color.TREFLE));
		 list.add(new Card(Rank.SEPT, Color.COEUR));
		 player.setHand(list);
		 assertEquals(player.totalOfHand(), 12);
	 }
	 
}
