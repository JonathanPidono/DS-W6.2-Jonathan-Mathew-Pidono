import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Question3 {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Masukkan total nama yang akan respon pintu: ");
        int totalNames = scanner.nextInt();

        String[] names = new String[totalNames];
        int[] chances = new int[totalNames];

        System.out.print("Masukkan urutan nama: ");
        for (int i = 0; i < totalNames; i++) {
            names[i] = scanner.next();
        }

        System.out.print("Masukkan total kesempatan untuk setiap nama: ");
        for (int i = 0; i < totalNames; i++) {
            chances[i] = scanner.nextInt();
        }

        Queue<String>  nameQueue   = new PriorityQueue<>();
        Queue<String> chancesQueue = new PriorityQueue<>();

        for (int i = 0; i < totalNames; i++) {
            nameQueue.add(i + "," + names[i]);
            chancesQueue.add(i + "," + chances[i]);
        }

        int order = totalNames;

        while (!nameQueue.isEmpty()) {
            int remaining = Integer.parseInt(chancesQueue.remove().split(",")[1]) - 1;
            String currentName = nameQueue.remove().split(",")[1];

            if (remaining > 0) {
                System.out.println(currentName + "|Try Again|" + remaining);
                nameQueue.add(order + "," + currentName);
                chancesQueue.add(order + "," + remaining);
                order++;
            } else {
                System.out.println(currentName + "|Get Out|0");
            }
        }
        scanner.close();

    }
}
