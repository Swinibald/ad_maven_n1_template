package ch.hslu.ad.exercise.n1.vBalls;

public class BallTask implements Runnable {
    private final String[] colorList = {"red", "black", "blue", "yellow", "green", "magenta"};

    @Override
    public void run() {
        for (int i = 0; i < 50; i++) { // Generates 10 balls
            Ball ball = new Ball(sizeGen(), xPosGen(), yPosGen(), colorGen()); //create new ball
            Thread ballThread = new Thread(ball);// create new ballThread
            ballThread.start();//start ball Thread
            
        }
    }

    static int sizeGen() {
        return (int) (Math.random() * 31 + 20); // Random size between 20 and 50
    }

    private static int xPosGen() {
        return (int) (Math.random() * 600); // X position within canvas width
    }

    private static int yPosGen() {
        return (int) (Math.random() * 400); // y position within canvas height
    }

    private String colorGen() {
        return colorList[(int) (Math.random() * colorList.length)];// random ball color
    }

    public static int gravityGen() {
        return (int) (Math.random() * 5 + 5);// random gravity
    }
}
