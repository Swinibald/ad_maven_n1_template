package ch.hslu.ad.exercise.n1.balls;

public class BallTask implements Runnable {
    private final String[] colorList = {"red", "black", "blue", "yellow", "green", "magenta"};

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) { // Generates 10 balls
            Ball ball = new Ball(sizeGen(), xPosGen(), yPosGen(), colorGen());
            Thread ballThread = new Thread(ball);
            ballThread.start();

            try {
                Thread.sleep(500); // Small delay between ball creations
            } catch (InterruptedException e) {
                System.out.println("BallTask interrupted!");
            }
        }
    }

    static int sizeGen() {
        return (int) (Math.random() * 31 + 20); // Random size between 20 and 50
    }

    private static int xPosGen() {
        return (int) (Math.random() * 600); // X position within canvas width
    }

    private static int yPosGen() {
        return (int) (Math.random() * 400); // Start at the top
    }

    private String colorGen() {
        return colorList[(int) (Math.random() * colorList.length)];
    }

    public static int gravityGen() {
        return (int) (Math.random() * 5 + 5);
    }
}
