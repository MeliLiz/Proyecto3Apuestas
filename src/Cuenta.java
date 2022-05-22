package src.edd;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Cuenta {
    private int saldoDisponible;
    Lista<String> movimientos;
    Lista<String> apuestasGanadas;
    Lista<String> apuestasPerdidas;
    int numeroDeApuesta;
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");

    public Cuenta(){
        saldoDisponible=0;
        movimientos=new Lista<String>();
        movimientos.add("Creacion de cuenta: "+dtf.format(LocalDateTime.now()));
        apuestasGanadas=new Lista<String>();
        apuestasPerdidas=new Lista<String>();
        numeroDeApuesta=0;
    }//FIN DE CONSTRUCTOR 1

    public Cuenta(int n){
        saldoDisponible=n;
    }//FIN DE CONSTRUCTOR 2

    public boolean depositar(int n){
        if(n<0){
            return false;
        }else{
            saldoDisponible+=n;
            movimientos.add("Deposito de $"+n+" "+dtf.format(LocalDateTime.now()));
            return true;
        }
    }//FIN DE DEPOSITAR

    public boolean retirar(int n){
        if(n<0||n>saldoDisponible){
            return false;
        }else{
            saldoDisponible-=n;
            movimientos.add("Retiro de $"+n+" "+dtf.format(LocalDateTime.now()));
            return true;
        }
    }//FIN DE RETIRAR

    public boolean apostar(int n){
        if(n<0||n>saldoDisponible){
            return false;
        }else{
            saldoDisponible-=n;
            movimientos.add("Apuesta de $"+n+" "+dtf.format(LocalDateTime.now()));
            return true;
        }
    }// FIN DE APOSTAR

    public int consultarSaldo(){
        return saldoDisponible;
    }//FIN DE CONSULTAR SALDO

    public void agregarGanada(int ganado, int apostado){
        depositar(ganado);
        String s="Apostado: "+apostado+" Gana: "+ganado+" . Día: "+dtf.format(LocalDateTime.now());
        apuestasGanadas.add(s);
    }// FIN DE AGREGAR GANADA

    public void agregarPerdida(int perdido){
        String s="Perdido: "+perdido+" . Día: "+dtf.format(LocalDateTime.now());
        apuestasPerdidas.add(s);
    }//FIN DE AGREGAR PERDIDA
}
