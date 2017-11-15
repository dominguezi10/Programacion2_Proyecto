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
public class Reina extends Pieza {

    public Reina() {
        super();
    }

    public Reina(int posicionX, int posicionY, int nuevaX, int nuevaY) {
        super(posicionX, posicionY, nuevaX, nuevaY);
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

    @Override
    public String toString() {
        return "Reina{" + super.toString() + '}';
    }

    @Override
    public int movimiento(String[][] matriz, boolean jugador) {
        int error = 1;
        int E1 = 0;
        // para ver si se puede o no mover
        if (posicionY == 0 && posicionX == 1) {
            if (nuevaY > posicionY && nuevaX > posicionX) {
                E1 = metodo(matriz[posicionY + 1][posicionX + 1], matriz, jugador);
                if (E1 > 0) {
                    return error = 100;
                }
            }else if(nuevaY >  posicionY && nuevaX == posicionX){
                E1 = metodo(matriz[posicionY + 1][posicionX], matriz, jugador);
                if (E1 > 0) {
                    return error = 100;
                }
            }else if(nuevaY == posicionY && nuevaX > posicionX){
                E1 = metodo(matriz[posicionY][posicionX+1], matriz, jugador);
                if (E1 > 0) {
                    return error = 100;
                }
            }
            // esquina
        } else if (posicionY == 0 && posicionX == matriz.length - 1) {
            if (nuevaY > posicionY && nuevaX < posicionX) {
                E1 = metodo(matriz[posicionY + 1][posicionX - 1], matriz, jugador);
                if (E1 > 0) {
                    return error = 100;
                }
            }else if(nuevaY >  posicionY && nuevaX == posicionX){
                E1 = metodo(matriz[posicionY + 1][posicionX], matriz, jugador);
                if (E1 > 0) {
                    return error = 100;
                }
            }else if(nuevaY == posicionY && nuevaX < posicionX){
                E1 = metodo(matriz[posicionY][posicionX-1], matriz, jugador);
                if (E1 > 0) {
                    return error = 100;
                }
            }
            // esquina superior derecha
        } else if (posicionY == matriz.length - 2 && posicionX == 1) {
            if (nuevaY < posicionY && nuevaX > posicionX) {
                E1 = metodo(matriz[posicionY - 1][posicionX + 1], matriz, jugador);
                if (E1 > 0) {
                    return error = 100;
                }
            }else if(nuevaY <  posicionY && nuevaX == posicionX){
                E1 = metodo(matriz[posicionY - 1][posicionX], matriz, jugador);
                if (E1 > 0) {
                    return error = 100;
                }
            }else if(nuevaY == posicionY && nuevaX > posicionX){
                E1 = metodo(matriz[posicionY][posicionX+1], matriz, jugador);
                if (E1 > 0) {
                    return error = 100;
                }
            }
            // esquina inferior izquierda
        } else if (posicionY == matriz.length - 2 && posicionX == matriz.length - 1) {
            if (nuevaY < posicionY && nuevaX < posicionX) {
                E1 = metodo(matriz[posicionY - 1][posicionX - 1], matriz, jugador);
                if (E1 > 0) {
                    return error = 100;
                }
            }else if(nuevaY <  posicionY && nuevaX == posicionX){
                E1 = metodo(matriz[posicionY - 1][posicionX], matriz, jugador);
                if (E1 > 0) {
                    return error = 100;
                }
            }else if(nuevaY == posicionY && nuevaX < posicionX){
                E1 = metodo(matriz[posicionY][posicionX-1], matriz, jugador);
                if (E1 > 0) {
                    return error = 100;
                }
            }
            // esquina inferior derecha
        } else if ((posicionY > 0 && posicionY < matriz.length - 2) && (posicionX > 1 && posicionX < matriz.length - 1)) {
            if ((nuevaY > posicionY) && (nuevaX > posicionX)) {
                E1 = metodo(matriz[posicionY + 1][posicionX + 1], matriz, jugador);
                if (E1 > 0) {
                    return error = 100;
                }
            } else if ((nuevaY > posicionY) && (nuevaX < posicionX)) {
                E1 = metodo(matriz[posicionY + 1][posicionX - 1], matriz, jugador);
                if (E1 > 0) {
                    return error = 100;
                }
            } else if ((nuevaY < posicionY) && (nuevaX > posicionX)) {
                E1 = metodo(matriz[posicionY - 1][posicionX + 1], matriz, jugador);
                if (E1 > 0) {
                    return error = 100;
                }
            } else if ((nuevaY < posicionY) && (nuevaX < posicionX)) {
                E1 = metodo(matriz[posicionY - 1][posicionX - 1], matriz, jugador);
                if (E1 > 0) {
                    return error = 100;
                }
            }else if(nuevaY >  posicionY && nuevaX == posicionX){
                E1 = metodo(matriz[posicionY + 1][posicionX], matriz, jugador);
                if (E1 > 0) {
                    return error = 100;
                }
            }else if(nuevaY == posicionY && nuevaX > posicionX){
                E1 = metodo(matriz[posicionY][posicionX+1], matriz, jugador);
                if (E1 > 0) {
                    return error = 100;
                }
            }else if(nuevaY <  posicionY && nuevaX == posicionX){
                E1 = metodo(matriz[posicionY - 1][posicionX], matriz, jugador);
                if (E1 > 0) {
                    return error = 100;
                }
            }else if(nuevaY == posicionY && nuevaX < posicionX){
                E1 = metodo(matriz[posicionY][posicionX-1], matriz, jugador);
                if (E1 > 0) {
                    return error = 100;
                }
            }
            // si esta en el centro
        } else if (posicionY == 0 && (posicionX > 1 && posicionX < matriz.length - 1)) {
            if (nuevaY > posicionY && nuevaX < posicionX) {
                E1 = metodo(matriz[posicionY + 1][posicionX - 1], matriz, jugador);
                if (E1 > 0) {
                    return error = 100;
                }
            } else if (nuevaY > posicionY && nuevaX > posicionX) {
                E1 = metodo(matriz[posicionY + 1][posicionX + 1], matriz, jugador);
                if (E1 > 0) {
                    return error = 100;
                }
            }else if(nuevaY >  posicionY && nuevaX == posicionX){
                E1 = metodo(matriz[posicionY + 1][posicionX], matriz, jugador);
                if (E1 > 0) {
                    return error = 100;
                }
            }else if(nuevaY == posicionY && nuevaX > posicionX){
                E1 = metodo(matriz[posicionY][posicionX+1], matriz, jugador);
                if (E1 > 0) {
                    return error = 100;
                }
            }else if(nuevaY == posicionY && nuevaX < posicionX){
                E1 = metodo(matriz[posicionY][posicionX-1], matriz, jugador);
                if (E1 > 0) {
                    return error = 100;
                }
            }
            // validacio de la primera linea
        } else if (posicionY == matriz.length - 2 && (posicionX > 1 && posicionX < matriz.length - 1)) {
            if (nuevaY < posicionY && nuevaX < posicionX) {
                E1 = metodo(matriz[posicionY - 1][posicionX - 1], matriz, jugador);
                if (E1 > 0) {
                    return error = 100;
                }
            } else if (nuevaY < posicionY && nuevaX > posicionX) {
                E1 = metodo(matriz[posicionY - 1][posicionX + 1], matriz, jugador);
                if (E1 > 0) {
                    return error = 100;
                }
            }else if(nuevaY == posicionY && nuevaX > posicionX){
                E1 = metodo(matriz[posicionY][posicionX+1], matriz, jugador);
                if (E1 > 0) {
                    return error = 100;
                }
            }else if(nuevaY == posicionY && nuevaX < posicionX){
                E1 = metodo(matriz[posicionY][posicionX-1], matriz, jugador);
                if (E1 > 0) {
                    return error = 100;
                }
            }else if(nuevaY < posicionY && nuevaX == posicionX){
                E1 = metodo(matriz[posicionY+1][posicionX], matriz, jugador);
                if (E1 > 0) {
                    return error = 100;
                }
            }
            // validacion de la ultima linea
        }// fin de la condicion

        int n1 = nuevaY - posicionY;
        int n2 = nuevaX - posicionX;
        if (n1 < 0) {
            n1 = n1 * (-1);
        }

        if (n2 < 0) {
            n2 = n2 * (-1);
        }

        if (n1 == n2) {
            error = 0;
            String piezaS = matriz[nuevaY][nuevaX];
            error = metodo(piezaS, matriz, jugador);
            if (error == 0) {
                boolean Contrincante;
                if (jugador == true) {
                    Contrincante = false;
                } else {
                    Contrincante = true;
                }
                if (nuevaX < posicionX && nuevaY > posicionY) {
                    for (int i = 1; i <= (nuevaY - posicionY) - 1; i++) {
                        if (metodo(matriz[posicionY + i][posicionX - i], matriz, jugador) != 0
                                || metodo(matriz[posicionY + i][posicionX - i], matriz, Contrincante) != 0) {
                            error = 1;
                        }
                    }// fin del for
                } else if (nuevaX > posicionX && nuevaY > posicionY) {
                    for (int i = 1; i <= (nuevaY - posicionY) - 1; i++) {
                        if (metodo(matriz[posicionY + i][posicionX + i], matriz, jugador) != 0
                                || metodo(matriz[posicionY + i][posicionX - i], matriz, Contrincante) != 0) {
                            error = 1;
                        }
                    }// fin del for
                } else if (nuevaX < posicionX && nuevaY < posicionY) {
                    for (int i = 1; i <= (posicionY - nuevaY) - 1; i++) {
                        if (metodo(matriz[posicionY - i][posicionX - i], matriz, jugador) != 0
                                || metodo(matriz[posicionY + i][posicionX - i], matriz, Contrincante) != 0) {
                            error = 1;
                        }
                    }// fin del for
                } else if (nuevaX > posicionX && nuevaY < posicionY) {
                    for (int i = 1; i <= (posicionY - nuevaY) - 1; i++) {
                        if (metodo(matriz[posicionY - i][posicionX + i], matriz, jugador) != 0
                                || metodo(matriz[posicionY + i][posicionX - i], matriz, Contrincante) != 0) {
                            System.out.println(matriz[posicionY - i][posicionX + i]);
                            error = 1;
                        }
                    }// fin del for
                }
            }// fin de la condicion

        }else{
            // validacion como si se fuera a mover como torre
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
            }// fin
            
            
            
        }// fin de la condicon

        if (error == 0) {
            String pieza = matriz[nuevaY][nuevaY];
            error = metodo(pieza, matriz, jugador);
            return error;
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

        return error;
    }// fin del metodo

}
