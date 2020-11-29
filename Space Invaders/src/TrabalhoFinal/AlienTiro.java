package TrabalhoFinal;

import java.util.Timer;
import java.awt.Toolkit;
import java.util.TimerTask;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Paint;

public class AlienTiro extends AlienNormal{
	
	
	public AlienTiro(int px, int py) {
		super(px, py);
		Game.getInstance().addChar(new Shot(px,py+10));
		
		
	}

	public void Draw(GraphicsContext graphicsContext){
        graphicsContext.setFill(Paint.valueOf("#DE3C4B"));
        graphicsContext.fillOval(getX(), getY(), 32, 32);
    }   
}
