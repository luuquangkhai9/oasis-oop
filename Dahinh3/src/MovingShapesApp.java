import javax.swing.*;

public class MovingShapesApp {
    private static final int width = 500;
    private static final int height = 500;
    private static final int time = 9;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(MovingShapesApp::runApplication);
    }

    private static void runApplication() {
        JFrame frame = createFrame();
        MovingShapesPanel circlesPanel = new MovingShapesPanel();
        setupFrame(frame, circlesPanel);

        Timer timer = createTimer(circlesPanel, frame);
        startTimer(timer);

        showFrame(frame);
    }

    private static JFrame createFrame() {
        JFrame frame = new JFrame();
        frame.setSize(width, height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        return frame;
    }

    private static void setupFrame(JFrame frame, MovingShapesPanel circlesPanel) {
        frame.add(circlesPanel);
    }

    private static Timer createTimer(MovingShapesPanel circlesPanel, JFrame frame) {
        return new Timer(time, e -> circlesPanel.moveShapes());
    }

    private static void startTimer(Timer timer) {
        timer.start();
    }

    private static void showFrame(JFrame frame) {
        frame.setVisible(true);
    }
}
