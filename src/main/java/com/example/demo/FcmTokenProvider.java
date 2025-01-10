package com.example.demo;
import com.google.auth.oauth2.GoogleCredentials;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.IOException;

@Service
public class FcmTokenProvider {

    private static final String FIREBASE_SCOPE = "https://www.googleapis.com/auth/firebase.messaging";

    public String getAccessToken() throws IOException {
        GoogleCredentials googleCredentials = GoogleCredentials
                .fromStream(new FileInputStream("path/to/your-service-account-file.json"))
                .createScoped(FIREBASE_SCOPE);

        googleCredentials.refreshIfExpired();
        return googleCredentials.getAccessToken().getTokenValue();
    }
}
