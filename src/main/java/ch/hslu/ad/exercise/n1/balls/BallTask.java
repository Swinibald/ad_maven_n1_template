package ch.hslu.ad.exercise.n1.balls;

public class BallTask implements Runnable{
    private String[] colorList = {"red", "black", "blue", "yellow", "green", "magenta"};
    public BallTask(){
        
    }
    
    @Override
    public void run() {
        Ball ball = new Ball(sizeGen(), xPosGen(), yPosGen(), colorGen());
    }
    
    public int sizeGen(){
        return (int)(Math.random() * 31 + 10);
    }

    public int xPosGen(){
        return (int)(Math.random() * 601);
    }
    
    public int yPosGen(){
        return (int)(Math.random() * 401);
    }

    public String colorGen(){
       return colorList[(int)(Math.random() * 6)];
    }

    public int gravityGen(){
        return (int)(Math.random() * 101);
    }


}
