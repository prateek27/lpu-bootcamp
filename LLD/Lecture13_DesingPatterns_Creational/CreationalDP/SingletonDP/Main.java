package Lecture11_DesignPatterns.CreationalDP.SingletonDP;

public class Main {

    public static void readConfig(){
        //potential
        ConfigManager cm = ConfigManager.getInstance();
        System.out.println("Reading config");
        System.out.println(cm.get("IconSize"));;
        System.out.println(cm.get("Color"));;
    }

    public static void main(String[] args) {
        ConfigManager cm = ConfigManager.getInstance();
        cm.set("Color","DarkTheme");
        cm.set("IconSize","Medium");
        readConfig();

    }
}
