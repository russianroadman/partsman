package dbproject.partsman;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.*;

@Controller
public class PartsController {

    @GetMapping("/")
    public String indexRequest(){
        return "index";
    }

    @GetMapping("instock")
    public String instockRequest(Model model){
        List<String[]> instock = StoredProcedures.getInstock();
        model.addAttribute("instock", instock);
        return "instock";
    }
}
