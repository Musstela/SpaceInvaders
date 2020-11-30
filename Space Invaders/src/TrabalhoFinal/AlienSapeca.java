package TrabalhoFinal;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Paint;

/**
 * Arthur_Maia_20108454_Luiz_Felipe_Oliveira_20103391-7_Felipe_Fonseca_Fagundes_20108219-5
 */

public class AlienSapeca extends AlienNormal{
	
	public AlienSapeca(int px,int py) {
		super(px,py);
		setSpeed(getSpeed()/2);
	}
	
	
	public void Draw(GraphicsContext graphicsContext){
        graphicsContext.setFill(Paint.valueOf("#EF5773"));
        graphicsContext.fillOval(getX(), getY(), 32, 32);
    } 
}    

