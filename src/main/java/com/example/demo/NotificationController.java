package com.example.demo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/notifications")
public class NotificationController {

    @Autowired
    private FcmService fcmService;

    @PostMapping("/send")
    public String sendNotification(@RequestParam String targetToken,
                                   @RequestParam String title,
                                   @RequestParam String body) {
        try {
            return fcmService.sendNotification(targetToken, title, body);
        } catch (Exception e) {
            e.printStackTrace();
            return "Error sending notification: " + e.getMessage();
        }
    }
}
