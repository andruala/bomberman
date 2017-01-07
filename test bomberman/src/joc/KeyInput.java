

package joc;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
public class KeyInput extends KeyAdapter {

public static int miscpl1=0,miscpl2=0,temp;
//SUS JOS STANGA DREATA
// 1   2     3      4
int valauxmiscare;
	@SuppressWarnings("unused")
	public void keyPressed(KeyEvent e){
		
			
	
		
		if(Peint.gamestate=="pause" || Peint.gamestate=="play"){
			if(e.getKeyCode()==KeyEvent.VK_P){
				if(Peint.gamestate=="pause") Peint.gamestate="play";
				else Peint.gamestate="pause";
			}
		}
			if(Peint.gamestate=="dead"){
				if(e.getKeyCode()==KeyEvent.VK_R) {
					Window.restart();
					Peint.gamestate="play";
				}
				if(e.getKeyCode()==KeyEvent.VK_B){
					Peint.gamestate="meniu";
				}
			}
		
			if(Peint.gamestate=="help"){
				
				if(e.getKeyCode()==KeyEvent.VK_B) {
				
					
					Peint.gamestate="meniu" ;
					Thread.currentThread();
					
					
				}
				
			}
			
				
			if(Peint.gamestate=="meniu"){	
			
				
				if(e.getKeyCode()==KeyEvent.VK_S){
					Menus.tastameniu++;
					if(Menus.tastameniu<=0) Menus.tastameniu*=-1;
					if(Menus.tastameniu>=3) Menus.tastameniu%=3;
					
					Thread.currentThread();
					try {
						Thread.sleep(50);
					} catch (InterruptedException e1) {
						
						e1.printStackTrace();
					}
				
				}
				
				if(e.getKeyCode()==KeyEvent.VK_W){
					Menus.tastameniu--;
					if(Menus.tastameniu<0) Menus.tastameniu=2;
					if(Menus.tastameniu>=3) Menus.tastameniu%=3;
					
					Thread.currentThread();
					try {
						Thread.sleep(30);
					} catch (InterruptedException e1) {
						
						e1.printStackTrace();
					}
			
				}
			    if(e.getKeyCode()==KeyEvent.VK_C){
			    	
			    	switch (Menus.tastameniu){
			    	case 0:
			    		Peint.gamestate="play";
			    		Window.restart();
			    		break;
			    	case 1:
			    		Peint.gamestate="help";
			    		break;
			    	case 2:
			    		System.exit(0);
			    		break;
			    	}
			    
					}}
			
			
			for(Player p:Player.players){
		if(Peint.gamestate=="play"){
		
				if(p.name=="Player1" && p.alive==true){
		if(e.getKeyCode()==KeyEvent.VK_D) {
			/////pentru a nu se bloca in colturi
			p.velx=5;miscpl1=4;
			
		valauxmiscare=p.vely;
		p.vely=0;
		if(!(p.posy%40==0)){temp=p.posy%40;
		if(temp>=20) p.posy+=40-temp;
		else p.posy-=temp;}
		p.vely=valauxmiscare;
		/////pentru a nu se bloca in colturi
		}
		
		
		
		if(e.getKeyCode()==KeyEvent.VK_A) {p.velx=-5;miscpl1=3;
		valauxmiscare=p.vely;
		p.vely=0;
		if(!(p.posy%40==0)){temp=p.posy%40;
		if(temp>=20) p.posy+=40-temp;
		else p.posy-=temp;
		}
		p.vely=valauxmiscare;
		
		}
		if(e.getKeyCode()==KeyEvent.VK_S) {p.vely=5;miscpl1=2;
		valauxmiscare=p.velx;
		p.velx=0;
		if(!(p.posx%40==0)) {temp=p.posx%40;
		if(temp>=20) p.posx+=40-temp;
		else p.posx-=temp;
		}
		p.velx=valauxmiscare;
		}
		
		if(e.getKeyCode()==KeyEvent.VK_W) {p.vely=-5;miscpl1=1;
		
		valauxmiscare=p.velx;
		p.velx=0;
		if(!(p.posx%40==0)){temp=p.posx%40;
		if(temp>=20) p.posx+=40-temp;
		else p.posx-=temp;
		}
		p.velx=valauxmiscare;
		}
		
		
		
		if(e.getKeyCode()==KeyEvent.VK_SPACE) { if(p.nrbmbactuale<p.nrmaxbmb){Bomba bmb=new Bomba(p.posx,p.posy,p.range,0);p.nrbmbactuale++;}}
	
		
		if(e.getKeyCode()==KeyEvent.VK_E) {}
		
			
				}
		if(p.name=="Player2" && p.alive==true){
			
		if(e.getKeyCode()==KeyEvent.VK_RIGHT) {
			
			p.velx=5;miscpl2=4;
			
			valauxmiscare=p.vely;
			p.vely=0;
			if(!(p.posy%40==0)){temp=p.posy%40;
			if(temp>=20) p.posy+=40-temp;
			else p.posy-=temp;}
			p.vely=valauxmiscare;
			
		}
		if(e.getKeyCode()==KeyEvent.VK_LEFT) {p.velx=-5;miscpl2=3;
		valauxmiscare=p.vely;
		p.vely=0;
		if(!(p.posy%40==0)){temp=p.posy%40;
		if(temp>=20) p.posy+=40-temp;
		else p.posy-=temp;
		}
		p.vely=valauxmiscare;
		}
		if(e.getKeyCode()==KeyEvent.VK_DOWN) {p.vely=5;miscpl2=2;
		
		valauxmiscare=p.velx;
		p.velx=0;
		if(!(p.posx%40==0)) {temp=p.posx%40;
		if(temp>=20) p.posx+=40-temp;
		else p.posx-=temp;
		}
		p.velx=valauxmiscare;
		
		}
		if(e.getKeyCode()==KeyEvent.VK_UP) {p.vely=-5;miscpl2=1;
		
		valauxmiscare=p.velx;
		p.velx=0;
		if(!(p.posx%40==0)){temp=p.posx%40;
		if(temp>=20) p.posx+=40-temp;
		else p.posx-=temp;}
		p.velx=valauxmiscare;
		}
		
		
		if(e.getKeyCode()==KeyEvent.VK_ENTER) {if(p.nrbmbactuale<p.nrmaxbmb) {Bomba bmb=new Bomba(p.posx,p.posy,p.range,1);p.nrbmbactuale++;}
		}}
		}
		}
		}
			

	
	public void keyReleased(KeyEvent e){
		
	
		for(Player p:Player.players){	
			if(p.name=="Player1"){
	if(e.getKeyCode()==KeyEvent.VK_D) {p.velx=0;miscpl1=0;}
	if(e.getKeyCode()==KeyEvent.VK_A) {p.velx=0;miscpl1=0;}
	if(e.getKeyCode()==KeyEvent.VK_S) {p.vely=0;miscpl1=0;}
	if(e.getKeyCode()==KeyEvent.VK_W) {p.vely=0;miscpl1=0;}	}

	if(p.name=="Player2"){
		
	if(e.getKeyCode()==KeyEvent.VK_RIGHT) {p.velx=0;miscpl2=0;}
	if(e.getKeyCode()==KeyEvent.VK_LEFT)  {p.velx=0;miscpl2=0;}
	if(e.getKeyCode()==KeyEvent.VK_DOWN)  {p.vely=0;miscpl2=0;}
	if(e.getKeyCode()==KeyEvent.VK_UP)    {p.vely=0;miscpl2=0;}}}}

}




