package Lecture11_DesignPatterns.CreationalDP.PrototypeDP;

public class Square implements Shape{
    int len;

    Square(int len){
        this.len = len;
    }

    int getLen(){
        return len;
    }
    void setLen(int len){
        this.len = len;
    }

    public double getArea(){
        return len*len;
    }
    public Shape clone(){
        return new Square(len);
    }
}
