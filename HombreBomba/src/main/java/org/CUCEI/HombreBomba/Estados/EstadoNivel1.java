package org.CUCEI.HombreBomba.Estados;

import java.util.ArrayList;

import org.CUCEI.HombreBomba.ContenedorDelJuego;
import org.CUCEI.HombreBomba.Objetos.ObjetoDelJuego;
import org.CUCEI.HombreBomba.Objetos.Enemigos.EnemigoBasico;
import org.CUCEI.HombreBomba.Objetos.Jugador.Jugador;
import org.CUCEI.HombreBomba.Objetos.Niveles.Nivel1;

import com.majoolwip.engine.Renderer;
import com.majoolwip.engine.util.State;

import lombok.Getter;

public class EstadoNivel1 extends State {
	/**
	 * Es la lista de objetos que interactuaran en el render.
	 */
	@Getter
	private ArrayList<ObjetoDelJuego> listaObjetos = new ArrayList<ObjetoDelJuego>();
	private ContenedorDelJuego juego;
	private Jugador jugador;

	public EstadoNivel1(ContenedorDelJuego juego) {
		this.juego = juego;
		// Añadimos mapa
		new Nivel1().crearMapa(listaObjetos);
	}

	@Override
	public void update(float dt) {

		for (int i = 0; i < listaObjetos.size(); i++) {
			listaObjetos.get(i).update(juego, dt);
			// Validamos si el jugador esta en contacto con otro objeto.
			if (listaObjetos.get(i).getNombre().equals("Jugador")) {
				jugador = (Jugador) listaObjetos.get(i);
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
					// Validamos contacto con la meta
					if (objeto.getNombre().equals("Meta") && jugador.estaTocando(objeto)) {
						System.out.println("Ganaste!");
						juego.setState(new EstadoNivel2(juego));
					}

					// Validamos contacto con enemigos
					if (objeto.getNombre().equals("Enemigo") && jugador.estaTocando(objeto)) {
						System.out.println("Perdiste!");
						juego.setState(new EstadoNivel1(juego));
					}

				}
			}

			// Comportamiento de los Enemigos
			if (listaObjetos.get(i).getNombre().equals("Enemigo")) {
				EnemigoBasico enemigo = (EnemigoBasico) listaObjetos.get(i);
				enemigo.seguirJugador(jugador);
				for (ObjetoDelJuego objeto : listaObjetos) {
					if (objeto.isSolido()) {
						if (enemigo.colisionaArriba(objeto))
							enemigo.setPosicionY(enemigo.getPosicionY() + enemigo.getNivel() + 2f);
						if (enemigo.colisionaAbajo(objeto))
							enemigo.setPosicionY(enemigo.getPosicionY() - enemigo.getNivel() - 2f);
						if (enemigo.colisionaIzquierda(objeto))
							enemigo.setPosicionX(enemigo.getPosicionX() + enemigo.getNivel() + 2f);
						if (enemigo.colisionaDerecha(objeto))
							enemigo.setPosicionX(enemigo.getPosicionX() - enemigo.getNivel() - 2f);

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
