package TrabalhoFinal;

import java.util.Random;

public class Params{
	
	/**
	 * Arthur_Maia_20108454_Luiz_Felipe_Oliveira_20103391-7_Felipe_Fonseca_Fagundes_20108219-5
	 */
	
    public static final String WINDOW_TITLE = "SpaceInvaders dos guri";
    public static final int WINDOW_WIDTH = 800;
    public static final int WINDOW_HEIGHT = 600;
    
    private static Params params = null;
    private Random rnd;
    
    private Params(){
        rnd = new Random();
    }
    
    public static Params getInstance(){
        if (params == null){
            params = new Params();
        }
        return(params);
    }
    
    public int nextInt(int lim){
        return(rnd.nextInt(lim));
    }
}

