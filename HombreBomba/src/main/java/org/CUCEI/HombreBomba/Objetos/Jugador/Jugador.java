package org.CUCEI.HombreBomba.Objetos.Jugador;

import java.awt.event.KeyEvent;

import org.CUCEI.HombreBomba.ContenedorDelJuego;
import org.CUCEI.HombreBomba.Objetos.ObjetoDelJuego;

import com.majoolwip.engine.Renderer;

public class Jugador extends ObjetoDelJuego {

	// Porpiedades del Jugador

	public Jugador(float posicionX, float posicionY) {
		this.setNombre("Jugador");
		this.setPosicionX(posicionX * this.getTamanoTiles() + 8);
		this.setPosicionY(posicionY * this.getTamanoTiles() + 8);
		this.setAltura(this.getTamanoTiles() / 2);
		this.setAnchura(this.getTamanoTiles() / 2);
	}

	@Override
	public void update(ContenedorDelJuego juego, float dt) {
		if (juego.getInput().isKeyDown(KeyEvent.VK_W)) {
			setPosicionY(getPosicionY() - this.getVelocidad());
		}
		if (juego.getInput().isKeyDown(KeyEvent.VK_S)) {
			setPosicionY(getPosicionY() + this.getVelocidad());
		}
		if (juego.getInput().isKeyDown(KeyEvent.VK_A)) {
			setPosicionX(getPosicionX() - this.getVelocidad());
		}
		if (juego.getInput().isKeyDown(KeyEvent.VK_D)) {
			setPosicionX(getPosicionX() + this.getVelocidad());
		}
	}

	@Override
	public void render(ContenedorDelJuego juego, Renderer r) {
		r.draw2DRect((int) getPosicionX(), (int) getPosicionY(), getAltura(), getAnchura(), 0xFF00FF00);
	}

}
