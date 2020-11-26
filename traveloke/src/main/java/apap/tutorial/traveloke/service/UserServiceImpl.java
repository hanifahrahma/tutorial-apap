package apap.tutorial.traveloke.service;

import apap.tutorial.traveloke.model.UserModel;
import apap.tutorial.traveloke.repository.UserDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserDb userDb;

    @Override
    public UserModel addUser(UserModel user) {
        String pass = encrypt(user.getPassword());
        user.setPassword(pass);
        return userDb.save(user);
    }

    @Override
    public String encrypt(String password) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String hashedPassword = passwordEncoder.encode(password);
        return hashedPassword;
    }

    @Override
    public String changePassword(UserModel user, String passlama, String passbaru, String passbaru2) {
        String msg;
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        if(passwordEncoder.matches(passlama, user.getPassword())){
            System.out.println("masuk 1");
            if (passbaru.equals(passbaru2)){
                System.out.println("masuk 2");
                msg = "OKAY";
                user.setPassword(passbaru);
                addUser(user);
            }
            else{
                System.out.println("masuk 3");
                msg = "FALSE2";
            }
        }
        else {
            System.out.println("masuk 4");
            msg = "FALSE";
        }
        return msg;
    }

    @Override
    public UserModel getbyUsername(String username) {
        return userDb.findByUsername(username);
    }
}
