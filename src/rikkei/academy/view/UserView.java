package rikkei.academy.view;

import rikkei.academy.config.Config;
import rikkei.academy.controller.UserController;
import rikkei.academy.dto.request.SignUpDTO;
import rikkei.academy.dto.response.ResponseMessage;
import rikkei.academy.model.User;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UserView {
    UserController userController = new UserController();
    List<User> userList = userController.getListUser();

    public void register() {
        int id;
        if (userList.size() == 0) {
            id = 1;
        } else {
            id = userList.get(userList.size() - 1).getId() + 1;
        }
        System.out.println("Enter the name: ");
        String name = Config.scanner().nextLine();
        System.out.println("Enter the username: ");
        String username = Config.scanner().nextLine();
        System.out.println("Enter the email: ");
        String email = Config.scanner().nextLine();
        System.out.println("Enter the password: ");
        String password = Config.scanner().nextLine();
        System.out.println("Enter the role");
        String role = Config.scanner().nextLine();
        Set<String> strRole = new HashSet<>();
        strRole.add(role);
        SignUpDTO sign = new SignUpDTO(id, name, username, email, password, strRole);
        ResponseMessage message = userController.register(sign);
        if (message.getMessage().equals("user_existed")){
            System.err.println("Username existed! Please try again");
            register();
        }
        if (message.getMessage().equals("email_existed")){
            System.err.println("Email existed! Please try again");
            register();
        }
        if (message.getMessage().equals("create_success")){
            System.out.println("Register successful!");
            new Navbar();
        }

    }
    public void showListUser(){
        System.out.println(userList);
        System.out.println("Type BACK to return Menu: ");
        String back = Config.scanner().nextLine();
        if(back.equalsIgnoreCase("back")){
            new Navbar();
        }
    }
}
