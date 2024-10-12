import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;
import java.util.Objects;
import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;

public class Boggle {
    private static List<Board> boards = new ArrayList<>();
    private static List<String> words = new ArrayList<>();
    private static Set<Solution> solutions = new TreeSet<>();

    private static int numberOfBoards = 1;
    private static int boardSize = 50;
    private static int numThreads = 1;
    private static String filename = "words.txt";
    private static int verbosity = 0;

    private static void solveRange(int first, int lastPlusOne, int threadNumber) {
        for (int i = first; i < lastPlusOne; i++) {
            Board board;
            synchronized (boards) {
                board = boards.get(i);
            }
            Solver solver = new Solver(board, threadNumber, verbosity);
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
        long startTime = System.currentTimeMillis();
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        long userStartTime = threadMXBean.getCurrentThreadUserTime();
        long sysStartTime = threadMXBean.getCurrentThreadCpuTime();

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
                if (args.length > 0 && !args[0].equals("-")) numberOfBoards = Integer.parseInt(args[0]);
                if (args.length > 1 && !args[1].equals("-")) boardSize = Integer.parseInt(args[1]);
                if (args.length > 2 && !args[2].equals("-")) numThreads = Integer.parseInt(args[2]);
                if (args.length > 3 && !args[3].equals("-")) filename = args[3];
                if (args.length > 4 && !args[4].equals("-")) verbosity = Integer.parseInt(args[4]);
            } catch (Exception e) {
                System.err.println("Invalid command line arguments: " + e);
                System.exit(-2);
            }

            try {
                for (int i = 0; i < numberOfBoards; ++i) {
                    boards.add(new Board(boardSize));
                    log("\nBoard " + i + "\n\n" + boards.get(i) + "\n\n", 2);
                }
            } catch (Exception e) {
                System.err.println("Unable to generate new Boggle boards: " + e);
                System.exit(-2);
            }

            String s;
            try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
                while ((s = br.readLine()) != null) words.add(s);
            } catch (IOException e) {
                System.err.println("Unable to read words from file " + filename + ": " + e);
                System.exit(-1);
            }

            List<Thread> threads = new ArrayList<>();
            int boardsPerThread = numberOfBoards / numThreads;
            int remainder = numberOfBoards % numThreads;
            int start = 0;

            for (int threadIndex = 0; threadIndex < numThreads; threadIndex++) {
                int end = start + boardsPerThread + (threadIndex < remainder ? 1 : 0);
                final int first = start;
                final int lastPlusOne = end;
                final int threadNumber = threadIndex;

                Thread thread = new Thread(() -> solveRange(first, lastPlusOne, threadNumber));
                threads.add(thread);
                thread.start();

                start = end;
            }

            for (Thread thread : threads) {
                try {
                    thread.join();
                } catch (InterruptedException e) {
                    System.err.println("Thread interrupted: " + e);
                }
            }

            for (Solution solution : solutions) {
                log(solution.toString(), 2);
            }

            long endTime = System.currentTimeMillis();
            long userEndTime = threadMXBean.getCurrentThreadUserTime();
            long sysEndTime = threadMXBean.getCurrentThreadCpuTime();
            
            long realTime = endTime - startTime;
            long userTime = userEndTime - userStartTime;
            long sysTime = sysEndTime - sysStartTime;

            System.out.println("\nFound " + solutions.size() + " solutions");
            System.out.printf("Hash is 0x%08X\n\n", Objects.hash(solutions));
            System.out.printf("real    %s\n", formatTime(realTime));
            System.out.printf("user    %s\n", formatTime(userTime));
            System.out.printf("sys     %s\n", formatTime(sysTime));
        } catch (Exception e) {
            System.err.println("Unexpected exception (panic): Contact support");
            e.printStackTrace();
            System.exit(-99);
        }
    }

    private static void log(String s, int level) {
        if (verbosity == level) System.out.println(s);
    }

    private static String formatTime(long milliseconds) {
        long seconds = milliseconds / 1000;
        long millis = milliseconds % 1000;
        return String.format("0m%02ds%03dms", seconds, millis);
    }
}
