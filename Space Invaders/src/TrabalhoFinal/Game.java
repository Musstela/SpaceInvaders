package TrabalhoFinal;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
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
    
    public int numAlien() {
    	int numero = 0;
    		
    	for(Character an:activeChars){
    		if(an instanceof AlienNormal) {numero++;}
    		}
    	
    	return numero;
    }

	public void Start() {
        // Repositório de personagens
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
