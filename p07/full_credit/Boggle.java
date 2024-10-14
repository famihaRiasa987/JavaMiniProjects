import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;
import java.util.Objects;

public class Boggle {
    private static List<Board> boards = new ArrayList<>();
    private static List<String> words = new ArrayList<>();
    private static Set<Solution> solutions = new HashSet<>();
    private static int numberOfBoards = 1;
    private static int boardSize = 50;
    private static int numThreads = 1;
    private static String filename = "words.txt";
    private static int verbosity = 0;

    public static void solveRange(int first, int lastPlusOne, int threadNumber) {
        for (int i = first; i < lastPlusOne; i++) {
            Board board;
            synchronized (boards) {
                board = boards.get(i);
            }
            Solver solver = new Solver(board, i, threadNumber);
            for (String word : words) {
                Solution solution = solver.solve(word);
                if (solution != null) {
                    synchronized (solutions) {
                        solutions.add(solution);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        try {
            if (args.length > 0 && args[0].equals("-h")) {
                System.err.println(
                    """
                    usage: java Boggle [#boards] [boardSize] [#threads] [wordsFilename] [verboseLevel(0-3)]
                           defaults:       1         50           1       words.txt            0 
                           You may skip any parameters with '-'. To use 4 threads, type: java Boggle - - 4
                           verbosity 0 = # solutions, 1 = threads, 2 = boards & solutions, 3 = details""");
                System.exit(0);
            }

            try {
                numberOfBoards = (args.length > 0 && !args[0].equals("-")) ? Integer.parseInt(args[0]) : 1;
                boardSize = (args.length > 1 && !args[1].equals("-")) ? Integer.parseInt(args[1]) : 50;
                numThreads = (args.length > 2 && !args[2].equals("-")) ? Integer.parseInt(args[2]) : 1;
                filename = (args.length > 3 && !args[3].equals("-")) ? args[3] : "words.txt";
                verbosity = (args.length > 4 && !args[4].equals("-")) ? Integer.parseInt(args[4]) : 0;
            } catch (Exception e) {
                System.err.println("Invalid command line arguments: " + e);
                System.exit(-2);
            }

            for (int i = 0; i < numberOfBoards; ++i) {
                boards.add(new Board(boardSize));
                log("\nBoard " + i + "\n\n" + boards.get(i) + "\n\n", 2);
            }

            String s;
            try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
                while ((s = br.readLine()) != null) {
                    words.add(s.trim().toUpperCase()); // Ensure words are uppercase
                }
            } catch (IOException e) {
                System.err.println("Unable to read words from file " + filename + ": " + e);
                System.exit(-1);
            }

            Thread[] threads = new Thread[numThreads];
            int boardsPerThread = (int) Math.ceil((double) numberOfBoards / numThreads);

            for (int threadNumber = 0; threadNumber < numThreads; threadNumber++) {
                final int finalThreadNumber = threadNumber; // Create a final variable for the thread number
                final int first = threadNumber * boardsPerThread;
                final int lastPlusOne = Math.min(first + boardsPerThread, numberOfBoards);
                threads[threadNumber] = new Thread(() -> solveRange(first, lastPlusOne, finalThreadNumber)); // Use final variable
                threads[threadNumber].start();
            }

            for (Thread thread : threads) {
                thread.join();
            }

            for (Solution solution : solutions) {
                log(solution.toString(), 2);
            }

            System.out.println("\nFound " + solutions.size() + " solutions");
            System.out.printf("Hash is 0x%08X\n", Objects.hash(solutions));
        } catch (Exception e) {
            System.err.println("Unexpected exception (panic): Contact support");
            e.printStackTrace();
            System.exit(-99);
        }
    }

    private static void log(String message, int level) {
        if (verbosity >= level) {
            System.out.print(message);
        }
    }
}
