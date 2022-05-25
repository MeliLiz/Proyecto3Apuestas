package src.edd;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Hilos extends Thread{
    public Hilos(){

    }
    public void run(){
        System.out.println("Ingresa una letra");
        Scanner scan=new Scanner(System.in);
        while (!Thread.currentThread().isInterrupted()) {
            scan.nextLine();
        }
        
        /*try{
            Thread.sleep(5000);
        }catch(Exception e){
            System.out.println("No se pudo dormir el hilo");
        }
        System.out.println("Termina");*/
        //notify();
    }
    public static void main(String[] args){
        /*Scanner scan=new Scanner(System.in);
        int contador=0;
        boolean sigue=true;
        Hilos hilo=new Hilos();
        hilo.start();
        while(hilo.isAlive()){
            //System.out.println("Vivo");
            boolean incorrecto=true;
            while(incorrecto&&hilo.isAlive()){
                System.out.println("Ingresa un numero");
                try {
                    int r=scan.nextInt();
                } catch (InputMismatchException e) {
                    System.out.println("Opcion no valida");
                    scan.next();
                }
            }
        }*/

        System.out.println("Empezando hilo");
        Hilos hilo=new Hilos();
        hilo.start();
        try{
            Thread.sleep(5000);
            System.out.println("Termino tiempo de espera");
        }catch(Exception e){
            System.out.println("No se pudo dormir el hilo");
        }
        hilo.interrupt();
        
        //Hacer que el hilo con el scanner se ejecute y fuera medir el tiempo, cuando pase el tiempo hacer el hilo.wait()


        /*while(sigue){
            System.out.println("Hola");
            try{
                Thread.sleep(5000);
            }catch(Exception e){
                System.out.println("No se pudo dormir el hilo");
            }
            
            contador++;
            if(contador==10){
                sigue=false;
            }
        }*/
    }
}
