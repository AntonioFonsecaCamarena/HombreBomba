package org.CUCEI.HombreBomba.Objetos.Enemigos;

import org.CUCEI.HombreBomba.ContenedorDelJuego;
import org.CUCEI.HombreBomba.Objetos.ObjetoDelJuego;
import org.CUCEI.HombreBomba.Objetos.Jugador.Jugador;

import com.majoolwip.engine.Renderer;

import lombok.Getter;

public class EnemigoBasico extends ObjetoDelJuego {

	@Getter
	private float nivel;

	public EnemigoBasico(float posicionX, float posicionY, int nivel) {
		this.setNombre("Enemigo");
		this.setSolido(false);
		switch (nivel) {
		case 1:
			this.nivel = 0.5f;
			break;
		case 2:
			this.nivel = 1.0f;
			break;
		case 3:
			this.nivel = 1.5f;
			break;

		default:
			break;
		}
		this.setPosicionX(posicionX * this.getTamanoTiles() + 4);
		this.setPosicionY(posicionY * this.getTamanoTiles() + 4);
		this.setAltura(this.getTamanoTiles() / 2);
		this.setAnchura(this.getTamanoTiles() / 2);
	}

	@Override
	public void update(ContenedorDelJuego juego, float dt) {

	}

	public void seguirJugador(Jugador jugador) {
		if (jugador.getPosicionX() < getPosicionX())
			setPosicionX(getPosicionX() - nivel);
		else
			setPosicionX(getPosicionX() + nivel);
		if (jugador.getPosicionY() < getPosicionY())
			setPosicionY(getPosicionY() - nivel);
		else
			setPosicionY(getPosicionY() + nivel);
	}

	@Override
	public void render(ContenedorDelJuego juego, Renderer r) {
		r.draw2DRect((int) getPosicionX(), (int) getPosicionY(), getAltura(), getAnchura(), 0xFFFFFF00);
	}

}
