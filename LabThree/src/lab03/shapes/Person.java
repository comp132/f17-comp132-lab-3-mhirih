package lab03.shapes;

import java.awt.Color;
import java.awt.Graphics;

/**
 * a Person is an object representing a stick figure. A Person has a reference point
 * (x,y) and a color. It can be moved, translated, and drawn.
 * 
 * @author Houssem Mhiri
 *
 */

public class Person implements Drawable{ 

	private int x;
    private int y;
    private Color theColor;
    private boolean isVisible;
	
    /**
     * Construct a new Person positioned at initX, initY with a color 
     * indicated by initColor. The new Person is visible by
     * default.
     * 
     * @param initX : initial x position
     * @param initY : initial y position
     * @param initColor : initial color
     */
    public Person(int initX, int initY, Color initColor){
    	x = initX;
    	y = initY;
    	theColor = initColor;
    	isVisible = true;
    }

    /**
     * Get the x coordinate of the position of this Person.
     * 
     * @return the x coordinate
     */
    public int getX() {
        return x;
    }

    /**
     * Get the y coordinate of the position of this Person.
     * 
     * @return the y coordinate
     */
    public int getY() {
    	return y;
    }
    
    /**
     * Move the Person to a new location. This method changes the position
     * of the person using the values provided by the parameters.
     * 
     * @param newX the new x coordinate
     * @param newY the new y coordinate
     */
    public void move(int newX, int newY) {
        x = newX;
        y = newY;
    }

    /**
     * Move the Person relative to its current location. The position
     * is moved by adding the parameters to the Person's current
     * location.
     * 
     * @param deltaX the change in the x coordinate. Positive values move the
     *            Person to the right, negative values move it to the left.
     * @param deltaY the change in the y coordinate. Positive values move the
     *            Person down, negative values move it up.
     */
    public void translate(int deltaX, int deltaY) {
        x = x + deltaX;
        y = y + deltaY;
    }
    
    // === Implementation of the Drawable interface ===

    /**
     * Draw this DrawableCircle onto the specified Graphics object.
     * 
     * @param g the Graphics object on which to draw this DrawableCircle.
     */
    public void draw(Graphics g) {
        g.setColor(getColor());
    }

    /**
     * Get the Color of this Circle.
     * 
     * @return the color.
     */
    public Color getColor() {
        return theColor;
    }

    /**
     * Change the color of this Circle to the newColor.
     * 
     * @param newColor the new color.
     */
    public void setColor(Color newColor) {
        theColor = newColor;
    }

    /**
     * Set whether or not this Circle will be visible. If it is visible its draw
     * method will be invoked when the DrawingTablet is repainted. If it is not
     * visible its draw method will not be invoked.
     * 
     * @param visible true to make this Circle visible, false to make it
     *            invisible.
     */
    public void setVisible(boolean visible) {
        isVisible = visible;
    }

    /**
     * Find out if this Circle is visible or not.
     * 
     * @return true if the Circle is visible, false if it is not.
     */
    public boolean isVisible() {
        return isVisible;
    }
}
