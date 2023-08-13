/**
 * 
 */
package progii.juegotablero.model.ajedrez.piezas;

import anotacion.Programacion2;
import list.ArrayList;
import list.IList;
import progii.juegotablero.model.Casilla;
import progii.juegotablero.model.Jugador;
import progii.juegotablero.model.ajedrez.ControlJugadoresAjedrez;
import progii.juegotablero.model.ajedrez.PiezaAjedrez;
import progii.juegotablero.model.ajedrez.TipoPiezaAjedrez;

/**
 * @author lucia
 *
 */
public class Peon extends PiezaAjedrez {

	/**
	 * Crea un Peón pertenenciente a jugador en la posición (x,y) del tablero
	 * 
	 * @param jugador El jugador al que pertenece la pieza
	 * @param fila    Fila que ocupa
	 * @param columna Columna que ocupa
	 */
	public Peon(Jugador jugador, int fila, char columna) {
		super(jugador, TipoPiezaAjedrez.PEON, fila, columna);
	}

	/**
	 * Normalmente, el peón solo se mueve hacia delante, una casilla cada vez, a
	 * excepción de que la primera vez que se mueve un peón se puede mover dos
	 * casillas hacia delante. El peón no puede saltar sobre otras piezas y
	 * cualquier pieza que esté justo delante de un peón bloquea su avance a esa
	 * casilla. El peón es la única pieza que no captura de la misma manera que se
	 * mueve, sino que lo hace en diagonal. No puede capturar moviéndose hacia
	 * delante.
	 * 
	 * @return Retorna todas las casillas permitidos para esta pieza en la situación
	 *         actual del tablero.
	 */
	@Override
	public IList<Casilla> movimientosValidos() {
		IList<Casilla> resultado = new ArrayList<>();

		boolean negro = this.getJugador().getId() == ControlJugadoresAjedrez.NEGRO;
		int dependeColor = -1;
		int filaOriginal = 6;
		if (negro) {
			dependeColor = 1;
			filaOriginal = 1;
		}

		// Desplazamiento de los peones, tanto para cuando está en la posición inicial no
		if (super.queHay(getFila() + dependeColor, getColumna()) == null) {
			// Si la ficha es negra se desplaza una posición en dirección vertical
			// descendente en el sentido de la matriz y si es blanca en sentido ascendente
			casillasVisitables(resultado, dependeColor, 0);
			if (super.getFila() == filaOriginal && super.queHay(getFila() + (2 * dependeColor), getColumna()) == null) {
				// Dos posiciones, en sentido ascendente o descendente según el color
				casillasVisitables(resultado, (2 * dependeColor), 0);
			}
		}

		// Capturar (en diagonal)
		if (super.queHay(getFila() + dependeColor, getColumna() + 1) != null) {
			casillasVisitables(resultado, dependeColor, 1);
		}
		if (super.queHay(getFila() + dependeColor, getColumna() - 1) != null) {
			casillasVisitables(resultado, dependeColor, -1);
		}

		return resultado;
	}

}
