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
        if (isTrue && answer.equals("true"))
            return true;
        if (!isTrue && answer.equals("false"))
            return true;
        throw new IllegalAnswerException();
    }
}
