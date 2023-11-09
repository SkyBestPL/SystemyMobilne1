package pl.edu.pb.wi;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class TaskStorage {
    private static TaskStorage taskStorage = new TaskStorage(); //pole statyczne - Singleton
    private List<Task> tasks;
    public static TaskStorage getInstance() {
        return taskStorage;
    }

    private TaskStorage() { //generowanie przykładowych zadań na listę
        final int ile = 150;
        tasks = new ArrayList<Task>(ile);
        for (int i = 1; i <= ile; i++) {
            Task task = new Task();
            task.setName("Pilne zadanie numer " + i);
            task.setDone(i % 3 == 0);
            tasks.add(task);
        }
    }
 //-------------------------------
    public List<Task> getTasks() { //zwraca całą listę zadań
        return tasks;
    }

    public Task getTask(UUID id) { //zwraca pojedyncze zadanie znajdowane po id
        for (Task task : tasks) {
            if (task.getId().equals(id))
                return task;
        }
        return null;
    }
}
