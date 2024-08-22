package com.devenes.kelime;

import com.devenes.kelime.GUI.Frame;

import javax.swing.*;

public class Main {
    public static Frame frame = new Frame();

    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                frame.setVisible(true);
            }
        });

    }
}
