class Solution {

    int[][] arr;
    int n;

    class State {
        long weight;
        List<Integer> indices;

        State(long weight, List<Integer> indices) {
            this.weight = weight;
            this.indices = indices;
        }
    }

    State[][] dp;

    private int findNext(int i) {

        int end = arr[i][1];

        int low = i + 1;
        int high = n;

        while (low < high) {

            int mid = low + (high - low) / 2;

            if (arr[mid][0] > end) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

    private boolean smaller(List<Integer> a, List<Integer> b) {

        if (b == null)
            return true;

        // Sort copies because final answer is based
        // on original indices
        List<Integer> x = new ArrayList<>(a);
        List<Integer> y = new ArrayList<>(b);

        Collections.sort(x);
        Collections.sort(y);

        for (int i = 0; i < Math.min(x.size(), y.size()); i++) {

            if (!x.get(i).equals(y.get(i))) {
                return x.get(i) < y.get(i);
            }
        }

        return x.size() < y.size();
    }

    private State solve(int i, int k) {

        if (i == n || k == 0) {
            return new State(0, new ArrayList<>());
        }

        if (dp[i][k] != null) {
            return dp[i][k];
        }

        // Don't take
        State skip = solve(i + 1, k);

        // Take
        int next = findNext(i);

        State nextState = solve(next, k - 1);

        List<Integer> takeList = new ArrayList<>(nextState.indices);
        takeList.add(arr[i][3]);

        long takeWeight = arr[i][2] + nextState.weight;

        State take = new State(takeWeight, takeList);

        State best;

        if (take.weight > skip.weight) {

            best = take;

        } else if (take.weight < skip.weight) {

            best = skip;

        } else {

            // Same weight → lexicographically smaller
            if (smaller(take.indices, skip.indices)) {
                best = take;
            } else {
                best = skip;
            }
        }

        dp[i][k] = best;

        return best;
    }

    public int[] maximumWeight(List<List<Integer>> intervals) {

        n = intervals.size();

        arr = new int[n][4];

        for (int i = 0; i < n; i++) {

            arr[i][0] = intervals.get(i).get(0);
            arr[i][1] = intervals.get(i).get(1);
            arr[i][2] = intervals.get(i).get(2);
            arr[i][3] = i;
        }

        // Sort by start
        Arrays.sort(arr, (a, b) -> {

            if (a[0] != b[0]) {
                return Integer.compare(a[0], b[0]);
            }

            return Integer.compare(a[1], b[1]);
        });

        dp = new State[n][5];

        State answer = solve(0, 4);

        Collections.sort(answer.indices);

        int[] result = new int[answer.indices.size()];

        for (int i = 0; i < answer.indices.size(); i++) {
            result[i] = answer.indices.get(i);
        }

        return result;
    }
}