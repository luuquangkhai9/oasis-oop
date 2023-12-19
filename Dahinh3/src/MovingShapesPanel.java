import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MovingShapesPanel extends JPanel {
    private final List<Shape> shapes;

    public MovingShapesPanel() {
        shapes = createRandomShapes(19);
    }

    private List<Shape> createRandomShapes(int count) {
        List<Shape> randomShapes = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < count; i++) {
            int x = random.nextInt(Math.max(getWidth() - 50, 1)) + 25;
            int y = random.nextInt(Math.max(getHeight() - 50, 1)) + 25;

            int shapeType = random.nextInt(3); // 0: Circle, 1: Square, 2: Triangle

            switch (shapeType) {
                case 0:
                    int radius = random.nextInt(30) + 20;
                    Color color = new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256));
                    int xSpeed = random.nextInt(10) - 5;
                    int ySpeed = random.nextInt(10) - 5;
                    randomShapes.add(new Circle(x, y, radius, color, xSpeed, ySpeed));
                    break;
                case 1:
                    int squareSideLength = random.nextInt(40) + 20;
                    Color rectColor = new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256));
                    int rectXSpeed = random.nextInt(10) - 5;
                    int rectYSpeed = random.nextInt(10) - 5;
                    randomShapes.add(new Square(x, y, squareSideLength, rectColor, rectXSpeed, rectYSpeed));
                    break;
                case 2:
                    int triangleSideLength = random.nextInt(40) + 20;
                    Color triangleColor = new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256));
                    int triangleXSpeed = random.nextInt(10) - 5;
                    int triangleYSpeed = random.nextInt(10) - 5;
                    randomShapes.add(new Triangle(x, y, triangleSideLength, triangleColor, triangleXSpeed, triangleYSpeed));
                    break;
            }
        }

        return randomShapes;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (Shape shape : shapes) {
            shape.draw(g);
        }
    }

    public void moveShapes() {
        for (Shape shape : shapes) {
            shape.move(getWidth(), getHeight());
        }
        repaint();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Moving Shapes Example");
            frame.setSize(400, 400);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            MovingShapesPanel shapesPanel = new MovingShapesPanel();
            frame.add(shapesPanel);

            Timer timer = new Timer(9, e -> shapesPanel.moveShapes());
            timer.start();

            frame.setVisible(true);
        });
    }
}
