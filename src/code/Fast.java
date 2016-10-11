package code;

import java.util.Arrays;  
import java.util.PriorityQueue;

import edu.princeton.cs.introcs.In;
import edu.princeton.cs.introcs.StdDraw;
import edu.princeton.cs.introcs.StdOut;

public class Fast {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String file=args[0];
		In in=new In(file);
		int N=in.readInt();
		if(N<4)
			return;
		Point[]points=new Point[N];
		for(int i=0;i<N;i++)
		{
			points[i]=new Point(in.readInt(),in.readInt());
			StdDraw.setXscale(0,32768); StdDraw.setYscale(0,32768);
			points[i].draw();
		}
		PriorityQueue<Point>qu;
		for(int i=0;i<=N-4;i++)//hi
		{
			Arrays.sort(points,i,N,points[i].SLOPE_ORDER);
			for(int j=i;j<N;j++)
			{
				double slope;
				int count;
				qu=new PriorityQueue<Point>();
				if(j==i)
					{slope=points[i].slopeTo(points[i+1]);count=1;qu.add(points[i]);}
				else
					{slope=points[i].slopeTo(points[j]);count=2;qu.add(points[i]);qu.add(points[j]);}
				int k;
				for(k=j+1;k<N;k++)
				{
					if(points[i].slopeTo(points[k])!=slope)
						break;
					else
						{count++;//(20000, 21000) -> (3000, 4000) -> (14000, 15000) -> (6000, 7000)
							qu.add(points[k]);
						}
				}
				if(count>=4)
				{	
					Point start=new Point(0,0);Point end=new Point(0,0);
					for(int ind=1;ind<=count;ind++)
					{
						if(ind==count)
						{
							end=qu.poll();StdOut.println(end.toString());
						}
						else
						{
							if(ind==1)
							{
								start=qu.poll();StdOut.print(start.toString()+" -> ");
							}
							else
								StdOut.print(qu.poll().toString()+" -> ");
						}
					}
					StdDraw.setXscale(0,32768); StdDraw.setYscale(0,32768);
					start.drawTo(end);
				}
				j=k-1;
			}
		}
	}

}
