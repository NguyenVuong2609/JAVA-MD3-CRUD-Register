package rikkei.academy.service.user;

import rikkei.academy.model.User;
import rikkei.academy.service.IGenericService;

public interface IUserService extends IGenericService<User> {
    boolean existedByUsername(String username);
    boolean existByEmail(String email);
    boolean checkLogin(String username, String password);
    User getCurentUser();
}
