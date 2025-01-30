package com.devenes.kelime.Core;

import com.devenes.kelime.FileHandler;
import com.devenes.kelime.Word;

import java.util.*;

public class Rep {
    public Word word;
    public String question, answer = "";
    public List<Word> words = new ArrayList<>();
    public int correct, questionIndex = 0;
    String filePath = ".\\src\\com\\devenes\\kelime\\Languages\\EN\\en-learning.txt";
    FileHandler fileHandler = new FileHandler(filePath);
    public Rep() {
        generateWords();
    }
    public void selectWord() {
        List<String> lines = fileHandler.readFile();

        if (!lines.isEmpty()) {
            Random random = new Random();
            int randomIndex = random.nextInt(lines.size());
            String selectedLine = lines.get(randomIndex);

            String[] parts = selectedLine.split(",");
            if (parts.length == 3) {
                word = new Word(parts[0], parts[1], Integer.parseInt(parts[2]));
            }
        }
    }
    public void generateWords() {
        words.clear();
        Random random = new Random();

        while (words.size() != 5) {
            selectWord();
            if (!words.contains(word)) {
                words.add(word);
            }
        }
        questionIndex = random.nextInt(5);
        question = words.get(questionIndex).getEnglish();
        answer = words.get(questionIndex).getTurkish();
    }
}
