package src.edd;
import java.lang.Comparable;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Jugador implements Comparable{
    String nombreUsuario;
    Cuenta cuenta;
    String key;

    /**
     * Costructor
     * @param nombre El nombre se usuario
     * @param key La contraseña de la cuenta
     */
    public Jugador(String nombre, String key){
        nombreUsuario=nombre;
        cuenta=new Cuenta();
        this.key=key;
    }//FIN DE CONSTRUCTOR

    public void ajustesCuenta(){
        Scanner sc=new Scanner(System.in);
        System.out.println("*************Ajustes de cuenta********");
        boolean incorrecto=true;
        while(incorrecto){
            System.out.println("¿Qué deseas hacer?");
            System.out.println("1) Consultar saldo");
            System.out.println("2) Depositar");
            System.out.println("3) Retirar");
            System.out.println("4) Consultar historial de movimentos");
            System.out.println("5) Ver apuestas ganadas");
            System.out.println("6) Ver apuestas perdidas");
            try{
                int respuesta=sc.nextInt();
                if(respuesta<1||respuesta>6){
                    System.out.println("Opcion no valida");
                }else{
                    switch (respuesta) {
                        case 1://consultar saldo
                            System.out.println("Saldo disponible: "+cuenta.consultarSaldo());
                            incorrecto=false;
                            break;
                        case 2://DEpositar
                            System.out.println("Ingresa el monto a depositar");
                            boolean incorrecto2=true;
                            while(incorrecto2){
                                try{
                                    int aDepositar=sc.nextInt();
                                    if(cuenta.depositar(aDepositar)==false){
                                        System.out.println("No se pudo depositar esa cantidad");
                                    }else{
                                        incorrecto2=false;
                                        incorrecto=false;
                                    }
                                }catch(InputMismatchException e){
                                    System.out.println("Probablemente no ingresaste un numero");
                                    sc.next();
                                }
                            }
                            break;
                        case 3://Retirar
                            System.out.println("Ingresa el monto a retirar");
                            boolean incorrecto3=true;
                            while(incorrecto3){
                                try{
                                    int aRetirar=sc.nextInt();
                                    if(cuenta.retirar(aRetirar)==false){
                                        System.out.println("No se pudo retirar dicha cantidad");
                                    }else{
                                        incorrecto3=false;
                                        incorrecto=false;
                                    }
                                }catch(InputMismatchException e){
                                    System.out.println("Probablemente no ingresaste un numero");
                                    sc.next();
                                }
                            }
                            break;
                        case 4://Historial de movimientos
                            System.out.println("*********Historial de movimientos******************");
                            System.out.println(cuenta.movimientos);
                        break;
                        case 5://Ver apuestas ganadas
                            System.out.println("**********Apuestas ganadas**********************");
                            System.out.println(cuenta.apuestasGanadas);
                        break;
                        case 6://Ver apuestas perdidas
                            System.out.println("**********Apuestas perdidas**********************");
                            System.out.println(cuenta.apuestasPerdidas);
                        break;
                        default:
                            break;
                    }
                }
            }catch(InputMismatchException e){
                System.out.println("Probablemente no ingresaste un número");
                sc.next();
            }
        }
    }//FIN DE AJUSTES CUENTA

    /**
     * Metodo equals
     * @param o
     * @return
     */
    @Override public int compareTo(Object o){
        if(!o.getClass().equals(this.getClass())){
            throw new IllegalArgumentException("Parametro no valido");
        }else{
            Jugador j=(Jugador)o;
            if(nombreUsuario.equals(j.nombreUsuario)){
                return 0;
            }
            if(nombreUsuario.compareTo(j.nombreUsuario)<0){
                return -1;
            }else{
                return 1;
            }
        }
    }//FIN DE COMPARE TO

    @Override public boolean equals(Object obj){
        if(!obj.getClass().equals(this.getClass())){
            return false;
        }else{
            Jugador j=(Jugador) obj;
            if(j.nombreUsuario.equals(this.nombreUsuario)){
                return true;
            }else{
                System.out.println("else");
                return false;
            }
        }
    }//FIN DE EQUALS

    public String toString(){
        return nombreUsuario;
    }//FIN DE TO STRING
}
