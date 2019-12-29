package me.geed.util;

import java.util.ArrayList;
import java.util.List;

import me.geed.models.Question;

public  class QuestionInitializer {
    private static int counter = 0;
    private static List<Question> questions;

    public static  void initializeQuestions(){
        questions = new ArrayList<Question>();

        questions.add(new Question("Soru 1 Başlık","Soru 1 Açıklama"));
        questions.add(new Question("Soru 2 Başlık","Soru 2 Açıklama"));
        questions.add(new Question("Soru 3 Başlık","Soru 3 Açıklama"));
        questions.add(new Question("Soru 4 Başlık","Soru 4 Açıklama"));
        questions.add(new Question("Soru 5 Başlık","Soru 5 Açıklama"));
        questions.add(new Question("Soru 6 Başlık","Soru 6 Açıklama"));
        questions.add(new Question("Soru 7 Başlık","Soru 7 Açıklama"));
        questions.add(new Question("Soru 8 Başlık","Soru 8 Açıklama"));
        questions.add(new Question("Soru 9 Başlık","Soru 9 Açıklama"));
        questions.add(new Question("Soru 10 Başlık","Soru 10 Açıklama"));
        questions.add(new Question("Soru 12 Başlık","Soru 11 Açıklama"));
        questions.add(new Question("Soru 13 Başlık","Soru 12 Açıklama"));
        questions.add(new Question("Soru 14 Başlık","Soru 13 Açıklama"));
        questions.add(new Question("Soru 15 Başlık","Soru 14 Açıklama"));
        questions.add(new Question("Soru 16 Başlık","Soru 15 Açıklama"));
        questions.add(new Question("Soru 17 Başlık","Soru 16 Açıklama"));

    }

    public static Question getCurrentQuestion(){
        return questions.get(counter);
    }

    public static Question getNextQuestion(){
        if(questions.size()-1 > counter ){
            counter++;
        }
        else{
            //list out of index error
        }
        return questions.get(counter);
    }

    public static Question getPreviousQuestion(){
        if(counter > 0 ){
            counter--;
        }
        else{
            //list out of index error
        }
        return questions.get(counter);
    }



}
