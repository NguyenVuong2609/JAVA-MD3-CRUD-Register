package rikkei.academy.view;

import rikkei.academy.controller.UserController;
import rikkei.academy.model.Role;
import rikkei.academy.model.RoleName;
import rikkei.academy.model.User;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ProfileView {
    UserController userController = new UserController();

    public ProfileView() {
        User user = userController.getUserLogin();
        Set<Role> roleSet = user.getRoles();
        if (user != null) {
            List<Role> roles = new ArrayList<>(roleSet);
            if (roles.get(0).getName() == RoleName.ADMIN) {
                System.out.println("Admin Menu");
            } else if (roles.get(0).getName()== RoleName.USER){
                System.out.println("User Menu");
            } else {
                System.out.println("PM Menu");
            }
        }
    }
}
