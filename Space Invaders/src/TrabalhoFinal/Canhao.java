package TrabalhoFinal;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Paint;

/**
 * Arthur_Maia_20108454_Luiz_Felipe_Oliveira_20103391-7_Felipe_Fonseca_Fagundes_20108219-5
 */
public class Canhao extends BasicElement implements KeyboardCtrl{
   
	public int vida = 3;
	
	public Canhao(int px,int py){
        super(px,py);
    }    
    
    @Override
    public void start() {
        setLimH(20,Params.WINDOW_WIDTH-20);
        setLimV(Params.WINDOW_HEIGHT-100,Params.WINDOW_HEIGHT);
    }
    
    @Override
    public void Update() {
        setPosX(getX() + getDirH() * getSpeed());        
    }
    
    @Override
    public void OnInput(KeyCode keyCode, boolean isPressed) {
        if (keyCode == KeyCode.LEFT){
            int dh = isPressed ? -5: 0;
            if(this.getX() < 0) {this.setPosX(0);}
            setDirH(dh);
        }
        if (keyCode == KeyCode.RIGHT){
            int dh = isPressed ? 5 : 0;
            if(this.getX() > 767+16) {this.setPosX(770);}
            setDirH(dh);
        }
        if (keyCode == KeyCode.SPACE && Game.getInstance().lista().contains(this)){
            Game.getInstance().addChar(new Shot(getX()+12,getY()-26));
        }
        
    }
    //2C2C54 EC6A32
    @Override
    public void Draw(GraphicsContext graphicsContext) {
        graphicsContext.setFill(Paint.valueOf("#F8ED77"));
        graphicsContext.fillRect(getX(), getY()+16, 32, 32);
        graphicsContext.fillRect(getX()+8, getY()-16, 16, 48);        
    }   
}
