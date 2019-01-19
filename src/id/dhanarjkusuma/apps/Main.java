package id.dhanarjkusuma.apps;

import java.util.Scanner;

public class Main {

    public static final int INVALID_MENU = -1;

    public static void main(String[] args) {
        ScoreCalculator calculator = new ScoreCalculator();
        Scanner scanner = new Scanner(System.in);
        int menu;
        do{

            menu = getMenu(scanner);
            if(menu == INVALID_MENU){
                System.out.println("Menu yang anda masukkan tidak valid");
                return;
            }
            proceedMenu(calculator, scanner, menu);

        }while(menu != 4);
    }

    public static void proceedMenu(ScoreCalculator calculator, Scanner scanner, int menu){
        switch (menu){
            case 1:
                System.out.print("Masukkan Jumlah Matakuliah : ");
                int count = scanner.nextInt();
                for(int i=0; i<count; i++){
                    System.out.print("Masukkan Kode Matakuliah : ");
                    String code = scanner.next();
                    System.out.print("Masukkan Nama Matakuliah : ");
                    String name = scanner.next();
                    System.out.print("Masukkan Grade Matakuliah : ");
                    String grade = scanner.next();
                    System.out.print("Masukkan Jumlah SKS : ");
                    int sks = scanner.nextInt();
                    calculator.recordScore(code, name, grade, sks);
                    System.out.println("");
                }
                break;
            case 2:
                calculator.calculateIPS();
                break;
            case 3:
                System.out.print("Masukkan Kode Matakuliah : ");
                String code = scanner.next();
                System.out.print("Masukkan Grade Baru : ");
                String grade = scanner.next();
                calculator.updateScore(code, grade);
                break;
        }
    }

    public static int getMenu(Scanner scanner){
        System.out.println("---------------------------------------------------------");
        System.out.println("Pendataan dan Perhitungan IPS (Indeks Prestasi Semester)");
        System.out.println("1. Pendataan Matakuliah");
        System.out.println("2. Perhitungan IPS");
        System.out.println("3. Update Grade");
        System.out.println("4. Keluar");
        System.out.println("Masukan Pilihan Anda : ");
        int menu = scanner.nextInt();
        if(!validateMenu(menu)){
            return INVALID_MENU;
        }
        return menu;
    }

    public static boolean validateMenu(int menu){
        if(menu <= 0 || menu > 5){
            return false;
        }
        return true;
    }
}
