package joc;

import java.awt.Dimension;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Window extends JFrame  {
	
	

@SuppressWarnings("unused")
public static void restart(){
	Wall.walls.clear();
	Player.players.clear();
	Wall.nrpowerups=10;
	Bomba.bombs.clear();
	Powerup.puteri.clear();
	
	Player jucator1=new Player("Player1",40,40,1);
	Player jucator2=new Player("Player2",520,520,1);
	createwalls();

}
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
public static int inaltime,latime;
	static	Player jucator1,jucator2;
	public static void main (String[] args){
		
		
		 inaltime=600;
		 latime=600;
		 JPanel ajutor=new JPanel();
		 JFrame frame=new JFrame("Bomberman L.Alex.");
		 ajutor.setPreferredSize(new Dimension(600,600));
		 frame.add(ajutor);
		 frame.pack();
		 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 
		 jucator1=new Player("Player1",40,40,1);
		 jucator2=new Player("Player2",520,520,3);
	   	 createwalls();
		
		
		Peint a=new Peint();
		frame.add(a);
		frame.addKeyListener(new KeyInput());
	System.out.println("SPORT");	
	frame.setVisible(true);
	}
	/// am adaugat un panel numit ajutor pentru a seta jframe-ul la 600 x 600
	
private static void createwalls(){
	@SuppressWarnings("unused")
	Wall walls;
	for(int i=0;i<=latime-40;i+=40){
		walls=new Wall(i,0,false);
		walls=new Wall(i,560,false);
	
	}
	
	for(int i=40;i<=latime-80;i+=40){
		
		walls=new Wall(0,i,false);
		walls=new Wall(560,i,false);	
	}
	for(int i=80;i<=latime-120;i+=80){
		walls=new Wall(i,80,false);
		walls=new Wall(i,160,false);
		walls=new Wall(i,240,false);
		walls=new Wall(i,320,false);
		walls=new Wall(i,400,false);
		walls=new Wall(i,480,false);

	}
		Random rand=new Random();
	int[][] matricetest=new int[14][14];
	int a,b,nrmaxwalld;

	nrmaxwalld=70;
	//MAXIM 128
	while(nrmaxwalld>0){
		a=rand.nextInt(13)+1;
		b=rand.nextInt(13)+1;
		if(!(a%2==0 && b%2==0) && !(a==1 && b==1) && !(a==1 && b==2) && !(a==2 && b==1) && !(a==13 && b==13) && !(a==12 && b==13) && !(a==13 && b==12)  && matricetest[a][b]==0) {
			matricetest[a][b]=3;
			nrmaxwalld--;
			walls=new Wall(a*40,b*40,true);
		}	
	}

	
	
	}
}
	

