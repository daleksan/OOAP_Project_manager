package ru.unn.ooap.projectmanager.server.model.users.manager;

import ru.unn.ooap.projectmanager.server.model.projects.Project;
import ru.unn.ooap.projectmanager.server.model.projects.Projects;
import ru.unn.ooap.projectmanager.server.model.tasks.Tasks;
import ru.unn.ooap.projectmanager.server.model.users.User;

import java.util.List;

public class Manager extends User implements IManager {
    public Manager(final int id, final String un, final String pw) {
        super(id, un, pw);
    }

    public IProject createProject() {
        return Projects.getInstance().create();
    }

    public List<? extends IProject> getProjects() {
        return Projects.getInstance().get();
    }

    public ITask createTask(final IProject project) {
        return Tasks.getInstance().create((Project) project);
    }
}
