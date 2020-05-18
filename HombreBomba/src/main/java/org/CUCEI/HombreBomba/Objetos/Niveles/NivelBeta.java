package org.CUCEI.HombreBomba.Objetos.Niveles;

import java.util.ArrayList;

import org.CUCEI.HombreBomba.Objetos.ObjetoDelJuego;
import org.CUCEI.HombreBomba.Objetos.Mapa.Muro;

public class NivelBeta extends Nivel {
//
	int[][] mapa = { 
			{ 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20 },
			{ 1, 0, 0, 0, 0, 0, 0, 0, 0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 20 },
			{ 1, 0, 0, 0, 0, 0, 0, 0, 0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 20 },
			{ 1, 0, 0, 0, 0, 0, 0, 0, 0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 20 },
			{ 1, 0, 0, 0, 0, 1, 1, 1, 1,  1,  0,  1,  1,  1,  1,  0,  0,  0,  0, 20 },
			{ 1, 0, 0, 0, 0, 1, 0, 0, 0,  0,  0,  0,  0,  0,  1,  0,  0,  0,  0, 20 },
			{ 1, 0, 0, 0, 0, 1, 0, 0, 0,  0,  0,  0,  0,  0,  1,  0,  0,  0,  0, 20 },
			{ 1, 0, 0, 0, 0, 1, 0, 0, 0,  0,  0,  0,  0,  0,  1,  0,  0,  0,  0, 20 },
			{ 1, 0, 0, 0, 0, 1, 0, 0, 0,  0,  0,  0,  0,  0,  1,  0,  0,  0,  0, 20 },
			{ 1, 0, 0, 0, 0, 1, 0, 0, 0,  0,  0,  0,  0,  0,  1,  0,  0,  0,  0, 20 },
			{ 1, 0, 0, 0, 0, 1, 1, 1, 1,  0,  0,  1,  1,  1,  1,  0,  0,  0,  0, 20 },
			{ 1, 0, 0, 0, 0, 0, 0, 0, 0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 20 },
			{ 1, 0, 0, 0, 0, 0, 0, 0, 0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 20 },
			{ 1, 0, 0, 0, 0, 0, 0, 0, 0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 20 },
			{ 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20 } };
//
//	int[][] mapa = {
//			{ 0, 0, 0, 0, 0, 0, 0, 0, 0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 0 },
//			{ 0, 0, 0, 0, 0, 0, 0, 0, 0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 0 },
//			{ 0, 0, 0, 0, 0, 0, 0, 0, 0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 0 },
//			{ 0, 0, 0, 0, 0, 0, 0, 0, 0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 0 },
//			{ 0, 0, 0, 0, 0, 0, 0, 0, 1,  1,  1,  1,  0,  0,  0,  0,  0,  0,  0, 0 },
//			{ 0, 0, 0, 0, 0, 0, 0, 0, 0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 0 },
//			{ 0, 0, 0, 0, 0, 0, 0, 0, 0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 0 },
//			{ 0, 0, 0, 0, 0, 0, 0, 0, 0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 0 },
//			{ 0, 0, 0, 0, 0, 0, 0, 0, 0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 0 },
//			{ 0, 0, 0, 0, 0, 0, 0, 0, 0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 0 },
//			{ 0, 0, 0, 0, 0, 0, 0, 0, 0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 0 },
//			{ 0, 0, 0, 0, 0, 0, 0, 0, 0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 0 },
//			{ 0, 0, 0, 0, 0, 0, 0, 0, 0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 0 },
//			{ 0, 0, 0, 0, 0, 0, 0, 0, 0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 0 },
//			{ 0, 0, 0, 0, 0, 0, 0, 0, 0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 0 }
//
//	};

	
	
	@Override
	public void crearMapa(ArrayList<ObjetoDelJuego> listaObjetos) {
		for (int x = 0; x < 20; x++) {
			for (int y = 0; y < 15; y++) {
				if (mapa[y][x] > 0)
					listaObjetos.add(new Muro(x, y));
			}
		}
	}

}
