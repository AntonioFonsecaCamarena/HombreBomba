package org.CUCEI.HombreBomba;

import org.CUCEI.HombreBomba.Estados.EstadoBeta;

import com.majoolwip.engine.Game;
import com.majoolwip.engine.Input;

import lombok.Getter;
import lombok.Setter;

public class ContenedorDelJuego extends Game {

	@Getter @Setter private Input input;

	@Override
	public void init(Input input) {
		// Inicializacion de la prueba beta
		this.setState(new EstadoBeta(this));
		this.input = input;
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
	}

}