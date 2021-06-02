package br.com.drone.dronetest;


import java.util.LinkedList;

public  class Drone {
    private Ponto posicao;
    private final int MAX_VALUE = 2147483647;
    public Drone(){
        posicao = new Ponto();
    }


    public boolean validInput(String str){
        if (str == null) return false;
        final String[] invalidChar = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "M", "P", "Q", "R", "T", "U", "V", "W", "Y", "Z"};
        for(String letter : invalidChar){
            if(str.contains(letter)) return false;
        }
        if(str.length()>0 && str.charAt(0)>47 && str.charAt(0)<58) return false;
        if(!str.contains("N") &&
                !str.contains("S") &&
                !str.contains("L") &&
                !str.contains("O")) return false;
        int num = str.length();
        for (int i = 0; i < num; i++){
            if(i < num -1 && str.charAt(i) == 'X' && ((str.charAt(i+1)-48)>=0 && (str.charAt(i+1)-48)<=9) )
                return false;
        }
        return true;
    }

    public String simplifyInput(String str){

        int num = str.length();
        for(int i = 0; i < num; i++){
            if(str.charAt(i) == 'X'){
                if((str.charAt(i-1)-48)>=0 && (str.charAt(i-1)-48)<=9){
                    str = str.substring(0, i-1) + str.substring(i);
                    num = str.length();
                    i = 0;
                }
            }
        }
        for(int i = 0; i < num; i++){
            if(str.charAt(i) == 'X'){
                str = str.substring(0, i-1) + str.substring(i+1);
                num = str.length();
                i = 0;
            }
        }
        System.out.println(str);
        return str;
    }

    public void moveDrone(String str){
        int num = str.length();
        String number;
        for (int i = 0; i < num; i++){
            try {
                if (i == num - 1 || str.charAt(i + 1) < 48 || str.charAt(i + 1) > 57) { //not a number after letter
                    switch (str.charAt(i)) {
                        case 'N':
                            posicao.goNorth();
                            break;
                        case 'S':
                            posicao.goSouth();
                            break;
                        case 'L':
                            posicao.goEast();
                            break;
                        case 'O':
                            posicao.goWest();
                            break;
                    }
                } else {
                    char c = str.charAt(i);
                    number = "";
                    i++;
                    while (i < num && str.charAt(i) >= 48 && str.charAt(i) <= 57) {
                        number += str.charAt(i);
                        i++;
                    }
                    switch (c) {
                        case 'N':
                            posicao.goNorth(Integer.parseInt(number));
                            break;
                        case 'S':
                            posicao.goSouth(Integer.parseInt(number));
                            break;
                        case 'L':
                            posicao.goEast(Integer.parseInt(number));
                            break;
                        case 'O':
                            posicao.goWest(Integer.parseInt(number));
                            break;
                    }
                    i--;
                }
            }catch (ArithmeticException e){
                posicao.setY(999);
                posicao.setX(999);
            }
        }
    }


    public String changePosition(String str){
        if(!validInput(str)){
            posicao.setY(999);
            posicao.setX(999);
        }
        else{
            str = simplifyInput(str);
            moveDrone(str);
        }
        return posicao.toString();
    }
}
