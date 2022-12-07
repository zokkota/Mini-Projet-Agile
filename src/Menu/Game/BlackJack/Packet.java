package Menu.Game.BlackJack;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


	public class Packet {
		private List<Card> packet = new ArrayList<Card>();
		
	
		public Packet(int nb) {
			for(int i = 0; i < 4; i++) {
				for(int j = 0; j < 13; j++) {
					for(int nbpack = 0; nbpack < nb; nbpack ++) {
						packet.add(new Card(Rank.values()[j],Color.values()[i]));
					}
					
				}
			}
		}


		public List<Card> getToto() {
			return packet;
		}
		
		public Card PickCard() {
			Random rand = new Random();
			int pioche = rand.nextInt(packet.size()) + 1;
			return packet.get(pioche);
		}
		
		
		public static void main(String[] args) {
			Packet packet = new Packet(5);
			System.out.println(packet.PickCard());
		}
	
}

