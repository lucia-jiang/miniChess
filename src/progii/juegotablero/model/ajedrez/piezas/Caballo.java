/**
 * 
 */
package progii.juegotablero.model.ajedrez.piezas;

import anotacion.Programacion2;
import list.ArrayList;
import list.IList;
import progii.juegotablero.model.Casilla;
import progii.juegotablero.model.Jugador;
import progii.juegotablero.model.ajedrez.PiezaAjedrez;
import progii.juegotablero.model.ajedrez.TipoPiezaAjedrez;

/**
 * @author lucia
 *
 */
public class Caballo extends PiezaAjedrez {

	/**
	 * Crea un Caballo pertenenciente a jugador en la posición (x,y) del tablero
	 * 
	 * @param jugador El jugador al que pertenece la pieza
	 * @param fila    Fila que ocupa
	 * @param columna Columna que ocupa
	 */
	public Caballo(Jugador jugador, int fila, char columna) {
		super(jugador, TipoPiezaAjedrez.CABALLO, fila, columna);
	}

	/**
	 * Única pieza capaz de saltar a otras piezas, se mueve dos casillas en
	 * dirección horizontal o vertical y después una casilla más en ángulo recto. El
	 * movimiento del caballo tiene la forma de una “L”.
	 * 
	 * @return Retorna todas las casillas permitidos para esta pieza en la situación
	 *         actual del tablero.
	 */
	@Override
	public IList<Casilla> movimientosValidos() {
		IList<Casilla> resultado = new ArrayList<>();
		
		// Dos casillas abajo y una a la derecha
		casillasVisitables(resultado, 2, 1);
		// Dos casillas arriba y una a la derecha
		casillasVisitables(resultado, -2, 1);
		// Dos casillas abajo y una a la izquierda
		casillasVisitables(resultado, 2, -1);
		// Dos casillas arriba y una a la izquierda
		casillasVisitables(resultado, -2, -1);
		// Una casilla abajo y dos a la derecha
		casillasVisitables(resultado, 1, 2);
		// Una casilla arriba y dos a la derecha
		casillasVisitables(resultado, -1, 2);
		// Una casilla abajo y dos a la izquierda
		casillasVisitables(resultado, 1, -2);
		// Una casilla arriba y dos a la izquierda
		casillasVisitables(resultado, -1, -2);
		
		return resultado;
	}

}
