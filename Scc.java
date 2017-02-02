import java.util.*;
public class Scc
{
	static int n,m,s1;
	static int visited[]=new int[10];
	static Map<Integer,ArrayList<Integer>> ma=new HashMap<Integer,ArrayList<Integer>>();
	static Map<Integer,ArrayList<Integer>> ma2=new HashMap<Integer,ArrayList<Integer>>();
	static Map<Integer,ArrayList<Integer>> ma1=new HashMap<Integer,ArrayList<Integer>>();
	static List<Integer> li;
	static int curlable;
	static int temp2[]=new int[10]; 
	static int leader[]=new int[10];
	public static void main(String s[])
	{
		Scanner sc=new Scanner(System.in);
		int count=0,odd=0,even=0;
		int a[]=new int[10];
		Arrays.fill(a,0);
		n=sc.nextInt();
		m=sc.nextInt();
		curlable=0;
		s1=0;
		Arrays.fill(visited,0);
			for(int i=0;i<m;i++)
			{
				int k=sc.nextInt();
				int l=sc.nextInt();
				if(ma.containsKey(k))
				{
					li=(ArrayList)ma.get(k);
					li.add(l);
					ma.put(k,(ArrayList)li);
				}
				else
				{
					li=new ArrayList<Integer>();
					li.add(l);
					ma.put(k,(ArrayList)li);
				}
				if(ma1.containsKey(l))
				{
					li=(ArrayList)ma1.get(l);
					li.add(k);
					ma1.put(l,(ArrayList)li);
				}
				else
				{
					li=new ArrayList<Integer>();
					li.add(k);
					ma1.put(l,(ArrayList)li);
				}
			}
			dfsloop1();
			for(int i=1;i<=n;i++)
			{
				List<Integer> temp3=new ArrayList<Integer>();
				List<Integer> temp4=new ArrayList<Integer>();
				if(ma.get(i)==null)
				;
				else
				temp3=ma.get(i);
				for(int k:temp3)
				{
					k=temp2[k];
					temp4.add(k);
				}
				ma2.put(temp2[i],(ArrayList)temp4);
			}
			Arrays.fill(visited,0);
			dfsloop();
			for(int i=1;i<=n;i++)
			{
				a[leader[i]]++;
			}
			for(int i=1;i<=n;i++)
			{
				if(a[i]>0) 
				{
					if(a[i]%2==0)
						even+=a[i];
					else
						odd+=a[i];
				}
			}
			System.out.println(odd-even);
	}
	public static void dfsloop1()
	{
		for(int i=n;i>=1;i--)
		if(visited[i]!=1)
		{
			dfs1(i);
		}
	}
	public static void dfsloop()
	{
		for(int i=n;i>=1;i--)
		if(visited[i]!=1)
		{
			s1=i;
			dfs(i);
		}
	}
	public static void dfs(int i)
	{
		visited[i]=1;
		leader[i]=s1;
		//System.out.println(i+" "+leader[i]);
		List<Integer> temp=new ArrayList<Integer>();
		if((ArrayList)ma2.get(i)==null)
		{
			//System.out.println(i);
			//System.out.println(temp2[i]);
			return; 
		}
		else
		temp=(ArrayList)ma2.get(i);
		for(int k:temp)
		{
			if(visited[k]!=1)
			{
				visited[k]=1;
				dfs(k);
			}
		}
			//System.out.println(i);
			//System.out.println(temp2[i]);
	}
	public static void dfs1(int i)
	{
		visited[i]=1;
		List<Integer> temp=new ArrayList<Integer>();
		if((ArrayList)ma1.get(i)==null)
		{
			curlable++;
			temp2[i]=curlable;
			//System.out.println(temp2[i]);
			return; 
		}
		else
		temp=(ArrayList)ma1.get(i);
		for(int k:temp)
		{
			if(visited[k]!=1)
			{
				visited[k]=1;
				dfs1(k);
			}
		}
			//System.out.println(i);
			curlable++;
			temp2[i]=curlable;
			//System.out.println(temp2[i]);
	}
}
