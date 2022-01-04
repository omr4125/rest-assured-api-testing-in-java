package pojos;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

//If you are given limited data, how would you resolve the response?
//    When I have limited data, I use @JsonIgnoreProperties(ignoreUnknown = true) so I can skip unknown or uncessary data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Todo {
    /*
        "userId": 1,
        "id": 2,
        "title": "quis ut nam facilis et officia qui",
        "completed": false
     */

    private int userId;
    private int id;
    private String title;
    private boolean completed;

    public Todo() {}

    public Todo(int userId, int id, String title, boolean completed) {
        this.userId = userId;
        this.id = id;
        this.title = title;
        this.completed = completed;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    @Override
    public String toString() {
        return "Todo{" +
                "userId=" + userId +
                ", id=" + id +
                ", title='" + title + '\'' +
                ", completed=" + completed +
                '}';
    }
}
