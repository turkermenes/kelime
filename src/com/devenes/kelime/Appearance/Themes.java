package com.devenes.kelime.Appearance;

import java.awt.*;

public class Themes {
    public Themes() {
        setSelectedTheme();
    }

    public static String selectedTheme;
    public Color firstColor, secondColor, thirdColor, fourthColor, fifthColor;
    // first color -> arkaplan rengi 1
    // second color -> arkaplan rengi 2 & seçenekler
    // third color -> yazılar
    // fourth color -> yazılar 2
    // fifth color -> uygulama başlığı
    public String[] themes = {"Varsayilan", "Darkie", "Acik renk", "Selm"};
    public void setSelectedTheme() {
        switch (selectedTheme) {
            case "Varsayilan":
                setDefaultTheme();
                break;
            case "Acik renk":
                setLightTheme();
                break;
            case "Selm":
                setSelmTheme();
                break;
            case "Darkie":
                setDarkieTheme();
        }
    }

    public void setDefaultTheme() {
        firstColor = Color.decode("#395A94");
        secondColor = Color.decode("#2A436E");
        thirdColor = Color.white;
        fourthColor = Color.black;
        fifthColor = Color.decode("#152136");
    }

    public void setLightTheme() {
        firstColor = Color.decode("#ADADAD");
        secondColor = Color.decode("#C7C7C7");
        thirdColor = Color.black;
        fourthColor = Color.black;
        fifthColor = Color.decode("#262626");
    }

    public void setSelmTheme() {
        firstColor = Color.decode("#FF7F27");
        secondColor = Color.decode("#C2611E");
        thirdColor = Color.white;
        fourthColor = Color.white;
        fifthColor = Color.decode("#7920C2");
    }

    public void setDarkieTheme() {
        firstColor = Color.decode("#1C1C1C");
        secondColor = Color.decode("#262626");
        thirdColor = Color.decode("#BABABA");
        fourthColor = Color.decode("#BABABA");
        fifthColor = Color.decode("#AD151B");
    }
}
