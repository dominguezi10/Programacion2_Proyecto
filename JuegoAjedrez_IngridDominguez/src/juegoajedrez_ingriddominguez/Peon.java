/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juegoajedrez_ingriddominguez;

import static juegoajedrez_ingriddominguez.JuegoAjedrez_IngridDominguez.Tablero;

/**
 *
 * @author 1234
 */
public class Peon extends Pieza {

//    private int idy;
//    private int idx;
    public Peon() {
        super();
    }

    public Peon(int posicionX, int posicionY, int nuevaX, int nuevaY) {
        super(posicionX, posicionY, nuevaX, nuevaY);
    }

    @Override
    public int movimiento(String[][] matriz, boolean jugador) {
        int error = 0;
        String pieza = "";

//        System.out.println("y "+ posicionY+ " nnue "+nuevaY);
//        System.out.println("x "+posicionX);
        int n1 = nuevaY - posicionY;
        int n2 = nuevaX - posicionX;
        boolean contrincante;
        if (jugador == true) {
            contrincante = false;
        } else {
            contrincante = true;
        }
       
        String piezaS = matriz[nuevaY][nuevaX];
        if (jugador == true) {
            //movimiento bueno cencillo
            if ((posicionY + 1 == nuevaY) && (nuevaX == posicionX)) {
                error = 0;
                piezaS = matriz[nuevaY][nuevaX];
                error = metodo(piezaS, matriz, jugador);
                error += metodo(piezaS, matriz, contrincante);
                if (error > 0) {
                    return error = 100;
                }
            } else if (nuevaY < posicionY) {
                // no para atras
                error = 1;
                return error;
            } else if (n1 == 1 && (n2 == 1 || n2 == -1)) {
                // si come en diagonal
                error = 0;
                String piezaComer = "";
                if (nuevaX > posicionX) {
                    error = metodo(matriz[posicionY + 1][posicionX + 1], matriz, jugador);
                    return error;
                    /*piezaComer = matriz[posicionY + 1][posicionX + 1];
                    if (piezaComer.equals("▒") || piezaComer.equals("▓")) {
                        error = 1;
                    } else {
                        error = metodo(piezaComer, matriz, jugador);
                        error += metodo(matriz[nuevaY][nuevaX], matriz, jugador);
                        error += metodo(matriz[nuevaY][nuevaX], matriz, contrincante);
                    }
                    
                    
                    if (error == 0) {
                        //matriz[posicionY + 1][posicionX + 1] = "▒";
                        if ((((posicionY + 1 )== 0 )|| ((posicionY + 1)%2 == 0)) && ((posicionX + 1)%2 != 0)) {
                            Tablero[posicionY + 1][posicionX + 1] = "▓";
                            //System.out.println(Tablero[posicionY + 1][posicionX + 1]);
                        } else if (((posicionY+1 )%2 != 0 )&& ((posicionX+1)%2 != 0)) {
                            //System.out.println("aqui "+(posicionY+1 )+ " "+(posicionX+1));
                            Tablero[posicionY + 1][posicionX + 1] = "▓";
                        } else {
                            Tablero[posicionY + 1][posicionX + 1] = "▒";
                        }

                    }*/

                } else if (nuevaX < posicionX) {
                    error = metodo(matriz[posicionY + 1][posicionX - 1], matriz, jugador);
                    return error;
                    /*piezaComer = matriz[posicionY + 1][posicionX - 1];
                    if (piezaComer.equals("▒") || piezaComer.equals("▓")) {
                        error = 1;
                    } else {
                        error = metodo(piezaComer, matriz, jugador);
                        error += metodo(matriz[nuevaY][nuevaX], matriz, jugador);
                        error += metodo(matriz[nuevaY][nuevaX], matriz, contrincante);
                    }

                    if (error == 0) {
                        System.out.println((posicionY+1) + " " + (posicionX-1));
                        //matriz[posicionY + 1][posicionX + 1] = "▒";
                        if (((posicionY + 1 )== 0 || (posicionY + 1 )% 2 == 0) && ((posicionX - 1) % 2 != 0)) {
                            Tablero[posicionY + 1][posicionX - 1] = "▓";
                            // System.out.println("---");
                        } else if (((posicionY + 1 )% 2 != 0) && ((posicionX - 1 )% 2 != 0)) {
                            Tablero[posicionY + 1][posicionX - 1] = "▓";
                        } else {
                            Tablero[posicionY + 1][posicionX - 1] = "▒";
                            System.out.println("aqui");
                        }

                    }*/
                }// fin de la condicion

            } else if (posicionY == 1) {
                // que se mueva en dos la primera vez
                if (nuevaY - posicionY == 2 && nuevaX == posicionX) {
                    int E2 = metodo(matriz[nuevaY + 1][nuevaX], matriz, jugador);
                    int E1 = metodo(matriz[nuevaY][nuevaX], matriz, jugador);
                    if (E1 > 0 || E2 > 0) {
                        return error = 100;
                    }
                } else if (((nuevaY - 1) != posicionY) || (nuevaX != posicionX)) {
                    error = 1;
                    return error;
                }
            } else if (((nuevaY - 1) != posicionY) || (nuevaX != posicionX)) {
                error = 1;
                return error;
            }// configurar para que esto sea valido para comer
        } else {
            if ((posicionY - 1 == nuevaY) && (nuevaX == posicionX)) {
                error = 0;
                piezaS = matriz[nuevaY][nuevaX];
                error = metodo(piezaS, matriz, jugador);
                error += metodo(piezaS, matriz, contrincante);
                //int errorE = metodo(piezaS, matriz, true);
                //System.out.println(error + " cambio");
                if (error > 0) {
                    return error = 100;
                }
                System.out.println("e2");
            } else if (nuevaY > posicionY) {
                error = 1;
                return error;
            } else if (n1 == -1 && (n2 == 1 || n2 == -1)) {
                error = 0;
                String piezaComer = "";
                if (nuevaX > posicionX) {
                    error = metodo(matriz[posicionY - 1][posicionX + 1], matriz, jugador);
                    return error;
                    /*piezaComer = matriz[posicionY - 1][posicionX + 1];
                    if (piezaComer.equals("▒") || piezaComer.equals("▓")) {
                        error = 1;
                    } else {
                        error = metodo(piezaComer, matriz, jugador);
                        error += metodo(matriz[nuevaY][nuevaX], matriz, jugador);
                        error += metodo(matriz[nuevaY][nuevaX], matriz, contrincante);
                    }

                    if (error == 0) {
                        //matriz[posicionY - 1][posicionX + 1] = "▒";
                        if ((((posicionY - 1) == 0) || ((posicionY - 1)%2 == 0)) && ((posicionX + 1)%2 != 0)) {
                            Tablero[posicionY - 1][posicionX + 1] = "▓";
                            // System.out.println("---");
                        } else if (((posicionY - 1)%2 != 0) && ((posicionX+ 1)%2 != 0)) {
                            Tablero[posicionY - 1][posicionX + 1] = "▓";
                        } else {
                            Tablero[posicionY - 1][posicionX + 1] = "▒";
                        }
                    }*/

                } else if (nuevaX < posicionX) {
                    error = metodo(matriz[posicionY - 1][posicionX - 1], matriz, jugador);
                    return error;
                    /*piezaComer = matriz[posicionY - 1][posicionX - 1];
                    if (piezaComer.equals("▒") || piezaComer.equals("▓")) {
                        error = 1;
                    } else {
                        error = metodo(piezaComer, matriz, jugador);
                        error += metodo(matriz[nuevaY][nuevaX], matriz, jugador);
                        error += metodo(matriz[nuevaY][nuevaX], matriz, contrincante);
                    }

                    if (error == 0) {
                       // matriz[posicionY - 1][posicionX - 1] = "▒";
                        if ((((posicionY - 1) == 0 )|| ((posicionY - 1)%2 == 0))&& ((posicionX - 1)%2 != 0)) {
                            Tablero[posicionY - 1][posicionX - 1] = "▓";
                            // System.out.println("---");
                        } else if (((posicionY - 1)%2 != 0) && ((posicionX - 1)%2 != 0)) {
                            Tablero[posicionY - 1][posicionX - 1] = "▓";
                        } else {
                            Tablero[posicionY - 1][posicionX - 1] = "▒";
                        }
                    }*/
                }// fin de la condicion

            } else if (posicionY == matriz.length - 3) {
                if (posicionY - nuevaY == 2 && nuevaX == posicionX) {
                    int E2 = metodo(matriz[nuevaY - 1][nuevaX], matriz, jugador);
                    int E1 = metodo(matriz[nuevaY][nuevaX], matriz, jugador);
                    if (E1 > 0 || E2 > 0) {
                        return error = 100;
                    }
                } else if ((nuevaY + 1) != posicionY || nuevaX != posicionX) {
                    error = 1;
                    return error;
                }
            } else if ((nuevaY + 1) != posicionY || nuevaX != posicionX) {
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
