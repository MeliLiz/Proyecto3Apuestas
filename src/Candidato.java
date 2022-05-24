package src.edd;
import java.io.Serializable;

/**
 * Clase de candidatos a jugadores
 */
public class Candidato implements Serializable {

    int num;//El numero de candidato
    int habilidad;//La habilidad del candidato
    int cuota;//La cuota por apostar por este candidato
    Lista<Integer> historialPosiciones;//el historial de posiciones
    
    
    /**
     * Constructor del candidato
     * @param numCandidato
     * @param habilidad
     */
    public Candidato(int numCandidato, int habilidad){
        /*historialPosiciones.add(n1);
        historialPosiciones.add(n2);
        historialPosiciones.add(n3);
        historialPosiciones.add(n4);
        historialPosiciones.add(n5);*/
        num=numCandidato;
        this.habilidad=habilidad;
    }

    /**
     * Metodo para calcular la cuota 
     * @return
     */
    public int calcularCuota(){
        //Por hacer
    }
}
