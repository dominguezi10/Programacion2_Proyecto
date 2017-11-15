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
public class Torre extends Pieza {

    public Torre() {
        super();
    }

    public Torre(int posicionX, int posicionY, int nuevaX, int nuevaY) {
        super(posicionX, posicionY, nuevaX, nuevaY);
    }

    @Override
    public String toString() {
        return "Torre{" + super.toString() + '}';
    }

    //el metodo funciona ya lo probastes!!!
    @Override
    public int movimiento(String[][] matriz, boolean jugador) {
       
        int E1 = 0;
        int error = 0;
        System.out.println(posicionY + "," + posicionX);
        // ver si se puede o no mover
        if (posicionX == 1 && posicionY == 0) {
            if (nuevaY > posicionY && nuevaX == posicionX) {
                E1 = metodo(matriz[posicionY + 1][posicionX], matriz, jugador);
                if (E1 > 0) {
                    return error = 100;
                }
            } else if (nuevaX > posicionX && nuevaY == posicionY) {
                E1 = metodo(matriz[posicionY][posicionX + 1], matriz, jugador);
                if (E1 > 0) {
                    return error = 100;
                }
            }
            // para 0,0
        } else if (posicionY == 0 && (posicionX > 1 && posicionX < matriz.length - 1)) {
            if (nuevaY > posicionY && nuevaX == posicionX) {
                E1 = metodo(matriz[posicionY + 1][posicionX], matriz, jugador);
                if (E1 > 0) {
                    return error = 100;
                }
            } else if (nuevaX > posicionX && nuevaY == posicionY) {
                E1 = metodo(matriz[posicionY][posicionX + 1], matriz, jugador);
                if (E1 > 0) {
                    return error = 100;
                }
            } else if (nuevaX < posicionX && nuevaY == posicionY) {
                E1 = metodo(matriz[posicionY][posicionX - 1], matriz, jugador);
                if (E1 > 0) {
                    return error = 100;
                }
            }
            // y cero y menor al margen
        } else if (posicionY == 0 && posicionX == matriz.length - 1) {
            if (nuevaY > posicionY && nuevaX == posicionX) {
                E1 = metodo(matriz[posicionY + 1][posicionX], matriz, jugador);
                if (E1 > 0) {
                    return error = 100;
                }
            } else if (nuevaX < posicionX && nuevaY == posicionY) {
                E1 = metodo(matriz[posicionY][posicionX - 1], matriz, jugador);
                if (E1 > 0) {
                    return error = 100;
                }
            }
            // y = 0 y ultimo de x
        } else if (posicionY == matriz.length - 2 && posicionX == 1) {
            if (nuevaY < posicionY && nuevaX == posicionX) {
                E1 = metodo(matriz[posicionY - 1][posicionX], matriz, jugador);
                if (E1 > 0) {
                    return error = 100;
                }
            } else if (nuevaY == posicionY && nuevaX > posicionX) {
                E1 = metodo(matriz[posicionY][posicionX + 1], matriz, jugador);
                if (E1 > 0) {
                    return error = 100;
                }
            }
            // esquina inferior
        } else if (posicionY == matriz.length - 2 && posicionX == matriz.length - 1) {
            if (nuevaY < posicionY && nuevaX == posicionX) {
                E1 = metodo(matriz[posicionY - 1][posicionX], matriz, jugador);
                if (E1 > 0) {
                    return error = 100;
                }
            } else if (nuevaY == posicionY && nuevaX < posicionX) {
                E1 = metodo(matriz[posicionY][posicionX - 1], matriz, jugador);
                if (E1 > 0) {
                    return error = 100;
                }
            }
            // esquina inferior dos
        } else if (posicionY == matriz.length - 2 && (posicionX > 1 && posicionX < matriz.length - 1)) {
            if (nuevaY < posicionY && nuevaX == posicionX) {
                E1 = metodo(matriz[posicionY - 1][posicionX], matriz, jugador);
                if (E1 > 0) {
                    return error = 100;
                }
            } else if (nuevaY == posicionY && nuevaX > posicionX) {
                E1 = metodo(matriz[posicionY][posicionX + 1], matriz, jugador);
                if (E1 > 0) {
                    return error = 100;
                }
            } else if (nuevaY == posicionY && nuevaX < posicionX) {
                E1 = metodo(matriz[posicionY][posicionX - 1], matriz, jugador);
                if (E1 > 0) {
                    return error = 100;
                }
            }
            // entre la ultima fila
        } else if ((posicionY > 0 && posicionY < matriz.length - 2) && (posicionX == 1)) {
            if (nuevaX > posicionX && nuevaY == posicionY) {
                E1 = metodo(matriz[posicionY][posicionX + 1], matriz, jugador);
                if (E1 > 0) {
                    return error = 100;
                }
            } else if (nuevaY > posicionY && nuevaX == posicionX) {
                E1 = metodo(matriz[posicionY + 1][posicionX], matriz, jugador);
                if (E1 > 0) {
                    return error = 100;
                }
            } else if (nuevaY < posicionY && nuevaX == posicionX) {
                E1 = metodo(matriz[posicionY - 1][posicionX], matriz, jugador);
                if (E1 > 0) {
                    return error = 100;
                }
            }
            // margen izquierdo
        } else if ((posicionY > 0 && posicionY < matriz.length - 2) && (posicionX == matriz.length - 1)) {
            if (nuevaX < posicionX && nuevaY == posicionY) {
                E1 = metodo(matriz[posicionY][posicionX - 1], matriz, jugador);
                if (E1 > 0) {
                    return error = 100;
                }
            } else if (nuevaY > posicionY && nuevaX == posicionX) {
                E1 = metodo(matriz[posicionY + 1][posicionX], matriz, jugador);
                if (E1 > 0) {
                    return error = 100;
                }
            } else if (nuevaY < posicionY && nuevaX == posicionX) {
                E1 = metodo(matriz[posicionY - 1][posicionX], matriz, jugador);
                if (E1 > 0) {
                    return error = 100;
                }
            }
            // margen derecho
        } else if ((posicionY > 0 && posicionY < matriz.length - 2)
                && (posicionX > 1 && posicionX < matriz.length - 1)) {
            if (nuevaY > posicionY && posicionX == nuevaX) {
                E1 = metodo(matriz[posicionY + 1][posicionX], matriz, jugador);
                if (E1 > 0) {
                    return error = 100;
                }
            } else if (nuevaY < posicionY && nuevaX == posicionX) {
                E1 = metodo(matriz[posicionY - 1][posicionX], matriz, jugador);
                if (E1 > 0) {
                    return error = 100;
                }
            } else if ((nuevaX > posicionX) && (nuevaY == posicionY)) {
                E1 = metodo(matriz[posicionY][posicionX + 1], matriz, jugador);
                if (E1 > 0) {
                    return error = 100;
                }
            } else if ((nuevaX < posicionX) && (nuevaY == posicionY)) {
                E1 = metodo(matriz[posicionY][posicionX - 1], matriz, jugador);
                if (E1 > 0) {
                    return error = 100;
                }
            }
            // si la torre esta en posiciones del centro
        }// fin de la validacion

        // movimiento que sea correcto
        if ((posicionX < nuevaX || posicionX > nuevaX) && nuevaY != posicionY) {
            error = 1;
            System.out.println("erooooo1");
        } else if ((posicionY < nuevaY || posicionY > nuevaY) && nuevaX != posicionX) {
            error = 1;
            System.out.println("erooooo2");
        } else {
            String piezaS = matriz[nuevaY][nuevaX];
            error = metodo(piezaS, matriz, jugador);
            System.out.println("er 3" + error);
        }

        if (error == 0) {
            boolean Contrincante;
            if (jugador == true) {
                Contrincante = false;
            } else {
                Contrincante = true;
            }

            if (nuevaY > posicionY && nuevaX == posicionX) {
                for (int i = 1; i <= (nuevaY - posicionY) - 1; i++) {
                    if (metodo(matriz[posicionY + i][posicionX], matriz, jugador) != 0
                            || metodo(matriz[posicionY + i][posicionX], matriz, Contrincante) != 0) {
                        error = 1;
                    }
                }
            } else if (nuevaY < posicionY && nuevaX == posicionX) {
                for (int i = 1; i <= (posicionY - nuevaY) - 1; i++) {
                    if (metodo(matriz[posicionY - i][posicionX], matriz, jugador) != 0
                            || metodo(matriz[posicionY - i][posicionX], matriz, Contrincante) != 0) {
                        error = 1;
                    }
                }
            } else if (nuevaY == posicionY && nuevaX > posicionX) {
                for (int i = 1; i <= (nuevaX - posicionX) - 1; i++) {
                    if (metodo(matriz[posicionY][posicionX+i], matriz, jugador) != 0
                            || metodo(matriz[posicionY][posicionX + i], matriz, Contrincante) != 0) {
                        error = 1;
                    }
                }
            }else if (nuevaY == posicionY && nuevaX < posicionX) {
                for (int i = 1; i <= (posicionX - nuevaX) - 1; i++) {
                    if (metodo(matriz[posicionY][posicionX-i], matriz, jugador) != 0
                            || metodo(matriz[posicionY][posicionX - i], matriz, Contrincante) != 0) {
                        error = 1;
                    }
                }
            }
        }// fin de la condicion

        if (error == 0) {
            String piezaSe = matriz[nuevaY][nuevaX];
            error = metodo(piezaSe, matriz, jugador);
        }
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
        
        
        System.out.println("erni "+ error);
        return error;
    }// fin del metodo

}
