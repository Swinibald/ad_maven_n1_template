package ch.hslu.ad.exercise.n1.vBalls;



public final class Ball implements Runnable {

    private final Circle circle;
    private final int size;

    /**
     * Creates a ball with given size, position, and color.
     *
     * @param size Size of the ball.
     * @param xPos X position of the ball.
     * @param yPos Y position of the ball.
     * @param color Color of the ball.
     */
    public Ball(final int size, final int xPos, final int yPos, String color) {
        this.size = size;
        this.circle = new Circle(xPos, yPos, size, color); // Ensure circle is initialized
        Canvas.getCanvas().draw(circle, color, new java.awt.geom.Ellipse2D.Double(circle.getX(), circle.getY(), size, size));
    }
    
    @Override
    public void run() {
        int groundLevel = 400;
        int speed = BallTask.gravityGen(); // Random fall speed
        
        // Continue moving the ball until it reaches the ground
        while (circle.getY() + size < groundLevel) {
            circle.moveVertical(speed); // Update vertical position of the ball
            circle.moveHorizontal(BallTask.gravityGen());// Move ball 
            circle.moveHorizontal(-BallTask.gravityGen());
            
            // Erase previous ball position and redraw it in the new position
            Canvas.getCanvas().erase(circle);  // Erase the ball from the old position
            Canvas.getCanvas().draw(circle, circle.getColor(), new java.awt.geom.Ellipse2D.Double(circle.getX(), circle.getY(), size, size)); // Draw ball at new position
            
            Canvas.getCanvas().redraw(); // Force repaint to update the canvas with the new ball position
            
            Canvas.getCanvas().wait(50); // Small delay to control animation speed
        }
        
        // Ball disappears after reaching the ground
        Canvas.getCanvas().erase(circle);
    }
}
