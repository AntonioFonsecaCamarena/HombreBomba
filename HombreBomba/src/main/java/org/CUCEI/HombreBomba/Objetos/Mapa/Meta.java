package org.CUCEI.HombreBomba.Objetos.Mapa;

import org.CUCEI.HombreBomba.ContenedorDelJuego;
import org.CUCEI.HombreBomba.Objetos.ObjetoDelJuego;

import com.majoolwip.engine.Renderer;

public class Meta extends ObjetoDelJuego {

	public Meta(float posicionX, float posicionY) {
		this.setNombre("Meta");
		this.setSolido(false);
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
		r.draw2DFillRect((int) getPosicionX(), (int) getPosicionY(), getAltura(), getAnchura(), 0xFFF0FFFF);
	}

}
