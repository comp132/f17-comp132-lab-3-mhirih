package lab03.shapes;

import static org.junit.Assert.*;

import java.awt.Color;

import org.junit.Before;
import org.junit.Test;


public class DrawableObjectListTest {

	private DrawableObjectList l1;

	@Before
	public void setUp() throws Exception {

		l1 = new DrawableObjectList();
	}

	@Test
	public void testConstructor() {
		assertEquals("Array list is not empty", 0, l1.getSize());
	}
	
	@Test
	public void testAddDrawable(){
		Circle c1 = new Circle(0,0,0,Color.BLACK);
		l1.addDrawable(c1);
		assertEquals("The object was not added", 1, l1.getSize());
		
	}
	
	@Test
	public void testRemoveDrawable(){
		Circle c1 = new Circle(0,0,0,Color.BLACK);
		Circle c2 = new Circle(0,0,0,Color.BLACK);
		l1.addDrawable(c1);
		l1.addDrawable(c2);
		l1.removeDrawable(c2);
		assertEquals("The object was not removed", 1,l1.getSize() );
	}
	
	@Test
	public void testScaleAllTrue(){
		Circle c1 = new Circle(0,0,1,Color.BLACK);
		Circle c2 = new Circle(0,0,2,Color.BLACK);
		l1.addDrawable(c1);
		l1.addDrawable(c2);
		l1.scaleAll(2);
		assertEquals("The first object was not scaled", 2, c1.getRadius());
		assertEquals("The second object was not scaled", 4, c2.getRadius());
	}
	
	@Test
	public void testScaleAllFalse(){
		Person p1 = new Person(0,0,Color.BLACK);
		l1.addDrawable(p1);
		l1.scaleAll(2);
	}
}