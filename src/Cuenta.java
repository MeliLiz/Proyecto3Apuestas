package src.edd;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.io.Serializable;

public class Cuenta implements Serializable{
    private int saldoDisponible;//Saldo disponible
    Lista<String> movimientos;//Historial de movimientos
    int numeroDeApuesta;//Num de apuesta jugada
    Lista<String> apuestasGanadas;//Apuestas que se han ganado
    Lista<String> apuestasPerdidas;//Apuestas que se han perdido
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");


    /**
     * Constructor de una cuenta
     */
    public Cuenta(){
        saldoDisponible=0;//Saldo inicial 0
        movimientos=new Lista<String>();//creamos lista de historial
        movimientos.add("Creacion de cuenta: "+dtf.format(LocalDateTime.now()));//agregamos la creacion de la cuenta al historial
        apuestasGanadas=new Lista<String>();//Creamos la lista de apuestas ganadas
        apuestasPerdidas=new Lista<String>();//Creamos la lista de apuestas perdidas
        numeroDeApuesta=0;//Aun no se han hecho apuestas
    }//FIN DE CONSTRUCTOR 1

    /**
     * Metodo para depositar dinero a la cuenta
     * @param n
     * @return boolean false si no se pudo hacer el deposito, true si se realizó existosamente
     */
    public boolean depositar(int n){
        if(n<0){//No se puede depositar saldo negativo
            return false;
        }else{
            saldoDisponible+=n;
            movimientos.add("Deposito de $"+n+" "+dtf.format(LocalDateTime.now()));//registramos el movimiento en el historial
            return true;
        }
    }//FIN DE DEPOSITAR

    /**
     * Metodo para retirar dinero de la cuenta
     * @param n
     * @return boolean true si se realizó exitosamente, false si no se pudo
     */
    public boolean retirar(int n){
        if(n<0||n>saldoDisponible){//Si el numero es negativo o el saldo disponible no alcanza
            return false;
        }else{
            saldoDisponible-=n;
            movimientos.add("Retiro de $"+n+" "+dtf.format(LocalDateTime.now()));//registramos el movimiento en el historial
            return true;
        }
    }//FIN DE RETIRAR

    /**
     * Metodo para apostar. Similar a retirar pero el historial se registra diferente
     * @param n
     * @return
     */
    public boolean apostar(int n){
        if(n<0||n>saldoDisponible){
            return false;
        }else{
            saldoDisponible-=n;
            movimientos.add("Apuesta de $"+n+" "+dtf.format(LocalDateTime.now()));//registramos el movimiento en el historial
            return true;
        }
    }// FIN DE APOSTAR

    /**
     * Metodo para consultar el saldo disponible
     * @return
     */
    public int consultarSaldo(){
        return saldoDisponible;
    }//FIN DE CONSULTAR SALDO

    /**
     * Metodo para depositar el dinero ganado de la carrera
     * @param ganado
     * @param apostado
     */
    public void agregarGanada(int ganado, int apostado){
        depositar(ganado);
        String s="Apostado: "+apostado+" Gana: "+ganado+" . Día: "+dtf.format(LocalDateTime.now());//registramos el movimiento en el historial
        apuestasGanadas.add(s);
    }// FIN DE AGREGAR GANADA

    /**
     * Metodo para registrar la perdida de la carrera
     * @param perdido
     */
    public void agregarPerdida(int perdido){
        String s="Perdido: "+perdido+" . Día: "+dtf.format(LocalDateTime.now());//registramos el movimiento en el historial
        apuestasPerdidas.add(s);
    }//FIN DE AGREGAR PERDIDA
}
