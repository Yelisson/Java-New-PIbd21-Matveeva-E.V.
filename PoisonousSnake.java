package progrLab6_new;

import java.awt.Color;
import java.awt.Graphics;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class PoisonousSnake extends Snake implements Serializable  {

	private int countPoison;

	public PoisonousSnake(int maxSpeed, int maxCountMouse, int maxCountBirds, int height, Color color1, Color color2) {
		this.maxSpeed = maxSpeed;
		this.maxCountMouse = maxCountMouse;
		this.maxCountBirds = maxCountBirds;
		this.setColorBody1(color1);
		this.setColorBody2(color2);
		this.ColorBody1 = color1;
		this.ColorBody2 = color2;
		this.height = height;
		this.countMouse=0;
		this.countBirds=0;
		startPosX = 60;
		startPosY = 60;
	}

	public void drawAnimal(Graphics g) {
		drawLightAnimal(g);
	}

	protected void drawLightAnimal(Graphics g) {
		Color newColorGreen = new Color(0, 255, 0);
		g.setColor(newColorGreen);
		g.setColor(getColorBody1());
		g.fillOval(startPosX, startPosY, 90, 30);
		g.fillOval(startPosX - 7, startPosY - 30, 20, 45);
		g.fillOval(startPosX - 20, startPosY - 45, 25, 20);

		Color newColorBlack = new Color(0, 0, 0);
		g.setColor(newColorBlack);
		g.fillOval(startPosX - 16, startPosY - 42, 5, 5);
		g.fillOval(startPosX - 8, startPosY - 42, 5, 5);

		g.setColor(getColorBody2());
		g.drawLine(startPosX - 4, startPosY - 25, startPosX - 4, startPosY + 10);
		g.drawLine(startPosX + 4, startPosY - 25, startPosX + 4, startPosY + 10);
		g.drawLine(startPosX, startPosY - 25, startPosX, startPosY + 10);
		g.drawLine(startPosX + 4, startPosY + 14, startPosX + 90, startPosY + 14);
		g.drawLine(startPosX + 4, startPosY + 17, startPosX + 90, startPosY + 17);
		g.drawLine(startPosX + 4, startPosY + 20, startPosX + 90, startPosY + 20);
	}

	@Override
	public void moveAnimal(Graphics g) {
		startPosX += (maxSpeed * 50 / height);
		drawAnimal(g);
	}

	public void setCountPoison(int countPoison) {
		this.countPoison = countPoison;
	}

	public int getCountPoison() {
		return countPoison;
	}

	public int getMaxSpeed() {
		return super.getMaxSpeed();
	}

	protected void setMaxSpeed(int value) {
		if (value > 0 && value < 300) {
			super.setMaxSpeed(value);
		} else {
			super.setMaxSpeed(150);
		}
	}

	public int getMaxCountMouse() {
		return super.getMaxCountMouse();
	}

	protected void setMaxCountMouse(int value) {
		if (value > 0 && value < 30) {
			super.setMaxCountMouse(value);
		} else {
			super.setMaxCountMouse(29);
		}
	}

	public int getMaxCountBirds() {
		return super.getMaxCountBirds();
	}

	protected void setMaxCountBirds(int value) {
		if (value > 0 && value < 16) {
			super.setMaxCountBirds(value);
		} else {
			super.setMaxCountBirds(15);
		}
	}

	public int getHeight() {
		return super.getHeight();
	}

	protected void setHeight(int value) {
		if (value > 150 && value < 1500) {
			super.setHeight(value);
		} else {
			super.setHeight(500);
		}
	}
	
	@Override
 	public String getInfo() {
 		// TODO Auto-generated method stub
 		return maxSpeed + ";" + maxCountMouse + ";" + maxCountBirds + ";" + height + ";" + ColorBody1+";"+ColorBody2;
 
 	}
 	
 	private void writeObject(ObjectOutputStream s) throws IOException {
         s.defaultWriteObject();
         s.writeInt(ColorBody1.getRed());
         s.writeInt(ColorBody1.getGreen());
         s.writeInt(ColorBody1.getBlue());
       	s.writeInt(ColorBody2.getRed());
		s.writeInt(ColorBody2.getGreen());
		s.writeInt(ColorBody2.getBlue());
     }
 
     private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
         s.defaultReadObject();
         int red = s.readInt();
         int green = s.readInt();
         int blue = s.readInt();
         ColorBody1 = new Color(red, green, blue);
     	int red1 = s.readInt();
		int green1 = s.readInt();
		int blue1 = s.readInt();
		ColorBody2 = new Color(red1, green1, blue1);
     }
}
