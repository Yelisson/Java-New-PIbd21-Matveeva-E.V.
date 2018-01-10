package progrLab5;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

public class Terrarium {

	List<ClassArray<Interface1>> terrariumStages;
	int countPlaces = 4;
	int placeSizeWidth = 270;
	int placeSizeHeight = 182;
	int currentLevel;

	public Terrarium(int countLevels) {
		terrariumStages = new ArrayList<ClassArray<Interface1>>();
		for (int i = 0; i < countLevels; i++) {
			terrariumStages.add(new ClassArray<Interface1>(countPlaces, null));
		}
		currentLevel = 0;
	}

	public int GetCurrentLevel() {
		return currentLevel;
	}

	public void levelUp() {
		if (currentLevel + 1 < terrariumStages.size()) {
			currentLevel++;
		}
	}

	public void levelDown() {
		if (currentLevel > 0) {
			currentLevel--;
		}
	}

	public int putSnakeInTerrarium(Interface1 snake) {
		return terrariumStages.get(currentLevel).add(terrariumStages.get(currentLevel), snake);
	}

	public Interface1 getSnakeInTerrarium(int index) {
		return terrariumStages.get(currentLevel).dec(terrariumStages.get(currentLevel), index);
	}

	public void Draw(Graphics g) {
		DrawMarking(g);
		for (int i = 0; i < countPlaces; i++) {
			Interface1 PoisonousSnake = terrariumStages.get(currentLevel).getSnake(i);
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
