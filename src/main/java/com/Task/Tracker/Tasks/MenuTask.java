package com.Task.Tracker.Tasks;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MenuTask {
    private List<Task> tasks;
    private final TaskFileHandler fileHandler = new TaskFileHandler();

    Scanner sc = new Scanner(System.in);
    List<Task> listTasks = new ArrayList<Task>();

    public void menuTask(){

        this.listTasks = fileHandler.load();

        int choice;
        System.out.println("MENU TASK");

        do {
            System.out.println("1. Add Task");
            System.out.println("2. Remove Task");
            System.out.println("3. List Tasks");
            System.out.println("4. List Tasks Completed");
            System.out.println("5. List Unfinished Tasks");
            System.out.println("6. Modify Status");
            System.out.println("7. Exit");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> {
                    System.out.println("What's your task ? ");
                    String task = sc.nextLine();
                    System.out.println("What's the task description ?");
                    String description = sc.nextLine();

                    addTask(task, description);
                }

                case 2 -> { deleteTask(); }

                case 3 -> { viewTasks(); }

                case 4 -> { viewCompletedTasks(); }

                case 5 -> { viewUnfinishedTasks(); }

                case 6 -> { modifyStatus(); }
            }

        } while (choice != 7);

    }


    public void addTask(String nome, String descricao){
        Task newTask = new Task(nome, descricao);
        listTasks.add(newTask);

        fileHandler.save(listTasks);

    }

    public void deleteTask(){
        viewTasks();
        System.out.println("Which task do you want to remove ?");
        int choice = sc.nextInt();
        sc.nextLine();
        if  (choice > 0 && choice <= listTasks.size()){
            listTasks.remove((choice - 1));

            fileHandler.save(listTasks);

        } else {
            System.out.println("invalid number");
        }

    }


    public void viewTasks(){
        if (alertListEmpty(listTasks)) { return; }

        for(int i = 0; i < listTasks.size(); i++){
            System.out.println((i+1) + " " +listTasks.get(i));
        }
    }

    public void viewCompletedTasks(){
        if (alertListEmpty(listTasks)) { return; }

        for (Task t: listTasks){
            if(t.getStatus()) {
                System.out.println(t);
            }
        }
    }

    public void viewUnfinishedTasks(){
        if (alertListEmpty(listTasks)) { return; }

        for (Task t: listTasks){
            if(!t.getStatus()) {
                System.out.println(t);
            }
        }
    }

    public void modifyStatus(){
        viewTasks();
        System.out.println("Which task do you want to modify status ?");
        int choice = sc.nextInt();
        sc.nextLine();
        listTasks.get((choice-1)).changeStatus();

    }

    public  boolean alertListEmpty(List<Task> listTasks){
        if (listTasks.isEmpty()){
            System.out.println("The list is empty");
            return true;
        }
        return false;
    }

}


