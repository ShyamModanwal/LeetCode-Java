class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> result = new ArrayList<>();

        int rowBegin = 0;
        int rowEnd = matrix.length - 1;

        int columnBegin = 0;
        int columnEnd = matrix[0].length - 1;

        while (rowBegin <= rowEnd && columnBegin <= columnEnd) {

            // 1. Left → Right
            for (int j = columnBegin; j <= columnEnd; j++) {
                result.add(matrix[rowBegin][j]);
            }
            rowBegin++;

            // 2. Top → Bottom
            for (int j = rowBegin; j <= rowEnd; j++) {
                result.add(matrix[j][columnEnd]);
            }
            columnEnd--;

            // 3. Right → Left
            if (rowBegin <= rowEnd) {
                for (int j = columnEnd; j >= columnBegin; j--) {
                    result.add(matrix[rowEnd][j]);
                }
                rowEnd--;
            }

            // 4. Bottom → Top
            if (columnBegin <= columnEnd) {
                for (int j = rowEnd; j >= rowBegin; j--) {
                    result.add(matrix[j][columnBegin]);
                }
                columnBegin++;
            }
        }

        return result;
    }
}