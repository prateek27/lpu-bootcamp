package Lecture12_HLD;

public class Server {
    private String id;
    private boolean status;

    Server(String id){
        this.id = id;
        this.status = true;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isHealth(){
        return status;
    }

    public void setStatus(boolean status){
        this.status = status;
    }

    @Override
    public String toString() {
        return "Server{" +
                "id='" + id + '\'' +
                ", status=" + status +
                '}';
    }
}
