package com.github.elainecao93;

import java.util.ArrayList;
import java.util.Scanner;

public class Quiz {
    public static void main(String[] args) {
        ArrayList<Question> questions = new ArrayList<>();
        //TODO make your questions here like this: questions.add(new MultipleChoiceQuestion(...)); ...

        Scanner sc = new Scanner(System.in);

        Integer score = 0;
        for (Question question : questions) {
            System.out.println(question.getPrompt());
            try {
                if (question.queryForResponse(sc.nextLine())) {
                    score ++;
                    System.out.println("Correct!");
                } else {
                    System.out.println("Wrong :(");
                }
            } catch (IllegalAnswerException ex) {
                System.out.println("You entered something stupid. You get no points.");
                //TODO the correct solution would probably be to have it repeat the prompt in this case, but I'm lazy
            }
        }
        System.out.println("Score is: " + score);
    }
}
