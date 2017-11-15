/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juegoajedrez_ingriddominguez;

import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author 1234
 */
public class JuegoAjedrez_IngridDominguez {

    static Scanner lectura = new Scanner(System.in);
    static String Tablero[][] = new String[9][9];
    static int ReyY1 = 0;
    static int ReyX1 = 5;
    static int ReyY2 = 7;
    static int ReyX2 = 5;
    static ArrayList<Pieza> movimientos = new ArrayList();

    public static void main(String[] args) {
        String coordenada = "";
        String coordenada2 = "";
        boolean jugador = true;
        int x = 0;
        int y = 0;
        int nuevaX = 0;
        int nuevaY = 0;
        int mov = 1;
        int n = 0;
        Tablero();
        imprimir(Tablero, 0, 0);
        int contt = 0;
        int juego = 0;
        String Jugador = "";

        System.out.println("");
        int error = 1;
        boolean condicionJuego = true;
        while (condicionJuego) {
            error = 1;
            boolean PiezaMover = true;
            while (PiezaMover == true) {
                error = 1;
                if (jugador == true) {
                    Jugador = "Jugador 1";
                } else {
                    Jugador = "Jugador 2";
                }
                System.out.println("Turno del " + Jugador);
                while (error == 1) {
                    while (error == 1) {
                        System.out.println("Ingrese la cordenada de la pieza que deseas mover [b,5]");
                        coordenada = lectura.next().toLowerCase();
                        error = entrada(coordenada);
                    }// fin de la condicion

                    x = cordenadaX("" + coordenada.charAt(0));
                    y = cordenadaY(coordenada.charAt(2));
                    System.out.println(y + "," + x);
                    error = SeleccionPieza(x, y, jugador);
                    System.out.println(error);
                }// fin de la validacion de la seleccion de la pieza
                System.out.println("pieza seleccionada " + Tablero[y][x]);
                String pieza = Tablero[y][x];
                n = PiezaSeleccionada(Tablero[y][x]);

                mov = 1;
                while (mov > 0) {
                    error = 1;
                    while (error == 1) {
                        System.out.println("Ingresa la coordenada donde deseas mover tu pieza [b,5]:");
                        coordenada2 = lectura.next().toLowerCase();
                        error = entrada(coordenada2);
                    } // fin del validacion de la nueva coordenada
                    nuevaX = cordenadaX("" + coordenada2.charAt(0));
                    nuevaY = cordenadaY(coordenada2.charAt(2));

                    mov = CreacionMovimiento(n, x, y, nuevaX, nuevaY, jugador);
                    if (mov > 0 && mov < 100) {
                        //JOptionPane.showMessageDialog(null, "Movimiento Invalido!");
                        System.out.println("Movimiento Invalido!!");
                    }
                    if (mov == 100) {
                        break;
                    }

                }// while que valida que sel movimineto sea valido

                if (mov == 100) {
                    System.out.println("La pieza que escogio no se puede mover en esa direccion");
                } else {
                    PiezaMover = false;
                }
            }// fin del metodo para ver que la pieza se puede mover

            Movimiento(n, x, y, nuevaY, nuevaX, jugador);
            if (movimientos.get(movimientos.size() - 1) instanceof Rey) {
                if (jugador == true) {
                    ReyX1 = movimientos.get(movimientos.size() - 1).getNuevaX();
                    ReyY1 = movimientos.get(movimientos.size() - 1).getNuevaY();
                } else {
                    ReyX2 = movimientos.get(movimientos.size() - 1).getNuevaX();
                    ReyY2 = movimientos.get(movimientos.size() - 1).getNuevaY();
                }

            } else {
                int Jaque = 0;
                if(jugador == true){
                    Jaque = CreacionMovimiento(n, nuevaX, nuevaY, ReyX2, ReyY2, jugador);
                }else{
                    Jaque = CreacionMovimiento(n, nuevaX, nuevaY, ReyX1, ReyY1, jugador);
                }
                
                if(Jaque ==0){
                    System.out.println("Jaque!\nEl Rey Esta En Posicion \nPara Ser Derrotador");
                }
            }

            juego = JaqueMate(jugador);
            if (juego == 0) {
                //JOptionPane.showMessageDialog(null, "JaqueMate\n"+Jugador+" Ganastes!!");
                System.out.println("JaqueMate\n" + Jugador + " Ganastes!!");
                break;
            }

            contt++;
            if (contt == 6) {
                condicionJuego = false;
            }

            if (jugador == true) {
                jugador = false;
            } else {
                jugador = true;
            }

        }// fin del juego

    }// fin del main

