package Menu.Game.BlackJack;

public enum Rank {

	DEUX(2), TROIS(3), QUATRE(4), CINQ(5), SIX(6), SEPT(7), HUIT(8), NEUF(9), DIX(10), VALET(10), ROI(10), DAME(10), AS(11);
	
	
	int points;
	Rank(int i) {
		points = i;
	}
	
}
