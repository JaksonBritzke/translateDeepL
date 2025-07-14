package com.translate.backtranslate.controller;

import com.translate.backtranslate.service.TranslateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4201")
public class TranslateController {

    @Autowired
    private TranslateService translateService;

    @PostMapping("/translate")
    public Map<String, String> translate(@RequestBody TranslateRequest request) {
        Map<String, String> response = new HashMap<>();

        String spanish = translateService.translateText(request.getText(), "ES");
        String english = translateService.translateText(request.getText(), "EN");

        response.put("spanish", spanish);
        response.put("english", english);

        return response;
    }

    public static class TranslateRequest {
        private String text;

        public String getText() { return text; }
        public void setText(String text) { this.text = text; }
    }
}