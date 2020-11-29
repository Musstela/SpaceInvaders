package TrabalhoFinal;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Paint;

public class AlienSapeca extends AlienNormal{
	
	public AlienSapeca(int px,int py) {
		super(px,py);
		setSpeed(getSpeed()/2);
	}
	
	
	public void Draw(GraphicsContext graphicsContext){
        graphicsContext.setFill(Paint.valueOf("#E5C1BD"));
        graphicsContext.fillOval(getX(), getY(), 32, 32);
    } 
}    

