import java.util.Scanner;

public class Task5 {
    public static void main(String[] args) {
        int timeSeconds = new Scanner(System.in).nextInt();

        Timer timer = new Timer(timeSeconds);
        timer.start();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        timer.stop();
    }
}


class Timer implements Task {

    private int timeSeconds;
    private Thread thread;

    public Timer(int timeSeconds) {
        this.timeSeconds = timeSeconds;
    }

    @Override
    public void start() {
        thread = new Thread(this::runTimer);
        thread.start();
    }

    @Override
    public void stop() {
        thread.interrupt();
    }

    private void runTimer() {
        while (timeSeconds > 0) {
            System.out.println(timeSeconds);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                timeSeconds--;
                break;
            }

            timeSeconds--;
        }

        System.out.println(timeSeconds);
    }
}

interface Task {
    /**
     * Запускает задачу
     */
    void start();

    /**
     * Останавливает задачу
     */
    void stop();
}
