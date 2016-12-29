import java.util.*;
class ScarnesDice
{
   static int whose_move=1;
   static int ply1=0,ply2=0;
   static int limit=100;
   static int pl1_totscore=0;
   static int pl2_totscore=0;
   static int pl1_curturnscore=0;
   static int pl2_curturnscore=0;
   static int who_win=0;
   public static void main(String s[])
   {
    System.out.println("\t\t\t-----------SCARNES DICE------------------");
    System.out.println("\n\n");
    System.out.println("\t\t\t------------INSTRUCTIONS-----------------");
    System.out.println("1: This is a two player game");
    System.out.println("2: First player starts the game");
    System.out.println("3: The player who gets more than or equal to 100 wins the game");
    System.out.println("4: In one turn the dice is rolled and player has two choices");
    System.out.println("\t4.1: one he can hold his score and add this to total score");
    System.out.println("\t4.2:He can try another chance by repetedly throw dice and increase his score");
    System.out.println("5: If he gets one he is fired,his score in that turn becomes zero");
    System.out.println("\t\t\t-------------------------------GOOD LUCK---------------------------");
       Random pl1=new Random();
       Random pl2=new Random();
       System.out.println("Player 1 starts");
        System.out.println("press y to continue");
       if(whose_move==1)
       process(pl1);
       if(who_win==1)
           System.out.println("Player 1 won");
       if(who_win==2)
           System.out.println("Player 2 won");
   }
   public static void process(Random k)
   {
       
       k=new Random();
       int p=k.nextInt(6)+1;
       if(whose_move==1)
       {
        if(p==1)
        {
            ply1=0;
          pl1_curturnscore=0;
            whose_move=2;
            System.out.println("you  got 1");
            System.out.println("player 2 turn");
        }
        else
          {
              System.out.println("do u wanna continue----if yes press y else n");
                 char c;
       Scanner sc=new Scanner(System.in);
       c=sc.next().charAt(0);
         if(c=='y')
          {
             ply1=ply1+p; 
           whose_move=1;
          }
         else
          {
              pl1_curturnscore=ply1;
              pl1_totscore=pl1_totscore+pl1_curturnscore;
              ply1=0;
              System.out.println("Player 1 total score is "+pl1_totscore);
                         if(who_won())
                           return;
              whose_move=2;
              System.out.println("player 2 turn");
          }
       }
       }
       else
        {
         if(p==1)
         {
             ply2=0;
                  System.out.println("you got 1");
           System.out.println("player 1 turn");
           pl1_curturnscore=0;
           whose_move=1;       
           }
          else
           {
           System.out.println("do u wanna continue----if yes press y else n");
               char c;
       Scanner sc=new Scanner(System.in);
       c=sc.next().charAt(0);
          if(c=='y')
           {
               ply2=ply2+p;
           whose_move=2;
          }
          else
          {
            pl2_curturnscore=ply2;
               ply2=0;
           pl2_totscore=pl2_totscore+pl2_curturnscore;
           System.out.println("Player 2 total score is "+pl2_totscore);
           if(who_won())
               return;
           whose_move=1;
            System.out.println("player 1 turn");
           }
        }
        }
        process(k);
        
    } 
   public static boolean who_won()
   {
       if(pl1_totscore>=limit)
       {
           who_win=1;
           return true;
       }  
       if(pl2_totscore>=limit)
       {
           who_win=2;
           return true;
       }   
       return false;
   }
}
