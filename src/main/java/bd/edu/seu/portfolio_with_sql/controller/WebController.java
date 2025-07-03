package bd.edu.seu.portfolio_with_sql.controller;

import bd.edu.seu.portfolio_with_sql.model.User;
import bd.edu.seu.portfolio_with_sql.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@SpringBootApplication
public class WebController {

    @Autowired
    private final UserService userService;
    public WebController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String indexPage() {
        return "index";
    }

    private final CaptchaController captchaController=new CaptchaController();


    @GetMapping("/captcha")
    public String captchaPage(Model captchaModel) {
        captchaModel.addAttribute("captchaQuestion", captchaController.generateCaptchaQuestion());//generate new captcha
        return "captcha";

    }
    @GetMapping("/verify-captcha")
    public String validateCaptcha(@RequestParam("captchaAnswer") int userAnswer, Model validatecaptchaModel) {
        if (captchaController.isCaptchaCorrect(userAnswer)) {
            validatecaptchaModel.addAttribute("successMessage", "Your answer is correct");
            validatecaptchaModel.addAttribute("user",new User());
            return "formFields";

           // return "redirect:/formFields";

        } else {

            validatecaptchaModel.addAttribute("error", "Incorrect Captcha ❌. Try Again");
            validatecaptchaModel.addAttribute("captchaQuestion", captchaController.generateCaptchaQuestion());
            return "captcha";
        }
    }

    @GetMapping("/formFields")
    public String formFieldPage(Model model){
        model.addAttribute("user", new User());
        return "formFields";
    }

    @PostMapping("/submit-object-form")
    public String objectSubmit( @ModelAttribute User user){
        userService.addUser(user);
        return "success";
    }


}
