package myjgApp.login;

import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
    public boolean Authenticate(String username,String password){
        boolean isValidUsername = username.equalsIgnoreCase("geeta");
        boolean isValidPassword = password.equalsIgnoreCase("12345");
        boolean isValidUsername1 = username.equalsIgnoreCase("jhai");
        boolean isValidPassword1 = password.equalsIgnoreCase("love");

        return ((isValidUsername && isValidPassword ) || (isValidUsername1 && isValidPassword1));
    }
}
