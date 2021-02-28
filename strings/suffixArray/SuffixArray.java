package strings.suffixArray;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SuffixArray {

    public static void main(String[] args) {
        System.out.println(buildSuffixArray("banana"));
    }

    public static List<Object> buildSuffixArray(String string) {
        ArrayList<Metadata> arrayList = new ArrayList<>();
        for (int i = 0; i < string.length(); i++) {
            arrayList.add(new Metadata(string.length() - i - 1, string.substring(string.length() - i - 1)));
        }
        return arrayList.stream()
                .sorted(Comparator.comparing(o -> o.value))
                .map(metadata -> metadata.position)
                .collect(Collectors.toList());
    }

    static class Metadata {
        int position;
        String value;

        public Metadata(int position, String value) {
            this.position = position;
            this.value = value;
        }
    }
}
