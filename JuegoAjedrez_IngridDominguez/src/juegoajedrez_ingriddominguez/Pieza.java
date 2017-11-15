/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juegoajedrez_ingriddominguez;

/**
 *
 * @author 1234
 */
public abstract class Pieza {
    protected int posicionX;
    protected int posicionY;
    protected int nuevaX;
    protected int nuevaY;

    public Pieza() {
    }

    public Pieza(int posicionX, int posicionY, int nuevaX, int nuevaY) {
        this.posicionX = posicionX;
        this.posicionY = posicionY;
        this.nuevaX = nuevaX;
        this.nuevaY = nuevaY;
    }

    public int getNuevaX() {
        return nuevaX;
    }

    public void setNuevaX(int nuevaX) {
        this.nuevaX = nuevaX;
    }

    public int getNuevaY() {
        return nuevaY;
    }

    public void setNuevaY(int nuevaY) {
        this.nuevaY = nuevaY;
    }

    

    public int getPosicionX() {
        return posicionX;
    }

    public void setPosicionX(int posicionX) {
        this.posicionX = posicionX;
    }

    public int getPosicionY() {
        return posicionY;
    }

    public void setPosicionY(int posicionY) {
        this.posicionY = posicionY;
    }

    @Override
    public String toString() {
        return "Pieza{" + "posicionX=" + posicionX + ", posicionY=" + posicionY + ", nuevaX=" + nuevaX + ", nuevaY=" + nuevaY + '}';
    }

   
    
   
    public abstract int movimiento(String [][] matriz, boolean jugador);
    public abstract int metodo(String pieza, String[][] matriz, boolean jugador);
    
}
