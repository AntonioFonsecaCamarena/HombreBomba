package org.CUCEI.HombreBomba.Estados;

import java.util.ArrayList;

import org.CUCEI.HombreBomba.ContenedorDelJuego;
import org.CUCEI.HombreBomba.Objetos.ObjetoDelJuego;
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

	public EstadoBeta(ContenedorDelJuego juego) {
		this.juego = juego;
		// Añadimos al jugador
		listaObjetos.add(new Jugador(10, 7));

		// Añadimos mapa
		new NivelBeta().crearMapa(listaObjetos);
	}

	@Override
	public void update(float dt) {

		for (int i = 0; i < listaObjetos.size(); i++) {

			listaObjetos.get(i).update(juego, dt);

			// Validamos si el jugador esta en contacto con otro objeto.
			if (listaObjetos.get(i).getNombre().equals("Jugador")) {
				Jugador jugador = (Jugador) listaObjetos.get(i);
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
