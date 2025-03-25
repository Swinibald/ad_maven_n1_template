package ch.hslu.ad.exercise.n1.vBalls;

public class Main {
    public static void main(String[] args) {
        Thread ballThread = new Thread(new BallTask());
        ballThread.start();
    }
}
