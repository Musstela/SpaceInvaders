package TrabalhoFinal;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;

import java.util.List;
import java.util.LinkedList;

/**
 * Handles the game lifecycle and behavior
 * @author Bernardo Copstein and Rafael Copstein
 */
public class Game {
    private static Game game = null;
    private List<Character> activeChars;
    private Canhao canhao;
        
    private boolean gameOver;
    private int vida = 2;
    private int score = 0;
    
    private Game(){
    }
    
    public static Game getInstance(){
        if (game == null){
            game = new Game();
        }
        return(game);
    }
    
    public void estrela(GraphicsContext gc) {
    	for(int i =0; i< 4; i++) {
    		for(int j=0;j<6;j++) {
	    	gc.fillRect((200*i)+100, 140*j, 4, 4);
	    	gc.setFill(Color.WHITE);
    		}
    	}
    }
    
    public void draw(GraphicsContext gc) {
    	gc.setFill(Color.grayRgb(20));
    	gc.fillRect(0, 0, 800, 600);
    }
    
    
    public void score(GraphicsContext gc) {
    	if(gameOver==false) {
    	gc.setTextAlign(TextAlignment.CENTER);
    	gc.setFont(Font.font(20));
    	gc.setFill(Color.WHITE);
    	gc.fillText("Score: "+score, 60, 20);
    	}
    }
    
    public void vida(GraphicsContext gc) {
    	if(gameOver == false) {
    	gc.setTextAlign(TextAlignment.CENTER);
    	gc.setFont(Font.font(20));
    	gc.setFill(Color.WHITE);
    	gc.fillText("Vidas restantes: "+(vida+1), 700, 20);
    	}
	}
    
    public List<Character> lista(){
    	return this.activeChars;
    }
    
    public void aumentaScore() {
    	score++;
    }
    
    public boolean getGameOver() {
    	return gameOver;
    }
    
    public void addChar(Character c){
        activeChars.add(c);
        c.start();
    }
    
    public void eliminate(Character c){
        activeChars.remove(c);
    }   
    
    public void updateVida() {
    	if(vida <= 2 && vida > 0) {
    		vida--;
    	}
    	else{
    		gameOver();
    	}
    }
    
    public void gameOver() {
    	activeChars.remove(canhao);
		gameOver = true;
    }
    
    public void creditos(GraphicsContext gc) {
		
    	gc.setTextAlign(TextAlignment.CENTER);
    	gc.setFont(Font.font(40));
    	gc.setFill(Color.YELLOW);
    	gc.fillText("Game Over \n Sua pontuação foi de " + score + " pontos", 400, 250);
		
	}
    
    public int numAlien() {
    	int numero = 0;
    		
    	for(Character an:activeChars){
    		if(an instanceof AlienNormal) {numero++;}
    		}
    	
    	return numero;
    }

	public void Start() {
        // RepositÃ³rio de personagens
        activeChars = new LinkedList();
        
        // Adiciona o canhao
        canhao = new Canhao(400,550);
        activeChars.add(canhao);
        
        for(int i=0;i<5;i++) {
        activeChars.add(new AlienNormal(100+(i*120),0));
        }
        
        for(Character c:activeChars){
            c.start();
        }
    }
    
    public void Update(long currentTime, long deltaTime) {
        for(int i=0;i<activeChars.size();i++){
            Character este = activeChars.get(i);
            este.Update();
            for(int j =0; j<activeChars.size();j++){
                Character outro = activeChars.get(j);
                if (este != outro && outro instanceof Shot){
                	//if(outro instanceof Canhao) {vida jogo termina}
                    este.testaColisao(outro);
                    
                }
            }
        }
    }
    
    public void OnInput(KeyCode keyCode, boolean isPressed) {
        canhao.OnInput(keyCode, isPressed);
    }
    
    public void Draw(GraphicsContext graphicsContext) {
        for(Character c:activeChars){
            c.Draw(graphicsContext);
        }
    }

	public int getScore() {
		
		return score;
	}
	
}
