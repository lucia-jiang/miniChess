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
public class Alfil extends PiezaAjedrez {

	/**
	 * Crea un Alfil pertenenciente a jugador en la posición (x,y) del tablero
	 * 
	 * @param jugador El jugador al que pertenece la pieza
	 * @param fila    Fila que ocupa
	 * @param columna Columna que ocupa
	 */
	public Alfil(Jugador jugador, int fila, char columna) {
		super(jugador, TipoPiezaAjedrez.ALFIL, fila, columna);
	}

	/**
	 * El alfil se mueve sobre el tablero en una línea recta diagonal tantas
	 * casillas como quiera hasta que se encuentre con el final del tablero o con
	 * otra pieza. El alfil no puede saltar sobre otras piezas. Captura del mismo
	 * modo que se desplaza, colocándose en la casilla de la pieza oponente.
	 * 
	 * @return Retorna todas las casillas permitidos para esta pieza en la situación
	 *         actual del tablero.
	 */
	@Override
	public IList<Casilla> movimientosValidos() {
		IList<Casilla> resultado = new ArrayList<>();

		// Diagonal abajo derecha
		casillasVisitables(resultado, 1, 1);
		// Diagonal arriba izquierda
		casillasVisitables(resultado, -1, -1);
		// Diagonal abajo izquierda
		casillasVisitables(resultado, 1, -1);
		// Diagonal arriba derecha
		casillasVisitables(resultado, -1, 1);
		
		return resultado;
	}

}
