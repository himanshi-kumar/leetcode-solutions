
class Solution {
    public String[] createGrid(int m, int n) {
        String[] grid = new String[m];

        grid[0] = ".".repeat(n);

        for (int i = 1; i < m; i++) {
            grid[i] = "#".repeat(n);
        }

        StringBuilder lastRow = new StringBuilder(grid[m - 1]);
        lastRow.setCharAt(n - 1, '.');
        grid[m - 1] = lastRow.toString();

        for (int i = 1; i < m; i++) {
            char[] row = grid[i].toCharArray();

            if (i == m - 1) {
                row[n - 1] = '.';
            }

            grid[i] = new String(row);
        }

        // Open the last column from row 1 to m-1.
        for (int i = 1; i < m; i++) {
            char[] row = grid[i].toCharArray();
            row[n - 1] = '.';
            grid[i] = new String(row);
        }

        return grid;
    }
}
