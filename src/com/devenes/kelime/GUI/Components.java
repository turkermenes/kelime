package com.devenes.kelime.GUI;

import com.devenes.kelime.Appearance.Themes;
import com.devenes.kelime.Config;
import com.devenes.kelime.Core.Core;
import com.devenes.kelime.Core.Learn;
import com.devenes.kelime.Core.Rep;

import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.*;
import java.util.Timer;
import java.util.TimerTask;

import static com.devenes.kelime.Main.frame;

public class Components {
    JButton option1, option2, option3, option4, option5;
    JLabel questionLabel;
    JLabel timeLabel = new JLabel();
    JButton[] options = new JButton[5];
    Timer timer;
    Rep rep = new Rep();
    Learn learn = new Learn();
    Core core = new Core();
    Config config = new Config();
    Themes themes = new Themes();
    String fontName = "Century Gothic";
    public JPanel menuPanel() {

        config.readConfig();
        // Kelimet, Kelimetre, Kelimetren
        JLabel titleLabel = new JLabel("KELİMETRE");
        titleLabel.setFont(new Font("Century Gothic", Font.BOLD, 75));
        titleLabel.setForeground(themes.fifthColor);
        titleLabel.setBounds(200, 0, 500, 150);
        titleLabel.setVisible(true);
        int width = Frame.screenWidth / 4;
        int height = Frame.screenHeight / 10;

        JButton[] buttons = new JButton[4];

        JButton learnButton = new JButton("Kelime Öğren");
        JButton repButton = new JButton("Tekrar Yap");
        JButton listButton = new JButton("Kelime Listesi");
        JButton settingsButton = new JButton("Ayarlar");

        buttons[0] = learnButton;
        buttons[1] = repButton;
        buttons[2] = listButton;
        buttons[3] = settingsButton;

        for (int i = 0; i < buttons.length; i++) {
            buttons[i].setFocusable(false);
            buttons[i].setOpaque(false);
            buttons[i].setContentAreaFilled(false);
            buttons[i].setBorderPainted(false);
            buttons[i].setFocusPainted(false);
            buttons[i].setForeground(themes.thirdColor);
            buttons[i].setFont(new Font(fontName, Font.PLAIN, 25));
        }

        learnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Core.selectedMode = "learn";
                JLabel languageText = new JLabel("Dil:");
                languageText.setForeground(themes.thirdColor);
                languageText.setFont(new Font(fontName, Font.PLAIN, 23));
                languageText.setBounds(20, 20, 150, 50);
                languageText.setVisible(true);

                JComboBox<String> language = new JComboBox<>(Core.languages);
                language.setFont(new Font(fontName, Font.PLAIN, 20));
                language.setBounds(150, 30, 100,30);
                language.setVisible(true);

                JLabel numberText = new JLabel("Kelime Sayısı:");
                numberText.setForeground(themes.thirdColor);
                numberText.setFont(new Font(fontName, Font.PLAIN, 23));
                numberText.setBounds(20, 70, 180, 50);
                numberText.setVisible(true);

                String[] numbers = {"10", "20", "30", "40", "50", "60", "70", "80", "90", "100"};
                JComboBox<String> wordNumber = new JComboBox<>(numbers);
                wordNumber.setEditable(true);
                wordNumber.setSelectedItem("20");
                wordNumber.setFont(new Font(fontName, Font.PLAIN, 20));
                wordNumber.setBounds(200, 80, 50,30);
                wordNumber.setVisible(true);

                JLabel repText = new JLabel("Tekrar Sayısı:");
                repText.setForeground(themes.thirdColor);
                repText.setFont(new Font(fontName, Font.PLAIN, 23));
                repText.setBounds(20, 120, 150, 50);
                repText.setVisible(true);

                String[] reps = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
                JComboBox<String> repNumber = new JComboBox<>(reps);
                repNumber.setEditable(true);
                repNumber.setSelectedItem("5");
                repNumber.setFont(new Font(fontName, Font.PLAIN, 20));
                repNumber.setBounds(200, 130, 50,30);
                repNumber.setVisible(true);

                JButton startButton = new JButton("Başla!");
                startButton.setFont(new Font(fontName, Font.PLAIN, 20));
                startButton.setBounds(75, 200, 150,30);
                startButton.setFocusable(false);
                startButton.setBackground(themes.firstColor);
                startButton.setForeground(themes.thirdColor);

                JDialog adjustments = new JDialog(frame, "", true);

                startButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        learn.wordNumber = Integer.parseInt(String.valueOf(wordNumber.getSelectedItem()));
                        learn.repNumber = Integer.parseInt(String.valueOf(repNumber.getSelectedItem()));
                        if (learn.wordNumber >= 5) {
                            learn.generateWordList();
                            learn.generateQuestion();
                            adjustments.dispose();
                            frame.getContentPane().removeAll();
                            frame.repaint();
                            frame.revalidate();
                            frame.add(learnPanel());
                        } else {
                            JOptionPane.showMessageDialog(null, "En az 5 kelime seçmelisiniz!", "", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                });
                startButton.setVisible(true);

                adjustments.setSize(300, 300);
                adjustments.getContentPane().setBackground(themes.secondColor);
                adjustments.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
                adjustments.setLayout(null);
                adjustments.setResizable(false);
                adjustments.setLocationRelativeTo(frame);
                adjustments.add(languageText);
                adjustments.add(language);
                adjustments.add(numberText);
                adjustments.add(wordNumber);
                adjustments.add(repText);
                adjustments.add(repNumber);
                adjustments.add(startButton);
                adjustments.setVisible(true);
            }
        });
        learnButton.setBounds((int) (Frame.screenWidth * (3.0/8.0)), (int) (Frame.screenHeight * 0.4), width + 5, height);
        learnButton.setVisible(true);

        repButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Core.selectedMode = "rep";
                JLabel languageText = new JLabel("Dil:");
                languageText.setForeground(themes.thirdColor);
                languageText.setFont(new Font(fontName, Font.PLAIN, 23));
                languageText.setBounds(20, 20, 150, 50);
                languageText.setVisible(true);

                JComboBox<String> language = new JComboBox<>(Core.languages);
                language.setFont(new Font(fontName, Font.PLAIN, 20));
                language.setBounds(150, 30, 100,30);
                language.setVisible(true);

                JLabel listText = new JLabel("Liste:");
                listText.setForeground(themes.thirdColor);
                listText.setFont(new Font(fontName, Font.PLAIN, 23));
                listText.setBounds(20, 70, 150, 50);
                listText.setVisible(true);

                String[] lists = {"Tüm Kelimeler"};
                JComboBox<String> wordList = new JComboBox<>(lists);
                wordList.setFont(new Font(fontName, Font.PLAIN, 20));
                wordList.setBounds(100, 80, 150,30);
                wordList.setVisible(true);

                JButton startButton = new JButton("Başla!");
                startButton.setFont(new Font(fontName, Font.PLAIN, 20));
                startButton.setBounds(75, 200, 150,30);
                startButton.setFocusable(false);
                startButton.setBackground(themes.firstColor);
                startButton.setForeground(themes.thirdColor);

                JDialog adjustments = new JDialog(frame, "", true);

                startButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                        adjustments.dispose();
                        frame.getContentPane().removeAll();
                        frame.repaint();
                        frame.revalidate();
                        frame.add(repPanel());
                        core.resetTime();
                        timer = new Timer();
                        timer.schedule(new TimerTask() {
                            @Override
                            public void run() {
                                core.seconds++;
                                if (core.seconds >= 60) {
                                    core.seconds = 0;
                                    core.minutes++;
                                }

                                if (core.minutes >= 60) {
                                    core.minutes = 0;
                                    core.hours++;
                                }
                                timeLabel.setText(core.timeFormat());
                            }
                        }, 1000, 1000);
                    }
                });
                startButton.setVisible(true);

                adjustments.setSize(300, 300);
                adjustments.getContentPane().setBackground(themes.secondColor);
                adjustments.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
                adjustments.setLayout(null);
                adjustments.setResizable(false);
                adjustments.setLocationRelativeTo(frame);
                adjustments.add(languageText);
                adjustments.add(language);
                adjustments.add(listText);
                adjustments.add(wordList);
                adjustments.add(startButton);
                adjustments.setVisible(true);

            }
        });
        repButton.setBounds((int) (Frame.screenWidth * (3.0/8.0)), (int) (Frame.screenHeight * 0.53), width, height);
        repButton.setVisible(true);

        listButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        });
        listButton.setBounds((int) (Frame.screenWidth * (3.0/8.0)), (int) (Frame.screenHeight * 0.66), width, height);
        listButton.setEnabled(false);
        listButton.setVisible(true);

        settingsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JLabel themeText = new JLabel("Tema:");
                themeText.setForeground(themes.thirdColor);
                themeText.setFont(new Font(fontName, Font.PLAIN, 23));
                themeText.setBounds(20, 20, 150, 50);
                themeText.setVisible(true);

                JComboBox<String> theme = new JComboBox<>(themes.themes);
                theme.setSelectedItem(Themes.selectedTheme);
                theme.setFont(new Font(fontName, Font.PLAIN, 20));
                theme.setBounds(100, 30, 150,30);
                theme.setVisible(true);

                JButton okButton = new JButton("Tamam");
                okButton.setFont(new Font(fontName, Font.PLAIN, 20));
                okButton.setBounds(75, 200, 150,30);
                okButton.setFocusable(false);
                okButton.setBackground(themes.firstColor);
                okButton.setForeground(themes.thirdColor);

                JDialog adjustments = new JDialog(frame, "", true);

                okButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        adjustments.dispose();
                        if (theme.getSelectedItem().equals("Varsayilan")) {
                            Themes.selectedTheme = "Varsayilan";
                        } else if (theme.getSelectedItem().equals("Acik renk")) {
                            Themes.selectedTheme = "Acik renk";
                        } else if (theme.getSelectedItem().equals("Selm")) {
                            Themes.selectedTheme = "Selm";
                        } else if (theme.getSelectedItem().equals("Darkie")) {
                            Themes.selectedTheme = "Darkie";
                        }
                        themes.setSelectedTheme();
                        config.updateConfigSetting("theme");
                        config.readConfig();

                        //daha iyi çözüm bul temayı uygulamak için menü panelinde silip tekrar eklemek yerine
                        frame.getContentPane().removeAll();
                        frame.getContentPane().add(menuPanel());
                        frame.repaint();
                        frame.revalidate();
                    }

                });
                okButton.setVisible(true);

                adjustments.setSize(300, 300);
                adjustments.getContentPane().setBackground(themes.secondColor);
                adjustments.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
                adjustments.setLayout(null);
                adjustments.setResizable(false);
                adjustments.setLocationRelativeTo(frame);
                adjustments.add(themeText);
                adjustments.add(theme);
                adjustments.add(okButton);
                adjustments.setVisible(true);
            }
        });
        settingsButton.setBounds((int) (Frame.screenWidth * (3.0/8.0)), (int) (Frame.screenHeight * 0.79), width, height);
        settingsButton.setVisible(true);

        JPanel panel = new JPanel();
        panel.setBackground(themes.firstColor);
        panel.setSize(Frame.screenWidth, Frame.screenHeight);
        panel.setLayout(null);
        panel.add(titleLabel);
        panel.add(learnButton);
        panel.add(repButton);
        panel.add(listButton);
        panel.add(settingsButton);
        panel.setVisible(true);
        return panel;
    }

    public void update() {
        if (Core.selectedMode.equals("rep")) {
            for (int i = 0; i < options.length; i++) {
                options[i].setText(rep.words.get(i).getTurkish());
                options[i].setBackground(themes.secondColor);

            }
            questionLabel.setText(rep.question);
        } else if (Core.selectedMode.equals("learn")) {
            for (int i = 0; i < options.length; i++) {
                options[i].setText(learn.options.get(i).getTurkish());
                options[i].setBackground(themes.secondColor);
            }
            questionLabel.setText(learn.question);
        }
    }

    public JPanel learnPanel() {
        int width = Frame.screenWidth / 4;
        int height = Frame.screenHeight / 10;
        JPanel panel = new JPanel();
        panel.setBackground(themes.firstColor);
        panel.setSize(Frame.screenWidth, Frame.screenHeight);
        panel.setLayout(null);

        questionLabel = new JLabel();
        questionLabel.setBounds((int) (Frame.screenWidth * (3.0/8.0)), (int) (Frame.screenHeight * 0.15), width, height);
        questionLabel.setForeground(themes.thirdColor);
        questionLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                StringSelection stringSelection = new StringSelection(questionLabel.getText());
                Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
            }

        });
        questionLabel.setFont(new Font(fontName, Font.BOLD | Font.ITALIC, 30));
        questionLabel.setText(learn.question);
        questionLabel.setHorizontalAlignment(JTextField.CENTER);

        option1 = new JButton();
        options[0] = option1;
        option2 = new JButton();
        options[1] = option2;
        option3 = new JButton();
        options[2] = option3;
        option4 = new JButton();
        options[3] = option4;
        option5 = new JButton();
        options[4] = option5;


        double heightRatio = 0.3;
        for (int i = 0; i < options.length; i++) {
            options[i].setText(learn.options.get(i).getTurkish());
            options[i].setBackground(themes.secondColor);
            options[i].setFocusable(false);
            options[i].setFont(new Font(fontName, Font.BOLD | Font.ITALIC, 23));
            options[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JButton button = (JButton) e.getSource();
                    if(button.getText().equals(learn.answer)) {
                        for (int i = 0; i < learn.words.size(); i++) {
                            if (learn.words.get(i).getEnglish().equals(learn.question)) {
                                learn.words.get(i).setRep(learn.words.get(i).getRep() - 1);
                            }
                        }

                        System.out.println(learn.words);
                        learn.generateQuestion();
                        update();
                    }
                }
            });
            options[i].setBounds((int) (Frame.screenWidth * (3.0/8.0)), (int) (Frame.screenHeight * heightRatio), width, height);
            options[i].setForeground(themes.thirdColor);
            options[i].setVisible(true);
            panel.add(options[i]);
            heightRatio += 0.1;
        }

        panel.add(questionLabel);
        panel.add(backToMenuButton());
        panel.setVisible(true);
        return panel;
    }

    public JPanel repPanel() {
        int width = Frame.screenWidth / 4;
        int height = Frame.screenHeight / 10;
        JPanel panel = new JPanel();
        panel.setBackground(themes.firstColor);
        panel.setSize(Frame.screenWidth, Frame.screenHeight);
        panel.setLayout(null);

        timeLabel = new JLabel("00:00:00");
        timeLabel.setForeground(themes.thirdColor);
        timeLabel.setFont(new Font(fontName, Font.PLAIN, 30));
        timeLabel.setBounds(620, 20, 200, 50);
        timeLabel.setVisible(true);

        questionLabel = new JLabel();
        questionLabel.setBounds((int) (Frame.screenWidth * (2.8/8.0)), (int) (Frame.screenHeight * 0.15), width * 11 / 10, height);
        questionLabel.setForeground(themes.thirdColor);
        questionLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                StringSelection stringSelection = new StringSelection(questionLabel.getText());
                Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
            }

        });
        questionLabel.setFont(new Font("Century Gothic", Font.BOLD, 30));
        questionLabel.setText(rep.question);
        questionLabel.setHorizontalAlignment(JTextField.CENTER);

        option1 = new JButton();
        options[0] = option1;
        option2 = new JButton();
        options[1] = option2;
        option3 = new JButton();
        options[2] = option3;
        option4 = new JButton();
        options[3] = option4;
        option5 = new JButton();
        options[4] = option5;


        double heightRatio = 0.3;
        for (int i = 0; i < options.length; i++) {
            options[i].setText(rep.words.get(i).getTurkish());
            options[i].setBackground(themes.secondColor);
            options[i].setFocusable(false);
            options[i].setFont(new Font(fontName, Font.BOLD | Font.ITALIC, 23));
            options[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    optionClickedAction(e);
                }
            });
            options[i].setBounds((int) (Frame.screenWidth * (2.3/8.0)), (int) (Frame.screenHeight * heightRatio), (Frame.screenWidth / 24) * 10, height);
            options[i].setForeground(themes.thirdColor);
            options[i].setVisible(true);
            panel.add(options[i]);
            heightRatio += 0.1;
        }


        panel.add(timeLabel);
        panel.add(questionLabel);
        panel.add(backToMenuButton());
        panel.setVisible(true);
        return panel;
    }

    public JButton backToMenuButton() {
        int width = Frame.screenWidth / 5;
        int height = Frame.screenHeight / 10;
        JButton menuButton = new JButton("Menü");
        menuButton.setForeground(themes.thirdColor);
        menuButton.setFocusable(false);
        menuButton.setOpaque(false);
        menuButton.setContentAreaFilled(false);
        menuButton.setBorderPainted(false);
        menuButton.setFocusPainted(false);
        menuButton.setFont(new Font(fontName, Font.PLAIN, 30));
        menuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JDialog areYouSure = new JDialog(frame, "", true);

                JLabel areYouSureText = new JLabel();
                areYouSureText.setText("           Emin misiniz?");
                areYouSureText.setFont(new Font(fontName, Font.PLAIN, 25));
                areYouSureText.setForeground(themes.thirdColor);
                areYouSureText.setVisible(true);

                JButton yesButton = new JButton("Evet");
                yesButton.setFocusable(false);
                yesButton.setForeground(themes.thirdColor);
                yesButton.setOpaque(false);
                yesButton.setContentAreaFilled(false);
                yesButton.setBorderPainted(false);
                yesButton.setFocusPainted(false);
                yesButton.setFont(new Font(fontName, Font.PLAIN, 25));
                yesButton.setSize(50, 50);
                yesButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        areYouSure.dispose();
                        if (timer != null) {
                            timer.cancel();
                        }
                        frame.getContentPane().removeAll();
                        frame.add(menuPanel());
                        frame.repaint();
                    }
                });
                yesButton.setVisible(true);

                JButton noButton = new JButton("Hayır");
                noButton.setFont(new Font(fontName, Font.PLAIN, 25));
                noButton.setFocusable(false);
                noButton.setForeground(themes.thirdColor);
                noButton.setOpaque(false);
                noButton.setContentAreaFilled(false);
                noButton.setBorderPainted(false);
                noButton.setFocusPainted(false);
                noButton.setSize(50, 50);
                noButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        areYouSure.dispose();
                    }
                });
                noButton.setVisible(true);

                areYouSure.setSize(300, 300);
                areYouSure.getContentPane().setBackground(themes.secondColor);
                areYouSure.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
                areYouSure.setLayout(new GridLayout(3, 1));
                areYouSure.setResizable(false);
                areYouSure.setLocationRelativeTo(frame);
                areYouSure.add(areYouSureText);
                areYouSure.add(yesButton);
                areYouSure.add(noButton);
                areYouSure.setVisible(true);
            }
        });
        menuButton.setBounds(0, 20, width, height);

        menuButton.setVisible(true);
        return menuButton;
    }

    public void reset() {
    }


    public void optionClickedAction(ActionEvent e) {
        JButton button = (JButton) e.getSource();


        if(button.getText().equals(rep.answer)) {
            if (!button.getBackground().equals(Color.decode("#13632B")) && !button.getBackground().equals(Color.decode("#880015"))) {
                rep.correct++;
            }
            rep.generateWords();
            update();
        } else {
            button.setBackground(Color.decode("#880015"));
            options[rep.questionIndex].setBackground(Color.decode("#13632B"));
        }
        if (!button.getBackground().equals(Color.decode("#880015"))) {
        }
    }
}
