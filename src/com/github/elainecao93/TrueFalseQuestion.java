package com.github.elainecao93;

public class TrueFalseQuestion extends Question {

    String question;
    Boolean isTrue;

    public TrueFalseQuestion(String question, Boolean isTrue) {
        this.question = question;
        this.isTrue = isTrue;
    }

    @Override
    public String getPrompt() {
        return question + "\n" +
                "True\n" +
                "False\n";
    }

    @Override
    public Boolean queryForResponse(String answer) {
        if (isTrue) {
            if (answer.equals("true"))
                return true;
            if (answer.equals("false"))
                return false;
        } else {
            if (answer.equals("false"))
                return true;
            if (answer.equals("true"))
                return false;
        }
        throw new IllegalAnswerException();
    }
}
