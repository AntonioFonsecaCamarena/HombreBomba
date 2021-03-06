package org.CUCEI.HombreBomba.Estados;

import java.util.ArrayList;

import org.CUCEI.HombreBomba.ContenedorDelJuego;
import org.CUCEI.HombreBomba.Objetos.ObjetoDelJuego;
import org.CUCEI.HombreBomba.Objetos.Enemigos.EnemigoBasico;
import org.CUCEI.HombreBomba.Objetos.Jugador.Jugador;
import org.CUCEI.HombreBomba.Objetos.Niveles.NivelBeta;

import com.majoolwip.engine.Renderer;
import com.majoolwip.engine.util.State;

import lombok.Getter;

public class EstadoBeta extends State {
	/**
	 * Es la lista de objetos que interactuaran en el render.
	 */
	@Getter
	private ArrayList<ObjetoDelJuego> listaObjetos = new ArrayList<ObjetoDelJuego>();
	private ContenedorDelJuego juego;
	private Jugador jugador;

	public EstadoBeta(ContenedorDelJuego juego) {
		this.juego = juego;
		// Añadimos al jugador
		jugador = new Jugador(10, 7);
		listaObjetos.add(jugador);

		// Añadimos mapa
		new NivelBeta().crearMapa(listaObjetos);

		// Añadimos Enemigos
		listaObjetos.add(new EnemigoBasico(10, 2, 1));
		listaObjetos.add(new EnemigoBasico(0, 2, 5));
		listaObjetos.add(new EnemigoBasico(15, 14, 2));
		listaObjetos.add(new EnemigoBasico(11, 14, 3));
	}

	@Override
	public void update(float dt) {

		for (int i = 0; i < listaObjetos.size(); i++) {
			listaObjetos.get(i).update(juego, dt);
			// Validamos si el jugador esta en contacto con otro objeto.
			if (listaObjetos.get(i).getNombre().equals("Jugador")) {
				for (ObjetoDelJuego objeto : listaObjetos) {
					if (!objeto.getNombre().equals("Jugador") && objeto.isSolido()) {
						if (jugador.colisionaArriba(objeto))
							jugador.setPosicionY(jugador.getPosicionY() + jugador.getVelocidad() + 1f);
						if (jugador.colisionaAbajo(objeto))
							jugador.setPosicionY(jugador.getPosicionY() - jugador.getVelocidad() - 1f);
						if (jugador.colisionaIzquierda(objeto))
							jugador.setPosicionX(jugador.getPosicionX() + jugador.getVelocidad() + 1f);
						if (jugador.colisionaDerecha(objeto))
							jugador.setPosicionX(jugador.getPosicionX() - jugador.getVelocidad() - 1f);

					}

				}
			}

			// Comportamiento de los Enemigos
			if (listaObjetos.get(i).getNombre().equals("Enemigo")) {
				EnemigoBasico enemigo = (EnemigoBasico) listaObjetos.get(i);

				for (ObjetoDelJuego objeto : listaObjetos) {
					if (!objeto.getNombre().equals("Enemigo") && objeto.isSolido()) {
						if (enemigo.colisionaArriba(objeto))
							enemigo.setPosicionY(enemigo.getPosicionY() + enemigo.getVelocidad() + 1f);
						if (enemigo.colisionaAbajo(objeto))
							enemigo.setPosicionY(enemigo.getPosicionY() - enemigo.getVelocidad() - 1f);
						if (enemigo.colisionaIzquierda(objeto))
							enemigo.setPosicionX(enemigo.getPosicionX() + enemigo.getVelocidad() + 1f);
						if (enemigo.colisionaDerecha(objeto))
							enemigo.setPosicionX(enemigo.getPosicionX() - enemigo.getVelocidad() - 1f);

					}

				}
				enemigo.seguirJugador(jugador);
			}
			// Validamos si el objeto esta activo, de no ser el caso lo eliminamos de la
			// lista activa de objetos.
			if (!listaObjetos.get(i).isActivo())

			{
				listaObjetos.remove(i);
				i--;
			}

		}

	}

	@Override
	public void render(Renderer r) {
		for (ObjetoDelJuego objeto : listaObjetos) {
			objeto.render(juego, r);
		}
	}

}
