import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Question4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Masukkan jumlah pengunjung: ");
        int totalVisitors = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Masukkan nama pengunjung: ");
        String names = scanner.nextLine();

        System.out.print("Masukkan uang pengunjung: ");
        String money = scanner.nextLine();

        String[] arrNames = names.split(", ");
        String[] arrMoney = money.split(", ");

        String[] finalNames = new String[totalVisitors];
        int[] finalMoney = new int[totalVisitors];
        int validCount = 0;

        for (int i = 0; i < totalVisitors; i++) {
            if (!arrNames[i].equals("Jeff") && !arrNames[i].equals("jeff")) {
                finalNames[validCount] = arrNames[i];
                finalMoney[validCount] = Integer.parseInt(arrMoney[i]);
                validCount++; 
            } else {
                System.out.println("Send " + arrNames[i] + " to failure management ");
            }
        }

        for (int i = 0; i < validCount - 1; i++) {
            for (int j = 0; j < validCount - i - 1; j++) {
                
                if (finalMoney[j] < finalMoney[j + 1]) {
                    
                    int tempMoney = finalMoney[j];
                    finalMoney[j] = finalMoney[j + 1];
                    finalMoney[j + 1] = tempMoney;

                    String tempName = finalNames[j];
                    finalNames[j] = finalNames[j + 1];
                    finalNames[j + 1] = tempName;
                }
            }
        }

        Queue<String> finalQueue = new LinkedList<>();
        
        for (int i = 0; i < validCount; i++) {
            finalQueue.add(finalNames[i]);
        }
        System.out.println(finalQueue);

        scanner.close();
    }
}