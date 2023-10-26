package pl.edu.pb.wi;

public class Question {
    private int questionId;
    private boolean trueAnswer;

    public Question(int questionId, boolean trueAnswer) {
        this.questionId = questionId;
        this.trueAnswer = trueAnswer;
    }

    public int getId() {
        return questionId;
    }

    public boolean isTrueAnswer() {
        return trueAnswer;
    }
}