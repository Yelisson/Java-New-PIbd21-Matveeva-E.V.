package progrLab5;

import java.awt.Color;
import java.awt.Graphics;

public interface Interface1 {

	void drawAnimal(Graphics g);

	void moveAnimal(Graphics g);

	void setPosition(int x, int y);

	void eatMouse(int countMouse);

	void eatBirds(int countBirds);

	void setMainColor(Color color);

	void setDopColor(Color color);
}
