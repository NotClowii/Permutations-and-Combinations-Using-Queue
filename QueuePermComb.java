import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class QueuePermComb {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Queue<String> queue = new LinkedList<>();

        for (int i = 1; i <= 5; i++) {
            System.out.print("Enter element " + i + ": ");
            queue.add(sc.next());                
        }
        System.out.println("Queue: " + queue);
        System.out.println("Front: " + queue.peek());  

        System.out.println("Dequeued: " + queue.poll()); 
        System.out.println("Dequeued: " + queue.poll());
        System.out.println("Queue now: " + queue);
        System.out.println("Is empty? " + queue.isEmpty());

        Queue<String> letters = new LinkedList<>();
        letters.add("A");
        letters.add("B");
        letters.add("C");
        System.out.println("\nQueue: " + letters);

        System.out.print("Enter number of elements to arrange: ");
        int r = sc.nextInt();
        System.out.println();

        Queue<String> perms = new LinkedList<>();
        perms.add("");                           

        for (int round = 0; round < r; round++) {
            int size = perms.size();              
            for (int i = 0; i < size; i++) {
                String current = perms.poll();  
                for (String letter : letters) {
           
                    if (!current.contains(letter)) {
                        perms.add(current + letter);
                    }
                }
            }
        }

        int count = 0;
        while (!perms.isEmpty()) {
            System.out.println(perms.poll());
            count++;
        }
        System.out.println("\nTotal Permutations: " + count);

        Queue<String> letters2 = new LinkedList<>();
        letters2.add("A");
        letters2.add("B");
        letters2.add("C");
        letters2.add("D");
        System.out.println("\nQueue: " + letters2);

        System.out.print("Enter number of elements to select: ");
        int k = sc.nextInt();
        System.out.println();

        Queue<String> combos = new LinkedList<>();
        combos.add("");

        for (int round = 0; round < k; round++) {
            int size = combos.size();
            for (int i = 0; i < size; i++) {
                String current = combos.poll();
                for (String letter : letters2) {

                    if (current.isEmpty()
                            || current.substring(current.length() - 1).compareTo(letter) < 0) {
                        combos.add(current + letter);
                    }
                }
            }
        }

        count = 0;
        while (!combos.isEmpty()) {
            System.out.println(combos.poll());
            count++;
        }
        System.out.println("\nTotal Combinations: " + count);

        sc.close();
    }
}
