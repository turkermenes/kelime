package com.devenes.kelime.GUI;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Frame extends JFrame {

    public static int screenWidth = 800;
    public static int screenHeight = 600;
    Components components = new Components();
    public Frame() {
        super("Kelimetre");
        setResizable(false);
        setSize(screenWidth, screenHeight);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setFocusable(true);
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                int keyCode = e.getKeyCode();
                if (keyCode >= KeyEvent.VK_1 && keyCode <= KeyEvent.VK_5) {
                    int index = keyCode - KeyEvent.VK_1;
                    components.options[index].doClick();
                }
            }
        });
        add(components.menuPanel());
    }
}
