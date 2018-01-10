package progrLab3;

import java.awt.Color;
import java.awt.Graphics;

public class Terrarium {

	ClassArray<Interface1> terrarium;
	int countPlaces = 4;
	int placeSizeWidth = 270;
	int placeSizeHeight = 182;

	
	public Terrarium() {
	    terrarium = new ClassArray<Interface1>(countPlaces,null);
	}
	
	public int putSnakeInTerrarium(Interface1 PoisonousSnake) {
		return terrarium.add(terrarium, PoisonousSnake);
	}

	public Interface1 getSnakeInTerrarium(int number) {
		return terrarium.dec(terrarium, number);
	}

	public void Draw(Graphics g) {
		DrawMarking(g);
		for (int i = 0; i < countPlaces; i++) {
			Interface1 PoisonousSnake = terrarium.getObject(i);
			if (PoisonousSnake != null) {
				PoisonousSnake.setPosition(35 + i / 2 * placeSizeWidth + 35, i % 2 * placeSizeHeight + 75);
				PoisonousSnake.drawAnimal(g);
			}
		}
	}

	private void DrawMarking(Graphics g) {
		g.setColor(Color.BLACK);
		g.drawRect(0, 0, (countPlaces) * placeSizeWidth, 1000);
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 2; ++j) {
				g.drawLine(i * placeSizeWidth, j * placeSizeHeight, i * placeSizeWidth + 270, j * placeSizeHeight);
			}
			g.drawLine(i * placeSizeWidth, 0, i * placeSizeWidth, 370);
		}
	}

}
