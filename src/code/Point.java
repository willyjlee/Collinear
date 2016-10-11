package code;
import edu.princeton.cs.introcs.*;

import java.util.Comparator;

public class Point implements Comparable<Point> {

    // compare points by slope
    public final Comparator<Point> SLOPE_ORDER=new bySlope(this);      // YOUR DEFINITION HERE
    
    private final int x;                              // x coordinate
    private final int y;                              // y coordinate

    // create the point (x, y)
    public Point(int x, int y) {
        /* DO NOT MODIFY */
        this.x = x;
        this.y = y;
    }

    private static class bySlope implements Comparator<Point>
    {	Point center;
    	public bySlope(Point c)
    	{
    		center=c;
    	}
    	public int compare(Point i,Point j)
    	{
    		double toi=center.slopeTo(i);
    		double toj=center.slopeTo(j);
    		return Double.compare(toi,toj);
//    		if(Double.compare(toi, toj)==0)
//    			return i.compareTo(j);
//    		else
//    			return Double.compare(toi,toj);
    	}
    }
    // plot this point to standard drawing
    public void draw() {
        /* DO NOT MODIFY */
        StdDraw.point(x, y);
    }

    // draw line between this point and that point to standard drawing
    public void drawTo(Point that) {
        /* DO NOT MODIFY */
        StdDraw.line(this.x, this.y, that.x, that.y);
    }

    // slope between this point and that point
    public double slopeTo(Point that) {
        /* YOUR CODE HERE */
    	if(this.x==that.x&&this.y==that.y)
    		return Double.NEGATIVE_INFINITY;
    	else if(this.x==that.x)
    		return Double.POSITIVE_INFINITY;
    	else if(this.y==that.y)
    		return +0d;
    	else
    		return 1.0*(that.y-this.y)/(that.x-this.x);
    }

    // is this point lexicographically smaller than that one?
    // comparing y-coordinates and breaking ties by x-coordinates
    public int compareTo(Point that) {
        /* YOUR CODE HERE */
    	if(this.y<that.y)
    		return -1;
    	else if(this.y==that.y)
    		if(this.x<that.x)
    			return -1;
    		else if(this.x==that.x)
    			return 0;
    	return 1;
    }

    // return string representation of this point
    public String toString() {
        /* DO NOT MODIFY */
        return "(" + x + ", " + y + ")";
    }

    // unit test
    public static void main(String[] args) {
        /* YOUR CODE HERE */
    }
}

