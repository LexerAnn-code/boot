package combase.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("base")
public class Boot {
    @GetMapping()
    public String boot(){
        return  "adasdasd";
    }
}
