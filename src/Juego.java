package src.edd;
import java.io.Serializable;
import java.util.Iterator;

/**
 * Clase para crear un juego con usuarios y candidatos
 */
public class Juego implements Serializable{

    ArbolBinarioBusqueda<Jugador> arbol;//el arbol de usuarios
    Lista<Candidato> candidatos;//La lista de candidatos que son los posibles jugadores

    /**
     * Constructor del juego
     */
    public Juego(){
        arbol=new ArbolBinarioBusqueda<Jugador>();//creamos el arbol de usuarios
        candidatos=new Lista<Candidato>();//creamos la lista de candidatos
        agregaCandidatos();//Agregamos los candidatos a la lista de candidatos
    }

    /**
     * Metodo para añadir un jugador al arbol de usuarios
     * @param nuevo
     */
    public void addJugador(Jugador nuevo){
        arbol.add(nuevo);
    }

    /**
     * Metodo para buscar un jugador en el arbol de usuarios
     * @param j
     * @return
     */
    public boolean buscar(Jugador j){
        return arbol.buscaElemento(j);
    }

    /**
     * Metodo que regresa al jugador si la contraseña es correcta, regresa null en otro caso
     * @param password
     * @param j
     * @return
     */
    public Jugador verificaPassword(String password, Jugador j){
        Jugador jugador=arbol.elemEnVertice(j);
        if(jugador.key.equals(password)){
            return jugador;
        }else{
            return null;
        }
    }

    /**
     * Metodo para agregar candidatos a la lista de candidatos
     */
    public void agregaCandidatos(){
        
        int contador=40;//contador para asignar habilidad a cada candidato
        //Creamos a los candidatos y los ponemos en la lista
        for(int i=0;i<16;i++){
            Candidato c=new Candidato(i+1, contador+15);
            candidatos.add(c);
            contador+=15;
        }
        Iterator<Candidato> iterador=candidatos.iterator();
        //Llenar el historial de posiciones de cada candidato
        for(int i=0;i<5;i++){
            candidatos.shuffle();
            for(int j=0;j<10;j++){
                Candidato actual=iterador.next();
                //System.out.println(actual);
                actual.historialPosiciones.add(j+1);
            }
            for(int j=10;j<16;j++){
                Candidato actual=iterador.next();
                //System.out.println(actual);
                actual.historialPosiciones.add(j+1);
            }
            iterador=candidatos.iteradorLista();
        }
    }

}
