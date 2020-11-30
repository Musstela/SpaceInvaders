package TrabalhoFinal;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Paint;

/**
 * Arthur_Maia_20108454_Luiz_Felipe_Oliveira_20103391-7_Felipe_Fonseca_Fagundes_20108219-5
 */
public interface Character {
    int getX();
    int getY();
    int getAltura();
    int getLargura();
    
    boolean testaColisao(Character c);
    boolean jaColidiu();
    void setColidiu();
    
    void start();
    boolean isActive();
    void Update();
    void Draw(GraphicsContext graphicsContext);
}
