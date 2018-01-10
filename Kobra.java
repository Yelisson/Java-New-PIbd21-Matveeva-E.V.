package progrLab2New;

import java.awt.Color;
import java.awt.Graphics;

public class Kobra extends PoisonousSnake {

	  private boolean leftHood;
      private boolean rightHood;
      private Color dopColor;

      public Kobra(int maxSpeed, int maxCountMouses, int maxCountBirdss, int height,
          Color color1, boolean leftHood, boolean rightHood,
          Color color2){
   	   super(maxSpeed, maxCountMouses, maxCountBirdss, height, color1, color2);      
          this.leftHood = leftHood;
          this.rightHood = rightHood;
          this.dopColor = color2;
      }
      protected void drawLightAnimal(Graphics g)
      {
          if (leftHood)
          {
       	   Color colorBlack = new Color(0,0,0);
          	   g.setColor(colorBlack);
              g.fillOval(startPosX - 14, startPosY - 35, 15, 25);
          }
          if (rightHood)
          {
       	   Color colorBlack = new Color(0,0,0);
              g.setColor(colorBlack);
              g.fillOval(startPosX + 4, startPosY - 35, 15, 25);
          }

          super.drawLightAnimal(g);
          Color colorBlack = new Color(0,0,0);
          g.setColor(colorBlack);

          g.drawLine(startPosX - 10, startPosY - 30, startPosX - 20, startPosY - 25);
          g.drawLine(startPosX - 20, startPosY - 25, startPosX - 25, startPosY - 26);
          g.drawLine(startPosX - 20, startPosY - 25, startPosX - 16, startPosY - 21);
      }
}
