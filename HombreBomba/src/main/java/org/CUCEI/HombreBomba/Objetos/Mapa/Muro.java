package org.CUCEI.HombreBomba.Objetos.Mapa;

import org.CUCEI.HombreBomba.ContenedorDelJuego;
import org.CUCEI.HombreBomba.Objetos.ObjetoDelJuego;

import com.majoolwip.engine.Renderer;

public class Muro extends ObjetoDelJuego {

	public Muro(float posicionX, float posicionY) {
		this.setNombre("Muro-" + (int) posicionX + "-" + (int) posicionY);
		this.setSolido(true);
		// TODO lo del 16
		this.setPosicionX(posicionX * this.getTamanoTiles());
		this.setPosicionY(posicionY * this.getTamanoTiles());
		this.setAltura(this.getTamanoTiles());
		this.setAnchura(this.getTamanoTiles());
	}

	@Override
	public void update(ContenedorDelJuego juego, float dt) {

	}

	@Override
	public void render(ContenedorDelJuego juego, Renderer r) {
		// TODO Auto-generated method stub
		r.draw2DRect((int) getPosicionX(), (int) getPosicionY(), getAltura(), getAnchura(), 0xFFFF0000);
	}

}
