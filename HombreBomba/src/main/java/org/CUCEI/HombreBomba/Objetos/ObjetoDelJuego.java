package org.CUCEI.HombreBomba.Objetos;

import org.CUCEI.HombreBomba.ContenedorDelJuego;

import com.majoolwip.engine.Renderer;

import lombok.Getter;
import lombok.Setter;

/**
 * Clase Abstracta que define las propiedades que deben de tener todos los
 * elementos en el juego.
 * 
 * @author Jose Antonio Fonseca
 *
 */

public abstract class ObjetoDelJuego {

	/**
	 * Nombre con el que identificaremos el objeto del juego.
	 */
	@Getter
	@Setter
	private String Nombre;
	/**
	 * La coordenada X donde posicionaremos el objeto.
	 */
	@Getter
	@Setter
	private float posicionX, posicionY;

	/**
	 * Determinamos la altura y anchura del objeto.
	 */
	@Getter
	@Setter
	private int altura, anchura;
	/**
	 * Stado para considerarlo en el juego, si este se encuentra el false el
	 * elemento sera descartado.
	 */
	@Getter
	@Setter
	private boolean activo = true;

	public abstract void update(ContenedorDelJuego juego, float dt);

	public abstract void render(ContenedorDelJuego juego, Renderer r);
}
