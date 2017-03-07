import java.util.*;
import java.io.*;
class Clustering
{
	static Map<Integer,ArrayList<Integer>> e=new HashMap<Integer,ArrayList<Integer>>();
	static Map<Integer,ArrayList<Integer>> w=new HashMap<Integer,ArrayList<Integer>>();
	static Map<Integer,ArrayList<Integer>> r=new HashMap<Integer,ArrayList<Integer>>();
	static Map<Integer,ArrayList<Integer>> tree=new HashMap<Integer,ArrayList<Integer>>();
	static PriorityQueue<Integer> p=new PriorityQueue<Integer>();
	static List<Integer> li;
	static List<Integer> wi;
	static List<Integer> ri;
	static int n,m;
	static int b[]=new int[501];
	public static void main(String s[])throws Exception
	{
		File fi=new File("Clustering1.txt");
		Scanner sc=new Scanner(fi);
		n=sc.nextInt();
		 List<Integer> f=new ArrayList<Integer>();
		for(int i=1;i<=n;i++)
			b[i]=i;
		while(sc.hasNextLine())
		{
			int k=sc.nextInt();
			int l=sc.nextInt();
			int t=sc.nextInt();
			f.add(t);
			if(e.containsKey(k))
			{
				li=e.get(k);
				li.add(l);
				e.put(k,(ArrayList)li);
			}
			else
			{
				li=new ArrayList<Integer>();
				li.add(l);
				e.put(k,(ArrayList)li);
			}
			
			if(e.containsKey(l))
			{
				li=e.get(l);
				li.add(k);
				e.put(l,(ArrayList)li);
			}
			else
			{
				li=new ArrayList<Integer>();
				li.add(k);
				e.put(l,(ArrayList)li);
			}
			if(w.containsKey(k))
			{
				wi=w.get(k);
				wi.add(t);
				w.put(k,(ArrayList)wi);
			}
			else
			{
				wi=new ArrayList<Integer>();
				wi.add(t);
				w.put(k,(ArrayList)wi);
			}
			if(w.containsKey(l))
			{
				wi=w.get(l);
				wi.add(t);
				w.put(l,(ArrayList)wi);
			}
			else
			{
				wi=new ArrayList<Integer>();
				wi.add(t);
				w.put(l,(ArrayList)wi);
			}
			if(r.containsKey(t))
			{
				ri=r.get(t);
				if(!ri.contains(k))
				ri.add(k);
				r.put(t,(ArrayList)ri);
			}
			else
			{
				ri=new ArrayList<Integer>();
				ri.add(k);
				r.put(t,(ArrayList)ri);
			}
			if(r.containsKey(t))
			{
				ri=r.get(t);
				if(!ri.contains(l))
				ri.add(l);
				r.put(t,(ArrayList)ri);
			}
			else
			{
				ri=new ArrayList<Integer>();
				ri.add(l);
				r.put(t,(ArrayList)ri);
			}
		}
		   int a[]=new int[f.size()];
		   for(int i=0;i<f.size();i++)
		   {
			   a[i]=f.get(i);
		   }
			Arrays.sort(a);
			List<Integer> temp=new ArrayList<Integer>();
			List<Integer> temp1=new ArrayList<Integer>();
			List<Integer> temp3=new ArrayList<Integer>();
			List<Integer> temp4=new ArrayList<Integer>();
			List<Integer> temp5=new ArrayList<Integer>();
			List<Integer> temp2;
			int c[]=new int[n+1];
			int min=9999;
			for(int i=0;i<f.size();i++)
			{
				int count1=0,flag=0;
				int count=0;
				int k=a[i];
				temp=r.get(k);
				//System.out.println(temp);
				int h=0;
				for(int l=0;l<temp.size();l++)
				{
					 int p=temp.get(l);
						temp1=e.get(p);
						temp3=w.get(p);
					for(int j=0;j<temp.size();j++)
					{
						Arrays.fill(c,0);
						count1=0;
						if(l!=j && temp1.contains(temp.get(j)))
						{
							int g=temp1.indexOf(temp.get(j));
							int o=temp3.get(g);
							if(o==k)
							{
					int q=temp.get(j);
					if(!find(p,q))
					{
						union(p,q);
						for(int t=1;t<=n;t++)
						{
						   c[b[t]]++;
						}
						for(int t=1;t<=n;t++)
						{
							if(c[t]>0)
								count1++;
						}
						if(count1==4)
						{
							flag=1;
							break;
						}
					}
							}
						}
					}
					if(flag==1)
						break;
				}
				if(flag==1)
					break;
				if(count!=0)
				i=i+count-1;
			}
			for(int i=1;i<=n;i++)
			{
					temp5=e.get(i);
					temp1=w.get(i);
					int t=b[i];
					for(int j=1;j<=n;j++)
					{
						if(i!=j && temp5.contains(j)&& b[j]!=t)
						{
							int k=temp5.indexOf(j);
							int q=temp1.get(k);
							if(q<min)
								min=q;
						}
					}
			}
		System.out.println(min);
	//	System.out.print(tree);
		sc.close();
	}
			public static void union(int p,int q)
			{
				int temp=b[p];
				for(int i=1;i<=n;i++)
				{
					if(b[i]==temp)
					{
						b[i]=b[q];
					}
				}
			}
			public static boolean find(int p,int q)
			{
				if(b[p]==b[q])
					return true;
				else
					return false;
			}
}
