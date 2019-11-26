package com.github.elainecao93;

public class IllegalAnswerException extends IllegalArgumentException {
    /*
    This is basically an Exception that represents a state where the user enters a nonsense answer that doesn't make sense.
    This state should be handled by the Quiz object but right noq the error handling is stubbed out.
     */
    public IllegalAnswerException() {
        super("You put in an answer that doesn't make sense.");
    }
}
