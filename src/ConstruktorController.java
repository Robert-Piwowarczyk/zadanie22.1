import org.springframework.stereotype.Controller;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

@Controller
public class ConstruktorController {

    private Store userStore;

    public void ConstruktorControllerr(Store userStore) {
        this.userStore = userStore;
    }


    @ResponseBody
    @GetMapping("/users")
    public String users() {
        List<User> users = userStore.getAll();

        String result = "";

        for (User user : users) {
            result += user.toString() + "<br/>";
        }

        return result;

    }

    @RequestMapping("/add")
    public String add(HttpServletRequest request) {
        String imie = request.getParameter("imie");
        String nazwisko = request.getParameter("nazwisko");
        String wiek = request.getParameter("wiek");

        int age = Integer.parseInt(wiek);

        if(StringUtils.isEmpty(imie)) {
            return "redirect:/err.html";
        } else  {
            User user = new User(imie, nazwisko, age);
            userStore.add(user);
            return "redirect:/success.html";
        }
    }
}