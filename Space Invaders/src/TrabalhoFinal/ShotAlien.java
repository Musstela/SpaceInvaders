package TrabalhoFinal;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Paint;

public class ShotAlien extends Shot{
	public ShotAlien(int px, int py, int speed) {
		super(px, py);
		setSpeed(speed + 5);
	}

	  @Override
    public void start(){
        setDirV(+1);        
    }
		  

	  public void Draw(GraphicsContext graphicsContext){
	        graphicsContext.setFill(Paint.valueOf("#DE3C4B"));
	        graphicsContext.fillOval(getX(), getY(), 8, 16);
	    }    
	  
}
