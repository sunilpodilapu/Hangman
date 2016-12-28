import java.util.*;
import java.io.*;
class Hangman
{
    public static void main(String s[]) throws IOException
    {
                System.out.println("\n\n");
        System.out.println("\t\t\t\t----------------HANGMAN GAME--------------------");
        System.out.println("\n\n");
                System.out.println("\t\t\t\t------------------INSTRUCTIONS----------------\n");
                System.out.println("1 :You will be given the length of a string");
                System.out.println("2 :You must guess the word by guessing some charactesrs");
                System.out.println("3 :If you correctly guess the character,its a hit and you will be given the index of the character");
                System.out.println("4 :you are given only 5 chances to miss");
                System.out.println("\t\t\t\t-------------------GOOD LUCK--------------------");
                System.out.println("\n\n");
        int len,limit=5,miss=0;
       Scanner sca=new Scanner(System.in); 
        List<String> load=new ArrayList<String>(1000);
        File fi=new File("sun.txt");
        Scanner sc=new Scanner(fi);
        Scanner scan=new Scanner(fi);
        
         while(sc.hasNextLine())
        {
           String line=sc.nextLine();
                load.add(line);
        }
         sc.close();
        Random r=new Random();
        String rand=load.get(r.nextInt(load.size()));
       // System.out.println(rand);
        len=rand.length();
        char temp[]=new char[len];
        System.out.println("the String is of length "+len);
        List<String> loadwords=new ArrayList<String>(1000);
        String line;
        while(scan.hasNextLine())
        {
            line=scan.nextLine();
            if(line.length()==len)
                loadwords.add(line);
        }
        while(miss!=limit)
        {
            System.out.println("choose any character");
            char c;
            c=sca.next().charAt(0);
            char ch[]=rand.toCharArray();
            int k=rand.indexOf(c);
            if(k==-1)
            {
            mustnothave(c,loadwords);
            miss++;
            System.out.println("its a miss");
            System.out.println("you have still "+(limit-miss)+" chances to miss");
            System.out.println("\n");
            }
            else
            {
                if(ch[k]==c)
                {
                System.out.println("Its a hit");
                System.out.println("Its index is "+k);
                
                musthaveat(c,k,loadwords);
                temp[k]=c;
                String found=String.valueOf(temp);
                //System.out.println("found is "+found);
                if(rand.equals(found))
                {
                    break;
                }
                }
            }
        }
        if(miss!=limit)
            System.out.println("You Won");
        else
        {
            System.out.println(" sry You Lose");
            System.out.println("The word is "+rand);
        }
        scan.close();
    }
    public static void musthaveat(char ch,int pos,List<String> alist)
    {
        for(int i=alist.size()-1;i>=0;i--)
        {
            String word=alist.get(i);
            if(pos>=word.length() || word.charAt(pos)!=ch)
                alist.remove(i);
        }
    }
    public static void mustnothave(char ch,List<String> alist)
    {
        Iterator<String> i=alist.iterator();
        while(i.hasNext())
        {
            String word=i.next();
            if(word.indexOf(ch)>=0)
                i.remove();
        }
    }
}
