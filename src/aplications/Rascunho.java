package aplications;

import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Rascunho {

	public static void main(String[] args) {
		int norte = 0;
		int sul = 0;
		int leste = 0;
		int oeste = 0;
		
		String multiplicadorEmChar = "";
		long multiplicadorEmLong = 0;
		
		String redutorXchar = "";
		int redutorXInt = 0;
		String charReduzido = "";

		String java = "nxx";
		
		
		char[] jav = new char[java.length()];
		java.getChars(0, java.length(), jav, 0);
		
		System.out.println("Entrada: " + java);
		System.out.println();
		
		System.out.println(jav[0]);
		
		for (int i=0;  i < jav.length; i++) {
			String unidadeCharText = Character.toString(jav[i]);
			Pattern pt1 = Pattern.compile("\\d");
			Matcher mt1 = pt1.matcher(unidadeCharText);
			boolean resultNumerico = mt1.matches();
			System.out.println("é numérico? " + resultNumerico);
			
			if (resultNumerico == true) {	
				multiplicadorEmChar = multiplicadorEmChar + jav[i];
				multiplicadorEmLong = Long.parseLong(multiplicadorEmChar);
					if (multiplicadorEmLong > 2147483647 ) {
						System.out.println("Número muito longo!");
						break;
						}
					System.out.println("numérico atual " + multiplicadorEmChar);
				}
			else if (resultNumerico == false) {
				if (multiplicadorEmChar != "") {
					multiplicadorEmLong = Integer.parseInt(multiplicadorEmChar);
					multiplicadorEmChar = "";
					System.out.println("total numérico: " + multiplicadorEmLong);
				}
				
				Pattern pt2 = Pattern.compile("[xX]");
				Matcher mt2 = pt2.matcher(unidadeCharText);
				boolean resultX = mt2.matches();
				System.out.println("é X? " + resultX);
				System.out.println("o que é? " + unidadeCharText);
				
				if (resultX == true) {
					//System.out.println("obs " + redutorXInt + " " + redutorXchar);
					redutorXchar = redutorXchar + jav[i];
					redutorXInt = redutorXchar.length();
					//System.out.println("obs " + redutorXInt + " " + redutorXchar);
					System.out.println("redutores atuais " + redutorXInt);

					if (charReduzido == "") {
					charReduzido =  Character.toString(jav[i-1]);
					
									
					System.out.println("char antes do x " + charReduzido);
					System.out.println();
						if (jav.length-1 == i) {
							if (redutorXInt != 0) {
								if (charReduzido.equals("n") || charReduzido.equals("N") ) {
									if (norte >= redutorXInt) {
										norte -= redutorXInt;
										System.out.println("***Coo-Norte lest " + norte);
										redutorXInt = 0;
										charReduzido = "";
										redutorXchar = "";
									}else {
										System.out.println(redutorXInt + charReduzido);
										System.out.println("Coordenada Inválida N<X");
										break;
										}
								}else if (charReduzido.equals("s") || charReduzido.equals("S") ) {
									if (sul >= redutorXInt) {
										sul -= redutorXInt;
										System.out.println("***Coo-Sul lest " + sul);
										redutorXInt = 0;
										charReduzido = "";
										redutorXchar = "";
										System.out.println(redutorXInt + charReduzido);
									}else {
										System.out.println("Coordenada Inválida S<X");
										break;
									}
								}else if (charReduzido.equals("l") || charReduzido.equals("L") ) {
									if (leste >= redutorXInt) {
										leste -= redutorXInt;
										System.out.println("***Coo-lest  lest " + leste);
										redutorXInt = 0;
										charReduzido = "";
										redutorXchar = "";
									}else {
										System.out.println("Coordenada Inválida L<X");
										break;
									}
								}else if (charReduzido.equals("o") || charReduzido.equals("O") ) {
									if (oeste >= redutorXInt) {
										oeste -= redutorXInt;
										System.out.println("***Coo-Oeste  lest " + oeste);
										redutorXInt = 0;
										charReduzido = "";
										redutorXchar = "";
									}else {
										System.out.println("Coordenada Inválida O<X");
									break;
								}
							}
							}
						}
					}			
				
				
				}
				else if (resultX == false) {
				
					if (redutorXInt != 0) {
						if (charReduzido.equals("n") || charReduzido.equals("N") ) {
							if (norte >= redutorXInt) {
								norte -= redutorXInt;
								System.out.println("***Coo-Norte " + norte);
								redutorXInt = 0;
								charReduzido = "";
								redutorXchar = "";
							}else {
								System.out.println(redutorXInt + charReduzido);
								System.out.println("Coordenada Inválida N<X");
								break;
								}
						}else if (charReduzido.equals("s") || charReduzido.equals("S") ) {
							if (sul >= redutorXInt) {
								sul -= redutorXInt;
								System.out.println("***Coo-Sul  " + sul);
								redutorXInt = 0;
								charReduzido = "";
								redutorXchar = "";
								System.out.println(redutorXInt + charReduzido);
							}else {
								System.out.println("Coordenada Inválida S<X");
								break;
							}
						}else if (charReduzido.equals("l") || charReduzido.equals("L") ) {
							if (leste >= redutorXInt) {
								leste -= redutorXInt;
								System.out.println("***Coo-lest  " + leste);
								redutorXInt = 0;
								charReduzido = "";
								redutorXchar = "";
							}else {
								System.out.println("Coordenada Inválida L<X");
								break;
							}
						
					}else if (charReduzido.equals("o") || charReduzido.equals("O") ) {
						if (oeste >= redutorXInt) {
							oeste -= redutorXInt;
							System.out.println("***Coo-Oeste  " + oeste);
							redutorXInt = 0;
							charReduzido = "";
							redutorXchar = "";
						}else {
							System.out.println("Coordenada Inválida O<X");
							break;
						}
					}
					}
					
					if (redutorXInt == 0) {
					
				Pattern pt3 = Pattern.compile("[nNsSlLoO]");
				Matcher mt3 = pt3.matcher(unidadeCharText);
				boolean resultChar = mt3.matches();
				System.out.println("é válido? " + resultChar);
				System.out.println("qual é? " + unidadeCharText);
				
				if (resultChar == true) {
					if (unidadeCharText.equals("n") || unidadeCharText.equals("N")){
						if (multiplicadorEmLong != 0 && norte == 0) {
								System.out.println(norte);
								norte++;
								System.out.println(norte);
								norte*=multiplicadorEmLong;
								multiplicadorEmLong = 0;
								System.out.println(multiplicadorEmLong);
								System.out.println(norte);
							}
						else if (multiplicadorEmLong != 0 && norte != 0) {
							norte*=multiplicadorEmLong;
							multiplicadorEmLong = 0;
							System.out.println(multiplicadorEmLong);
							System.out.println(norte);
						}
						else if (multiplicadorEmLong == 0) {
							norte++;
						}
					}else if (unidadeCharText.equals("s") || unidadeCharText.equals("S")) {
						if (multiplicadorEmLong != 0 && sul == 0) {
							System.out.println(sul);
							sul++;
							System.out.println(sul);
							sul*=multiplicadorEmLong;
							multiplicadorEmLong = 0;
							System.out.println(sul);
						}
						else if (multiplicadorEmLong != 0 && sul != 0) {
							sul*=multiplicadorEmLong;
							multiplicadorEmLong = 0;
							System.out.println(sul);
						}
						else if (multiplicadorEmLong == 0) {
							sul++;
						}
					}else if (unidadeCharText.equals("l") || unidadeCharText.equals("L")) {
						if (multiplicadorEmLong != 0 && leste == 0) {
							System.out.println(leste);
							leste++;
							System.out.println(leste);
							leste*=multiplicadorEmLong;
							multiplicadorEmLong = 0;
							System.out.println(leste);
						}
						else if (multiplicadorEmLong != 0 && leste != 0) {
							leste*=multiplicadorEmLong;
							multiplicadorEmLong = 0;
							System.out.println(leste);
						}
						else if (multiplicadorEmLong == 0) {
							leste++;
						}
					}else if (unidadeCharText.equals("o") || unidadeCharText.equals("O")) {
						if (multiplicadorEmLong != 0 && oeste == 0) {
							System.out.println(oeste);
							oeste++;
							System.out.println(oeste);
							oeste*=multiplicadorEmLong;
							multiplicadorEmLong = 0;
							System.out.println(oeste);
						}
						else if (multiplicadorEmLong != 0 && leste != 0) {
							oeste*=multiplicadorEmLong;
							multiplicadorEmLong = 0;
							System.out.println(oeste);
						}
						else if (multiplicadorEmLong == 0) {
							oeste++;
						}
					}

					System.out.println("Norte: " + norte +
										" Sul: " + sul +
										" lest: " + leste +
										" Oeste: " + oeste);
					System.out.println();
					redutorXInt = 0;
					charReduzido = "";
					redutorXchar = "";
				}
				else if (resultChar == false) {
					System.out.println("Código Inválido");
					break;
				}
				}
				}
				}
		}
		
		
		//java.getChars(0, java.length(), jav, 0);
		//System.out.println(jav);
		
		
		
		
		////////////////////////////////
		
		
		//String re = "\\w";
		//String text = "s";
		
		//Pattern pt = Pattern.compile(re); 
		//Matcher mt = pt.matcher(text);
		
		//boolean result = mt.matches();
		//System.out.println(result);
		
		
		
		
		////////////////////////////////////////////////
		
			
		
		String fonte = "mouse da cor azul";
		
		String queremosIsso = "cor";
		
		Pattern p = Pattern.compile(queremosIsso);
		
		Matcher m = p.matcher(fonte);
		
		while (m.find()) {
			//System.out.println(m.start());
		}
	}

}
