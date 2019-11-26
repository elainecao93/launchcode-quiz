package com.github.elainecao93;

public abstract class Question {

    public abstract String getPrompt();

    public abstract Boolean queryForResponse(String answer);
}
