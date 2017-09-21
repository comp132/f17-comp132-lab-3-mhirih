package lab03.shapes;

import static org.junit.Assert.*;

import java.awt.Color;

import org.junit.Before;
import org.junit.Test;

public class HouseTest {

	private House h1;
	
	@Before
	public void setUp() throws Exception {
		h1 = new House(10,20,5,6,Color.blue);
	}

	@Test
	public void testConstructor() {
		assertEquals("The x position is wrong", 10, h1.getX());
		assertEquals("The y position is wrong", 20, h1.getY());
		assertEquals("The width is wrong", 5, h1.getWidth());
		assertEquals("The height is wrong", 6, h1.getHeight());
		assertEquals("The roof color is wrong", Color.blue.darker(), h1.getRoof());
		assertEquals("The wall color is wrong", Color.blue, h1.getColor());
		assertTrue("should be visible", h1.isVisible());
	}
	
	@Test
    public void testMove() {
        h1.move(20,30);
        assertEquals("wrong x", 20, h1.getX());
        assertEquals("wrong y", 30, h1.getY());
    }
    
    @Test
    public void testTranslate() {
        h1.translate(5,10);
        assertEquals("wrong x", 15, h1.getX());
        assertEquals("wrong y", 30, h1.getY());
    }
    
    @Test
    public void testSetColor() {
        h1.setColor(Color.cyan);
        assertEquals("wrong color", Color.cyan, h1.getColor());     
    }
    
    @Test
    public void testSetVisible() {
        h1.setVisible(false);
        assertFalse("should be invisible", h1.isVisible());
        
        h1.setVisible(true);
        assertTrue("should be visible", h1.isVisible());
    }
    
    @Test
    public void testScale() {
        h1.scale(2.0);
        assertEquals("The width is wrong", 10, h1.getWidth());
		assertEquals("The height is wrong", 12, h1.getHeight());
        
        h1.scale(0.5);
        assertEquals("The width is wrong", 5, h1.getWidth());
		assertEquals("The height is wrong", 6, h1.getHeight());
        
        h1.scale(-2.0);
        assertEquals("The width is wrong", 5, h1.getWidth());
		assertEquals("The height is wrong", 6, h1.getHeight());
    }
}
