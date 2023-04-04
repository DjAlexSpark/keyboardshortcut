import com.github.kwhat.jnativehook.GlobalScreen;
import com.github.kwhat.jnativehook.NativeHookException;
import com.github.kwhat.jnativehook.keyboard.NativeKeyEvent;
import com.github.kwhat.jnativehook.keyboard.NativeKeyListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public class Main implements NativeKeyListener {

    @Override
    public void nativeKeyTyped(NativeKeyEvent nativeEvent) {

    }

    @Override
    public void nativeKeyPressed(NativeKeyEvent nativeEvent) {
        String listenedKey = null;
        listenedKey =NativeKeyEvent.getKeyText(nativeEvent.getKeyCode());
        System.out.println(NativeKeyEvent.getKeyText(nativeEvent.getKeyCode()));

        if(listenedKey=="Down"){
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_A);
            robot.keyRelease(KeyEvent.VK_A);
            robot.keyPress(KeyEvent.VK_C);
            robot.keyRelease(KeyEvent.VK_C);
            robot.keyRelease(KeyEvent.VK_CONTROL);

        }
        if(listenedKey=="Up"){
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_A);
            robot.keyRelease(KeyEvent.VK_A);
            robot.keyPress(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_CONTROL);
//            Robot robot = new Robot();
//            robot.mouseMove(305, 450);
//// first click
//            robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
//            robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
//// second click
//            robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
//            robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        }
    }

    @Override
    public void nativeKeyReleased(NativeKeyEvent nativeEvent) {

    }
    static Robot robot;
    public static void main(String[] args) {

        try {
            robot = new Robot();
            robot.setAutoDelay(150);

            GlobalScreen.registerNativeHook();
        } catch (NativeHookException | AWTException e) {
            throw new RuntimeException(e);
        }
        GlobalScreen.addNativeKeyListener(new Main());




            /*
            if (e.getKeyCode() == KeyEvent.VK_ENTER && e.isControlDown()) {
                System.out.println("Hello");
            }
            */

    }


}