import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Stopwatch extends JFrame {

    private JLabel timeLabel;
    private JButton startButton;
    private JButton stopButton;
    private JButton resetButton;

    private long startTime;
    private boolean running;

    public Stopwatch() {  // CONSTRUCTOR OF "Stopwatch" CLASS
        setTitle("TIMER And STOPWATCH");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 150);
        setLayout(new FlowLayout());

        timeLabel = new JLabel("00:00:00.000");
        timeLabel.setFont(new Font("Arial", Font.PLAIN, 24));
        add(timeLabel);

        startButton = new JButton("Start");
        stopButton = new JButton("Stop");
        resetButton = new JButton("Reset");

        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!running) {
                    startTime = System.currentTimeMillis();
                    running = true;
                    startButton.setEnabled(false);
                    stopButton.setEnabled(true);
                    resetButton.setEnabled(false);
                    updateTime();
                }
            }
        });

        stopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (running) {
                    running = false;
                    startButton.setEnabled(true);
                    stopButton.setEnabled(false);
                    resetButton.setEnabled(true);
                }
            }
        });

        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                running = false;
                startButton.setEnabled(true);
                stopButton.setEnabled(false);
                resetButton.setEnabled(false);
                timeLabel.setText("00:00:00.000");
            }
        });

        add(startButton);
        add(stopButton);
        add(resetButton);
    }

    private void updateTime() {  // METHOD OF "Stopwatch" CLASS
        if (running) {
            long currentTime = System.currentTimeMillis() - startTime;
            long hours = currentTime / 3600000;
            long minutes = (currentTime % 3600000) / 60000;
            long seconds = (currentTime % 60000) / 1000;
            long milliseconds = currentTime % 1000;
            timeLabel.setText(String.format("%02d:%02d:%02d.%03d", hours, minutes, seconds, milliseconds));
            SwingUtilities.invokeLater(this::updateTime);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Stopwatch stopwatch = new Stopwatch();
            stopwatch.setVisible(true);
        });
    }
}
