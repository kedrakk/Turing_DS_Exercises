/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.turingds.dsexercise.machinelearning;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author kedk
 */
public class NaiveBayesianSpamClassifer {

    List<String> spamTrainingSet = new ArrayList<>();
    List<String> hamTrainingSet = new ArrayList<>();

    List<String> spamTestSet = new ArrayList<>();
    List<String> hamTestSet = new ArrayList<>();

    List<String> stopWord = new ArrayList<>();
    List<String> wordsList = new ArrayList<>();

    Map<String, Double> wordProb = new HashMap<>();
    Map<String, Double> wordSpamProb = new HashMap<>();
    Map<String, Double> wordHamProb = new HashMap<>();

    double probSpam, probHam;

    NaiveBayesianSpamClassifer() {
        this.stopWord.add("us");
        this.stopWord.add("your");
        this.stopWord.add("our");
        this.stopWord.add("the");
    }

    public void buildWordList() {
        for (String spam : spamTrainingSet) {
            String[] words = spam.split(" ");
            for (String word : words) {
                if (!this.stopWord.contains(word)) {
                    this.wordsList.add(word);
                }
            }
        }
        for (String ham : hamTrainingSet) {
            String[] words = ham.split(" ");
            for (String word : words) {
                if (!this.stopWord.contains(word)) {
                    this.wordsList.add(word);
                }
            }
        }
    }

    void addSpamTraining(String word) {
        this.spamTrainingSet.add(word);
    }

    void addHamTraining(String word) {
        this.hamTrainingSet.add(word);
    }

    void buildWordProb() {
        int total = this.spamTrainingSet.size() + this.hamTrainingSet.size();
        for (String word : wordsList) {
            double noOfDocInSpam = this.noOfSpamDocWithWord(word);
            double noOfDocInHam = this.noOfHamDocWithWord(word);
            double noOfDoc = this.noOfDocWithWord(word);
            double prob = 0.0000001;
            double spamProb = 0.0000001;
            double hamProb = 0.0000001;
            if (noOfDoc > 0) {
                prob = noOfDoc / total;
            }
            this.wordProb.put(word, prob);

            if (noOfDocInSpam > 0) {
                spamProb = noOfDocInSpam / this.spamTrainingSet.size();
            }
            this.wordSpamProb.put(word, spamProb);

            if (noOfDocInHam > 0) {
                hamProb = noOfDocInHam / this.hamTrainingSet.size();
            }
            this.wordHamProb.put(word, hamProb);
        }
    }

    int noOfDocWithWord(String word) {
        int count = noOfSpamDocWithWord(word) + noOfHamDocWithWord(word);
        return count;
    }

    private int noOfSpamDocWithWord(String word) {
        int count = 0;
        for (String spam : this.spamTrainingSet) {
            if (spam.contains(word)) {
                count++;
            }
        }
        return count;
    }

    private int noOfHamDocWithWord(String word) {
        int count = 0;
        for (String ham : this.hamTrainingSet) {
            if (ham.contains(word)) {
                count++;
            }
        }
        return count;
    }

    void train() {
        int total = this.spamTrainingSet.size() + this.hamTrainingSet.size();
        this.probSpam = ((double) this.spamTrainingSet.size() / total);
        this.probHam = ((double) this.hamTrainingSet.size() / total);

        this.buildWordList();
        this.buildWordProb();
    }

    double getWordSpamProb(String word) {
        return this.wordSpamProb.get(word) == null ? 0.0000001 : this.wordSpamProb.get(word);
    }

    double getWordHamProb(String word) {
        return this.wordHamProb.get(word) == null ? 0.0000001 : this.wordHamProb.get(word);
    }

    double getWordProb(String word) {
        return this.wordProb.get(word) == null ? 0.0000001 : this.wordProb.get(word);
    }

    String classify(String email) {
        String label = "";
        String[] words = email.toLowerCase().split(" ");

        double spamProbCount = 1;
        double hamProbCount = 1;

        for (String word : words) {
            if (!this.stopWord.contains(word)) {
                spamProbCount *= getWordSpamProb(word) * this.probSpam / getWordProb(word);
                hamProbCount *= getWordHamProb(word) * this.probHam / getWordProb(word);
            }
        }

        return spamProbCount > hamProbCount ? "Spam" : "Ham";
    }

    public static void main(String[] args) {
        NaiveBayesianSpamClassifer model = new NaiveBayesianSpamClassifer();
        model.addSpamTraining("send us your password");
        model.addSpamTraining("review our website");
        model.addSpamTraining("send your password");
        model.addSpamTraining("send us your account");

        model.addHamTraining("Your activity report");
        model.addHamTraining("benefits physical activity");
        model.addHamTraining("the importance vows");

        model.train();

        System.out.println("Test spam:" + model.classify("renew your password"));
        System.out.println("Test spam:" + model.classify("renew your vows"));

        System.out.println("Test ham:" + model.classify("benefits of your account"));
        System.out.println("Test ham:" + model.classify("the importance of physical activity"));
    }
}
