package com.github.elainecao93;

import java.util.ArrayList;

public class MultipleAnswerQuestion extends Question {
    String question;
    ArrayList<String> answers;
    ArrayList<Integer> correctAnswers;

    public MultipleAnswerQuestion(String question, ArrayList<String> answers, ArrayList<Integer> correctAnswers) {
        this.question = question;
        this.answers = answers;
        this.correctAnswers = correctAnswers;
    }

    @Override
    public String getPrompt() {
        String output = question + "\n";
        for(String elem : answers)
            output += elem + "\n";
        return output;
    }

    @Override
    public Boolean queryForResponse(String answer) {
        String[] answers = answer.split(",");
        for (String elem : answers) {
            try {
                Integer thisElem = Integer.parseInt(elem);
                if (thisElem < 0 || thisElem > answers.length)
                    throw new IllegalAnswerException();
                if (!correctAnswers.contains(thisElem))
                    return false;
            } catch (NumberFormatException ignored) {
                throw new IllegalAnswerException();
            }

        }
        return true;
    }
}
