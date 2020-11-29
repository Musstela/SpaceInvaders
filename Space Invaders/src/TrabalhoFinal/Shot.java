package TrabalhoFinal;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Paint;

/**
 * Represents a shot that crosses the screen from bottom to up and then dismiss
 * @author Bernardo Copstein and Rafael Copstein
 */
public class Shot extends BasicElement{
    public Shot(int px,int py){
        super(px,py);
    }
    
    @Override
    public void start(){
        setDirV(-1);
        setSpeed(10);
    }
            
    @Override
    public boolean testaColisao(Character outro){     
        super.testaColisao(outro);
        return jaColidiu();
    }
    
		
                
    @Override
    public void Update(){
    	        
        setPosY(getY() + getDirV() * getSpeed());
        // Se chegou na parte superior da tela ...
        if (getY() <= getLMinV()){
            // Desaparece
            deactivate();
        }
    }
     

    public void Draw(GraphicsContext graphicsContext){
        graphicsContext.setFill(Paint.valueOf("#00FF00"));
        graphicsContext.fillOval(getX(), getY(), 8, 16);
    }    
}

