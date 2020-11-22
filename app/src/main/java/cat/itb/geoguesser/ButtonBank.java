package cat.itb.geoguesser;

public class ButtonBank {

    private int answerText;
    private boolean answer;

    public ButtonBank(){
    }

    public ButtonBank(int answerText, boolean answer){

        this.answer = answer;
        this.answerText = answerText;

    }


    public int getAnswerText() {
        return answerText;
    }

    public void setAnswerText(int answerText) {
        this.answerText = answerText;
    }

    public boolean isAnswer() {
        return answer;
    }

    public void setAnswer(boolean answer) {
        this.answer = answer;
    }
}
