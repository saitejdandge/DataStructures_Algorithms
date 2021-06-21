package amazon.Choclate;

import java.util.*;

public class Choclate {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        List<Input> input = new ArrayList<>();
        for (int i = 0; i < testCases; i++) {
            int n = scanner.nextInt();
            int x = scanner.nextInt();
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int j = 0; j < n; j++) {
                int value = scanner.nextInt();
                map.put(value, map.getOrDefault(value, 0) + 1);
            }
            input.add(new Input(map, x));

        }
        for (Input inputObj : input)
            System.out.println(inputObj.getOutput());
    }

    static class Input {
        HashMap<Integer, Integer> map;
        int x;

        public Input(HashMap<Integer, Integer> map, int x) {
            this.map = map;
            this.x = x;
        }

        public int getOutput() {

            PriorityQueue<Pair> priorityQueue = new PriorityQueue<>((i1, i2) -> i2.frequency - i1.frequency);
            for (Map.Entry<Integer, Integer> entry : map.entrySet())
                priorityQueue.add(new Pair(entry.getKey(), entry.getValue()));

            for (int i = 0; i < x && !priorityQueue.isEmpty(); i++) {
                Pair peek = priorityQueue.poll();
                peek.frequency--;
                if (peek.frequency > 0)
                    priorityQueue.add(peek);
            }
            int count = 0;
            while (!priorityQueue.isEmpty()) {
                Pair pair = priorityQueue.poll();
                if (pair.frequency > 0)
                    count++;
            }
            return count;
        }

    }

    static class Pair {
        int key;
        int frequency;

        public Pair(Integer key, Integer value) {
            this.key = key;
            this.frequency = value;
        }
    }
}
