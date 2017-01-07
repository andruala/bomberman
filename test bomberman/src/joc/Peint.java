package joc;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.util.Timer;
import java.util.TimerTask;

import javax.imageio.ImageIO;
import javax.swing.JPanel;


public class Peint extends JPanel {
	
	
	public class fps extends TimerTask{
		public void run(){
			repaint();
		}
	}
	
    public static BufferedImage[] pdr1=new BufferedImage[5];
    public static BufferedImage[] pdr2=new BufferedImage[5];
    
  
    
    public static BufferedImage[] pst1=new BufferedImage[5];
    public static BufferedImage[] pst2=new BufferedImage[5];
    
    public static BufferedImage[] pjo1=new BufferedImage[5];
    public static BufferedImage[] pjo2=new BufferedImage[5];
    
    public static BufferedImage[] psu1=new BufferedImage[5];
    public static BufferedImage[] psu2=new BufferedImage[5];
    
    public static BufferedImage[] pbo1=new BufferedImage[5];
    public static BufferedImage[] pbo2=new BufferedImage[5];
    
    public static BufferedImage[] walld=new BufferedImage[5];
    Player pc;
    Bomba bc;
    Wall wc;
    Powerup puc;
	public static BufferedImage ppl1=null,ppl2=null,pufire=null,pubmb=null;
	//public static BufferedImage pdr1=null,pdr2=null;
	//public static BufferedImage pst1=null,pst2=null;
	//public static BufferedImage pjo1=null,pjo2=null;
	//public static BufferedImage psu1=null,psu2=null;
	//public static BufferedImage pbo1=null,pbo2=null;
	BufferedImage b1=null,b2=null,expllat=null,explvert=null,explmijloc=null;
    //public static boolean peretesus,peretejos,peretest,peretedr;
	public static BufferedImage walli=null;
	int laturaplayer=40,p1contormiscare=0,p1contormiscare2=0,p2contormiscare=0,p2contormiscare2=0,i,j;
	static String gamestate="meniu";
	private static final long serialVersionUID = 1L;

	public Peint(){
		initializare();
		
		
	}
	
	
	
	/**
	 * 
	 */
	
