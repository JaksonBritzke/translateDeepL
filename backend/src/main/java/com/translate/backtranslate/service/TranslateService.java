package com.translate.backtranslate.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.List;
import java.util.Map;

@Service
public class TranslateService {

    @Value("${deepl.api.key}")
    private String apiKey;

    private static final String DEEPL_URL = "https://api-free.deepl.com/v2/translate";

    private final RestTemplate restTemplate;

    public TranslateService() {
        this.restTemplate = new RestTemplate();
    }

    public String translateText(String text, String targetLanguage) {
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
            headers.set("Authorization", "DeepL-Auth-Key " + apiKey);

            MultiValueMap<String, String> body = new LinkedMultiValueMap<>();
            body.add("text", text);
            body.add("source_lang", "PT");
            body.add("target_lang", targetLanguage);

            HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(body, headers);

            Map<String, Object> response = restTemplate.postForObject(DEEPL_URL, request, Map.class);

            if (response != null && response.containsKey("translations")) {
                List<Map<String, Object>> translations = (List<Map<String, Object>>) response.get("translations");
                if (!translations.isEmpty()) {
                    return (String) translations.get(0).get("text");
                }
            }

            return "Erro na tradução";
        } catch (Exception e) {
            e.printStackTrace();
            return "Erro na tradução: " + e.getMessage();
        }
    }
}