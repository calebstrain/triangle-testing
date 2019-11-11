import static org.junit.Assert.*;
import org.junit.Test;

public class TriangleTest {
	
	double a,b,c,d,e,f;
	Triangle triangle;
	
	// Testing with side-lengths
	
	@Test
	public void INVALID() 
	{
		a = 1; b = 2; c = 3;
		triangle = new Triangle(a, b, c);
		assertEquals(Triangle.TriangleType.INVALID, triangle.type);
	}

	@Test
	public void INVALID_2() 
	{
		a = 1; b = 4; c = 3;
		triangle = new Triangle(a, b, c);
		assertEquals(Triangle.TriangleType.INVALID, triangle.type);
	}
	
	@Test
	public void INVALID_3() 
	{
		a = 5; b = 2; c = 1;
		triangle = new Triangle(a, b, c);
		assertEquals(Triangle.TriangleType.INVALID, triangle.type);
	}
	
	@Test
	public void INVALID_4() 
	{
		a = 5; b = 5; c = -1;
		triangle = new Triangle(a, b, c);
		assertEquals(Triangle.TriangleType.INVALID, triangle.type);
	}
	
	@Test
	public void INVALID_5() 
	{
		a = 5; b = -2; c = -1;
		triangle = new Triangle(a, b, c);
		assertEquals(Triangle.TriangleType.INVALID, triangle.type);
	}
	
	@Test
	public void RIGHT_ISOSCELES() 
	{
		a = 5; b = 7.07; c = 5;
		triangle = new Triangle(a, b, c);
		assertEquals(Triangle.TriangleType.RIGHT_ISOSCELES, triangle.type);
	}
	
	@Test
	public void RIGHT_ISOSCELES_2() 
	{
		a = 5; b = 5; c = 7.07;
		triangle = new Triangle(a, b, c);
		assertEquals(Triangle.TriangleType.RIGHT_ISOSCELES, triangle.type);
	}
	
	@Test
	public void RIGHT_ISOSCELES_3() 
	{
		a = 7.07; b = 5; c = 5;
		triangle = new Triangle(a, b, c);
		assertEquals(Triangle.TriangleType.RIGHT_ISOSCELES, triangle.type);
	}
	
	@Test
	public void RIGHT_SCALENE() 
	{
		a = 8; b = 10; c = 6;
		triangle = new Triangle(a, b, c);
		assertEquals(Triangle.TriangleType.RIGHT_SCALENE, triangle.type);
	}
	
	@Test
	public void EQUILATERAL() 
	{
		a = 100; b = 100; c = 100;
		triangle = new Triangle(a, b, c);
		assertEquals(Triangle.TriangleType.EQUILATERAL, triangle.type);
	}
	
	@Test
	public void ISOSCELES() 
	{
		a = 50; b = 90; c = 50;
		triangle = new Triangle(a, b, c);
		assertEquals(Triangle.TriangleType.ISOSCELES, triangle.type);
	}
	
	@Test
	public void ISOSCELES_2() 
	{
		a = 50; b = 50; c = 99;
		triangle = new Triangle(a, b, c);
		assertEquals(Triangle.TriangleType.ISOSCELES, triangle.type);
	}
	
	@Test
	public void ISOSCELES_3() 
	{
		a = 30; b = 25; c = 25;
		triangle = new Triangle(a, b, c);
		assertEquals(Triangle.TriangleType.ISOSCELES, triangle.type);
	}
	
	@Test
	public void SCALENE() 
	{
		a = 20; b = 25; c = 30;
		triangle = new Triangle(a, b, c);
		assertEquals(Triangle.TriangleType.SCALENE, triangle.type);
	}
	
	// Testing with Cartesian points
	
	@Test
	public void _INVALID() 
	{
		a = 1; b = 1; c = 2; d = 1; e = 3; f = 1;
		triangle = new Triangle(new Point(a,b), new Point(c,d), new Point(e,f));
		assertEquals(Triangle.TriangleType.INVALID, triangle.type);
	}
	
	@Test
	public void _RIGHT_ISOSCELES() 
	{
		a = 3; b = 0; c = 0; d = 0; e = 0; f = 3;
		triangle = new Triangle(new Point(a,b), new Point(c,d), new Point(e,f));
		assertEquals(Triangle.TriangleType.RIGHT_ISOSCELES, triangle.type);
	}
	
	@Test
	public void _RIGHT_SCALENE() 
	{
		a = 0; b = 0; c = 0; d = 2; e = 1; f = 2;
		triangle = new Triangle(new Point(a,b), new Point(c,d), new Point(e,f));
		assertEquals(Triangle.TriangleType.RIGHT_SCALENE, triangle.type);
	}
	
	@Test
	public void _EQUILATERAL() 
	{
		a = 10; b = 0; c = 0; d = 0; e = 5; f = 8.66;
		triangle = new Triangle(new Point(a,b), new Point(c,d), new Point(e,f));
		assertEquals(Triangle.TriangleType.EQUILATERAL, triangle.type);
	}
	
	@Test
	public void _ISOSCELES() 
	{
		a = 2; b = 3; c = 1; d = 1; e = 1; f = 5;
		triangle = new Triangle(new Point(a,b), new Point(c,d), new Point(e,f));
		assertEquals(Triangle.TriangleType.ISOSCELES, triangle.type);
	}
	
	@Test
	public void _SCALENE() 
	{
		a = 2; b = 3; c = 1; d = 1; e = 1; f = 7;
		triangle = new Triangle(new Point(a,b), new Point(c,d), new Point(e,f));
		assertEquals(Triangle.TriangleType.SCALENE, triangle.type);
	}
}
