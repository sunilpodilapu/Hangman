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
