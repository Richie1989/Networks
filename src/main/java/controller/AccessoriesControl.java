package controller;

import Constant.Constant;
import Provider.AccessoryProvider;
import model.Accessory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.WebUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.List;





@Controller
public class AccessoriesControl {

    private final AccessoryProvider accessoryProvider;

    public AccessoriesControl(AccessoryProvider accessoryProvider) {
        this.accessoryProvider = accessoryProvider;
    }

    @GetMapping("/add")
    public String add() {
        return "add_product";
    }

    @PostMapping("/add")
    public String doAdd(HttpServletRequest request,
                        @RequestParam("name") String name,
                        @RequestParam("category") String category,
                        @RequestParam("stock") int stock,
                        @RequestParam("price") int price,
                        @RequestParam("description") String description) {
        Cookie cookie = WebUtils.getCookie(request, "username");
        String username = cookie.getValue();

        accessoryProvider.newAccessory(name, stock, price, category, description, username);

        return "redirect:/home";
    }

    @GetMapping("/single/{id}")
    public String single(@PathVariable int id, Model model) {
        model.addAttribute("accessory", Constant.accessories.get(id));
        return "single";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id, Model model) {
        model.addAttribute("accessory", Constant.accessories.get(id));
        accessoryProvider.removeAccessory(id);
        return "redirect:/home";
    }

    @PostMapping("/single/{id}")
    public String updateSingle(HttpServletRequest request,
                               @PathVariable int id,
                               @RequestParam("name") String name,
                               @RequestParam("category") String category,
                               @RequestParam("stock") int stock,
                               @RequestParam("price") int price,
                               @RequestParam("description") String description) {
        Cookie cookie = WebUtils.getCookie(request, "username");
        String username = cookie.getValue();


        Constant.accessories.set(id, new Accessory(id, name, stock, price, category, description, username));
        return "redirect:/home";
    }

    @RequestMapping("/category")
    public String category() {
        return "category";
    }

    @RequestMapping("/search")
    public String search(HttpServletRequest request, @RequestParam String n, Model model) {
        Cookie cookie = WebUtils.getCookie(request, "username");
        String username = cookie.getValue();
        List<Accessory> accessories = accessoryProvider.getAccessories(username);
        model.addAttribute("n", n.toLowerCase());
        model.addAttribute("accessories", accessories);
        model.addAttribute("holder",username);
        return "search";
    }
}

