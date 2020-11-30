package TrabalhoFinal;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Paint;

/**
 * Arthur_Maia_20108454_Luiz_Felipe_Oliveira_20103391-7_Felipe_Fonseca_Fagundes_20108219-5
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
    public void Update(){
    	        
        setPosY(getY() + getDirV() * getSpeed());
        // Se chegou na parte superior da tela ...
        if (getY() <= getLMinV()-100){
            // Desaparece
            deactivate();
        }
    }
    //EBEBEB

    public void Draw(GraphicsContext graphicsContext){
        graphicsContext.setFill(Paint.valueOf("#F4E32A"));
        graphicsContext.fillOval(getX(), getY(), 8, 16);
    }    
}

