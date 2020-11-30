package TrabalhoFinal;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Paint;

public class AlienTiro extends AlienNormal{
	
	
	public AlienTiro(int px, int py) {
		super(px, py);
		atirar();
	}

	public void atirar() {
		Game.getInstance().addChar(new ShotAlien(getX()-1, getY()+16, this.getSpeed()));
	}
	
	public void Draw(GraphicsContext graphicsContext){
        graphicsContext.setFill(Paint.valueOf("#FE654F"));
        graphicsContext.fillOval(getX(), getY(), 32, 32);
    }   
}
