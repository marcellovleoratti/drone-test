package br.com.drone.dronetest;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Drone {

    // Variáveis de controle
    private Integer x;
    private Integer y;
    private Integer countX;
    private List<Character> beforeChars;
    private List<String> matchList;
    private String nextChar;
    private boolean numberInvalid;

    // Construtor
    public Drone() {
        this.x = 0;
        this.y = 0;
        this.countX = 0;
        this.beforeChars = new ArrayList<>();
        this.matchList = new ArrayList<>();
        this.nextChar = null;
        this.numberInvalid = false;
    }

    public String changePosition(String str) {

        // Verificando se a string é vazia ou nula
        if (str != null && !str.isBlank()) {

            // Regex para validações
            Matcher DIGITS_AND_CHAR_PATTERN = Pattern.compile("^\\d\\w+").matcher(str); // Regex que verifica se no início de uma entrada existe dígitos antes de um char
            Matcher X_AND_DIGITS_PATTERN = Pattern.compile(".*X\\d.*").matcher(str); // Regex que verificar se apó um X existe dígitos

            // Quebrando String em vetor de caracteres
            char[] inputVector = str.toCharArray();
            for (int i = 0; i < inputVector.length; i++) {

                // Validando se o char atual é o último, caso não for receberemos o próximo em uma variável.
                if (inputVector.length > (i + 1)) nextChar = Character.toString(inputVector[i + 1]);

                // Regex para validar se os campos são (não dígitos)
                Matcher letterPattern = Pattern.compile("[^\\d]").matcher(nextChar);

                if (letterPattern.matches()) {

                    // Incrementando valores em X e Y
                    boolean isNSLO = this.incrementingByCoordinate(inputVector[i]);

                    // Caso seja alguma letra diferente de N, S, L, O e X, o sistema retorna (999 ,999)
                    if (!isNSLO && (Character.isLetter(inputVector[i]) && inputVector[i] != 'X')) {
                        return "(999, 999)";
                    }

                    // Caso o char atual seja igual a X, iremos desfazer ações anteriores.
                    else if (inputVector[i] == 'X') {
                        this.goBackActionsByX(inputVector, i);
                    }
                }
            }
            // Se a entrada possuir digitos antes de coordenadas (N, S, L, O) ou
            // se a entrada for igual a X com opção de passo será retornado o valor (999, 999)
            if (DIGITS_AND_CHAR_PATTERN.matches() || X_AND_DIGITS_PATTERN.matches()) {
                return "(999, 999)";
            }
            // Incrementando valores em X e Y com passos
            // Caso o passo seja maior ou igual a 2147483647 e a entrada não seja X, será retornado (999, 999)
            boolean numberInvalid = this.incrementingByCoordinateWithStep(str);
            if (numberInvalid) return "(999, 999)";

            // retornando dados processados
            return "(" + x + ", " + y + ")";
        }
        // Caso a string seja vazia ou nula, será retornado o valor (999, 999)
        return "(999, 999)";
    }

    private boolean incrementingByCoordinateWithStep(String str) {

        // Regex para validações
        Matcher CHAR_AND_DIGIT_PATTERN = Pattern.compile("\\w{1}\\d{1,}").matcher(str); //Regex que verifica se após uma char existe dígitos

        // Adicionando coordenadas e passos em array
        while (CHAR_AND_DIGIT_PATTERN.find()) matchList.add(CHAR_AND_DIGIT_PATTERN.group());

        matchList.stream().forEach(val -> {

            // Pegando tamanho do primeiro item de coordenada mais passo
            int valLength = val.length();

            // pegando a proxima posição da entrada
            int nextPosition = str.indexOf(val) + val.length();

            // Verificando se o tamanho da entrada é maior ou igual a próxima posição e
            // se o passo é menor que 2147483647 e se a próxima posição é diferente de X
            // Caso seja verdadeiro a lógica, será incrementado/decrementado os passos de acordo com as coordenadas.
            if (str.length() >= nextPosition && Integer.parseInt(val.substring(1, valLength)) < 2147483647 &&
                    !str.substring(nextPosition).equals("X")) {
                if (val.charAt(0) == 'N')
                    y = y + Integer.parseInt(val.substring(1, valLength));
                if (val.charAt(0) == 'S')
                    y = y - Integer.parseInt(val.substring(1, valLength));
                if (val.charAt(0) == 'L')
                    x = x + Integer.parseInt(val.substring(1, valLength));
                if (val.charAt(0) == 'O')
                    x = x - Integer.parseInt(val.substring(1, valLength));
            }
            // Verificando se o tamanho da entrada é maior ou igual a próxima posição e
            // se o passo é maior ou igual a 2147483647 e se a próxima posição é diferente de X
            // Caso o passo seja maior ou igual a 2147483647 e a entrada seja X, não será processado o calculo,
            else if (str.length() >= nextPosition && Integer.parseInt(val.substring(1, valLength)) >= 2147483647 &&
                    !str.substring(nextPosition, nextPosition + 1).equals("X")) numberInvalid = true;
        });
        return numberInvalid;
    }

    private boolean incrementingByCoordinate(char charValue) {
        // Incrementado/decrementado valores de X e Y de acordo com as coordenadas
        if (charValue == 'N') {
            y++;
            return true;
        } else if (charValue == 'S') {
            y--;
            return true;
        } else if (charValue == 'L') {
            x++;
            return true;
        } else if (charValue == 'O') {
            x--;
            return true;
        }
        return false;
    }

    private void goBackActionsByX(char[] inputVector, int i) {
        // Conta a quantidade de X consecutivos e adiciona os valores anteriores de acordo com a quantidade de X em uma lista
        for (int j = i; j < inputVector.length; j++) {
            countX++;
            beforeChars.add(inputVector[i - countX]);

            // Caso o proximo valor não seja X, o sistema para o loop
            if (inputVector.length == j + 1 || inputVector[j + 1] != 'X') break;
        }
        // Desfazendo ações
        for (char c : beforeChars) {
            if (c == 'N') y--;
            else if (c == 'S') y++;
            else if (c == 'L') x--;
            else if (c == 'O') x++;
        }
        // Zerando parâmetros de controle
        countX = 0;
        beforeChars = new ArrayList<>();
    }
}
