package lab03.shapes;

import java.awt.Color;
import java.awt.Graphics;

/**
 * A House is an object representing a house. A House has a location point
 * (x,y) for the upper left corner of its wall, a roof color and a wall color. 
 * It can be moved, translated, scaled and drawn.
 * 
 * @author Houssem Mhiri
 * 
 */
public class House implements Drawable, Scaleable{

	private int x;
    private int y;
    private int width;
    private int height;
    private Color roof;
    private Color wall;
    private boolean isVisible;
    
    /**
     * Construct a new House with its top right corner centered at initX, initY, 
     * a wall color indicated by initWall, and a roof color that is darker than the wall. 
     * The new House is visible by default.
     * 
     * @param initX the x coordinate of the upper left corner of the House.
     * @param initY the y coordinate of the upper left corner of the House.
     * @param initColor the color of the wall.
     * @param initW the width of the House.
     * @param initH the height of the House.
     */
    public House(int initX, int initY, int initW, int initH, Color initColor) {
        x = initX;
        y = initY;
        width = initW;
        height = initH;
        wall = initColor;
        roof=initColor.darker();
        isVisible = true;
    }

    /**
     * Get the x coordinate of the center of this House.
     * 
     * @return the x coordinate
     */
    public int getX() {
        return x;
    }

    /**
     * Get the y coordinate of the center of this House.
     * 
     * @return the y coordinate
     */
    public int getY() {
        return y;
    }

    /**
     * Get the width of this House.
     * 
     * @return the width
     */
    public int getWidth() {
        return width;
    }
    
    /**
     * Get the height of this House.
     * 
     * @return the height
     */
    public int getHeight() {
        return height;
    }

    /**
     * Get the color of the roof of this House.
     * 
     * @return the color of the roof
     */
    public Color getRoof() {
		return roof;
	}



	/**
     * Move the House to a new location. This method changes the reference point
     * of the House using the values provided by the parameters.
     * 
     * @param newX the new x coordinate
     * @param newY the new y coordinate
     */
    public void move(int newX, int newY) {
        x = newX;
        y = newY;
    }

    /**
     * Move the House relative to its current location. The position of the
     * House is moved by adding the parameters to the House's current
     * location.
     * 
     * @param deltaX the change in the x coordinate. Positive values move the
     *            House to the right, negative values move it to the left.
     * @param deltaY the change in the y coordinate. Positive values move the
     *            House down, negative values move it up.
     */
    public void translate(int deltaX, int deltaY) {
        x = x + deltaX;
        y = y + deltaY;
    }
    
    // === Implementation of the Scaleable interface ===
    /**
     * Scale this House by the specified factor. For example a factor of 2.0
     * will make the length and width twice as big and a factor of 0.5 will make it half
     * as large. If the factor is negative the dimensions are not changed.
     * 
     * @param factor the factor by which this House is to be scaled.
     */
    public void scale(double factor) {
        if (factor > 0) {
        	width = (int) Math.round(width * factor);
        	height = (int) (Math.round(height * factor));
        }
    }

    // === Implementation of the Drawable interface ===

    /**
     * Draw this DrawableHouse onto the specified Graphics object.
     * 
     * @param g the Graphics object on which to draw this DrawableHouse.
     */
    public void draw(Graphics g) {
    	//draw the bottom part
        g.setColor(Color.black);
        g.drawRect(x, y, width, height);
        g.setColor(getColor());
        g.fillRect(x, y, width, height);
        
        int[] xPoints = new int[3];
        int[] yPoints = new int[3];
        
        xPoints[0]=x;
        xPoints[1]=x+width;
        xPoints[2]=x+width/2;
        
        yPoints[0]=y;
        yPoints[1]=y;
        yPoints[2]=(int) (y-(height*0.75));
        
        //draw the roof
        g.setColor(Color.black);
        g.drawPolygon(xPoints, yPoints, 3);
        g.setColor(getColor().darker());
        g.fillPolygon(xPoints, yPoints, 3);
        
        //Draw the door
        g.setColor(Color.black);
        g.drawRect(x+(width/6), y+(height/5), width/4, (int) (height*0.75));
        g.setColor(Color.orange);
        g.fillRect(x+(width/6), y+(height/5), width/4, (int) (height*0.75));
        
        //draw the window
        g.setColor(Color.black);
        g.drawRect((int) (x+(0.625*width)), y+(height/4), width/4, height/3);
        g.setColor(Color.cyan);
        g.fillRect((int) (x+(0.625*width)), y+(height/4), width/4, height/3);     
    }

    /**
     * Get the wall Color of this House.
     * 
     * @return the wall color.
     */
    public Color getColor() {
        return wall;
    }

    /**
     * Change the color of the wall of this House to the newColor. Also sets the roof
     * color to a darker version of the new color.
     * 
     * @param newColor the new color.
     */
    public void setColor(Color newColor) {
    	wall = newColor;
    	roof=newColor.darker();
    }

    /**
     * Set whether or not this House will be visible. If it is visible its draw
     * method will be invoked when the DrawingTablet is repainted. If it is not
     * visible its draw method will not be invoked.
     * 
     * @param visible true to make this House visible, false to make it
     *            invisible.
     */
    public void setVisible(boolean visible) {
        isVisible = visible;
    }

    /**
     * Find out if this House is visible or not.
     * 
     * @return true if the House is visible, false if it is not.
     */
    public boolean isVisible() {
        return isVisible;
    }
}
