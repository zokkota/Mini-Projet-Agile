package Menu.Game.BlackJack;

import java.util.Random;

public class Card {
	private Rank rank;
	private Color color;

	// Couleurs dans terminal
	public static final String ANSI_RESET = "\u001B[0m";
    //public static final String ANSI_BLACK_BG = "\u001B[40m";
	public static final String ANSI_BLACK_BG = "\033[47m"; //WHITE
    public static final String ANSI_RED_BG = "\u001B[41m";
	
	public Card(Rank rank, Color color) {
		this.rank = rank;
		this.color = color;
	}
	
	Rank getRank() {
		return this.rank;
	}
	
	Color getColor() {
		return this.color;
	}
	
	public String toString() {
		return(getRank() + " de " + getColor()+ "\n");
	}

	//Haut de la carte
       public final String TOP_CARD = " ______\n";

	//Valeur de la carte
       public final String AS = "|A      |\n";
       public final String DEUX = "|2      |\n";
	   public final String TROIS = "|3      |\n";
	   public final String QUATRE = "|4      |\n";
	   public final String CINQ = "|5      |\n";
	   public final String SIX = "|6      |\n";
	   public final String SEPT = "|7      |\n";
	   public final String HUIT = "|8      |\n";
	   public final String NEUF = "|9      |\n";
	   public final String DIX = "|10     |\n";
	   public final String VALET = "|V      |\n";
	   public final String DAME = "|D      |\n";
	   public final String ROI = "|R      |\n";

	//Symbole de la carte
       public final String PIQUE =  
       "|   .   |\n" +
       "|  / \\  |\n" +
       "| (_._) |\n" +
       "|   |   |\n" +
       "| ______|";
       public final String TREFLE = 
       "|   _   |\n" +
       "|  ( )  |\n" +
       "| (_._) |\n" +
       "|   |   |\n" +
       "| ______|";
       public final String CARREAU = 
       "|   ^   |\n" +
       "|  / \\  |\n" +
       "|  \\ /  |\n" +
       "|   v   |\n" +
       "| ______|";

       //◠◠ symbole
       public final String COEUR = 
       "|       |\n" +
       "| ( v ) |\n" +
       "|  \\ /  |\n" +
       "|   v   |\n" +
       "| ______|";

       
       
       
       public String afficherSymbole(Color c){
              String res;
              if(c == Color.PIQUE){
                     res = PIQUE;
              }else if(c == Color.COEUR){
                     res = TREFLE;
              }else if(c == Color.CARREAU){
                     res = CARREAU;
              }else{
                     res = COEUR;
              }

              return res;
       }

       public String afficherNumber(Rank rank){
              String res = TOP_CARD;
              switch(rank){
                    case AS:
                        res = res + AS;
                        break;
                    case DEUX :
                        res = res + DEUX;
                        break;
					case TROIS :
                    	res = res + TROIS;
                    	break;
					case QUATRE :
                    	res = res + QUATRE;
                    	break;	
					case CINQ :
                    	res = res + CINQ;
                    	break;
					case SIX :
                    	res = res + SIX;
                    	break;
					case SEPT :
                    	res = res + SEPT;
                    	break;
					case HUIT :
                    	res = res + HUIT;
                    	break;
					case NEUF :
                    	res = res + NEUF;
                    	break;
					case DIX :
                    	res = res + DIX;
                    	break;
					case VALET :
                    	res = res + VALET;
                    	break;
					case DAME :
                    	res = res + DAME;
                    	break;
					case ROI :
                    	res = res + ROI;
                    	break;
              }
              return res;      
       }
	
}
