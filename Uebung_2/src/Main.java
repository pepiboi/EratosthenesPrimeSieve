import jdk.swing.interop.SwingInterOpUtils;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        EratosthenesPrimeSieve eps = new EratosthenesPrimeSieve();
        Scanner s = new Scanner(System.in);
        boolean running = true;
        String chosen = "";
        int max = 0;
        boolean func = false;

        while(running) {
            printMenue();
            func = true;
                chosen = s.nextLine();

            switch (chosen){
                case "1":
                    func = false;
                    try{
                        System.out.println("Geben Sie Ihre gewünschte Obergrenze mit.");
                        max = s.nextInt();
                        if(max < 0){
                            System.out.println("Geben Sie eine Gültige Zahl ein.");
                        }

                        }catch(InputMismatchException e){
                            System.out.println("Geben Sie eine Gültige Zahl ein.");
                        }
                    eps.setMax(max);

                    eps.printPrimes();
                    break;
                case "2":
                    func = false;
                    try{
                        System.out.println("Geben Sie Ihre gewünschte Zahl ein.");
                        max = s.nextInt();

                        if(max < 0){
                            System.out.println("Geben Sie eine Gültige Zahl ein.");
                        }

                    }catch(InputMismatchException e){
                        System.out.println("Geben Sie eine Gültige Zahl ein.");
                    }

                    if(eps.isPrime(max)){
                        System.out.println("Die Zahl ist eine Primzahl.");
                    }else{
                        System.out.println("Die Zahl ist keine Primzahl.");
                    }
                    break;
                case "3":
                    func = false;
                    try{
                        System.out.println("Geben Sie Ihre gewünschte Obergrenze ein.");
                        max = s.nextInt();

                        if(max < 0){
                            System.out.println("Geben Sie eine Gültige Zahl ein.");
                        }

                    }catch(InputMismatchException e){
                        System.out.println("Geben Sie eine Gültige Zahl ein.");
                    }

                    eps.printAddition(max);
                    break;
                case "4":
                    System.exit(0);
            }
            if(func){
                System.out.println("Ungültige Eingabe");
            }else {
                s.nextLine();
            }
        }
    }

    private static void printMenue(){
        System.out.println("Geben Sie Ihren gewünschten Menüpunkt als Zahl ein.");
        System.out.println("1) Primzahlen bis zu einer Obergrenze ausgeben");
        System.out.println("2) Zahl überprüfen ob Prim ist");
        System.out.println("3) Additionen bis zu einer Obergrenze ausgeben");
        System.out.println("4) Beenden");
    }

}
