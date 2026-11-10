
import java.util.Queue;
import java.util.LinkedList;
import java.util.Scanner;

public class QueuePermutationsCombinations {

    static int permCount = 0;
    static int combCount = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Queue Implementation
        Queue<String> queue = new LinkedList<>();

        System.out.println("Enter 5 elements:");
        for (int i = 0; i < 5; i++) {
            queue.add(sc.next());
        }

        System.out.println("Queue: " + queue);
        System.out.println("Front: " + queue.peek());

        queue.poll();
        queue.poll();

        System.out.println("After removing 2: " + queue);


        // Permutations
        Queue<String> permQueue = new LinkedList<>();

        System.out.println("\nEnter 3 elements:");
        for (int i = 0; i < 3; i++) {
            permQueue.add(sc.next());
        }

        System.out.println("Queue: " + permQueue);
        System.out.print("Enter number to arrange: ");
        int r = sc.nextInt();

        permute(permQueue.toArray(new String[0]), "", r);

        System.out.println("Total Permutations: " + permCount);


        // Combinations
        Queue<String> combQueue = new LinkedList<>();

        System.out.println("\nEnter 4 elements:");
        for (int i = 0; i < 4; i++) {
            combQueue.add(sc.next());
        }

        System.out.println("Queue: " + combQueue);
        System.out.print("Enter number to select: ");
        int n = sc.nextInt();

        combine(combQueue.toArray(new String[0]), n, 0, "");

        System.out.println("Total Combinations: " + combCount);

        sc.close();
    }

    // Permutation
    static void permute(String[] arr, String result, int r) {
        if (result.length() == r) {
            System.out.println(result);
            permCount++;
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            if (!result.contains(arr[i])) {
                permute(arr, result + arr[i], r);
            }
        }
    }

    // Combination
    static void combine(String[] arr, int r, int start, String result) {
        if (result.length() == r) {
            System.out.println(result);
            combCount++;
            return;
        }

        for (int i = start; i < arr.length; i++) {
            combine(arr, r, i + 1, result + arr[i]);
        }
    }
}
