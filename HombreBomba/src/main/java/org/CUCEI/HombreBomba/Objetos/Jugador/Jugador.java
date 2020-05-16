package org.CUCEI.HombreBomba.Objetos.Jugador;

import java.awt.event.KeyEvent;

import org.CUCEI.HombreBomba.ContenedorDelJuego;
import org.CUCEI.HombreBomba.Objetos.ObjetoDelJuego;

import com.majoolwip.engine.Renderer;

public class Jugador extends ObjetoDelJuego {
	
	//Porpiedades del Jugador
	private float VELOCIDAD = 0.5f;

	public Jugador(float posicionX, float posicionY) {
		this.setNombre("Jugador");
		// TODO lo del 16
		this.setPosicionX(posicionX * 16);
		this.setPosicionY(posicionY * 16);
		this.setAltura(16);
		this.setAnchura(16);
	}

	@Override
	public void update(ContenedorDelJuego juego,  float dt) {
		if (juego.getInput().isKeyDown(KeyEvent.VK_W)) {
			setPosicionY(getPosicionY()-VELOCIDAD);
		}
		if (juego.getInput().isKeyDown(KeyEvent.VK_S)) {
			setPosicionY(getPosicionY()+VELOCIDAD);
		}
		if (juego.getInput().isKeyDown(KeyEvent.VK_A)) {
			setPosicionX(getPosicionX()-VELOCIDAD);
		}
		if (juego.getInput().isKeyDown(KeyEvent.VK_D)) {
			setPosicionX(getPosicionX()+VELOCIDAD);
		}
	}

	@Override
	public void render(ContenedorDelJuego juego, Renderer r) {
		// TODO Auto-generated method stub
		r.draw2DRect((int) getPosicionX(), (int) getPosicionY(), getAltura(), getAnchura(), 0xFF00FF00);
	}

}
