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
public class Reina extends PiezaAjedrez {

	/**
	 * Crea una Reina pertenenciente a jugador en la posición (x,y) del tablero
	 * 
	 * @param jugador El jugador al que pertenece la pieza
	 * @param fila    Fila que ocupa
	 * @param columna Columna que ocupa
	 */
	public Reina(Jugador jugador, int fila, char columna) {
		super(jugador, TipoPiezaAjedrez.REINA, fila, columna);
	}

	/**
	 * Se puede mover cualquier número de casillas en línea recta, tanto de manera
	 * horizontal como vertical o diagonal.
	 * 
	 * @return Retorna todas las casillas permitidos para esta pieza en la situación
	 *         actual del tablero.
	 */
	@Override
	public IList<Casilla> movimientosValidos() {
		IList<Casilla> resultado = new ArrayList<>();
		
		// Una casilla en dirección vertical descendente
		casillasVisitables(resultado, 1, 0);
		// Una casilla en dirección vertical ascendente
		casillasVisitables(resultado, -1, 0);
		// Una casilla en dirección horizontal a la izquierda
		casillasVisitables(resultado, 0, -1);
		// Una casilla en dirección horizontal a la derecha
		casillasVisitables(resultado, 0, 1);
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
