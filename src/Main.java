package src.edd;

import java.util.Iterator;

import org.w3c.dom.ls.LSException;

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
        //System.out.println(lista);
        lista.shuffle();
        System.out.println(lista);
        Iterator<Integer> iterador=lista.iterator();
        for(int i=0;i<7;i++){
            //System.out.println(iterador.next());
        }

        /*Lista<Candidato> candidatos=new Lista<Candidato>();
        int contador=40;//contador para asignar habilidad a cada candidato
        //Creamos a los candidatos y los ponemos en la lista
        for(int i=0;i<16;i++){
            Candidato c=new Candidato(i+1, contador+15);
            candidatos.add(c);
            contador+=15;
        }
        Iterator<Candidato> it=candidatos.iterator();
        //Llenar el historial de posiciones de cada candidato
        for(int i=0;i<5;i++){
            candidatos.shuffle();
            System.out.println(candidatos.size());
            for(int j=0;j<10;j++){
                Candidato actual=it.next();
                System.out.println(actual.num);
                actual.historialPosiciones.add(j+1);
            }
            for(int j=9;j<17;j++){
                Candidato actual=it.next();
                actual.historialPosiciones.add(j+1);
            }
            it=candidatos.iterator();
        }*/
        
        
    }
}
