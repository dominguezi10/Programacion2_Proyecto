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
public class Caballo extends Pieza {

    private int direccion;

    public Caballo() {
        super();
    }

    public Caballo(int direccion, int posicionX, int posicionY, int nuevaX, int nuevaY) {
        super(posicionX, posicionY, nuevaX, nuevaY);
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        return "Caballo{" + super.toString() + '}';
    }
    
    
    //el metodo funciona ya lo probastes!!!
    @Override
    public int movimiento(String[][] matriz, boolean jugador) {
        int error = 1;
        String pieza = "";
        if (jugador == true) {
            pieza = "♞";
        } else {
            pieza = "♘";
        }
        
        
        
        
        
        // para ve si la entrada del movimiento esta bien
        String piezaS = matriz[nuevaY][nuevaX];
        if ((nuevaY - posicionY == 1)
                && ((nuevaX - posicionX == 2) || (nuevaX - posicionX == -2))) {
            error = 0;
            error = metodo(piezaS, matriz, jugador);
        } else if ((nuevaY - posicionY == 2)
                && ((nuevaX - posicionX == 1) || (nuevaX - posicionX == -1))) {
            error = 0;
            error = metodo(piezaS, matriz, jugador);
        } else if ((nuevaY - posicionY == -2)
                && ((nuevaX - posicionX == 1) || (nuevaX - posicionX == -1))) {
            error = 0;
            error = metodo(piezaS, matriz, jugador);
        } else if ((nuevaY - posicionY == -1)
                && ((nuevaX - posicionX == 2) || (nuevaX - posicionX == -2))) {
            error = 0;
            error = metodo(piezaS, matriz, jugador);
        }

        
        return error;
    }// fin de la validacion del movimiento

    @Override
    public int metodo(String pieza, String[][] matriz, boolean jugador) {
        int error = 0;
        if (jugador == true) {
            switch (pieza) {
                case "♞":
                case "♜":
                case "♛":
                case "♚":
                case "♟":
                case "♝":
                    error = 1;
                    break;
                default:
                    break;
            }// fin del caso
        }else {
            switch (pieza) {
                case "♘":
                case "♖":
                case "♕":
                case "♔":
                case "♙":
                case "♗":
                    error = 1;
                    break;
                default:
                    break;
            }// fin del caso
        }

        return error;
    }// fin del metodo

}// fin de la clase