	@Override
	public void paintComponent(Graphics g){
		if (gamestate=="meniu") Menus.meniu(g);
		if (gamestate=="help") Menus.help(g);
		if (gamestate=="dead") Menus.dead(g);
		if (gamestate=="pause") Menus.pause(g);
		if(gamestate=="play"){
		Toolkit.getDefaultToolkit().sync();
		super.paintComponent(g);
		g.setColor(Color.BLUE);
		g.fillRect(0, 0, 600, 600);	
		drawpowerups(g);
	drawwalls(g);
	drawbombs(g);
	drawplayers(g);
	miscare();

	
	
		}
		
	

}
	
	
	public void drawbombs(Graphics g){
		int crestere;
		for(int h1=Bomba.bombs.size()-1;h1>-1;h1--){
			bc=Bomba.bombs.get(h1);
			g.setColor(Color.BLACK);
			if(bc.size==1)g.drawImage(b1,bc.posbx, bc.posby, 40, 40,null);
			if(bc.size==2) g.drawImage(b2,bc.posbx, bc.posby, 40, 40,null);
			
			if(bc.size>2) {
				g.drawImage(explmijloc,bc.posbx, bc.posby, 40, 40,null);
				
				for(j=Player.players.size()-1;j>=0;j--){
					pc=Player.players.get(j);
					if(pc.posx+30>bc.posbx && pc.posx<bc.posbx+30 && pc.posy+30>bc.posby && pc.posy<bc.posby+30) {pc.dead();}}
				
			//	peretedr=false;
			//	peretest=false;
			//	peretesus=false;
			//	peretejos=false;
				
				////ALGORITM PRIN CARE RAZA CRESTE.
				//AM CATE O BUCATA PT DREAPTA STANGA SUS JOS, PENTRU CA DACA INCERCAM SA RETIN INDEXUL WALLULUI CARE TRBEUIE SPART, ERA PREA DIFICIL
				// CAND STERGEAM UN WALL, TOATE INDEXURILE SE SCHIMBAU.DACA VREI SA VEZI, DIN DRAWWALL sterge comentariul de la g.drawstring
				
				crestere=40;
				for(i=0;i<Bomba.bombs.get(h1).range;i++){
					bc=Bomba.bombs.get(h1);
					for(int h=Wall.walls.size()-1;h>=0;h--){
						wc=Wall.walls.get(h);
						if(wc.poswx==bc.posbx+crestere && (wc.poswy==bc.posby)){
							
							bc.peretedr[i]=true;
							if(bc.peretedr[i]==true && wc.sestrica==true && bc.size==3) wc.destr(); 
					
							}
						}
					
					if(bc.peretedr[i]==true) break;
					g.drawImage(explvert,bc.posbx+crestere, bc.posby, 40, 40,null);
					
					
					for(j=Player.players.size()-1;j>=0;j--){
						pc=Player.players.get(j);
						if(pc.posx+30>bc.posbx+crestere && pc.posx<bc.posbx+30+crestere && pc.posy+30>bc.posby && pc.posy<bc.posby+30){ pc.dead();}}
			//		
						crestere+=40;}
				
				
				//tot pentru raza
				crestere=40;
				for(i=0;i<Bomba.bombs.get(h1).range;i++){
					bc=Bomba.bombs.get(h1);
					for(int h=Wall.walls.size()-1;h>=0;h--){
						wc=Wall.walls.get(h);
						if(wc.poswx==bc.posbx-crestere && (wc.poswy==bc.posby)){
							
							bc.peretest[i]=true;
							if(bc.peretest[i]==true && wc.sestrica==true && bc.size==3) wc.destr(); 
							
							}
						}
					if(bc.peretest[i]==true) break;
					g.drawImage(explvert,bc.posbx-crestere, bc.posby, 40, 40,null);
					
						for(j=Player.players.size()-1;j>=0;j--){
							pc=Player.players.get(j);
						if(pc.posx+30>bc.posbx-crestere && pc.posx<bc.posbx+30-crestere && pc.posy+30>bc.posby && pc.posy<bc.posby+30) {pc.dead();}}
			//		
					
					
							crestere+=40;}
				
				//tot pentru raza
				
				crestere=40;
				for(i=0;i<Bomba.bombs.get(h1).range;i++){
					bc=Bomba.bombs.get(h1);
					for(int h=Wall.walls.size()-1;h>=0;h--){
						wc=Wall.walls.get(h);
						if(wc.poswy==bc.posby+crestere && (wc.poswx==bc.posbx)){
							
							bc.peretejos[i]=true;
							if(bc.peretejos[i]==true && wc.sestrica==true && bc.size==3) wc.destr(); 
							
							}
						}
					if(bc.peretejos[i]==true) break;
					g.drawImage(expllat,bc.posbx, bc.posby+crestere, 40, 40,null);
					
						for(j=Player.players.size()-1;j>=0;j--){
							pc=Player.players.get(j);
						if(pc.posx+30>bc.posbx && pc.posx<bc.posbx+30 && 
						pc.posy+30>bc.posby+crestere && pc.posy<bc.posby+30+crestere){ pc.dead();}}
			//		
					
					
					crestere+=40;}
				
				
				//tot pentru raza
				crestere=40;
				for(i=0;i<Bomba.bombs.get(h1).range;i++){
					bc=Bomba.bombs.get(h1);
					for(int h=Wall.walls.size()-1;h>=0;h--){
						wc=Wall.walls.get(h);
						if(wc.poswy==bc.posby-crestere && (wc.poswx==bc.posbx)){
							
							bc.peretesus[i]=true;
							if(bc.peretesus[i]==true && wc.sestrica==true && bc.size==3) wc.destr(); 
							
							}
						}
					if(bc.peretesus[i]==true) break;
					g.drawImage(expllat,bc.posbx, bc.posby-crestere, 40, 40,null);
						
					for(j=Player.players.size()-1;j>=0;j--){
						pc=Player.players.get(j);
						if(pc.posx+30>bc.posbx && pc.posx<bc.posbx+30 && 
						pc.posy+30>bc.posby-crestere && pc.posy<bc.posby+30-crestere){ pc.dead();}}
			//		
					
					crestere+=40;}
				
			}
			if(bc.size==4) { if(Player.players.size()>0) Player.players.get(bc.nrp).nrbmbactuale--; 
			Bomba.bombs.remove(bc);}
			
		}
	}
	private void drawpowerups(Graphics g){
		for(Powerup pu:Powerup.puteri)
			if(pu.nrrand==1)g.drawImage(pufire, pu.pospux, pu.pospuy,40,40, null);
			else g.drawImage(pubmb, pu.pospux, pu.pospuy,40,40, null);
	}
	private void drawwalls(Graphics g){
		
		for(i=Wall.walls.size()-1;i>=0;i--){
		
			wc=Wall.walls.get(i);
			g.setColor(Color.GRAY);
			if(wc.sestrica==false) g.drawImage(walli,wc.poswx, wc.poswy, 40, 40,null);
			else g.drawImage(walld[wc.contor],wc.poswx, wc.poswy, 40, 40,null);
			g.setColor(Color.RED);
	//		g.drawString(Integer.toString(w.nrwall), w.poswx+10, w.poswy+20);  //NUMERE INDEX
		}
	}
	
