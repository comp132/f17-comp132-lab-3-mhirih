package lab03.shapes;

import java.awt.Color;

/**
 * This program creates a person trying to get inside a house that keeps
 * running away from them.
 * 
 * @author Houssem Mhiri
 *
 */
public class MyPic {

	/**
	 * Display a house and a person at the bottom of the screen. the person moves
	 * towards the house. the house shrinks and disappears from the left bottom corner
	 * and reappears in the upper right corner. the person chases it but the house
	 * disappears again and reappears at the left upper corner. the person runs after it
	 * and finally catches it and walks in.
	 * 
	 * @param args
	 */
	public static void main(String[] args){

		//Initial Setting
		DrawableObjectList objList = new DrawableObjectList();
		DrawingTablet tablet = new DrawingTablet("The Elusive House", 300, 300, objList);

		House h1 = new House(20,250,60,45,Color.yellow);
		objList.addDrawable(h1);

		Person p1 = new Person(275, 290,Color.black);
		objList.addDrawable(p1);

		tablet.repaint();

		//Person starts walking towards the house slowly
		for (int i = 0; i < 43; i++) {
			p1.translate(-4, 0);
			tablet.repaint();
			AnimationTimer.sleep(100);
		}

		//the house pulsates while shrinking, and disappears
		for (int i = 0; i < 13; i++) {
			h1.scale(1.2);
			tablet.repaint();
			AnimationTimer.sleep(90);
			h1.scale(0.6);
			tablet.repaint();
			AnimationTimer.sleep(60);
		}

		h1.setVisible(false);;
		tablet.repaint();

		//the house appears in the upper right corner, pulsates, and expands        
		House h2 = new House(240,35,4,3,Color.yellow);
		objList.addDrawable(h2);

		for (int i = 0; i < 13; i++) {
			h2.scale(1.5);
			tablet.repaint();
			AnimationTimer.sleep(80);
			h2.scale(0.8);
			tablet.repaint();
			AnimationTimer.sleep(50);
		}

		//Person starts walking towards the house again, a bit faster
		for (int i = 0; i < 43; i++) {
			p1.translate(3, -4);
			tablet.repaint();
			AnimationTimer.sleep(55);
		}

		//the house pulsates while shrinking, and disappears again
		for (int i = 0; i < 13; i++) {
			h2.scale(1.2);
			tablet.repaint();
			AnimationTimer.sleep(90);
			h2.scale(0.6);
			tablet.repaint();
			AnimationTimer.sleep(60);
		}

		objList.removeDrawable(h2);
		tablet.repaint();

		//the house appears in the upper left corner, pulsates, and expands

		House h3 = new House(30,40,4,3,Color.yellow);
		objList.addDrawable(h3);

		for (int i = 0; i < 13; i++) {
			h3.scale(1.5);
			tablet.repaint();
			AnimationTimer.sleep(80);
			h3.scale(0.8);
			tablet.repaint();
			AnimationTimer.sleep(50);
		}

		//Person starts walking towards the house fast
		for (int i = 0; i < 45; i++) {
			p1.translate(-5, 0);
			tablet.repaint();
			AnimationTimer.sleep(30);
		}

		//create another person at the same location in front of the house       
		Person p2 = new Person(p1.getX(), p1.getY(),Color.black);
		objList.removeDrawable(p1);
		objList.addDrawable(p2);
		tablet.repaint();

		//Person finally walks inside the house
		for (int i = 0; i < 33; i++) {
			p2.translate(1, -1);
			tablet.repaint();
			AnimationTimer.sleep(25);
		}

		AnimationTimer.sleep(35);
		objList.removeDrawable(p2);
		tablet.repaint();
	}
}
