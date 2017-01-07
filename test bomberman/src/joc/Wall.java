package joc;


import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;






public class Wall{
	
	class timpw extends TimerTask{
		public void run(){
			
			contor++;
			if(contor==3) {
				
				remove();
			}
		
		}
	}
	
	public static ArrayList<Wall> walls=new ArrayList<Wall>();
	static int nrpowerups=10;
	int latura=40;
	int poswx,poswy,nrwall,contor=0;
	boolean sestrica=false,sedistruge=false;
	Random rand=new Random();
	int nrrandom;
	TimerTask timerTask = new timpw();
	Timer t = new Timer();
	public Wall(int a,int b,boolean c){
		poswx=a;
		poswy=b;
		sestrica=c;
		walls.add(this);
		//se genereaza power up-urile, intr-o locatie random.10 bucati.
		if(sestrica==true && nrpowerups>0){
		nrrandom=rand.nextInt(5)+0;
		if(nrrandom==3) {new Powerup(poswx,poswy);
		nrpowerups--;
		}}
		
	}
	
	public void destr(){
		if(sedistruge==false){
		sedistruge=true;
			
	
		t.schedule(timerTask,1,500);
	}}
	public void remove(){
		t.cancel();
		t.purge();
		walls.remove(this);
	}
	

}
