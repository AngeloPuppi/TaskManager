public class Tasks {
    private String name;
    private boolean completed;

    public Tasks(){
        this.name = "";
        this.completed = false;
    }

    public Tasks(String text, boolean state){
        setName(text);
        setCompleted(state);
    }

    public void setName(String name){
        this.name = name;
    }

    public void setCompleted(boolean completed){
        this.completed = completed;
    }

    public String getName(){
        return name;
    }   

    public boolean getCompleted(){
        return completed;
    }

}
