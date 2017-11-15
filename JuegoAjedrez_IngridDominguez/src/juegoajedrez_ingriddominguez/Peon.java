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
public class Peon extends Pieza {

    private int idy;
    private int idx;

    public Peon() {
        super();
    }

    public Peon(int idy, int idx, int posicionX, int posicionY, int nuevaX, int nuevaY) {
        super(posicionX, posicionY, nuevaX, nuevaY);
        this.idy = idy;
        this.idx = idx;
    }

    @Override
    public int movimiento(String[][] matriz, boolean jugador) {
        int error = 0;
        String pieza = "";

//        System.out.println("y "+ posicionY+ " nnue "+nuevaY);
//        System.out.println("x "+posicionX);
        int n1 = nuevaY - posicionY;
        int n2 = nuevaX - posicionX;

        String piezaS = matriz[nuevaY][nuevaX];
        if (jugador == true) {
            if ((posicionY + 1 == nuevaY) && (nuevaX == posicionX)) {
                error = 0;
                piezaS = matriz[nuevaY][nuevaX];
                error = metodo(piezaS, matriz, jugador);
                //int errorE = metodo(piezaS, matriz, false);
                if (error > 0) {
                    return error = 100;
                }
                System.out.println("e1");
            }else if(nuevaY < posicionY){
                error = 1;
                return error;
            } else if (n1 == 2 && (n2 == 2 || n2 == -2)) {
                error = 0;
                String piezaComer = "";
                if (nuevaX > posicionX) {
                    piezaComer = matriz[posicionY + 1][posicionX + 1];
                    if (piezaComer.equals("▒")) {
                        error = 1;
                    } else {
                        error = metodo(piezaComer, matriz, jugador);
                    }

                    if (error == 0) {
                        matriz[posicionY + 1][posicionX + 1] = "▒";
                    }

                } else if (nuevaX < posicionX) {
                    piezaComer = matriz[posicionY + 1][posicionX - 1];
                    if (piezaComer.equals("▒")) {
                        error = 1;
                    } else {
                        error = metodo(piezaComer, matriz, jugador);
                    }

                    if (error == 0) {
                        matriz[posicionY + 1][posicionX - 1] = "▒";
                    }
                }// fin de la condicion

            } else if (posicionY == 1) {
                if (nuevaY - posicionY == 2 && nuevaX == posicionX) {
                    System.out.println("eeee");
                    int E1 = metodo(matriz[nuevaY][nuevaX], matriz, jugador);
                    if (E1 > 0) {
                        return error = 100;
                    }
                }
            }else{
                error = 1;
                return error;
            }// configurar para que esto sea valido para comer
        } else {
            if ((posicionY - 1 == nuevaY) && (nuevaX == posicionX)) {
                error = 0;
                piezaS = matriz[nuevaY][nuevaX];
                error = metodo(piezaS, matriz, jugador);
                int errorE = metodo(piezaS, matriz, true);
                if (error > 0) {
                    return error = 100;
                }
                System.out.println("e2");
            }else if(nuevaY > posicionY){
                error = 1;
                return error;
            } else if (n1 == -2 && (n2 == 2 || n2 == -2)) {
                error = 0;
                String piezaComer = "";
                if (nuevaX > posicionX) {
                    piezaComer = matriz[posicionY - 1][posicionX + 1];
                    if (piezaComer.equals("▒")) {
                        error = 1;
                    } else {
                        error = metodo(piezaComer, matriz, jugador);
                    }

                    if (error == 0) {
                        matriz[posicionY - 1][posicionX + 1] = "▒";
                    }

                } else if (nuevaX < posicionX) {
                    piezaComer = matriz[posicionY - 1][posicionX - 1];
                    if (piezaComer.equals("▒")) {
                        error = 1;
                    } else {
                        error = metodo(piezaComer, matriz, jugador);
                    }

                    if (error == 0) {
                        matriz[posicionY - 1][posicionX - 1] = "▒";
                    }
                }// fin de la condicion

            } else if (posicionY == matriz.length-3) {
                if (posicionY - nuevaY == 2 && nuevaX == posicionX) {
                    int E1 = metodo(matriz[nuevaY][nuevaX], matriz, jugador);
                    if (E1 > 0) {
                        return error = 100;
                    }
                }
            }else{
                System.out.println("erooooo");
                error = 1;
                return error;
            }// configurar para que esto sea valido para comer
        }// fin de la condicion

        return error;
    }

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
        } else {
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

}
