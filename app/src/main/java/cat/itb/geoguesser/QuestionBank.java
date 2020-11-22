package cat.itb.geoguesser;

public class QuestionBank {

    private int question;
    private boolean answer;
    private int button;

    public QuestionBank(){
    }

    public QuestionBank(int question, boolean answer, int button){

        this.question = question;
        this.answer = answer;
        this.button = button;

    }

    public int getButton() {
        return button;
    }

    public void setButton(int button) {
        this.button = button;
    }

    public int getQuestion() {
        return question;
    }

    public void setQuestion(int question) {
        this.question = question;
    }

    public boolean isAnswer() {
        return answer;
    }

    public void setAnswer(boolean answer) {
        this.answer = answer;
    }
}
