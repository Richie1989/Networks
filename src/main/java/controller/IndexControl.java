package controller;

import Provider.AccessoryProvider;

import model.Accessory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.security.Principal;
import java.util.List;


@Controller
public class IndexControl {

    private final AccessoryProvider accessoryProvider;

    public IndexControl(AccessoryProvider accessoryProvider) {
        this.accessoryProvider = accessoryProvider;
    }

    @RequestMapping("/home")
    public String index(HttpServletResponse response, Principal principal, Model model) {
        String username = principal.getName();
        List<Accessory> accessories = accessoryProvider.getAccessories(username);
        saveCookie("username", principal.getName(), response);
        model.addAttribute("accessories", accessories);
        model.addAttribute("username", username);
        return "index";
    }

    private void saveCookie(String cookieName, String value, HttpServletResponse response) {
        Cookie cookie = new Cookie(cookieName, value);
        //maxAge is one month: 30*24*60*60
        cookie.setMaxAge(3242000);
        cookie.setPath("/");
        response.addCookie(cookie);
    }

}
