import java.util.Arrays;

class Main {
  public static void main(String[] args) {
    Main mn = new Main();
    int[][] matrix = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
    mn.rotateMatrix(matrix);
    System.out.println(Arrays.deepToString(matrix));

  }

  // 1. first transpose the matrix and then reverse the each row data
  // 2. down option
  public boolean rotateMatrix(int[][] matrix) {
    if (matrix.length == 0 || matrix.length != matrix[0].length)
      return false;
    int n = matrix.length;
    for (int layer = 0; layer < n / 2; layer++) {
      int first = layer;
      int last = n - 1 - layer;
      for (int i = first; i < last; i++) {
        int offset = i - first;
        int top = matrix[first][i];
        matrix[first][i] = matrix[last - offset][first];
        matrix[last - offset][first] = matrix[last][last - offset];
        matrix[last][last - offset] = matrix[i][last];
        matrix[i][last] = top;

      }

    }
    return true;

  }

}
