public static int[][] directedToUndirectedWeightedMatrix(int[][] directed) {
    int n = directed.length;
    int[][] undirected = new int[n][n];

    for (int i = 0; i < n; i++) {
        for (int j = i + 1; j < n; j++) {
            int w1 = directed[i][j];
            int w2 = directed[j][i];

            if (w1 == 0 && w2 == 0) continue;

            int w;
            if (w1 == 0) w = w2;
            else if (w2 == 0) w = w1;
            else w = Math.min(w1, w2);   // change rule here

            undirected[i][j] = w;
            undirected[j][i] = w;
        }
    }
    return undirected;
}
