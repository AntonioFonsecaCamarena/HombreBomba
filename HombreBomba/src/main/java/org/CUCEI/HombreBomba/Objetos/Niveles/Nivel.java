package org.CUCEI.HombreBomba.Objetos.Niveles;

import java.util.ArrayList;

import org.CUCEI.HombreBomba.Objetos.ObjetoDelJuego;

public abstract class Nivel {
	final int MURO = 1;
	final int JUGADOR = 2;
	final int ENEMIGOFACIL = 3;
	final int ENEMIGODINORMAL = 4;
	final int ENEMIGODIFICIL = 5;
	final int META = 6;

	public abstract void crearMapa(ArrayList<ObjetoDelJuego> listaObjetos);

}
