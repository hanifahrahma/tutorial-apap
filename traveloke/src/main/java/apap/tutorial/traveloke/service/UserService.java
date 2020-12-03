package apap.tutorial.traveloke.service;

import apap.tutorial.traveloke.model.UserModel;

public interface UserService {
    UserModel addUser(UserModel user);
    String encrypt(String password);
    String changePassword(UserModel user, String passlama, String passbaru, String passbaru2);
    UserModel getbyUsername(String user);
    boolean checkPass(String pass);
}
