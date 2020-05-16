package org.CUCEI.HombreBomba.Estados;

import java.util.ArrayList;

import org.CUCEI.HombreBomba.ContenedorDelJuego;
import org.CUCEI.HombreBomba.Objetos.ObjetoDelJuego;
import org.CUCEI.HombreBomba.Objetos.Jugador.Jugador;

import com.majoolwip.engine.Renderer;
import com.majoolwip.engine.util.State;

public class EstadoBeta extends State {
	/**
	 * Es la lista de objetos que interactuaran en el render.
	 */
	private ArrayList<ObjetoDelJuego> listaObjetos = new ArrayList<ObjetoDelJuego>();
	private ContenedorDelJuego juego;

	public EstadoBeta(ContenedorDelJuego juego) {
		this.juego = juego;

		//Añadimos al jugador
		listaObjetos.add(new Jugador(15, 10));
	}

	@Override
	public void update(float dt) {
		for (int i = 0; i < listaObjetos.size(); i++) {
			listaObjetos.get(i).update(juego, dt);
			// Validamos si el objeto esta activo, de no ser el caso lo eliminamos de la
			// lista activa de objetos.
			if (!listaObjetos.get(i).isActivo()) {
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