    public static void Tablero() {
        int cont = Tablero.length - 1;
        for (int i = 0; i < Tablero.length; i++) {
            for (int j = 0; j < Tablero.length; j++) {
                if (i == 0) {
                    if (j == 1 || j == Tablero.length - 1) {
                        Tablero[i][j] = "♜";
                    } else if (j == 2 || j == Tablero.length - 2) {
                        Tablero[i][j] = "♞";
                    } else if (j == 3 || j == Tablero.length - 3) {
                        Tablero[i][j] = "♝";
                    } else if (j == 4) {
                        Tablero[i][j] = "♛";
                    } else if (j == 5) {
                        Tablero[i][j] = "♚";
                    } else {
                        Tablero[i][j] = "[" + cont + "]";
                        cont--;
                    }

                } else if (i == Tablero.length - 2) {
                    if (j == 1 || j == Tablero.length - 1) {
                        Tablero[i][j] = "♖";
                    } else if (j == 2 || j == Tablero.length - 2) {
                        Tablero[i][j] = "♘";
                    } else if (j == 3 || j == Tablero.length - 3) {
                        Tablero[i][j] = "♗";
                    } else if (j == 4) {
                        Tablero[i][j] = "♕";
                    } else if (j == 5) {
                        Tablero[i][j] = "♔";
                    } else {
                        Tablero[i][j] = "[" + cont + "]";
                        cont--;
                    }

                } else if (i == 1 && j >= 1) {
                    Tablero[i][j] = "♟";
                } else if (i == Tablero.length - 3 && j >= 1) {
                    Tablero[i][j] = "♙";
                } else if (j == 0 && i <= Tablero.length - 2) {
                    Tablero[i][j] = "[" + cont + "]";
                    cont--;
                } else if (i == Tablero.length - 1) {
                    switch (j) {
                        case 1:
                            Tablero[i][j] = "A ";
                            break;
                        case 2:
                            Tablero[i][j] = "B ";
                            break;
                        case 3:
                            Tablero[i][j] = "C ";
                            break;
                        case 4:
                            Tablero[i][j] = "D";
                            break;
                        case 5:
                            Tablero[i][j] = "E ";
                            break;
                        case 6:
                            Tablero[i][j] = "F ";
                            break;
                        case 7:
                            Tablero[i][j] = "G ";
                            break;
                        case 8:
                            Tablero[i][j] = "H";
                            break;
                        default:
                            Tablero[i][j] = "   ";
                            break;
                    }

                } else {
                    if (j % 2 != 0 && i % 2 == 0) {
                        Tablero[i][j] = "▓";
                    } else if (j % 2 == 0 && i % 2 != 0) {
                        Tablero[i][j] = "▓";
                    } else {

                        Tablero[i][j] = "▒";
                    }
                }
            }
        }
    }// fin del metodo

    public static void imprimir(String[][] matriz, int posI, int posJ) {
        if (posI == matriz.length - 1 && posJ == matriz.length - 1) {
            // System.out.print("\t");
            System.out.println(matriz[posI][posJ] + " ");
        } else {
            if (posJ == matriz.length - 1) {
                // System.out.print("\t");
                System.out.println(matriz[posI][posJ]);
                imprimir(matriz, posI + 1, 0);
            } else {
                //System.out.print("\t");
                System.out.print(matriz[posI][posJ] + " ");
                imprimir(matriz, posI, posJ + 1);
            }
        }

    }// fin del metodo imprimir

    public static int JaqueMate(boolean jugador) {
        int error = 0;
        for (int i = 0; i < Tablero.length; i++) {
            for (int j = 0; j < Tablero.length; j++) {
                if (jugador == true) {
                    if (Tablero[i][j].equals("♕")) {
                        return error = 1;
                    }
                } else {
                    if (Tablero[i][j].equals("♛")) {
                        return error = 1;
                    }
                }

            }// segundo for
        }// primer for

        return error;
    }// fin del metodo

    public static int cordenadaX(String n) {
        int CordX = 0;
        switch (n) {
            case "a":
                CordX = 1;
                break;
            case "b":
                CordX = 2;
                break;
            case "c":
                CordX = 3;
                break;
            case "d":
                CordX = 4;
                break;
            case "e":
                CordX = 5;
                break;
            case "f":
                CordX = 6;
                break;
            case "g":
                CordX = 7;
                break;
            case "h":
                CordX = 8;
                break;

        }

        return CordX;
    }

    public static int cordenadaY(char numero) {
        int n = 9;
        switch (numero) {
            case '8':
                n = 0;
                break;
            case '7':
                n = 1;
                break;
            case '6':
                n = 2;
                break;
            case '5':
                n = 3;
                break;
            case '4':
                n = 4;
                break;
            case '3':
                n = 5;
                break;
            case '2':
                n = 6;
                break;
            case '1':
                n = 7;
                break;

        }

        return n;
    }

