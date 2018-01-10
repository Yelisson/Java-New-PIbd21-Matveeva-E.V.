package progrLab6_new;

import java.awt.Color;
import java.awt.Graphics;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Kobra extends PoisonousSnake implements Serializable {

	private boolean leftHood;
	private boolean rightHood;

	public Kobra(int maxSpeed, int maxCountMouses, int maxCountBirdss, int height, Color color1, boolean leftHood,
			boolean rightHood, Color color2) {
		super(maxSpeed, maxCountMouses, maxCountBirdss, height, color1, color2);
		this.leftHood = leftHood;
		this.rightHood = rightHood;
	}

	protected void drawLightAnimal(Graphics g) {
		if (leftHood) {
			Color colorBlack = new Color(0, 0, 0);
			g.setColor(colorBlack);
			g.fillOval(startPosX - 14, startPosY - 35, 15, 25);
		}
		if (rightHood) {
			Color colorBlack = new Color(0, 0, 0);
			g.setColor(colorBlack);
			g.fillOval(startPosX + 4, startPosY - 35, 15, 25);
		}

		super.drawLightAnimal(g);
		Color colorBlack = new Color(0, 0, 0);
		g.setColor(colorBlack);

		g.drawLine(startPosX - 10, startPosY - 30, startPosX - 20, startPosY - 25);
		g.drawLine(startPosX - 20, startPosY - 25, startPosX - 25, startPosY - 26);
		g.drawLine(startPosX - 20, startPosY - 25, startPosX - 16, startPosY - 21);
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

	@Override
	public String getInfo() {
		// TODO Auto-generated method stub

		return maxSpeed + ";" + maxCountMouse + ";" + maxCountBirds + ";" + height + ";" + ColorBody1 + ";" + true + ";" + true + ";"
				+ ColorBody2;

	}
}
