import java.util.Scanner;

public class ConsoleStopwatch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long startTime = 0;
        boolean isRunning = false;

        System.out.println(" Console Stopwatch");
        System.out.println("Commands: start, stop, reset, exit");

        while (true) {
            String input = scanner.nextLine().trim();

            if (input.equalsIgnoreCase("start")) {
                if (!isRunning) {
                    startTime = System.currentTimeMillis();
                    isRunning = true;
                    System.out.println("Stopwatch started.");
                } else {
                    System.out.println("Stopwatch is already running.");
                }
            } else if (input.equalsIgnoreCase("stop")) {
                if (isRunning) {
                    long elapsedTime = System.currentTimeMillis() - startTime;
                    int hours = (int) (elapsedTime / 3600000);
                    int minutes = (int) ((elapsedTime % 3600000) / 60000);
                    int seconds = (int) ((elapsedTime % 60000) / 1000);
                    int milliseconds = (int) (elapsedTime % 1000);

                    System.out.printf("Elapsed time: %02d:%02d:%02d.%03d%n", hours, minutes, seconds, milliseconds);

                    isRunning = false;
                } else {
                    System.out.println("Stopwatch is not running.");
                }
            } else if (input.equalsIgnoreCase("reset")) {
                isRunning = false;
                System.out.println("Stopwatch reset.");
            } else if (input.equalsIgnoreCase("exit")) {
                System.out.println("Exiting the stopwatch.");
                break;
            } else {
                System.out.println("Invalid command. Please use 'start', 'stop', 'reset', or 'exit'.");
            }
        }

        scanner.close();
    }
}
