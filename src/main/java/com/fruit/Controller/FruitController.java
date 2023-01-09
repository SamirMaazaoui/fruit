package com.fruit.Controller;

import com.fruit.service.FruitServiceImpl;
import com.fruit.service.Slot;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@AllArgsConstructor
@Slf4j
public class FruitController {

    private final FruitServiceImpl fruitService;

    @GetMapping("/play")
    public String getFruitsshowUserList(Model model) {
        Slot slot = this.fruitService.calculateScore();
        model.addAttribute("slot", slot);
        log.info("le score est : "+slot.getScore());
        return "index.html";
    }

}
