// working from home

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setSize(400,400);

        Arena panel = new Arena(5, false, true);

        frame.add(panel);

        frame.setVisible(true);
    }
}