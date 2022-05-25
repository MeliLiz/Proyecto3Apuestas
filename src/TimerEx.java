package src.edd;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

class TimerEx {
    public static void main(String arglist[]) {
        Timer timer = new Timer();
        timer = new Timer();

        TimerTask task = new TimerTask() {
            int tic=0;

            @Override
            public void run(){
                String str="";
                if( str.equals("") ){
                    System.out.println( "you input nothing. exit..." );
                    System.exit( 0 );
                }else if(str.equals("hola")){
                    System.out.println("hola");
                }
            }
        };

        timer.schedule( task, 5*1000 );

        Scanner sc = new Scanner(System.in);
        String in = sc.nextLine();
        
        if(in.equals("hola")){
            System.out.println("hola");
            timer.cancel();
        }

        
    }
}
