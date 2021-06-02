package br.com.drone.dronetest;

import static java.lang.Math.addExact;
import static java.lang.Math.subtractExact;

public class Ponto{
    private int x;
    private int y;

    //Constructors:

    public Ponto(){
        setX(0);
        setY(0);
    }

    public Ponto(int x, int y){
        setY(y);
        setX(x);
    }

    public String toString(){
        return String.format("(%d, %d)", this.x, this.y);
    }

    //Update coordinates functions:

    public void goNorth() throws ArithmeticException{
        this.setY(addExact(this.y, 1));
    }

    public void goNorth(int n) throws ArithmeticException{
        this.setY(addExact(this.y, n));
    }

    public void goSouth() throws ArithmeticException{
        this.setY(subtractExact(this.y, 1));
    }

    public void goSouth(int n) throws ArithmeticException{
        this.setY(subtractExact(this.y, n));
    }

    public void goWest() throws ArithmeticException{
        this.setX(subtractExact(this.x, 1));
    }

    public void goWest(int n)throws ArithmeticException{
        this.setX(subtractExact(this.x, n));
    }
    public void goEast()throws ArithmeticException{
        this.setX(addExact(this.x, 1));
    }

    public void goEast(int n)throws ArithmeticException{
        this.setX(addExact(this.x, n));
    }


    //Getters and setters:

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
