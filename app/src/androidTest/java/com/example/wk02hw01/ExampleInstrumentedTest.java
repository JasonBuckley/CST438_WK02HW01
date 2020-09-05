package com.example.wk02hw01;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        assertEquals("com.example.wk02hw01", appContext.getPackageName());
    }

    @Test
    public void testLandActivityGetIntent(){
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();

        //checks if an intent is sent.
        assertNotNull(LandingActivity.getIntent(appContext.getApplicationContext()));

        //checks if the right intent is sent
        Intent intent = new Intent(appContext.getApplicationContext(), LandingActivity.class);
        assertEquals(intent.toString(), LandingActivity.getIntent(appContext.getApplicationContext()).toString());
    }


    @Test
    public void testCompareCredentialsAndAuth(){

        boolean testUser[] = LoginUtil.compareCredentials("Admin", "Password");
        boolean testUser2[] = LoginUtil.compareCredentials("admin", "Password");
        boolean testUser3[] = LoginUtil.compareCredentials("Admin","password");

        //testUser one against credentials
        assertEquals(true, testUser[0]);
        assertEquals(true, testUser[1]);
        //testUser two against credentials
        assertEquals(true, testUser[0]);
        assertEquals(true, testUser[1]);
        //testUser three against credentials
        assertEquals(true, testUser[0]);
        assertEquals(true, testUser[1]);

        assertTrue(LoginUtil.authenticate(testUser[0], testUser[1]));
        assertFalse(LoginUtil.authenticate(testUser2[0], testUser2[1]));
        assertFalse(LoginUtil.authenticate(testUser3[0], testUser3[1]));
    }
}