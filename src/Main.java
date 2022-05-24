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

        /*Jugador j=new  Jugador("hola", "hola");
        Jugador a=new  Jugador("hola", "hola");
        System.out.println(j.equals(a));*/

        Lista<Integer> lista=new Lista<Integer>();
        lista.add(1);
        lista.add(2);
        lista.add(3);
        lista.add(4);
        lista.add(5);
        lista.add(6);
        lista.add(7);
        System.out.println(lista);
        lista.shuffle();
        System.out.println(lista);
        
        
    }
}
