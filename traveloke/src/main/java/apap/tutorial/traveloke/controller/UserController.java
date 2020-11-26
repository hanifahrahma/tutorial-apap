package apap.tutorial.traveloke.controller;

import apap.tutorial.traveloke.model.UserModel;
import apap.tutorial.traveloke.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public String addUserSubmit(@ModelAttribute UserModel userModel, Model model){
        String msg;
        if(!userService.checkPass(userModel.getPassword())){
            msg = "Password harus berisi angka dan huruf serta minimal memiliki 8 karakter";
        }
        else {
            userService.addUser(userModel);
        }
        msg = "User berhasil ditambah";
        model.addAttribute("user", userModel);
        model.addAttribute("msg", msg);
        return "hasil-update";

    }

    @RequestMapping(value = "/changePass", method = RequestMethod.POST)
    public String changePass(@ModelAttribute UserModel user, String passlama, String passbaru, String passbaru2, Model model){
        System.out.println(passlama);
        System.out.println(passbaru);
        System.out.println(passbaru2);
        UserModel user2 = userService.getbyUsername(user.getUsername());
        System.out.println(user2.getUsername());
        String isUpdated = userService.changePassword(user2, passlama, passbaru, passbaru2);
        String msg = "";
        if (isUpdated.equals("OKAY")){
            msg = "Password berhasil diperbaharui.";
        }
        else if (isUpdated.equals("FALSE")){
            msg = "Password lama anda salah";
        }
        else if(isUpdated.equals("FALSE2")){
            msg = "Password baru anda tidak sama.";
        }
        else if (isUpdated.equals("FALSE3")){
            msg = "Password harus berisi angka dan huruf serta minimal memiliki 8 karakter";
        }
        else {
            msg = "";
        }
        model.addAttribute("msg", msg);
        return "changepass";
    }
}
