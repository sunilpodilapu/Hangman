import java.util.*;
import java.io.*;
class Anagrams
{
    static List<String> li=new ArrayList<String>(1000);
   static Set <String> set=new HashSet<String>();
    static Map<String,List<String>> m=new HashMap<String,List<String>>();
 public static void main(String s[])throws IOException
 {
    File fi=new File("moon.txt");
    Scanner sca=new Scanner(fi);
    List<String> lin;
    while(sca.hasNextLine())
    {
        String word=sca.nextLine();
        li.add(word);
        set.add(word);
        String k=sorted(word);
        if(m.containsKey(k))
        {
            lin=(ArrayList)m.get(k);
            lin.add(word);
            m.put(k,lin);
        }
        else
        {
            lin=new ArrayList<String>();
            lin.add(word);
            m.put(k,lin);
        }
    }
    String start=startword();
    List<String> res=(ArrayList)getonemore(start);
    for(String re:res)
        System.out.println(re);
    sca.close();
 }
 public static String startword()
 {
     List<String> n=new ArrayList<String>();
     for(String s:li)
     {
         if(s.length()<=4)
             n.add(s);
     }
     Random r=new Random();
     String str=n.get(r.nextInt(n.size()));
     return str;
 }
 public static String sorted(String word)
 {
     char ch[]=word.toCharArray();
     Arrays.sort(ch);
     return String.valueOf(ch);
 }
 public static List<String> getonemore(String base)
 {
     List<String> temp=new ArrayList<String>();
     List<String> result=new ArrayList<String>();
     for(char c='a';c<='z';c++)
     {
         String apend=base+c;
         String k=sorted(apend);
         if(m.containsKey(k))
         {
             temp=m.get(k);
             for(String s:temp)
             {
                 int i=s.toLowerCase().indexOf(base.toLowerCase());
                 if(i==-1)
                     result.add(s);
             }
         }
     }
     return result;
 }
 public static boolean isgoodword(String word,String base)
 {
     if(!set.contains(word))
         return false;
     int i=word.toLowerCase().indexOf(base.toLowerCase());
     if(i==-1)
         return false;
     return true;
 }
}
