package src.edd;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.ObjectOutputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.FileInputStream;

import src.edd.ArbolBinarioBusqueda;
import src.edd.Juego;


public class Apuestas {

    /**
     * Metodo menu
     */
    public static void menu(Juego juego) {
        // Imprimir opciones
        Scanner scan =new Scanner(System.in);
        Scanner sc =new Scanner(System.in);
        System.out.print("\033[H\033[2J");
        System.out.println("\nBienvenid@ al sistema de apuestas ");
        boolean incorrecto=true;
        int respuesta=0;
        while(incorrecto){
            System.out.println("Selecciona una opcion (Ingresa el numero)");
            System.out.println("\n(1) Ingresar (ya tengo una cuenta)");
            System.out.println("(2) Crea una cuenta");
            System.out.println("(3) Salir");
            try{
                respuesta=scan.nextInt();
                if(respuesta<1||respuesta>3){
                    System.out.println("Opción no válida");
                }else{
                    
                    
                    //verificamos la respuesta
                    switch (respuesta) {
                        case 1://ya hay cuenta
                            boolean incorrecto2=true;
                            while(incorrecto2){
                                //Ingresar datos
                                System.out.println("Ingresa tu nombre de usuario");
                                String nombre=sc.nextLine();
                                System.out.println("Ingresa tu contaseña");
                                String key=sc.nextLine();
                                //HAcemos un jugador con el nombre y contraseña
                                Jugador jugador=new Jugador(nombre,key);
                                if(!juego.buscar(jugador)){
                                    System.out.println("Nombre de usuario incorrecto");
                                    System.out.println(juego.arbol);
                                }else{
                                    jugador=juego.verificaPassword(key, jugador);
                                    if(jugador==null){
                                        System.out.println("Contraseña incorrecta");
                                    }else{
                                        incorrecto2=false;
                                        empezar();
                                    }
                                }
                            }
                            
                            incorrecto=false;
                            break;
                        case 2://crear cuenta
                             incorrecto2=true;
                            Jugador j=new Jugador("n", "0");//hacemos un nuevo jugador
                            while(incorrecto2){
                                System.out.println("Ingresa tu nuevo nombre de usuario");
                                String nombre=sc.nextLine();
                                j.nombreUsuario=nombre;
                                if(juego.arbol!=null&&juego.buscar(j)){//verificamos que el nombre de usuario no este repetido
                                    System.out.println("Nombre de usuario no disponible, elige otro nombre");
                                }else{
                                    incorrecto2=false;
                                }
                            }
                            System.out.println("Ingresa tu contraseña");
                            String key=sc.nextLine();
                            j.key=key;
                            juego.addJugador(j);//añadimos al jugador en el arbol de usuarios
                            System.out.println("Inicia sesion por favor");
                            menu(juego);
                            incorrecto=false;
                            break;
                        case 3://salir
                            System.out.println("Saliendo...");
                            System.exit(0);
                            break;
                        default:
                            System.out.println("Opcion no valida");
                            break;
                    }
                    
                }
            }catch(InputMismatchException e){
                System.out.println("Al parecer no ingresaste un número");
                scan.next();
            }
        }

        
    }// FIN DE MENU

    public static void main(String[] args){
        Juego juego=new Juego();
            /*try{
                ObjectOutputStream salida=new ObjectOutputStream(new FileOutputStream("archivo.obj"));
                salida.writeObject(juego);
                salida.close();
                System.out.println("Serializado");
            }catch(Exception e){
                System.out.println("No se pudo serializar");
            }*/
            try{
                ObjectInputStream entrada=new ObjectInputStream(new FileInputStream("archivo.obj"));
                juego=(Juego)entrada.readObject();
                entrada.close();
            }catch(Exception e){
                System.out.println("No se pudo deserializar");
            }
        menu(juego);
    }// FIN DEL MAIN

    public static void empezar(){

    }// FIN DE EMPEZAR
}
