import com.github.kwhat.jnativehook.GlobalScreen;
import com.github.kwhat.jnativehook.NativeHookException;
import com.github.kwhat.jnativehook.keyboard.NativeKeyEvent;
import com.github.kwhat.jnativehook.keyboard.NativeKeyListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class Main implements NativeKeyListener {

    @Override
    public void nativeKeyTyped(NativeKeyEvent nativeEvent) {

    }

    @Override
    public void nativeKeyPressed(NativeKeyEvent nativeEvent) {
        String na = null;
        na =NativeKeyEvent.getKeyText(nativeEvent.getKeyCode());
        System.out.println(NativeKeyEvent.getKeyText(nativeEvent.getKeyCode()));

        if(na=="Down"){
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_A);
            robot.keyRelease(KeyEvent.VK_A);
            robot.keyPress(KeyEvent.VK_C);
            robot.keyRelease(KeyEvent.VK_C);
            robot.keyRelease(KeyEvent.VK_CONTROL);

        }
        if(na=="Up"){
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_A);
            robot.keyRelease(KeyEvent.VK_A);
            robot.keyPress(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_CONTROL);
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