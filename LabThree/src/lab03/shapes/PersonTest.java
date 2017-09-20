package lab03.shapes;

import static org.junit.Assert.*;

import java.awt.Color;

import org.junit.Before;
import org.junit.Test;

public class PersonTest {

	private Person p1;
	
	@Before
	public void setUp() throws Exception {
		p1 = new Person(1,1,Color.blue);
	}

	@Test
	public void testConstructor() {
		assertEquals("The x position is wrong", 1, p1.getX());
		assertEquals("The y position is wrong", 1, p1.getY());
		assertEquals("The color is wrong", Color.blue, p1.getColor());
		assertTrue("should be visible", p1.isVisible());
	}
	
	@Test
    public void testMove() {
        p1.move(20,30);
        assertEquals("wrong x", 20, p1.getX());
        assertEquals("wrong y", 30, p1.getY());
    }
    
    @Test
    public void testTranslate() {
        p1.translate(5,10);
        assertEquals("wrong x", 6, p1.getX());
        assertEquals("wrong y", 11, p1.getY());
    }
}
