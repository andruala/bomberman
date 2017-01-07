package joc;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Random;

public class Powerup {
public static ArrayList<Powerup> puteri=new ArrayList<Powerup>();
public  BufferedImage imaginepowerup=Peint.pubmb;


Random rand=new Random();
int nrrand;
int pospux,pospuy;
Powerup(int a,int b){
nrrand=rand.nextInt(2)+1;
pospux=a;
pospuy=b;
puteri.add(this);

}

public void pickuppowerup(Player p){
	//se executa o actiune in fct de tip-ul powerup --uluoi
	if(nrrand==1) p.nrmaxbmb++;
	else p.range++;
	puteri.remove(this);
}



}
