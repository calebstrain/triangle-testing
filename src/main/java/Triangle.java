import java.util.ArrayList;
import java.util.Arrays;

public class Triangle {
	
	private Double a, b, c, s;
	private Point points[];
	private Double angles[];
	public enum TriangleType { INVALID, RIGHT_ISOSCELES, RIGHT_SCALENE, EQUILATERAL, ISOSCELES, SCALENE  };
	public TriangleType type;
	
	Triangle(Double a, Double b, Double c) 
	{
		angles = new Double[3];
		this.a = a; this.b = b; this.c = c;
		type = classify();
	}
	
	Triangle( Point pointA, Point pointB, Point pointC)
	{
		points = new Point[3];
		angles = new Double[3];
		points[0] = pointA; points[1] = pointB; points[2] = pointC;
		determineSideLengths();
		type = classify();
	} 
	
	public TriangleType classify()
	{
		int state = 0;
		
		while(true) 
		{
			switch(state) 
			{
			case 0:
				if( !isValid() )
					return TriangleType.INVALID;
				else
					state = 1;
				break;
			case 1:
				if( rightTriangle() ) 
					state = 2;
				else 
					state = 3;
				break;
			case 2:  
				if( isIsosceles() )
					return TriangleType.RIGHT_ISOSCELES;
				else
					return TriangleType.RIGHT_SCALENE;
			case 3:
				if( isEquilateral() )
					return TriangleType.EQUILATERAL;
				else if( isIsosceles() )
					return TriangleType.ISOSCELES;
				else
					return TriangleType.SCALENE;
			}	
		}
	}
	
	private boolean isValid() 
	{
		if( a + b <= c )
			return false;
		else if( a + c <= b)
			return false;
		else if( b + c <= a) 
			return false;
		else 
			return true;
	}
	
	private boolean rightTriangle() 
	{
		angles[0] = Math.toDegrees( Math.acos( ( b*b + c*c - a*a ) / ( 2*b*c ) ) );
		angles[1] = Math.toDegrees( Math.acos( ( c*c + a*a - b*b ) / ( 2*a*c ) ) ); 
		angles[2] = ( 180 - angles[0] ) - angles[1];
		
		if( angles[0] >= 89.9 && angles[0] <= 90.1 ) 
			return true;
		else if( angles[1] >= 89.9 && angles[1] <= 90.1  )
			return true;
		else if( angles[2] >= 89.9 && angles[2] <= 90.1 )
			return true;
		else 
			return false;
	}
	
	private boolean isEquilateral() 
	{
		if( points == null )
			return ( a.equals(b) && b.equals(c) ); 
		else // compare by angles to prevent rounding error if using points instead of sides
		{
			for( double d : angles ) 
			{
				if( !(d >= 59.9 && d <= 60.1) )
					return false;
			}
			return true;
		}
	}
	private boolean isIsosceles() 
	{
		if( a.equals(b) && !b.equals(c) )
			return true;
		else  if( a.equals(c) && !c.equals(b) )
			return true;
		else if( b.equals(c) && !c.equals(a) )
			return true;
		else
			return false;
	}
	
	private void determineSideLengths() 
	{
		double arr[] = new double[3];
		int inc = 1;
		for( int i = 0; i < 3; i++) 
		{
			if( i == 2)
				inc = -2;
			double x1 = points[i].getX();
			double x2 = points[i + inc].getX();
			double y1 = points[i].getY();
			double y2 = points[i + inc].getY();
			
			double xVal = ( x2 - x1 );
			double yVal = ( y2 - y1 );
			
			arr[i] = Math.sqrt( ( xVal * xVal ) + ( yVal * yVal ) );
		}
		
		a = arr[0];
		b = arr[1];
		c = arr[2];
	}
}