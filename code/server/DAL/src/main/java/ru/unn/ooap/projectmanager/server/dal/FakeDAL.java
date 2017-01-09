package ru.unn.ooap.projectmanager.server.dal;

import ru.unn.ooap.projectmanager.server.model.IDAL;

import ru.unn.ooap.projectmanager.server.model.tasks.Task;
import ru.unn.ooap.projectmanager.server.model.projects.Project;
import ru.unn.ooap.projectmanager.server.model.projects.Projects;
import ru.unn.ooap.projectmanager.server.model.tasks.Tasks;
import ru.unn.ooap.projectmanager.server.model.users.User;
import ru.unn.ooap.projectmanager.server.model.users.Users;
import ru.unn.ooap.projectmanager.server.model.users.administrator.Administrator;
import ru.unn.ooap.projectmanager.server.model.users.executor.Executor;
import ru.unn.ooap.projectmanager.server.model.users.manager.Manager;

import java.util.ArrayList;
import java.util.List;

public class FakeDAL implements IDAL {
    private final List<User> usersList = new ArrayList<>();
    private final List<Project> projectsList = new ArrayList<>();
    private final List<Task> tasksList = new ArrayList<>();
    //private Users users;
    //private Projects projects;
    //private Tasks tasks;

    public FakeDAL() {
        /*
        Подключаемся к хранилищу.
        (Здесь же?) конструируем объекты,
        сохранённые в хранилище.
         */
        usersList.add(new Manager(1, "TestManager", " ", this));

        Executor testExecutor = new Executor(2, "TestExecutor", " ", this);
        usersList.add(testExecutor);

        Administrator testAdministrator
                = new Administrator(testExecutor.getID() + 1, "TestAdministrator", " ", this);
        usersList.add(testAdministrator);


        Project project = new Project(1, "Test Project", "Project, created just to proof of work",
                                      new ArrayList<>(), this);
        projectsList.add(project);

        Task testTask1 = new Task(1, "Test task 1", "", project, testExecutor,
                                  0, 1, true, false, this);
        project.addTask(testTask1);
        tasksList.add(testTask1);

        Task testTask2 = new Task(2, "Test task 2", "", project, testExecutor,
                                  1, 2, true, true, this);
        project.addTask(testTask2);
        tasksList.add(testTask2);
    }

    @Override
    public void setUsers(final Users users) {
        //this.users = users;
        /*
        Вставляем в объект класса Users
        список уже сконструированных объектов юзеров.
         */
    }

    @Override
    public void setProjects(final Projects projects) {
        //this.projects = projects;
        /*
        Вставляем в объект класса Projects
        список уже сконструированных проектов.
         */
    }

    @Override
    public void setTasks(final Tasks tasks) {
        //this.tasks = tasks;
        /*
        Вставляем в объект класса Users
        список уже сконструированных задач.
         */
    }

    @Override
    public void sync(final Project project) {
        //
    }

    @Override
    public void sync(final Projects projects) {
        projects.setProjects(projectsList);
    }

    @Override
    public void sync(final Task task) {
        String str = new String("test");
    }

    @Override
    public void sync(final Tasks tasks) {
        tasks.setTasks(tasksList);
    }

    @Override
    public void sync(final User user) {
        //if (user.getID() == -1) {
            // here we save new user and set it's ID
        //} else {
            // here we update information about existing user
        //}
    }

    @Override
    public void sync(final Users users) {
        users.setUsers(usersList);
    }

    @Override
    public void sync(final Administrator admin) {
        String str = new String("test");
    }

    @Override
    public void sync(final Manager manager) {
        String str = new String("test");
    }

    @Override
    public void sync(final Executor executor) {
        String str = new String("test");
    }
}
