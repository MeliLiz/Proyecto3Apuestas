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
                                //HAcemos un jugador con el nombre y contraseña para verificar que sean correctos
                                Jugador jugador=new Jugador(nombre,key);
                                //buscamos el jugador en el arbol
                                if(!juego.buscar(jugador)){//si el nombre de usuario no esta en el arbol de usuarios, entonces notificar que el nombre es incorrecto
                                    System.out.println("Nombre de usuario incorrecto");
                                    System.out.println(juego.arbol);
                                }else{
                                    jugador=juego.verificaPassword(key, jugador);//si el usuario sí está en el arbol, verificamos la contraseña
                                    if(jugador==null){//si el jugador al verificar la contraseña es null, la contraseña es incorrecta
                                        System.out.println("Contraseña incorrecta");
                                    }else{
                                        //si el usuario y contaseña son correctas, nos metemos a la sesion de jugador
                                        incorrecto2=false;
                                        boolean ya=true;
                                        while(ya){
                                            int opc=jugador.Bienvenida();//damos bienvenida con opciones
                                            if(opc==1){ //Si la opcion regresada por el metodo bienvenida es 1, entonces empezamos la partida
                                                empezar(jugador, juego);
                                                ya=false;
                                            }else if(opc==2){//Si la opcion regresada por el metodo bienvenida es 1, entonces regresamos al menu
                                                menu(juego);
                                                ya=false;
                                            }
                                        }   
                                    }
                                }
                            }
                            
                            incorrecto=false;
                            break;
                        case 2://crear cuenta
                             incorrecto2=true;
                            Jugador j=new Jugador("n", "0");//hacemos un nuevo jugador para poder verificar que el nombre de usuario no se encuentre ya en el arbol
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
                            menu(juego);//volvemos al menu
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
            }catch(InputMismatchException e){ //si no se ingreso un numero como opcion
                System.out.println("Al parecer no ingresaste un número");
                scan.next();
            }
        }

        
    }// FIN DE MENU

    /**
     * Metodo principal
     * @param args
     */
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

            //Leer el archivo con objetos
        try{
            ObjectInputStream entrada=new ObjectInputStream(new FileInputStream("archivo.obj"));
            juego=(Juego)entrada.readObject();
            entrada.close();
        }catch(Exception e){//Si el archivo no se pudo leer
            System.out.println("No se pudo deserializar");
        }
        menu(juego); //empezamos el menu pasandole el juego recopilado del archivo de objetos
    }// FIN DEL MAIN


    
    /**
     * Metodo para comenzar las apuestas y las carreras
     * @param jugador
     */
    public static void empezar(Jugador jugador, Juego juego){



    }// FIN DE EMPEZAR
}
