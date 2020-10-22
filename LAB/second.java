import java.util.Arrays;

public class second {

    static class Suffix {
        int index;
        int[] rank = new int[2];
    }

    public static int[] buildSuffixArray(String str) {

        int n = str.length();
        Suffix[] suffixes = new Suffix[n];
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            suffixes[i] = new Suffix();
            suffixes[i].index = i;
            suffixes[i].rank[0] = str.charAt(i) - 'a';
            suffixes[i].rank[1] = ((i + 1) < n) ? (str.charAt(i + 1) - 'a') : -1;
        }

        Arrays.sort(suffixes,
                (o1, o2) -> (o1.rank[0] == o2.rank[0])
                        ? ((o1.rank[1] == o2.rank[1]) ? 0 : (o1.rank[1] > o2.rank[1]) ? 1 : -1)
                        : ((o1.rank[0] > o2.rank[0]) ? 1 : -1));

        int[] ind = new int[n];
        for (int k = 4; k < 2 * n; k = k * 2) {
            int rank = 0;
            int prev_rank = suffixes[0].rank[0];
            suffixes[0].rank[0] = rank;
            ind[suffixes[0].index] = 0;

            for (int i = 1; i < n; i++) {

                if (suffixes[i].rank[0] == prev_rank && suffixes[i].rank[1] == suffixes[i - 1].rank[1]) {
                    prev_rank = suffixes[i].rank[0];
                    suffixes[i].rank[0] = rank;
                } else {
                    prev_rank = suffixes[i].rank[0];
                    suffixes[i].rank[0] = ++rank;
                }
                ind[suffixes[i].index] = i;
            }

            for (int i = 0; i < n; i++) {
                int nextindex = suffixes[i].index + k / 2;
                suffixes[i].rank[1] = (nextindex < n) ? suffixes[ind[nextindex]].rank[0] : -1;
            }

            Arrays.sort(suffixes,
                    (o1, o2) -> (o1.rank[0] == o2.rank[0])
                            ? ((o1.rank[1] == o2.rank[1]) ? 0 : (o1.rank[1] > o2.rank[1]) ? 1 : -1)
                            : ((o1.rank[0] > o2.rank[0]) ? 1 : -1));

        }

        for (int i = 0; i < n; i++)
            arr[i] = suffixes[i].index;

        return arr;
    }

    public static void main(String[] args) {
        String str = "banana";
        int[] arr = buildSuffixArray(str);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}