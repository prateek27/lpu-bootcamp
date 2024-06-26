package Lecture11_DesignPatterns.CommandPattern.client;

import Lecture11_DesignPatterns.CommandPattern.framework.Command;

public class AddCustomerCommand implements Command {
    CustomerService customerService;
    AddCustomerCommand(CustomerService cs){
        this.customerService = cs;
    }
    @Override
    public void execute() {
        //add a customer to the database
        System.out.println("Adding a customer ");
        customerService.addCustomer();
    }
}
