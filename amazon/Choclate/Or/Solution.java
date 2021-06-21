package amazon.Choclate.Or;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        List<Input> input = new ArrayList<>();
        for (int i = 0; i < testCases; i++) {
            int n = scanner.nextInt();
            int queries = scanner.nextInt();
            List<Integer> res = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                res.add(scanner.nextInt());
            }

            List<Query> queryList = new ArrayList<>();
            for (int k = 0; k < queries; k++)
                queryList.add(new Query(scanner.nextInt(), scanner.nextInt()));

            input.add(new Input(res, queryList));
        }
        for (Input input1 : input) {

            System.out.println(input1.getOutput());

            for (Query query : input1.queries) {
                input1.swap(query.x, query.y);
                System.out.println(input1.getOutput());
            }

        }
    }

    static class Input {
        List<Integer> list;
        List<Query> queries;

        public Input(List<Integer> list, List<Query> queries) {
            this.list = list;
            this.queries = queries;
        }

        public int getOutput() {
            int n = list.size();
            int orScore;
            List<Integer> andScores = new ArrayList<>();
            //[1,2,3,4]
            for (int i = 0; i < n; i++) {

                int andScore = list.get(i);
                for (int j = i; j < n; j++) {
                    andScore = (andScore & list.get(j));
                    andScores.add(andScore);

                }
            }
            orScore = andScores.get(0);
            for (int i = 1; i < andScores.size(); i++)
                orScore = orScore | andScores.get(i);
            return orScore;
        }

        public void swap(int x, int y) {
            list.set(x - 1, y);
        }
    }

    static class Query {
        int x;
        int y;

        public Query(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}
