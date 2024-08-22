package com.devenes.kelime.Core;

import com.devenes.kelime.FileHandler;
import com.devenes.kelime.Word;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Learn {
    public int wordNumber, repNumber, questionIndex = 0;
    public String question, answer;
    public ArrayList<Word> options = new ArrayList<>();
    public ArrayList<Word> words = new ArrayList<>();
    Random random = new Random();
    String filePath = "C:\\Users\\Enest\\IdeaProjects\\Kelime\\src\\com\\devenes\\kelime\\Languages\\EN\\en-learn.txt";
    FileHandler fileHandler = new FileHandler(filePath);
    public void generateWordList() {
        List<String> lines = fileHandler.readFile();

        if (!lines.isEmpty()) {
            Random random = new Random();
            while (words.size() < wordNumber) {
                Word word = new Word();
                int randomIndex = random.nextInt(lines.size());
                String selectedLine = lines.get(randomIndex);

                String[] parts = selectedLine.split(",");
                if (parts.length == 3) {
                    word.setEnglish(parts[0]);
                    word.setTurkish(parts[1]);
                    word.setRep(repNumber);
                }

                if (!words.contains(word)) {
                    words.add(word);
                }
            }
            System.out.println(words);
        }
    }

    public void generateQuestion() {
        options.clear();

        while (options.size() != 5) {
            int index = random.nextInt(words.size());
            if (!options.contains(words.get(index))) {
                options.add(words.get(index));
            }
        }
        questionIndex = random.nextInt(options.size());
        while (options.get(questionIndex).getRep() <= 0) {
            questionIndex = random.nextInt(options.size());
        }
        question = options.get(questionIndex).getEnglish();
        answer = options.get(questionIndex).getTurkish();
    }
}
