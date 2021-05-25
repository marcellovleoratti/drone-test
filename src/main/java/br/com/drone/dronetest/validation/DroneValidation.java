package br.com.drone.dronetest.validation;

import java.util.regex.Pattern;

/**
* Classe resposável por gerenciar validações no processo do Drone
*
* @author Ederson Patricio
*
*/
public class DroneValidation {

	/**
	 * Valida todas as possibilidades de entrada
	 *
	 * @param String
	 *            str
	 */
	public static boolean valorInvalido( String str ) {
    	return naoContemValor( str ) 
    			|| naoContemDirecao( str )
    			|| iniciaComNumero( str )
    			|| contemCaractereInvalido( str ) 
    			|| contemXAcompanhadoDeNumero( str );
    }
	
	private static boolean contemValor( Object value ) {
		return value != null && !( (String) value ).trim().equals( "" ) ? true : false;
	}
    
    private static boolean naoContemValor( Object value ) {
		return !contemValor( value );
	}
    
    /**
	 * Valida se na string de entrada não contém algum dos
	 * valores válidos para direção: N, S, L, O
	 *
	 * @param String
	 *            str
	 */
    private static boolean naoContemDirecao( String str ) {
		return !verificaExpressao( "[NSLO]", str );
    }
    
    /**
	 * Valida se na string de entrada inicia com valor numérico
	 *
	 * @param String
	 *            str
	 */
    private static boolean iniciaComNumero( String str ) {
		return verificaExpressao( "^\\d+", str );
    }
    
    /**
	 * Valida se na string de entrada existe algum caractere
	 * diferente dos esperados: N, S, L, O, X, Números
	 *
	 * @param String
	 *            str
	 */
    private static boolean contemCaractereInvalido( String str ) {
		return verificaExpressao( "[^NSLOX0-9]", str );
    }
    
    /**
	 * Valida se na string de entrada X acompanhado de número
	 *
	 * @param String
	 *            str
	 */
    private static boolean contemXAcompanhadoDeNumero( String str ) {
		return verificaExpressao( "X\\d+", str );
    }
    
    private static boolean verificaExpressao( String pattern, String value ) {
		return Pattern.compile( pattern ).matcher( value ).find();
    }
}
