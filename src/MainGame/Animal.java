package MainGame;

public class Animal {
    protected String Question;
    protected String name;
    protected Animal yes;
    protected Animal No;
    protected void ConstructQuest(){
        //we know that when we come across is it question, we have to let something for the program
        //when to stop if the answer is yes
        Question = "is it a "+ name + "?";
        name = null;
    }
    public Animal(String question, String name, Animal yes, Animal no) {
        Question = question;
        this.name = name;
        this.yes = yes;
        No = no;
    }
}