	private void drawplayers(Graphics g) {
		for(Player p:Player.players){
			
		for(Wall w:Wall.walls){
			if(p.vely>0 &&(p.posx>=w.poswx-39 && p.posx<=w.poswx+39) &&(p.posy==w.poswy-40)) p.vely=0; //verificare jos
			if(p.vely<0 &&(p.posx>=w.poswx-39 && p.posx<=w.poswx+39) &&(p.posy==w.poswy+40)) p.vely=0; //verificare sus
			if(p.velx>0 &&(p.posy>=w.poswy-39 && p.posy<=w.poswy+39) && (p.posx==w.poswx-40)) p.velx=0; //verificare dreapta
			if(p.velx<0 &&(p.posy>=w.poswy-39 && p.posy<=w.poswy+39) && (p.posx==w.poswx+40)) p.velx=0;} //verificare stanga
		
			
		for(Bomba b:Bomba.bombs){
		if(p.velx>0 &&(p.posx+40==b.posbx)&& (p.posy==b.posby)) p.velx=0;
		if(p.velx<0 &&(p.posx-40==b.posbx)&& (p.posy==b.posby)) p.velx=0;
		if(p.vely>0 &&(p.posy+40==b.posby)&&(p.posx==b.posbx)) p.vely=0;
		if(p.vely<0 && (p.posy-40==b.posby)&&(p.posx==b.posbx)) p.vely=0;
		
		
		}
		
			
			if(p.velx>0 && p.posx<Window.latime-laturaplayer*2) if(p.posy%40==0) p.posx+=p.velx;
			if(p.velx<0 && p.posx>laturaplayer)	if(p.posy%40==0) p.posx+=p.velx;
			if(p.vely>0 && p.posy<Window.inaltime-laturaplayer*2)	if(p.posx%40==0) p.posy+=p.vely;
			if(p.vely<0 && p.posy>laturaplayer) if(p.posx%40==0)	p.posy+=p.vely;
			
			
			
			if(p.name=="Player1") g.drawImage(ppl1, p.posx,p.posy, laturaplayer, laturaplayer,null);
				else g.drawImage(ppl2, p.posx,p.posy, laturaplayer, laturaplayer,null);
			
		for(i=Powerup.puteri.size()-1;i>=0;i--){
			puc=Powerup.puteri.get(i);
			if(p.posx==puc.pospux&& p.posy==puc.pospuy) puc.pickuppowerup(p);
			
		}
			
			
		}
	}
	
	
	private void initializare(){
		try{
	
		
	
		for(i=0;i<5;i++){
		
			pdr1[i]=ImageIO.read(getClass().getResource("resources/Player1/dreapta"+(i+1)+".png"));
			pdr2[i]=ImageIO.read(getClass().getResource("resources/Player2/dreapta"+(i+1)+".png"));
			
			pst1[i]=ImageIO.read(getClass().getResource("resources/Player1/stanga"+(i+1)+".png"));
			pst2[i]=ImageIO.read(getClass().getResource("resources/Player2/stanga"+(i+1)+".png"));
			
			psu1[i]=ImageIO.read(getClass().getResource("resources/Player1/sus"+(i+1)+".png"));
			psu2[i]=ImageIO.read(getClass().getResource("resources/Player2/sus"+(i+1)+".png"));
			
			pjo1[i]=ImageIO.read(getClass().getResource("resources/Player1/jos"+(i+1)+".png"));
			pjo2[i]=ImageIO.read(getClass().getResource("resources/Player2/jos"+(i+1)+".png"));
			
			pbo1[i]=ImageIO.read(getClass().getResource("resources/Player1/boom"+(i+1)+".png"));
			pbo2[i]=ImageIO.read(getClass().getResource("resources/Player2/boom"+(i+1)+".png"));
		
			
			walld[i]=ImageIO.read(getClass().getResource("resources/Etc/w"+i+".png"));
			pufire=ImageIO.read(getClass().getResource("resources/Etc/pubomb.png"));
			pubmb=ImageIO.read(getClass().getResource("resources/Etc/pufire.png"));
			
		}
		 b1 = ImageIO.read(getClass().getResource("resources/Etc/b1.png"));
		 b2 = ImageIO.read(getClass().getResource("resources/Etc/b2.png"));
		 
		 explmijloc = ImageIO.read(getClass().getResource("resources/Etc/explmijloc.png"));
		 explvert = ImageIO.read(getClass().getResource("resources/Etc/explvert.png"));
		 expllat = ImageIO.read(getClass().getResource("resources/Etc/expllat.png"));
		
		 walli=ImageIO.read(getClass().getResource("resources/Etc/wall.png"));
		
	
		 ppl1=pjo1[0];
		 ppl2=psu2[0];

	}
	catch(Exception e){
		System.out.println(e);
	}
		
		TimerTask timerTask = new fps();
		Timer t = new Timer();
		t.schedule(timerTask, 0,17);
	}
	
