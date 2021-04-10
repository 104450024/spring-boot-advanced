package com.irm.springbootadvance.web;


import com.irm.springbootadvance.domain.User;
import com.irm.springbootadvance.domain.UserRepository;
import com.irm.springbootadvance.form.UserForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.naming.Binding;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

@RestController
public class LoginController {

    private final UserRepository userRepository;

    @Autowired   /** 注入Beans(Java) **/
    public LoginController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
        @GetMapping("/")
        private String index()
        {
            return "index";
        }


    /**
     * 1-----跳转到注册页面(一開始的註冊頁面)
     * @param
     * @return
     */
    @GetMapping("/register")
    public String registerPage(Model model)
    {
        model.addAttribute("userForm",new UserForm());
        return "register";
    }

    /**
     * 3-----
     * @return -------- (一開始的登入頁面)
     */
    @GetMapping("/login")
    public String loginPage()
    {
        return "login";
    }


    /**
     *
     * login and index 之間的頁面，需要帳號及密碼
     *
     * **/

    @PostMapping("/login")
    public String loginPost(@RequestParam String username,
                            @RequestParam String password,
                            HttpSession session  )  //會話
    {
        User user=userRepository.findByUsernameAndPassword(username,password);
        if (user!=null){
            session.setAttribute("user",user);
            //收集user相關資料
            //如果你想要在瀏覽器與Web應用程式的會話期間，
            //保留請求之間的相關訊息，則可以使用 HttpSession 的 setAttribute()
            //方法將相關訊息設置為屬性。在會話期間，就可以當作 Web 應用程式「記得」客戶端的資訊，
            return "index";
        }
        return "login";
    }


    /**註銷返回登入頁面**/

    @GetMapping("/logout")
    public String logout(HttpSession session)
    {
        session.removeAttribute("user");
        return "login";
    }



    /**
     * 2-----登陆页面跳转(輸入資料)
     * @return
     */
    @PostMapping("/register")
    public String register(@Valid UserForm userForm, BindingResult result, Model model)
    {
        if (!userForm.confirmPassword())
         {
            result.rejectValue(
                    "confirmPassword",
                    "密碼兩次不一致",
                    "confirmError");
         }
        if (result.hasErrors())
        {
            return "register";
        }

        User user=userForm.convertToUser();
        userRepository.save(user);
        return "redirect:/login";
        //伺服器通知客戶端，讓其重新請求一次。

    }


    @GetMapping("/exception")
    public String testException()
    {
        throw new RuntimeException();
    }


}
