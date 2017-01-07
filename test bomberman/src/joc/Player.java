package joc;


import java.util.ArrayList;
import java.util.List;


public class Player 
{
/**
	 * 
	 */
	
	String name;
	boolean alive=true;
	public int posx,posy,velx,vely,nrmaxbmb=1,nrbmbactuale=0,range;
	public static List<Player> players=new ArrayList<Player>();
	public Player(String n,int x,int y,int r){
		name=n;
		posx=x;
		posy=y;
		range=r;
		players.add(this);
	}

	public void dead(){
		
		alive=false;
		Peint.gamestate="dead";
		if(this.name=="Player1") Menus.numeplayer="Red Player";  //se anunta castigatorul pentru Menus.dead
		else Menus.numeplayer="Blue Player";
		
		players.remove(this); 
	}


}
