package com.example.demo;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class FcmService {

    private final FcmTokenProvider tokenProvider;

    public FcmService(FcmTokenProvider tokenProvider) {
        this.tokenProvider = tokenProvider;
    }

    public String sendNotification(String targetToken, String title, String body) throws Exception {
        String accessToken = tokenProvider.getAccessToken();

        // FCM 메시지 생성
        Map<String, Object> message = new HashMap<>();
        Map<String, Object> notification = new HashMap<>();
        notification.put("title", title);
        notification.put("body", body);

        message.put("message", Map.of(
                "token", targetToken,
                "notification", notification
        ));

        // HTTP 요청 설정
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + accessToken);
        headers.set("Content-Type", "application/json");

        HttpEntity<Map<String, Object>> request = new HttpEntity<>(message, headers);
        RestTemplate restTemplate = new RestTemplate();

        // FCM 서버로 요청 보내기
        String fcmUrl = "https://fcm.googleapis.com/v1/projects/{project-id}/messages:send";
        ResponseEntity<String> response = restTemplate.postForEntity(fcmUrl, request, String.class);

        return response.getBody();
    }
}
