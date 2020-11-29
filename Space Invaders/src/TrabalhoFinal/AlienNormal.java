package TrabalhoFinal;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Paint;

/**
 * Represents a simple ball that crosses the screen over and over again
 * @author Bernardo Copstein and Rafael Copstein
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
    if (getY() >= getLMaxV()){
        // Reposiciona no lado esquerdo e ...
            setPosY(getLMinV()-100);
            //System.out.println("perdeu");
            //finalJogo();
            
            }
    }
  
    
    public void Draw(GraphicsContext graphicsContext){
        graphicsContext.setFill(Paint.valueOf("#78BC61"));
        graphicsContext.fillOval(getX(), getY(), 32, 32);
    }    
}

