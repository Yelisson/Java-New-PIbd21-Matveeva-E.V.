package progrLab6_new;

import java.awt.Color;
import java.awt.Graphics;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Terrarium implements Serializable {

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

	public boolean save(String fileName) throws IOException {

		FileOutputStream save = null;
		try {
			save = new FileOutputStream(fileName);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ObjectOutputStream obSave = new ObjectOutputStream(save);
		System.out.println(terrariumStages.get(0).getSnake(0).getInfo());
		obSave.writeObject(terrariumStages);

		return true;
	}

	public boolean load(String filename) {
		try {
			ObjectInputStream obLoad = new ObjectInputStream(new BufferedInputStream(new FileInputStream(filename)));
			try {
				terrariumStages = (ArrayList<ClassArray<Interface1>>) obLoad.readObject();
				System.out.println(terrariumStages.get(0).getSnake(0).getInfo());
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return true;
	}
}
