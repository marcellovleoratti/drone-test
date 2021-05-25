package br.com.drone.dronetest;

import br.com.drone.dronetest.enums.Cardinal;
import br.com.drone.dronetest.validation.DroneValidation;

public  class Drone {
	
	public final Integer MOVIMENTO = 1;
	
	public final String RETORNO_PADRAO = "(999, 999)";
	
	private static int matriz[] = new int[2];

	public String changePosition( String str ) {
		iniciarMatriz();
		
		if ( DroneValidation.valorInvalido( str ) ) {
			return RETORNO_PADRAO;
		}
		
		if ( str.contains( "X" ) ) {
			str = retificarStringInicial( str );
		}
    	
    	return calcularPosicao( str );
    }
	
	/**
	 * Método para calcular posição final
	 *
	 * @param String
	 *            str
	 */
	private String calcularPosicao( String str ) {
		char caractereAtual;
		String numeroStr = "";
		Integer numero = null;
		
		for ( int i = 0; i < str.length(); i++ ) {
			caractereAtual = str.charAt( i );
    		
			try {
				if ( Character.isDigit( str.charAt( i + 1 ) ) ) {
	    			numeroStr = String.valueOf( str.charAt( ++i ) );
	    			
	    			try {
	    				// Faz loop até pegar todo o número
						while( Character.isDigit( str.charAt( i + 1 ) ) ) {
							numeroStr += String.valueOf( str.charAt( ++i ) );
						}
					} catch ( StringIndexOutOfBoundsException e ) {
						System.out.println( "Tentou acessar indice da String maior que seu tamanho." );
					}
	    			
	    			numero = Integer.valueOf( numeroStr );
	    			
	    			if ( numeroInvalido( numero ) ) {
	    				return RETORNO_PADRAO;
	    			}
	    			
	    			incrementarOuDecrementarValor( caractereAtual, numero );
	    		} else {
	    			incrementarOuDecrementarValor( caractereAtual, MOVIMENTO );
	    		}
			} catch ( StringIndexOutOfBoundsException e ) {
				System.out.println( "Ultimo elemento da String." );
				incrementarOuDecrementarValor( caractereAtual, MOVIMENTO );
			}
		}
		
		return String.format( "(%s, %s)", matriz[0], matriz[1] );
	}
	
	private void incrementarOuDecrementarValor( char c, int valor ) {
		Cardinal cardinal = Cardinal.valueOf( String.valueOf( c ) );
		switch ( cardinal ) {
			case N:
				matriz[1] += valor;
				break;

			case S:
				matriz[1] -= valor;
				break;

			case L:
				matriz[0] += valor;
				break;

			case O:
				matriz[0] -= valor;
				break;
		}
	}
    
	/**
	 * Método para corrigir string inicial, removendo valores que não
	 * precisariam estar ali.
	 * Ex.: NNNXLLLXX -> NNL
	 *      NLS3X -> NL
	 *
	 * @param String
	 *            str
	 */
    private String retificarStringInicial( String str ) {
    	String novaStr = "";
    	
    	char letraAnterior;
    	String letra = null;
    	int indexAtual = 0;
    	
    	for ( int i = 0; i < str.length(); i++ ) {
    		letra = String.valueOf( str.charAt( i ) );
    		
    		if ( !letra.equals( "X" ) ) {
    			novaStr = novaStr.concat( letra );
    		} else {
    			indexAtual = i;
    			letraAnterior = str.charAt( i - 1 );
    			
    			if ( Character.isDigit( letraAnterior ) ) {
    				// Faz loop até pegar todo o número anterior a X
    				while( Character.isDigit( novaStr.charAt( i - 1 ) ) ) {
    					i--;
    					novaStr = novaStr.substring( 0, novaStr.length() - 1 );
					}
    				i = indexAtual;
    			}
    			novaStr = novaStr.substring( 0, novaStr.length() - 1 );
    		}
		}
    	
		return novaStr;
	}

	private void iniciarMatriz() {
    	matriz[0] = 0;
		matriz[1] = 0;
    }
    
	// Número deve estar compreendido entre 1 e 2147483647.
    private boolean numeroInvalido( int numero ) {
		return numero <= 1 || numero >= 2147483647;
	}
}
