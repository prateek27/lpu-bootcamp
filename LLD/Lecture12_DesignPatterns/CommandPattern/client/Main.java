package Lecture11_DesignPatterns.CommandPattern.client;

import Lecture11_DesignPatterns.CommandPattern.framework.Button;
import Lecture11_DesignPatterns.CommandPattern.framework.Command;

public class Main {
    public static void main(String[] args) {
        Button button = new Button();
        CustomerService cs = new CustomerService();
        Command command = new AddCustomerCommand(cs);
        button.onClick(command);
    }
}
