package org.CUCEI.HombreBomba.Objetos.Niveles;

import java.util.ArrayList;

import org.CUCEI.HombreBomba.Objetos.ObjetoDelJuego;
import org.CUCEI.HombreBomba.Objetos.Enemigos.EnemigoBasico;
import org.CUCEI.HombreBomba.Objetos.Jugador.Jugador;
import org.CUCEI.HombreBomba.Objetos.Mapa.Meta;
import org.CUCEI.HombreBomba.Objetos.Mapa.Muro;

public class Nivel1 extends Nivel {

	int[][] mapa = { 
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
			{ 1, 2, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 3, 1 },
			{ 1, 1, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 1, 1, 1 },
			{ 1, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 1 },
			{ 1, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 1 },
			{ 1, 0, 0, 1, 0, 1, 1, 1, 1, 1, 0, 0, 1, 1, 1, 0, 1, 0, 0, 1 },
			{ 1, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 1, 0, 0, 1 },
			{ 1, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 1, 1, 1, 0, 0, 1 },
			{ 1, 0, 0, 1, 1, 1, 1, 0, 0, 1, 0, 0, 1, 0, 1, 0, 0, 0, 0, 1 },
			{ 1, 0, 0, 0, 0, 0, 1, 0, 0, 1, 1, 1, 1, 0, 1, 1, 1, 1, 0, 1 },
			{ 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1 },
			{ 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1 },
			{ 1, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1 },
			{ 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 6, 1 },
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }

	};

	@Override
	public void crearMapa(ArrayList<ObjetoDelJuego> listaObjetos) {
		for (int x = 0; x < 20; x++) {
			for (int y = 0; y < 15; y++) {
				if (mapa[y][x] == MURO)
					listaObjetos.add(new Muro(x, y));
				if (mapa[y][x] == JUGADOR)
					listaObjetos.add(new Jugador(x, y));
				if (mapa[y][x] == ENEMIGOFACIL)
					listaObjetos.add(new EnemigoBasico(x, y, 1));
				if (mapa[y][x] == ENEMIGODINORMAL)
					listaObjetos.add(new EnemigoBasico(x, y, 2));
				if (mapa[y][x] == ENEMIGODIFICIL)
					listaObjetos.add(new EnemigoBasico(x, y, 3));
				if (mapa[y][x] == META)
					listaObjetos.add(new Meta(x, y));
			}
		}
	}

}
