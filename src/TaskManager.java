import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class TaskManager{

    private Validator validator = new Validator();
    private ArrayList<Tasks> taskManager = new ArrayList<>();
    private final String FILE_NAME = "task.txt";
    

    public void SaveTxt(){
        try (FileWriter file = new FileWriter(FILE_NAME);
            PrintWriter txt = new PrintWriter(file)) {
            for(int i = 0; i < taskManager.size(); i++){
            Tasks Task = taskManager.get(i);
            txt.println(Task.getName() + "|" + Task.getCompleted());
            }
        }catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void LoadTxt() throws IOException{

        try(FileReader file = new FileReader(FILE_NAME);
            BufferedReader reader = new BufferedReader(file)) {
            
            String text;
            while ((text = reader.readLine()) != null) { 
                String[] parts = text.split("\\|");       
                String task = parts[0];                         
                Boolean state = Boolean.parseBoolean(parts[1]);
                Tasks newTask = new Tasks(task, state);
                taskManager.add(newTask);    
                }
            
        } catch(FileNotFoundException e){
            System.out.println("No task found");
        } 
            
        catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public TaskManager(){
        try {
            LoadTxt();         
        } catch (IOException e) {
            System.out.println("No task loaded");
        }
    }

    public void MenuSelector(){
        
        boolean runnin = true; 

    while (runnin){
        System.out.println("Choose a number");
        System.out.println("1. to Add task to list");
        System.out.println("2. to Remove task from list");
        System.out.println("3. to Set task as completed");
        System.out.println("4. to Set task as not completed");
        System.out.println("5. to Show list");
        System.out.println("6. to Exit");

        int number = validator.CheckInt(1, 6);

        switch(number){
            case 1: 
                AddTask();
                SaveTxt();
                System.out.println("");
                break;
            case 2:
                RemoveTask();
                SaveTxt();
                System.out.println("");
                break;
            case 3:
                CompleteTask();
                SaveTxt();
                System.out.println("");
                break;
            case 4:
                NoCompleteTask();
                SaveTxt();
                System.out.println("");
                break;
            case 5:
                ShowTask();
                SaveTxt();
                System.out.println("");
                break;
            case 6:
                runnin = false;
                System.out.println("Saving tasks");
                SaveTxt();
                System.out.println("Tasks saved");
                System.out.println("");
                break;
            default:
                System.out.println("");
            }
        }
    }

    public void AddTask(){

        System.out.println("Which task woud you like to add?");
        Tasks newTask = new Tasks(validator.CheckString(), false);
        taskManager.add(newTask);
        System.out.println("Task added!");
    }

    public void RemoveTask(){
        System.out.println("What task woud you like to remove?");
        ShowTask();
        if (taskManager.isEmpty()) {
            System.out.println("There are no tasks yet");
            System.out.println("Provide some first!");
            System.out.println();
        }
        else{
        int number = validator.CheckInt(1,taskManager.size());
        Tasks removedTask = taskManager.remove(number-1);
        }
        System.out.println("Task removed!");
    }

    public void CompleteTask(){
        System.out.println("What task woud you like to set as completed?");
        ShowTask();
        if(taskManager.isEmpty()){
            System.out.println("There are no tasks yet");
            System.out.println("Provide some first!");
            System.out.println();
        }
        else{
            int number = validator.CheckInt(1, taskManager.size());
            Tasks CompleteTask = taskManager.get((number-1));
            CompleteTask.setCompleted(true);
        }
        System.out.println("Task updated!");
    }

    public void NoCompleteTask(){
        System.out.println("What task woud you like to set as not completed?");
        ShowTask();
        if(taskManager.isEmpty()){
            System.out.println("There are no tasks yet");
            System.out.println("Provide some first!");
            System.out.println();
        }
        else{
            int number = validator.CheckInt(1, taskManager.size());
            Tasks completeTask = taskManager.get((number-1));
            completeTask.setCompleted(false);
        }
        System.out.println("Task updated!");
    }

    public void ShowTask(){
        if(taskManager.isEmpty()){
            System.out.println("Provide some tasks first!");
        }
        else{
            System.out.println("Your Tasks");
        for(int i = 0; i < taskManager.size(); i++){
            Tasks Task = taskManager.get(i);
            boolean state = Task.getCompleted();
            String mark;
                if (state){
                     mark = "X";
                }
                else{
                    mark = "";
                }
            System.out.println( (i+1) + ". [" + mark + "] " + Task.getName());
            }
        }
        System.out.println();
    }
}
