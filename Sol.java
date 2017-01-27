import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Sol {

    public static void main(String[] args) {
        Map<Long,Long> m=new HashMap<Long,Long>();
        Scanner in = new Scanner(System.in);
        long n = in.nextLong();
        int c = in.nextInt();
         PriorityQueue<Long> pq=new PriorityQueue<Long>(c,Collections.reverseOrder());
        for(int i=0;i<c;i++)
            {
            Long x=in.nextLong();
            Long y=in.nextLong();
			if(m.containsKey(y))
            m.put(y,m.get(y)+x);
			else
			{
				m.put(y,x);
				pq.add(y);
			}
        }
        long max=0;
        for(int i=0;i<c;i++)
            {
         long k=pq.peek();
            long l=m.get(k);
            if(n<=l)
                {
                max=max+n*k;
                break;
            }
            else
                {
                max=max+l*k;
                n=n-l;
            pq.remove();
            }
        }
        System.out.println(max);
    }
}
