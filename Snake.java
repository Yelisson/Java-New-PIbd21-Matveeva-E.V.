package progrLab6_new;

import java.awt.Color;
import java.awt.Graphics;

public abstract class Snake implements Interface1 {

	public abstract void drawAnimal(Graphics g);

	public abstract void moveAnimal(Graphics g);
	
	public abstract String getInfo();

	protected int startPosX;
	protected int startPosY;
	protected int countMouse;
	protected int countBirds;

	protected int maxCountMouse;
	protected int maxCountBirds;
	protected Color ColorBody1;
	protected Color ColorBody2;
	protected int height;
	protected int maxSpeed;

	protected void setMaxCountBirds(int maxCountBirds) {
		this.maxCountBirds = maxCountBirds;
	}

	public int getMaxCountBirds() {
		return maxCountBirds;
	}

	protected void setMaxCountMouse(int maxCountMouse) {
		this.maxCountMouse = maxCountMouse;
	}

	public int getMaxCountMouse() {
		return maxCountMouse;
	}

	protected void setMaxSpeed(int maxSpeed) {
		this.maxSpeed = maxSpeed;
	}

	public int getMaxSpeed() {
		return maxSpeed;
	}

	protected void setHeight(int height) {
		this.height = height;
	}

	public int getHeight() {
		return height;
	}

	protected void setColorBody1(Color ColorBody1) {
		this.ColorBody1 = ColorBody1;
	}

	public Color getColorBody1() {
		return ColorBody1;
	}

	protected void setColorBody2(Color ColorBody2) {
		this.ColorBody2 = ColorBody2;
	}

	public Color getColorBody2() {
		return ColorBody2;
	}

	public void setPosition(int x, int y) {
		startPosX = x;
		startPosY = y;
	}

	public void eatMouse(int count) {
		if (countMouse + count < getMaxCountMouse()) {
			countMouse += count;
		}
	}

	public void eatBirds(int count) {
		if (countBirds + count < getMaxCountBirds()) {
			countBirds += count;
		}
	}

	public void setMainColor(Color c) {
		ColorBody1 = c;
	}

	public void setDopColor(Color c) {
		ColorBody2 = c;
	}
}
