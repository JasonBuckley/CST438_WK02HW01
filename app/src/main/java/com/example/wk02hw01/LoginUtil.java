package com.example.wk02hw01;

import android.graphics.Color;

public class LoginUtil {

    public static boolean[] compareCredentials(String username, String password ){
        boolean passes[] = {true, true};

        passes[0] = password.equals(MainActivity.PASSWORD);
        passes[1] = username.equals(MainActivity.USERNAME);

        return passes;
    }

    public static boolean authenticate(boolean pass, boolean user){
        return pass && user;
    }

}
