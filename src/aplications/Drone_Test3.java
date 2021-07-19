package aplications;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Scanner;

public class Drone_Test3 {

	public static void main(String[] args) {
		//ENTRADA
		Scanner sc = new Scanner(System.in);
		String coordenada = sc.nextLine();
		filtrarInicial(coordenada);
		char[] listchar = divisorCaracter(coordenada);
				
		//VARIAVEIS UTEIS
		String multCoordChar = "";
		long multCoordLong = 0;
		String redutorXchar = "";
		int qtdReducao = 0;
		String charReduzindo ="";
		
		//COORDENADAS
		long norte = 0;
		long sul = 0;
		long leste = 0;
		long oeste = 0;
		long coordX = 0;
		long coordY= 0; 
		
		//CHMADAS
		System.out.println("Você digitou: " + integradorChar(listchar));
		System.out.println();
		
		leituraTipo(listchar, multCoordChar, multCoordLong, redutorXchar, qtdReducao, charReduzindo,
					norte, sul, leste, oeste, coordX, coordY);
		
	}
	//FUNÇÂO FILTRAGENS INICIAIS
	public static void filtrarInicial(String coordenada) {
		char[] filtragemInicio = new char[1];
		coordenada.getChars(0, 1, filtragemInicio, 0);
		char inicio = filtragemInicio[0];
		
		char[] filtragemFinal = new char[1];
		coordenada.getChars(coordenada.length()-1, coordenada.length(), filtragemFinal, 0);
		char fim = filtragemFinal[0];
		
		if (inicio == 'x' || inicio == 'X' || inicio == '0'
				|| fim == '0' || fim == '1' || fim == '2'
				|| fim == '3' || fim == '4'	|| fim == '5'
				|| fim == '6' || fim == '7' || fim == '8'
				|| fim == '9') {
		System.err.println("Cordenadas Inválidas!");
		System.exit(0);
		}
	}
	
	//FUNÇÕES DIV-CHAR & INTER-CHAR
	public static char[] divisorCaracter(String coord) {
		char[] caracteres = new char[coord.length()];
		for (int i=0, j=0; i< coord.length(); i++, j++) {
			caracteres[j] = coord.charAt(i);
		}
		return caracteres;
	}
	public static String integradorChar(char[] showChar) {
		String interchar = "";
		for(int i=0; i < showChar.length; i++) {
			interchar = interchar + showChar[i];
		}
		return interchar;
	}
	//FUNÇÕES RECONHECIMENTO  & INTERPRETAÇÃO
	public static boolean seNum(char tchar) {
		String unichar = Character.toString(tchar);
		Pattern ptnum = Pattern.compile("\\d");
		Matcher mtnum = ptnum.matcher(unichar);
		boolean unicharnum = mtnum.matches();
		return unicharnum;
	}
	public static boolean seX(char tchar) {
		String unichar = Character.toString(tchar);
		Pattern ptnum = Pattern.compile("[xX]");
		Matcher mtnum = ptnum.matcher(unichar);
		boolean unicharX = mtnum.matches();
		return unicharX;
}
	public static boolean seCoord(char tchar) {
		String unichar = Character.toString(tchar);
		Pattern ptnum = Pattern.compile("[nNsSlLoO]");
		Matcher mtnum = ptnum.matcher(unichar);
		boolean unicharCoo = mtnum.matches();
		return unicharCoo;
}
	public static int tipadorChar(char uniChar) {
		boolean seNum = seNum(uniChar);
		boolean seX = seX(uniChar);
		boolean seCoord = seCoord(uniChar);
		if(seNum == true) {
			return 1;
		}else if (seX == true) {
			return 2;
		}else if (seCoord == true) {
			return 3;
		}else {
			return 4;
		}
	}
	//FUNÇÔES SE NUMERICO
	public static String multiplicadorCoordChar(char[] listChar, String multCoordChar, int id) {
		multCoordChar = multCoordChar + Character.toString(listChar[id]);
		return multCoordChar;
	}
	public static long multiplicadorCoordToLong(String multEmChar) {
		long multEmLong = Long.parseLong(multEmChar);
		if (multEmLong >= 2147483647) {
			System.out.println("Número muito longo!");
			System.exit(0);
		}return multEmLong;
	}
	
