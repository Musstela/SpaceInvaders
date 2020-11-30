package TrabalhoFinal;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Paint;

public class AlienGrupo extends AlienNormal{
	
	

	public AlienGrupo(int px, int py,int di) {
		super(px,py);
		setSpeed(getSpeed()/2);
		setDirH(di);
	}
	
	 public void Update(){
         
	    setPosY(getY() + getDirV() * getSpeed());
	    setPosX(getX() + getDirH() * getSpeed());
	    
	    if(getX() >= 740){
	    	setDirH(-1);
	    }else if(getX() <= 0) {
	    	setDirH(1);
	    }
	    
	    if (getY() >= getLMaxV()+100){
	    	Game.getInstance().gameOver();
	    	
	    	do {
	    	setPosX(ranAli.nextInt((786-32)+32));
	    	setPosY(getLMinV()-100);
	        setSpeed(1);
	    	}while(Game.getInstance().getGameOver() == false);
		}
	}
	
	
	
	 public void Draw(GraphicsContext graphicsContext){
	        graphicsContext.setFill(Paint.valueOf("#8370FF"));
	        graphicsContext.fillOval(getX(), getY(), 64, 32);
	        
	        
	    }    
}
