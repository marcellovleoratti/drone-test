package br.com.drone.dronetest;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import br.com.drone.Drone;

class DroneTestApplicationTests {
    private Drone drone = new Drone();
    @Test
    public void Input_NNNNNLLLLL() {
        Assertions.assertEquals("[[5, 5]]", this.drone.changePosition("NNNNNLLLLL"));
    }

    @Test
    public void Input_NLNLNLNLNL() {
        Assertions.assertEquals("[[5, 5]]", this.drone.changePosition("NLNLNLNLNL"));
    }

    @Test
    public void Input_NNNNNXLLLLLX() {
        Assertions.assertEquals("[[4, 4]]", this.drone.changePosition("NNNNNXLLLLLX"));
    }

    @Test
    public void Input_SSSSSOOOOO() {
        Assertions.assertEquals("[[-5, -5]]", this.drone.changePosition("SSSSSOOOOO"));
    }

    @Test
    public void Input_S5O5() {
        Assertions.assertEquals("[[-5, -5]]", this.drone.changePosition("S5O5"));
    }

    @Test
    public void Input_NNX2() {
        Assertions.assertEquals("[[999, 999]]", this.drone.changePosition("NNX2"));
    }

    @Test
    public void Input_N123LSX() {
        Assertions.assertEquals("[[1, 123]]", this.drone.changePosition("N123LSX"));
    }

    @Test
    public void Input_NLS3X() {
        Assertions.assertEquals("[[1, 1]]", this.drone.changePosition("NLS3X"));
    }

    @Test
    public void Input_NNNXLLLXX() {
        Assertions.assertEquals("[[1, 2]]", this.drone.changePosition("NNNXLLLXX"));
    }

    @Test
    public void Input_N40L30S20O10NLSOXX() {
        Assertions.assertEquals("[[21, 21]]", this.drone.changePosition("N40L30S20O10NLSOXX"));
    }

    @Test
    public void Input_NLSOXXN40L30S20O10() {
        Assertions.assertEquals("[[21, 21]]", this.drone.changePosition("NLSOXXN40L30S20O10"));
    }

    @Test
    public void Input_NULL() {
        Assertions.assertEquals("[[999, 999]]", this.drone.changePosition(null)); // Entrada nula
    }

    @Test
    public void Input_EMPTY() {
        Assertions.assertEquals("[[999, 999]]", this.drone.changePosition("")); // Entrada vazia
    }

    @Test
    public void Input_WHITESPACE() {
        Assertions.assertEquals("[[999, 999]]", this.drone.changePosition("   ")); // Entrada espaço vazio
    }

    @Test
    public void Input_123() {
        Assertions.assertEquals("[[999, 999]]", this.drone.changePosition("123")); // Entrada inválida
    }

    @Test
    public void Input_123N() {
        Assertions.assertEquals("[[999, 999]]", this.drone.changePosition("123N")); // passos antes da direçao
    }

    @Test
    public void Input_N2147483647N() {
        Assertions.assertEquals("[[999, 999]]", this.drone.changePosition("N2147483647N")); // Overflow
    }

    @Test
    public void Input_NNI() {
        Assertions.assertEquals("[[999, 999]]", this.drone.changePosition("NNI")); // Commando inválido
    }

    @Test
    public void Input_N2147483647XN() {
        Assertions.assertEquals("[[0, 1]]", this.drone.changePosition("N2147483647XN")); // Overflow cancelado
    }

    @Test
    public void Input_BIGSTRING() {
        Assertions.assertEquals("[[500, 500]]", this.drone.changePosition(
                ("N").repeat(1000) +
                        ("S").repeat(500) +
                        ("L").repeat(1000) +
                        ("O").repeat(500)));
    }

}