	//FUNÇÕES SE REDUTOR-X
	public static long redutorNorte(int tipo, int qtdReducao, long norte) {
		if (norte >= qtdReducao) {
			norte -= qtdReducao;
			System.out.println("Redução Norte: " + norte);
			return norte;
		}
		return 0;
	}
	public static long redutorSul(int tipo, int qtdReducao, long sul) {
		if (sul >= qtdReducao) {
			sul -= qtdReducao;
			System.out.println("Redução Sul: " + sul);
			return sul;
		}
		return 0;
	}
	public static long redutorLeste(int tipo, int qtdReducao, long leste) {
		if (leste >= qtdReducao) {
			leste -= qtdReducao;
			System.out.println("Redução Leste: " + leste);
			return leste;
		}
		return 0;
	}
	public static long redutorOeste(int tipo, int qtdReducao, long oeste) {
		if (oeste >= qtdReducao) {
			oeste -= qtdReducao;
			System.out.println("Redução oeste: " + oeste);
			return oeste;
		}
		return 0;
	}
	public static long redutorCoordenada(int tipo, int qtdReducao, String charReduzindo,
										long norte, long sul, long leste, long oeste) {
		if (tipo !=2 && charReduzindo.equals("n") || charReduzindo.equals("N")) {
			norte = redutorNorte(tipo, qtdReducao, norte);
			//System.out.println(norte);
		return norte;
		}
		if (tipo !=2 && charReduzindo.equals("s") || charReduzindo.equals("S")) {
			sul = redutorSul(tipo, qtdReducao, sul);
			//System.out.println(sul);
		return sul;
		}
		if (tipo !=2 && charReduzindo.equals("l") || charReduzindo.equals("L")) {
			leste = redutorLeste(tipo, qtdReducao, leste);
			//System.out.println(leste);
		return leste;
		}
		if (tipo !=2 && charReduzindo.equals("o") || charReduzindo.equals("O")) {
			oeste = redutorOeste(tipo, qtdReducao, oeste);
			//System.out.println(oeste);
		return oeste;
		}	
		return 0;
	}
	
	
	//FUNÇÃO MOTOR
	public static void leituraTipo(char[] listChar, String multCoordChar, long multCoordLong,
			String redutorXchar, int qtdReducao, String charReduzindo, long norte, long sul, long leste, long oeste,
			long coordX, long coordY) {
		
		for(int i=0; i < listChar.length; i++) {
			int tipo = tipadorChar(listChar[i]);
			//System.err.print("Tipo: " + tipo + " ");
			switch (tipo) {
			case 1: //Numero
				
				redutorCoordenada(tipo, qtdReducao, charReduzindo, norte, sul, leste, oeste);
				
				multCoordChar = multiplicadorCoordChar(listChar, multCoordChar, i);
				multCoordLong = multiplicadorCoordToLong(multCoordChar);
				//System.out.println("Multiplicador: " + multCoordLong);
			break;
			case 2: //Redutor
				redutorXchar = redutorXchar + listChar[i];
				qtdReducao = redutorXchar.length();
				System.out.print("Redutores Atuais: " + qtdReducao + " | ");
				charReduzindo = Character.toString(listChar[i-1]); //anterior a x			
				System.out.println("Char Reduzindo: " + charReduzindo);
				System.out.println();
				
				if(listChar.length-1 == i) {
					//QUE COORDENADA REDUZIR
					if (qtdReducao !=0 && charReduzindo.equals("n") || charReduzindo.equals("N")) {
						norte = redutorCoordenada(tipo, qtdReducao, charReduzindo, norte, sul, leste, oeste);
						qtdReducao = 0;
						redutorXchar= "";
					}else if (qtdReducao !=0 && charReduzindo.equals("s") || charReduzindo.equals("S")) {
						sul = redutorCoordenada(tipo, qtdReducao, charReduzindo, norte, sul, leste, oeste);
						qtdReducao = 0;
						redutorXchar= "";
					}else if (qtdReducao !=0 && charReduzindo.equals("l") || charReduzindo.equals("L")) {
						leste = redutorCoordenada(tipo, qtdReducao, charReduzindo, norte, sul, leste, oeste);
						qtdReducao = 0;
						redutorXchar= "";
					}else if (qtdReducao !=0 && charReduzindo.equals("o") || charReduzindo.equals("O")) {
						oeste = redutorCoordenada(tipo, qtdReducao, charReduzindo, norte, sul, leste, oeste);
						qtdReducao = 0;
						redutorXchar= "";
					}
				}
			break;
			case 3: //Coordenada
				//System.out.println(" * " + tipo + " " + qtdReducao + " " + charReduzindo + " " + norte + " *");
				
				//QUE COORDENADA REDUZIR
				if (qtdReducao !=0 && charReduzindo.equals("n") || charReduzindo.equals("N")) {
					norte = redutorCoordenada(tipo, qtdReducao, charReduzindo, norte, sul, leste, oeste);
					qtdReducao = 0;
					redutorXchar= "";
				}else if (qtdReducao !=0 && charReduzindo.equals("s") || charReduzindo.equals("S")) {
					sul = redutorCoordenada(tipo, qtdReducao, charReduzindo, norte, sul, leste, oeste);
					qtdReducao = 0;
					redutorXchar= "";
				}else if (qtdReducao !=0 && charReduzindo.equals("l") || charReduzindo.equals("L")) {
					leste = redutorCoordenada(tipo, qtdReducao, charReduzindo, norte, sul, leste, oeste);
					qtdReducao = 0;
					redutorXchar= "";
				}else if (qtdReducao !=0 && charReduzindo.equals("o") || charReduzindo.equals("O")) {
					oeste = redutorCoordenada(tipo, qtdReducao, charReduzindo, norte, sul, leste, oeste);
					qtdReducao = 0;
					redutorXchar= "";
				}
				
				// ADICIONADO OU MULTIPLICANDO COORDENADAS
				if (multCoordLong == 0) {
					if(listChar[i] == 'n' || listChar[i] == 'N') {
						norte++;
					}else if (listChar[i] == 's' || listChar[i] == 'S' ) {
						sul++;
						//System.out.println("Sul = " + sul);
					}else if (listChar[i] == 'l' || listChar[i] == 'L') {
						leste++;
						//System.out.println("leste = " + leste);
					}else if (listChar[i] == 'o' || listChar[i] == 'O') {
						oeste++;
						//System.out.println("Oeste = " + oeste);
					}
				}else if (multCoordLong != 0) {
					if(listChar[i] == 'n' || listChar[i] == 'N') {
						norte++;
						norte *= multCoordLong;
						multCoordLong = 0;
						multCoordChar = "";
						//System.out.println("Norte = " + norte);
					}else if (listChar[i] == 's' || listChar[i] == 'S' ) {
						sul++;
						sul *= multCoordLong;
						multCoordLong = 0;
						multCoordChar = "";
						//System.out.println("Sul = " + sul);
					}else if (listChar[i] == 'l' || listChar[i] == 'L') {
						leste++;
						leste *= multCoordLong;
						multCoordLong = 0;
						multCoordChar = "";
						//System.out.println("leste = " + leste);
					}else if (listChar[i] == 'o' || listChar[i] == 'O') {
						oeste++;
						oeste *= multCoordLong;
						multCoordLong = 0;
						multCoordChar = "";
						//System.out.println("Oeste = " + oeste);
					}
				}
			break;
			case 4:
				System.err.println("Coordenadas Inválidas");
				System.exit(0);
			break;
			default:
				System.err.println("Coordenadas Inválidas");
				System.exit(0);
			break;
			}
			valorCoordenada(norte, sul, leste, oeste, coordX, coordY);
			String coordenadaFinal = valorCoordenada(norte, sul, leste, oeste, coordX, coordY);
		}
	}
	
