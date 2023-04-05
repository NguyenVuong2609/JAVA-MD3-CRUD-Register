package rikkei.academy.view;

import rikkei.academy.config.Config;
import rikkei.academy.controller.UserController;
import rikkei.academy.model.User;


public class Navbar {
    UserController userController = new UserController();
    public Navbar() {
        User user = userController.getUserLogin();
        if (user != null){
            System.out.println("Welcome " + user.getName());
            int choice = Config.scanner().nextInt();
            switch (choice) {
                case 1:
                    new ProfileView();
                    break;
            }
        } else {
            System.out.println("1. Register\n" +
                    "2. Login\n" +
                    "3. Show list user");
            int choice = Config.scanner().nextInt();
            switch (choice) {
                case 1:
                    new UserView().register();
                    break;
                case 2:
                    new UserView().formLogin();
                    break;
                case 3:
                    new UserView().showListUser();
                    break;
            }
        }
    }

    public static void main(String[] args) {
        new Navbar();
    }
}