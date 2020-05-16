package org.CUCEI.HombreBomba;

import com.majoolwip.engine.Game;
import com.majoolwip.engine.Pix;
import com.majoolwip.engine.Renderer;
import com.majoolwip.engine.util.PixSettings;
import com.majoolwip.engine.util.State;

/**
 * Hello world!
 *
 */
public class App extends Game
{ 	
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
    	Pix pix = new Pix(new App(), new PixSettings());
		pix.start();
        
        
    }

	@Override
	public void init() {
		// TODO Auto-generated method stub
		this.setState(new State() {
			
			@Override
			public void update(float dt) {
				// TODO Auto-generated method stub
				System.out.println("llueve");
			}
			
			@Override
			public void render(Renderer r) {
				// TODO Auto-generated method stub
				
			}
		});
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		System.out.println("disj");
	}
}
