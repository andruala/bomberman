package joc;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class Menus {
public static String numeplayer;
static int tastameniu=0; //am folosit tasta meniu pentru a sti ce buton este "selectat"
public static void meniu(Graphics g){
	g.setColor(Color.BLACK);
	g.fillRect(0, 0, 600, 600);
	//g.setColor(Color.RED);
	g.setColor(new Color(125,10,25));
	g.fillRect(200, 50, 200, 100);
	g.fillRect(200, 250, 200, 100);
	g.fillRect(200, 450, 200, 100);
	g.setFont(new Font("TimesRoman", Font.BOLD, 15));
	g.setColor(Color.WHITE);
	g.drawString("W = up", 200, 180);
	g.drawString("S = down", 200, 380);
	g.drawString("C = select", 200, 580);
	g.setColor(new Color(234,55,25));
	
	switch (tastameniu){
	
	case 0:
		g.fillRect(205, 55, 190, 90);
		break;
	case 1:
		g.fillRect(205, 255, 190, 90);
		break;
	case 2:
		g.fillRect(205, 455, 190, 90);
		break;
	}
	
	g.setColor(Color.BLUE);
	g.setFont(new Font("TimesRoman", Font.BOLD, 40)); 
	g.drawString("START", 225, 115);
	g.drawString("HELP", 235, 315);
	g.drawString("EXIT", 245, 515);
	g.setFont(new Font("TimesRoman", Font.BOLD, 20)); 
	
}
public static void dead(Graphics g){
	g.setColor(Color.BLACK);
	g.fillRect(0, 0, 600,600);
	g.setFont(new Font("TimesRoman", Font.BOLD, 30)); 
	g.setColor(Color.WHITE);
	g.drawString(numeplayer+" won :D",160,160);
	g.drawString("Press r to restart",160,260);
	g.drawString("Press B to go into menu",160,360);
}
public static void help(Graphics g){
	g.setColor(Color.BLACK);
	g.fillRect(0, 0, 600, 600);
	g.setColor(Color.RED);
	g.setFont(new Font("TimesRoman", Font.BOLD, 20)); 
	g.drawString("Blue Player", 50, 100);
	g.drawString("Movement : W/A/S/D", 50, 150);
	g.drawString("Place bomb: SPACE",50, 200);
	
	g.drawString("Red Player", 50, 300);
	g.drawString("Movement : Upper/Left/Down/Right Arrow", 50, 350);
	g.drawString("Place bomb: ENTER",50, 400);
	g.drawString("Press \"B\" to go back", 175, 500);
}
public static void pause(Graphics g){
	g.setColor(Color.BLACK);
	g.fillRect(0, 0, 600, 600);
	g.setColor(Color.RED);
	g.setFont(new Font("TimesRoman", Font.BOLD, 40)); 
	g.drawString("Game paused", 150, 215);
	g.setFont(new Font("TimesRoman", Font.BOLD, 30)); 
	g.drawString("Press \"P\" to resume",130, 300);

}
}
