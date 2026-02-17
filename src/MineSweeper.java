import java.util.*;

public class MineSweeper {
    public static final int MINE = -1;
    public static final int[][] DIRECTIONS = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}, {1, 1}, {-1, -1}, {1, -1}, {-1, 1}};
    int rowNum;
    int colNum;
    int mineNum;
    int[][] board;
    boolean[][] visited;
    boolean isGameAlive;
    boolean[][] flags;

    public MineSweeper(int rowNum, int colNum, int mineNum) {
        this.rowNum = rowNum;
        this.colNum = colNum;
        this.mineNum = mineNum;
        board = new int[rowNum][colNum];
        visited = new boolean[rowNum][colNum];
        flags = new boolean[rowNum][colNum];
        isGameAlive = true;
        generateMines();
        countMineNum();
    }

    private void generateMines() {
        Random rand = new Random();
        Set<String> set = new HashSet<>();
        int count = 0;
        while (count < mineNum) {
            int r = rand.nextInt(rowNum);
            int c = rand.nextInt(colNum);
            if (!set.contains(r + "," + c)) {
                set.add(r + "," + c);
                board[r][c] = MINE;
                count++;
            }
        }
    }

    private void countMineNum() {
        for (int r = 0; r < rowNum; r++) {
            for (int c = 0; c < colNum; c++) {
                if (board[r][c] != MINE) {
                    int count = 0;
                    for (int[] d : DIRECTIONS) {
                        int r_ = r + d[0];
                        int c_ = c + d[1];
                        if (r_ >= 0 && r_ < rowNum && c_ >= 0 && c_ < colNum && board[r_][c_] == MINE) {
                            count++;
                        }
                    }
                    board[r][c] = count;
                }
            }
        }
    }

    public void printBoard() {
        for (int r = 0; r < rowNum; r++) {
            for (int c = 0; c < colNum; c++) {
                if (visited[r][c]) {
                    if (flags[r][c]) {
                        System.out.print("F ");
                    } else {
                        System.out.print(board[r][c] + " ");
                    }
                } else {
                    System.out.print("_ ");
                }
            }
            System.out.println();
        }
    }

    public void showResult() {
        for (int r = 0; r < rowNum; r++) {
            for (int c = 0; c < colNum; c++) {
                if (board[r][c] == MINE) {
                    System.out.print("M ");
                } else {
                    System.out.print(board[r][c] + " ");
                }
            }
            System.out.println();
        }
    }

    public void reveal(int row, int col) {
        if (board[row][col] == MINE) {
            System.out.println("Game Over");
            isGameAlive = false;
            return;
        }

        if (board[row][col] > 0) {
            visited[row][col] = true;
        } else if (board[row][col] == 0) {
            Queue<int[]> queue = new LinkedList<>();
            queue.add(new int[] {row, col});
            visited[row][col] = true;

            while (!queue.isEmpty()) {
                int[] cur = queue.poll();

                for (int[] d : DIRECTIONS) {
                    int r_ = cur[0] + d[0];
                    int c_ = cur[1] + d[1];
                    if (r_ >= 0 && r_ < rowNum && c_ >= 0 && c_ < colNum && !visited[r_][c_] && board[r_][c_] != MINE) {
                        if (board[r_][c_] == 0) {
                            queue.add(new int[] {r_, c_});
                        }
                        visited[r_][c_] = true;
                    }
                }
            }
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MineSweeper game = new MineSweeper(10, 10, 10);
        System.out.println("MineSweeper Game start");
        game.printBoard();

        while (game.isGameAlive) {
            System.out.println("Please choose your operation:");
            System.out.println("1. Choose the cell to reveal");
            System.out.println("2. Flag the cell as a mine");
            int op = sc.nextInt();
            System.out.println("Please enter the coordinate number (row, column):");
            int row = sc.nextInt();
            int col = sc.nextInt();
            if (row >= 0 && row < game.rowNum && col >= 0 && col < game.colNum) {
                if (op == 1) {
                    if (game.flags[row][col]) {
                        game.flags[row][col] = false;
                    }
                    game.reveal(row, col);
                    if (game.isGameAlive) {
                        game.printBoard();
                    } else {
                        game.showResult();
                    }
                } else if (op == 2) {
                    game.flags[row][col] = true;
                    game.visited[row][col] = true;
                    game.printBoard();
                }

            } else {
                System.out.println("Invalid coordinate! Please re-enter");
            }
        }

    }
}
