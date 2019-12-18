package com.giorgi.android_quiz_2;

public class Post {
    public int userId;
    public int id;
    public String title;
    public String completed;

    Post(int userId, int id, String title, String completed) {
        this.userId = userId;
        this.id = id;
        this.title = title;
        this.completed = completed;
    }
}
