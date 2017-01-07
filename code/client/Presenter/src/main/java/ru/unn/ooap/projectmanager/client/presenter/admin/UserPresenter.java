package ru.unn.ooap.projectmanager.client.presenter.admin;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import ru.unn.ooap.projectmanager.server.model.users.administrator.IUser;

public class UserPresenter {
    private IUser user;
    private final StringProperty username = new SimpleStringProperty();

    public void setUser(final IUser user) {
        this.user = user;
        username.set(user.getUsername());
    }

    public IUser getUser() {
        return user;
    }

    public String getUsername() {
        return username.get();
    }

    public StringProperty usernameProperty() {
        return username;
    }
}
