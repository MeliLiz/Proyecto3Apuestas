package src.edd;
import java.lang.Comparable;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.Serializable;

/**
 * Clase que representa la sesion del jugador
 */
public class Jugador implements Comparable, Serializable{
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

    /**
     * Regresa 1 si ya se debe comenzar a jugar, 2 para volver al inicio y 0 en otro caso
     * @return
     */
    public int Bienvenida(){
        Scanner scan=new Scanner(System.in);
        System.out.println("Bienvenid@ a tu sesión");
        System.out.println("Tu saldo actual es de $"+ cuenta.consultarSaldo());//Mostrar el saldo actual del jugador
        boolean incorrecto=true;
        while(incorrecto){
            //Opciones
            System.out.println("¿Qué quieres hacer?");
            System.out.println("1) Ver ajustes de cuenta");
            System.out.println("2) Comenzar a apostar");
            System.out.println("3) Ir al inicio");
            int r;
            try{
                r= scan.nextInt();
                if(r>0&&r<4){
                    switch (r) {
                        case 1://Ver ajustes de cuenta
                            ajustesCuenta();
                            return 0;
                        case 2:
                            //apostar
                            return 1;
                        case 3:
                            //regresar al inicio
                            return 2;
                        default:
                            break;
                    }
                    incorrecto=false;
                }else{
                    System.out.println("Opcion no válida");//Si la respuesta no es 1, 2 ni 3
                }
            }catch(InputMismatchException e){//Si no se ingresó un numero como opción
                System.out.println("Probablemente no ingresaste un número");
                scan.next();
            }
        }
        return 0;
    }

    /**
     * Metodo para poder manipular la cuenta
     */
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
            System.out.println("7) Volver a mi sesion");
            try{
                int respuesta=sc.nextInt();
                if(respuesta<1||respuesta>6){//Si el numero ingresado no corresponde a alguna opcion
                    System.out.println("Opcion no valida");
                }else{
                    switch (respuesta) {
                        case 1://consultar saldo
                            System.out.println("Saldo disponible: "+cuenta.consultarSaldo());
                            incorrecto=false;
                            break;
                        case 2://Depositar
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
                        default://volver a la sesion
                            break;
                    }
                }
            }catch(InputMismatchException e){//Si no se ingresó un numero como opción
                System.out.println("Probablemente no ingresaste un número");
                sc.next();
            }
        }
    }//FIN DE AJUSTES CUENTA


    /**
     * Metodo compareTo para comparar a los jugadores con base en su nombre de usuario
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

    /**
     * Metodo equals basandose en el nombre de usuario
     */
    @Override public boolean equals(Object obj){
        if(!obj.getClass().equals(this.getClass())){
            return false;
        }else{
            Jugador j=(Jugador) obj;
            if(j.nombreUsuario.equals(this.nombreUsuario)){
                return true;
            }else{
                //System.out.println("else");
                return false;
            }
        }
    }//FIN DE EQUALS

    /**
     * ToString que regresa el nombre de usuario
     */
    public String toString(){
        return nombreUsuario;
    }//FIN DE TO STRING
}
