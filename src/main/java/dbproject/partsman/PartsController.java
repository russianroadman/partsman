package dbproject.partsman;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PartsController {

    @GetMapping("/")
    public String indexRequest(){
        return "index";
    }



}
