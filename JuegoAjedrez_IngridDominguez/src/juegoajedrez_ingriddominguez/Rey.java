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
public class Rey extends Pieza {

    public Rey() {
        super();
    }

    public Rey(int posicionX, int posicionY, int nuevaX, int nuevaY) {
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
        return "Rey{" + super.toString() + '}';
    }

    @Override
    public int movimiento(String[][] matriz, boolean jugador) {
        int error = 0;
        int E1 = 0;

        
        if (posicionY == 0 && posicionX == 1) {
            if ((nuevaY - posicionY == 1) && nuevaX == posicionX) {
                E1 = metodo(matriz[nuevaY][nuevaX], matriz, jugador);
                if (E1 > 0) {
                    return error = 100;
                }
            } else if (nuevaY - posicionY == 1 && nuevaY - posicionX == 1) {
                E1 = metodo(matriz[nuevaY][nuevaX], matriz, jugador);
                if (E1 > 0) {
                    return error = 100;
                }
            }else if(nuevaY == posicionY  && nuevaX - posicionX == 1){
                E1 = metodo(matriz[nuevaY][nuevaX], matriz, jugador);
                if (E1 > 0) {
                    return error = 100;
                }
            }else {
                error = 1;
            }
            // primera esquina
        } else if (posicionY == 0 && (posicionX > 1 && posicionX < matriz.length - 1)) {
            if (nuevaY == posicionY && (nuevaX - posicionX == 1)) {
                E1 = metodo(matriz[nuevaY][nuevaX], matriz, jugador);
                if (E1 > 0) {
                    return error = 100;
                }
            } else if (nuevaY == posicionY && (posicionX - nuevaX == 1)) {
                E1 = metodo(matriz[nuevaY][nuevaX], matriz, jugador);
                if (E1 > 0) {
                    return error = 100;
                }
            } else if (nuevaY - posicionY == 1 && (nuevaX == posicionX)) {
                E1 = metodo(matriz[nuevaY][nuevaX], matriz, jugador);
                if (E1 > 0) {
                    return error = 100;
                }
            } else if (nuevaY - posicionY == 1 && posicionX - nuevaX == 1) {
                E1 = metodo(matriz[nuevaY][nuevaX], matriz, jugador);
                if (E1 > 0) {
                    return error = 100;
                }
            } else if (nuevaY - posicionY == 1 && nuevaX - posicionX == 1) {
                E1 = metodo(matriz[nuevaY][nuevaX], matriz, jugador);
                if (E1 > 0) {
                    return error = 100;
                }
            } else {
                error = 1;
            }
            // primera linea
        } else if (posicionY == 0 && posicionX == matriz.length - 1) {
            if (nuevaY - posicionY == 1 && posicionX == nuevaX) {
                E1 = metodo(matriz[nuevaY][nuevaX], matriz, jugador);
                if (E1 > 0) {
                    return error = 100;
                }
            } else if (posicionY == nuevaY && posicionX - nuevaX == 1) {
                E1 = metodo(matriz[nuevaY][nuevaX], matriz, jugador);
                if (E1 > 0) {
                    return error = 100;
                }
            } else if (nuevaY - posicionY == 1 && posicionX - nuevaX == 1) {
                E1 = metodo(matriz[nuevaY][nuevaX], matriz, jugador);
                if (E1 > 0) {
                    return error = 100;
                }
            } else {
                error = 1;
            }
            //segunda esquina
        } else if (posicionY == matriz.length - 2 && posicionX == 1) {
            if (posicionY - nuevaY == 1 && (nuevaX == posicionX)) {
                E1 = metodo(matriz[nuevaY][nuevaX], matriz, jugador);
                if (E1 > 0) {
                    return error = 100;
                }
            } else if (posicionY == nuevaY && (nuevaX - posicionX == 1)) {
                E1 = metodo(matriz[nuevaY][nuevaX], matriz, jugador);
                if (E1 > 0) {
                    return error = 100;
                }
            } else if (posicionY - nuevaY == 1 && nuevaX - posicionX == 1) {
                E1 = metodo(matriz[nuevaY][nuevaX], matriz, jugador);
                if (E1 > 0) {
                    return error = 100;
                }
            } else {
                error = 1;
            }
            // esquina inferior
        } else if (posicionY == matriz.length - 2 && (posicionX > 1 && posicionX < matriz.length - 1)) {
            if (nuevaY == posicionY && (nuevaX - posicionX == 1)) {
                E1 = metodo(matriz[nuevaY][nuevaX], matriz, jugador);
                if (E1 > 0) {
                    return error = 100;
                }
            } else if (nuevaY == posicionY && (posicionX - nuevaX == 1)) {
                E1 = metodo(matriz[nuevaY][nuevaX], matriz, jugador);
                if (E1 > 0) {
                    return error = 100;
                }
            } else if (nuevaX == posicionX && (posicionY - nuevaY == 1)) {
                E1 = metodo(matriz[nuevaY][nuevaX], matriz, jugador);
                if (E1 > 0) {
                    return error = 100;
                }
            } else if (posicionY - nuevaY == 1 && posicionX - nuevaX == 1) {
                E1 = metodo(matriz[nuevaY][nuevaX], matriz, jugador);
                if (E1 > 0) {
                    return error = 100;
                }
            } else if (posicionY - nuevaY == 1 && nuevaX - posicionX == 1) {
                E1 = metodo(matriz[nuevaY][nuevaX], matriz, jugador);
                if (E1 > 0) {
                    return error = 100;
                }
            } else {
                error = 1;
            }
            // fila inferior
        } else if (posicionY == matriz.length - 2 && (posicionX == matriz.length - 1)) {
            if (posicionY - nuevaY == 1 && (nuevaX == posicionX)) {
                E1 = metodo(matriz[nuevaY][nuevaX], matriz, jugador);
                if (E1 > 0) {
                    return error = 100;
                }
            } else if (posicionY == nuevaY && (posicionX - nuevaX == 1)) {
                E1 = metodo(matriz[nuevaY][nuevaX], matriz, jugador);
                if (E1 > 0) {
                    return error = 100;
                }
            } else if (posicionY - nuevaY == 1 && posicionX - nuevaX == 1) {
                E1 = metodo(matriz[nuevaY][nuevaX], matriz, jugador);
                if (E1 > 0) {
                    return error = 100;
                }
            } else {
                error = 1;
            }
            // ultima esquina
        } else if ((posicionY > 0 && posicionY < matriz.length - 2) && posicionX == 0) {
            if (posicionY - nuevaY == 1 && nuevaX == posicionX) {
                E1 = metodo(matriz[nuevaY][nuevaX], matriz, jugador);
                if (E1 > 0) {
                    return error = 100;
                }
            } else if (nuevaY - posicionY == 1 && nuevaX == posicionX) {
                E1 = metodo(matriz[nuevaY][nuevaX], matriz, jugador);
                if (E1 > 0) {
                    return error = 100;
                }
            } else if (nuevaY == posicionY && (nuevaX - posicionX == 1)) {
                E1 = metodo(matriz[nuevaY][nuevaX], matriz, jugador);
                if (E1 > 0) {
                    return error = 100;
                }
            } else if (posicionX - nuevaX == 1 && nuevaX - posicionX == 1) {
                E1 = metodo(matriz[nuevaY][nuevaX], matriz, jugador);
                if (E1 > 0) {
                    return error = 100;
                }
            } else if (nuevaY - posicionY == 1 && nuevaX - posicionX == 1) {
                E1 = metodo(matriz[nuevaY][nuevaX], matriz, jugador);
                if (E1 > 0) {
                    return error = 100;
                }
            } else {
                error = 1;
            }
            // primera columna
        } else if ((posicionY > 0 && posicionY < matriz.length - 2) && posicionX == matriz.length - 1) {
            if (posicionY - nuevaY == 1 && nuevaX == posicionX) {
                E1 = metodo(matriz[nuevaY][nuevaX], matriz, jugador);
                if (E1 > 0) {
                    return error = 100;
                }
            } else if (nuevaY - posicionY == 1 && nuevaX == posicionX) {
                E1 = metodo(matriz[nuevaY][nuevaX], matriz, jugador);
                if (E1 > 0) {
                    return error = 100;
                }
            } else if (nuevaY == posicionY && (posicionX - nuevaX == 1)) {
                E1 = metodo(matriz[nuevaY][nuevaX], matriz, jugador);
                if (E1 > 0) {
                    return error = 100;
                }
            } else if (posicionY - nuevaY == 1 && posicionX - nuevaX == 1) {
                E1 = metodo(matriz[nuevaY][nuevaX], matriz, jugador);
                if (E1 > 0) {
                    return error = 100;
                }
            } else if (nuevaY - posicionY == 1 && posicionX - nuevaX == 1) {
                E1 = metodo(matriz[nuevaY][nuevaX], matriz, jugador);
                if (E1 > 0) {
                    return error = 100;
                }
            } else {
                error = 1;
            }
            // ultima columna
        } else if ((posicionY > 0 && posicionY < matriz.length - 2)
                && (posicionX > 1 && posicionY < matriz.length - 1)) {
            if (posicionY - nuevaY == 1 && posicionX == nuevaX) {
                E1 = metodo(matriz[nuevaY][nuevaX], matriz, jugador);
                if (E1 > 0) {
                    return error = 100;
                }
            }else if(posicionY - nuevaY == 1 && posicionX - nuevaX == 1){
                E1 = metodo(matriz[nuevaY][nuevaX], matriz, jugador);
                if (E1 > 0) {
                    return error = 100;
                }
            }else if(posicionY - nuevaY == 1 && nuevaX - posicionX == 1){
                E1 = metodo(matriz[nuevaY][nuevaX], matriz, jugador);
                if (E1 > 0) {
                    return error = 100;
                }
            }else if(nuevaY == posicionY && nuevaX - posicionX == 1){
                E1 = metodo(matriz[nuevaY][nuevaX], matriz, jugador);
                if (E1 > 0) {
                    return error = 100;
                }
            }else if(nuevaY == posicionY && posicionX - nuevaX == 1){
                E1 = metodo(matriz[nuevaY][nuevaX], matriz, jugador);
                if (E1 > 0) {
                    return error = 100;
                }
            }else if(nuevaY - posicionY == 1 && nuevaX == posicionX ){
                E1 = metodo(matriz[nuevaY][nuevaX], matriz, jugador);
                if (E1 > 0) {
                    return error = 100;
                }
            }else if(nuevaY - posicionY == 1 && nuevaX- posicionX ==1 ){
                E1 = metodo(matriz[nuevaY][nuevaX], matriz, jugador);
                if (E1 > 0) {
                    return error = 100;
                }
            }else if(nuevaY - posicionY == 1 && posicionX - nuevaX ==1 ){
                E1 = metodo(matriz[nuevaY][nuevaX], matriz, jugador);
                if (E1 > 0) {
                    return error = 100;
                }
            }else {
                error = 1;
            }
        }// fin

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
