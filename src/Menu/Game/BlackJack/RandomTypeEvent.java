package Menu.Game.BlackJack;

public enum RandomTypeEvent {
	PH(0), BAR(1), LUNCH(2), SUP(3), WORK(4), AMENDE(5), ABSENT(6), ECHELON(7), RIEN(8);
	
	int nb;
	RandomTypeEvent(int i) {
		nb = i;
	}
}
