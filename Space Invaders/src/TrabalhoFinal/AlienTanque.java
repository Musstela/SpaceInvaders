package TrabalhoFinal;

public class AlienTanque extends AlienNormal{

	private int vida = 100; 
	
	public AlienTanque(int px, int py) {
		super(px, py);
		// TODO Auto-generated constructor stub
	}

	
	@Override
    public void Update(){
        if (jaColidiu()){this.vida--;}
    	
        if(vida == 0) {deactivate();}
        
    	else{
            setPosY(getY() + getDirV() * getSpeed());
            // Se chegou no lado direito da tela ...
            if (getY() >= getLMaxV()){
                // Reposiciona no lado esquerdo e ...
                setPosY(getLMinV()-100);
                setPosX(ranAli.nextInt(800-50) + 32);
                // Sorteia o passo de avanço [1,5]
                setSpeed(Params.getInstance().nextInt(4)+2);
            }
        }
    }    
}
