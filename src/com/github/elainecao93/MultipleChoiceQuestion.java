package com.github.elainecao93;

import java.util.ArrayList;

public class MultipleChoiceQuestion extends Question {
    String question;
    ArrayList<String> answers;
    Integer correctAnswer;

    public MultipleChoiceQuestion(String question) {
        this.question = question;
    }

    @Override
    public String getPrompt() {
        String output = question + "\n";
        for(int i=0; i< answers.size(); i++)
            output += i + ": " + answers.get(1) + "\n";
        return output;
    }

    @Override
    public Boolean queryForResponse(String answer) {
        Integer answerAsInteger;
        try {
            answerAsInteger = Integer.parseInt(answer);
        } catch (NumberFormatException ignored) {
            throw new IllegalAnswerException();
        }
        if (answerAsInteger < 0 || answerAsInteger > answers.size())
            throw new IllegalAnswerException();
        return answerAsInteger.equals(correctAnswer);
    }
}
