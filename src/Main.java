package src.edd;

import java.util.Iterator;

/**
 * Clase de prueba de los metodos de arboles
 */
public class Main {
    public static void main(String[] args) {
        
        /*ArbolBinarioBusqueda<Jugador> arbol=new ArbolBinarioBusqueda<Jugador>();
        Jugador jugador=new Jugador("nombre", "contraseña");
        arbol.add(jugador);
        System.out.println(arbol);*/

        Jugador j=new  Jugador("hola", "hola");
        Jugador a=new  Jugador("hola", "hola");
        System.out.println(j.equals(a));
        
    }
}
