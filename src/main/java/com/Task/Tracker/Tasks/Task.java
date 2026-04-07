package com.Task.Tracker.Tasks;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class Task {
    private String name;
    private String description;
    private Boolean status;

    public Task(String name, String description){
        this.name = name;
        this.description = description;
        this.status = false;
    }


    public void changeStatus(){
        this.status = !status;
    }

    @Override
    public String toString() {
        return "NOME: " + name + " |DESCR: " + description + " |STATUS: " + status;
    }
}
