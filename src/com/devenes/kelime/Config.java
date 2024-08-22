package com.devenes.kelime;

import com.devenes.kelime.Appearance.Themes;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

public class Config {
    String filePath = "C:\\Users\\Enest\\IdeaProjects\\Kelime\\src\\com\\devenes\\kelime\\config.properties";
    public Config() {
        readConfig();
    }
    public void readConfig() {
        Properties properties = new Properties();

        try (InputStreamReader reader = new InputStreamReader(new FileInputStream(filePath), StandardCharsets.UTF_8)) {
            properties.load(reader);

            Themes.selectedTheme = properties.getProperty("theme");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void updateConfigSetting(String setting) {
        Properties properties = new Properties();
        switch (setting) {
            case "theme":
                properties.setProperty(setting, Themes.selectedTheme);
                break;
        }
        try (FileOutputStream out = new FileOutputStream(filePath)) {
            properties.store(out, "Updated theme setting");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