    public static int entrada(String coordenada) {

        int error = 0;
        if (coordenada.length() != 3) {
            error = 1;
            System.out.println("e1");
        } else if (!coordenada.contains(",")) {
            error = 1;
            System.out.println("e2");
        } else if (coordenada.indexOf(",") != 1) {
            error = 1;
            System.out.println("e3");
        } else if (coordenada.charAt(0) < 97 || coordenada.charAt(0) > 104) {
            error = 1;
            System.out.println("e4");
        } else if (coordenada.charAt(2) < 49 || coordenada.charAt(2) > 56) {
            error = 1;
            System.out.println("e5");
        }

        return error;
    }

    public static int SeleccionPieza(int x, int y, boolean jugador) {
        int error = 0;
        if (jugador == true) {
            switch (Tablero[y][x]) {
                case "♜":
                case "♞":
                case "♝":
                case "♛":
                case "♚":
                case "♟":
                    break;
                default:
                    error = 1;
                    break;
            }
        } else {
            switch (Tablero[y][x]) {
                case "♙":
                case "♖":
                case "♘":
                case "♗":
                case "♕":
                case "♔":
                    break;
                default:
                    error = 1;
                    break;
            }
        }// fin de las condiciones

        return error;
    }// fin del metodo

    public static int PiezaSeleccionada(String pieza) {
        int n = 0;
        if (pieza.equals("♜") || pieza.equals("♖")) {
            n = 1;
        } else if (pieza.equals("♘") || pieza.equals("♞")) {
            n = 2;
        } else if (pieza.equals("♗") || pieza.equals("♝")) {
            n = 3;
        } else if (pieza.equals("♛") || pieza.equals("♕")) {
            n = 4;
        } else if (pieza.equals("♔") || pieza.equals("♚")) {
            n = 5;
        } else if (pieza.equals("♙") || pieza.equals("♟")) {
            n = 6;
        }

        return n;
    }// que pieza se selecciono

    public static int CreacionMovimiento(int n_pieza, int x, int y, int nuevaX, int nuevaY, boolean jugador) {
        int mov = 0;
        if (n_pieza == 1) {
            movimientos.add(new Torre(x, y, nuevaX, nuevaY));
        } else if (n_pieza == 2) {
            movimientos.add(new Caballo(0, x, y, nuevaX, nuevaY));
        } else if (n_pieza == 3) {
            movimientos.add(new Alfin(x, y, nuevaX, nuevaY));
        } else if (n_pieza == 4) {
            movimientos.add(new Rey(x, y, nuevaX, nuevaY));
        } else if (n_pieza == 5) {
            movimientos.add(new Reina(x, y, nuevaX, nuevaY));
        } else if (n_pieza == 6) {
            movimientos.add(new Peon(nuevaX, nuevaY, x, y, nuevaX, nuevaY));
        }
        // fin condicion

        mov = movimientos.get(movimientos.size() - 1).movimiento(Tablero, jugador);
        System.out.println(mov);
        return mov;
    }// fin del metodo que crea el movimineto

    public static void Movimiento(int n, int x, int y, int nuevaY, int nuevaX, boolean jugador) {
        Tablero[y][x] = "▒";
        switch (n) {
            case 1:
                if (jugador == true) {
                    Tablero[nuevaY][nuevaX] = "♜";
                } else {
                    Tablero[nuevaY][nuevaX] = "♖";
                }
                break;
            case 2:
                if (jugador == true) {
                    Tablero[nuevaY][nuevaX] = "♞";
                } else {
                    Tablero[nuevaY][nuevaX] = "♘";
                }
                break;
            case 3:
                if (jugador == true) {
                    Tablero[nuevaY][nuevaX] = "♝";
                } else {
                    Tablero[nuevaY][nuevaX] = "♗";
                }
                break;
            case 4:
                if (jugador == true) {
                    Tablero[nuevaY][nuevaX] = "♛";
                } else {
                    Tablero[nuevaY][nuevaX] = "♕";
                }
                break;
            case 5:
                if (jugador == true) {
                    Tablero[nuevaY][nuevaX] = "♚";
                } else {
                    Tablero[nuevaY][nuevaX] = "♔";
                }
                break;
            case 6:
                if (jugador == true) {
                    Tablero[nuevaY][nuevaX] = "♟";
                } else {
                    Tablero[nuevaY][nuevaX] = "♙";
                }
                break;
            default:
                break;
        }// fin del caso

        System.out.println("");
        imprimir(Tablero, 0, 0);
    }// fin del metodo

}// fin de la clase
