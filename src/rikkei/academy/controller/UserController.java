package rikkei.academy.controller;

import rikkei.academy.dto.request.SignUpDTO;
import rikkei.academy.dto.response.ResponseMessage;
import rikkei.academy.model.Role;
import rikkei.academy.model.RoleName;
import rikkei.academy.model.User;
import rikkei.academy.service.role.IRoleService;
import rikkei.academy.service.role.RoleServiceIMPL;
import rikkei.academy.service.user.IUserService;
import rikkei.academy.service.user.UserServiceIMPL;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UserController {
    private IUserService userService = new UserServiceIMPL();
    private IRoleService roleService = new RoleServiceIMPL();

    public ResponseMessage register(SignUpDTO data) {
        if (userService.existedByUsername(data.getUsername())) {
            return new ResponseMessage("username_existed");
        }
        if (userService.existByEmail(data.getEmail())) {
            return new ResponseMessage("email_existed");
        }
        Set<Role> roleSet = new HashSet<>();
        Set<String> strRole = data.getStrRole();
        strRole.forEach(role -> {
            switch (role) {
                case "admin":
                    roleSet.add(roleService.findByName(RoleName.ADMIN));
                    break;
                case "pm":
                    roleSet.add(roleService.findByName(RoleName.PM));
                    break;
                default:
                    roleSet.add(roleService.findByName(RoleName.USER));
                    break;
            }
        });
        User user = new User(data.getId(), data.getName(), data.getUsername(), data.getEmail(), data.getPassword(), roleSet);
        userService.save(user);
        return new ResponseMessage("create_success");
    }
    public List<User> getListUser(){
        return userService.findAll();
    }
}