	//FUNÇÃO EXIBIÇÂO
	public static String valorCoordenada(long norte, long sul, long leste, long oeste, long coordX, long coordY) {
		System.out.println("Norte: " + norte +
				" Sul: " + sul +
				" lest: " + leste +
				" Oeste: " + oeste);
	
		coordX = leste - oeste;
		coordY = norte - sul;
		
		System.out.println("Coordenadas: ("+ coordX + "," + coordY +")");
		System.out.println();
		return ("Coordenadas: ("+ coordX + "," + coordY +")");
	}
	
	
	
	
	
	//FUNÇÕES RASCUNHOS
	public static long redutorX(int tipo, int qtdReducao, String charReduzindo, String redutorXchar,
								long norte, long sul, long leste, long oeste ) {
		
		System.err.println();
		System.err.println("tipo: " + tipo +  " qtdReducao: " + qtdReducao + " Reduzindo: " + charReduzindo
							+ " redutorXchar: " + redutorXchar + " norte: " + norte + " sul: " + sul
							+ " leste: " + leste + " Oeste:" + oeste);		
		
		if (tipo == 2 && qtdReducao !=0) {
			System.err.println("REDUZINDO");
			if (charReduzindo.equals("n") || charReduzindo.equals("N") ) {
				if (norte >= qtdReducao) {
					norte -= qtdReducao;
					System.out.println("***Coo-Norte " + norte);
					return norte;
				}else {
					System.out.println(qtdReducao + charReduzindo);
					System.out.println("Coordenada Inválida N<X");
					System.exit(0);
					}
			}else if (charReduzindo.equals("s") || charReduzindo.equals("S") ) {
				if (sul >= qtdReducao) {
					sul -= qtdReducao;
					System.out.println("***Coo-Sul  " + sul);
					return sul;
				}else {
					System.out.println("Coordenada Inválida S<X");
					System.exit(0);
				}
			}else if (charReduzindo.equals("l") || charReduzindo.equals("L") ) {
				if (leste >= qtdReducao) {
					leste -= qtdReducao;
					System.out.println("***Coo-lest  " + leste);
					return leste;
				}else {
					System.out.println("Coordenada Inválida L<X");
					System.exit(0);
			}
			}else if (charReduzindo.equals("o") || charReduzindo.equals("O") ) {
				if (oeste >= qtdReducao) {
					oeste -= qtdReducao;
					System.out.println("***Coo-Oeste  " + oeste);
					return oeste;
				}else{
					System.out.println("Coordenada Inválida O<X");
					System.exit(0);
					}
			}
		}return 0;
	}
}
