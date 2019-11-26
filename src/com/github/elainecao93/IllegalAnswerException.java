package com.github.elainecao93;

public class IllegalAnswerException extends IllegalArgumentException {
    public IllegalAnswerException() {
        super("You put in an answer that doesn't make sense.");
    }
}
