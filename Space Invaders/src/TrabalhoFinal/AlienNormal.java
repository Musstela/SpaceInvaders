package TrabalhoFinal;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Paint;

/**
 * Arthur_Maia_20108454_Luiz_Felipe_Oliveira_20103391-7_Felipe_Fonseca_Fagundes_20108219-5
 */
public class AlienNormal extends BasicElement{
    public AlienNormal(int px,int py){
    	super(px,py);
    	setSpeed((Game.getInstance().getScore()/40)+2);
    }
    
    @Override
    public void start(){
        setDirV(1);
    }
        
    @Override
    public void Update(){
            
	    setPosY(getY() + getDirV() * getSpeed());
	    // Se chegou no lado direito da tela ...
	    
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
        graphicsContext.setFill(Paint.valueOf("#91C87E"));
        graphicsContext.fillOval(getX(), getY(), 32, 32);
    }    
}