	private void miscare(){
		///animatii
		switch (KeyInput.miscpl1){
		case 1: //sus
			
			ppl1=psu1[p1contormiscare2];
			p1contormiscare++;
			if(p1contormiscare%5==0) p1contormiscare2++;
			p1contormiscare2%=5;
			
			break;
		case 2: //jos
			ppl1=pjo1[p1contormiscare2];
			p1contormiscare++;
			if(p1contormiscare%5==0) p1contormiscare2++;
			p1contormiscare2%=5;
			break;
		case 3: //stanga 
			ppl1=pst1[p1contormiscare2];
			p1contormiscare++;
			if(p1contormiscare%5==0) p1contormiscare2++;
			p1contormiscare2%=5;
			break;
		case 4: //dreapta
			ppl1=pdr1[p1contormiscare2];
			p1contormiscare++;
			if(p1contormiscare%5==0) p1contormiscare2++;
			p1contormiscare2%=5;
			break;
		}
		
		switch (KeyInput.miscpl2){
		case 1: //sus
			ppl2=psu2[p2contormiscare2];
			p2contormiscare++;
			if(p2contormiscare%5==0) p2contormiscare2++;
			p2contormiscare2%=5;
			
			
			break;
		case 2: //jos
			ppl2=pjo2[p2contormiscare2];
			p2contormiscare++;
			if(p2contormiscare%5==0) p2contormiscare2++;
			p2contormiscare2%=5;
			break;
		case 3: //stanga 
			ppl2=pst2[p2contormiscare2];
			p2contormiscare++;
			if(p2contormiscare%5==0) p2contormiscare2++;
			p2contormiscare2%=5;
			break;
		case 4: //dreapta
			ppl2=pdr2[p2contormiscare2];
			p2contormiscare++;
			if(p2contormiscare%5==0) p2contormiscare2++;
			p2contormiscare2%=5;
			break;
		}
		
		
	}


}

