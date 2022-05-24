package src.edd;
import java.io.Serializable;
public class Candidato implements Serializable {

    int num;//El numero de candidato
    int habilidad;
    Lista<Integer> historialPosiciones;//el historial de posiciones
    int cuota;
    

    public Candidato(int numCandidato, int habilidad){
        /*historialPosiciones.add(n1);
        historialPosiciones.add(n2);
        historialPosiciones.add(n3);
        historialPosiciones.add(n4);
        historialPosiciones.add(n5);*/
        num=numCandidato;
        this.habilidad=habilidad;
    }

    public int calcularCuota(){

    }
}
