package com.github.elainecao93;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class MultipleAnswerQuestion extends Question {
    String question;
    ArrayList<String> answers;
    ArrayList<Integer> correctAnswers;
    
    public MultipleAnswerQuestion(String question, ArrayList<String> answers, ArrayList<Integer> correctAnswers) {
        this.question = question;
        this.answers = answers;
        this.correctAnswers = new ArrayList<>(new HashSet(correctAnswers));
    }

    @Override
    public String getPrompt() {
        String output = question + "\n";
        for(int i=0; i< answers.size(); i++)
            output += i + ": " + answers.get(1) + "\n";
        return output;
    }

    /*
    This basically takes in a "CSV" of answers. It expects a bunch of Integers, representing answers, separated by commas.
     */
    @Override
    public Boolean queryForResponse(String answer) {
        List<String> answers = new ArrayList<>(new HashSet(Arrays.asList(answer.split(","))));
        for (String elem : answers) {
            try {
                Integer thisElem = Integer.parseInt(elem);
                if (thisElem < 0 || thisElem > answers.size())
                    throw new IllegalAnswerException();
                if (!correctAnswers.contains(thisElem))
                    return false;
            } catch (NumberFormatException ignored) {
                throw new IllegalAnswerException();
            }
        }
        return answers.size() == correctAnswers.size();
    }
}
