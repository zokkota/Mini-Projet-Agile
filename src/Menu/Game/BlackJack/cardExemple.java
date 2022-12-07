package Menu.Game.BlackJack;

import java.util.Random;

/*
 * 

 ______
|A      |
|   .   |
|  /.\  |
| (_._) |
|   |   |
|______ |



 _____
|A ^  |
| / \ |
| \ / |
|  .  |
|____ |


         |A .  | _____
         | /.\ ||A ^  | _____
         |(_._)|| / \ ||A _  | _____
ejm98    |  |  || \ / || ( ) ||A_ _ |
         |____V||  .  ||(_'_)||( v )|
                |____V||  |  || \ / |
                       |____V||  .  |
                              |____V|

                               _____
         |A .  | _____
         | /.\ ||A ^  | _____
         |(_._)|| / \ ||A _  | _____
ejm98    |  |  || \ / || ( ) ||A_ _ |
         |____V||  .  ||(_'_)||( v )|
                |____V||  |  || \ / |
                       |____V||  .  |
                              |____V|

                              
 */

public class cardExemple {
       public static final String ANSI_RESET = "\u001B[0m";
       public static final String ANSI_BLACK_BG = "\u001B[40m";
       public static final String ANSI_RED_BG = "\u001B[41m";

       public static void main(String[] args) {
              System.out.println(
                            " ______\n" +
                                          "|A      |");

              System.out.println(
                            "|   .   |\n" +
                                          "|  / \\  |\n" +
                                          "| (_._) |\n" +
                                          "|   |   |\n" +
                                          "|______ |"

              );

              System.out.println(TOP_CARD + A + PIQUE);
              System.out.println(COEUR);
              System.out.println();
              System.out.println();
              System.out.println();
              System.out.println( TOP_CARD + afficherNumber() + afficherSymbole());
              System.out.println(ANSI_RED_BG + "test" + ANSI_RESET);
       }

       public int a;
       public int b;
       public final static String TOP_CARD = " ______\n";
       public final static String A = "|A      |\n";
       public final static String DEUX = "|2      |\n";
       public final static String PIQUE =  
       "|   .   |\n" +
       "|  / \\  |\n" +
       "| (_._) |\n" +
       "|   |   |\n" +
       "| ______|";
       public final static String TREFLE = 
       "|   _   |\n" +
       "|  ( )  |\n" +
       "| (_._) |\n" +
       "|   |   |\n" +
       "| ______|";
       public final static String CARREAU = 
       "|   ^   |\n" +
       "|  / \\  |\n" +
       "|  \\ /  |\n" +
       "|   v   |\n" +
       "| ______|";

       //◠◠ symbole
       public final static String COEUR = 
       "|       |\n" +
       "| ( v ) |\n" +
       "|  \\ /  |\n" +
       "|   v   |\n" +
       "| ______|";

       static Random random = new Random();
       
       
       
       public static String afficherSymbole(){
              String res;
              int r = random.nextInt(4) + 1;
              if(r == 1){
                     res = PIQUE;
              }else if(r == 2){
                     res = TREFLE;
              }else if(r == 3){
                     res = CARREAU;
              }else{
                     res = COEUR;
              }

              return res;
       }

       public static String afficherNumber(){
              String res = "";
              int n = random.nextInt(2) + 1;
              switch(n){
                     case 1 :
                            res = A;
                            break;
                     case 2 :
                            res = DEUX;
                            break;
              }
              return res;      
       }

        
}