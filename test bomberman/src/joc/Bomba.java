package joc;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;





public class Bomba {
	
	class timp extends TimerTask{
		public void run(){
			size++;
			
			if(size==4) {
				t.cancel();
				t.purge();}
			//la secunda 4 se sterge timerul.am observa ca timerul nu se sterge daca se sterge obiectul care continea acel timer
		}
	}
	public static ArrayList<Bomba> bombs=new ArrayList<Bomba>();

	 public int posbx,posby,range,nrp;
	public int  size=0;
	int temp,contor=0;
	int[] tempwalls=new int[4];
	TimerTask timerTask = new timp();
	Timer t = new Timer();

	
	public boolean[] peretedr=new boolean[10],peretest=new boolean[10],peretejos=new boolean[10],peretesus=new boolean[10];
	

	
	Bomba(int x,int y,int r,int n){
		
		
		
	
		
		
		nrp=n;
		posbx=x;
		posby=y;
		range=r;
		bombs.add(this);
	
		
		//pentru a se situa doar in mijlocul patratelor
		temp=posbx%40;
		if(temp>=20) posbx+=40-temp;
		else posbx-=temp;
		
		temp=posby%40;
		if(temp>=20) posby+=40-temp;
		else posby-=temp;
		
		
		
		t.schedule(timerTask, 0, 1000);
	}

}
