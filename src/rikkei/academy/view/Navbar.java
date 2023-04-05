package rikkei.academy.view;

import rikkei.academy.config.Config;



public class Navbar {
    public Navbar() {
        System.out.println("1. Register\n" +
                "2. Login\n" +
                "3. Show list user");
        int choice = Config.scanner().nextInt();
        switch (choice){
            case 1:
                new UserView().register();
                break;
            case 3:
                new UserView().showListUser();
                break;
        }
    }

    public static void main(String[] args) {
        new Navbar();
    }
}