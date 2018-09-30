import java.awt.Robot;
import java.awt.AWTException;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.security.Key;
import java.util.Scanner;

public class Typer {

    static void proceed(File profile, String text, int delay) {
        /*
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the text: ");
        String string = scanner.nextLine();
        System.out.println("Enter delay between typing in millisecond: ");
        int delay = scanner.nextInt();
        */
        Robot rb = null;
        try {
            rb = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }

        /*
        Runtime rt = Runtime.getRuntime();

        try {
            rt.exec("notepad.exe");
        } catch (IOException e) {
            e.printStackTrace();
        }
        */
        rb.delay(3000); //Start in 3 seconds

        char ch[] = text.toCharArray();

        int i = 0;
        while (i < ch.length) {

            if (ch[i] == ' ') {
                rb.keyPress(KeyEvent.VK_SPACE);
                rb.keyRelease(KeyEvent.VK_SPACE);
                rb.delay(delay);
            }

            if (ch[i] == '0') {
                rb.keyPress(KeyEvent.VK_0);
                rb.keyRelease(KeyEvent.VK_0);
                rb.delay(delay);
            }

            if (ch[i] == '1') {
                rb.keyPress(KeyEvent.VK_1);
                rb.keyRelease(KeyEvent.VK_1);
                rb.delay(delay);
            }

            if (ch[i] == '2') {
                rb.keyPress(KeyEvent.VK_2);
                rb.keyRelease(KeyEvent.VK_2);
                rb.delay(delay);
            }

            if (ch[i] == '3') {
                rb.keyPress(KeyEvent.VK_3);
                rb.keyRelease(KeyEvent.VK_3);
                rb.delay(delay);
            }

            if (ch[i] == '4') {
                rb.keyPress(KeyEvent.VK_4);
                rb.keyRelease(KeyEvent.VK_4);
                rb.delay(delay);
            }

            if (ch[i] == '5') {
                rb.keyPress(KeyEvent.VK_5);
                rb.keyRelease(KeyEvent.VK_5);
                rb.delay(delay);
            }

            if (ch[i] == '6') {
                rb.keyPress(KeyEvent.VK_6);
                rb.keyRelease(KeyEvent.VK_6);
                rb.delay(delay);
            }

            if (ch[i] == '7') {
                rb.keyPress(KeyEvent.VK_7);
                rb.keyRelease(KeyEvent.VK_7);
                rb.delay(delay);
            }

            if (ch[i] == '8') {
                rb.keyPress(KeyEvent.VK_8);
                rb.keyRelease(KeyEvent.VK_8);
                rb.delay(delay);
            }

            if (ch[i] == '9') {
                rb.keyPress(KeyEvent.VK_9);
                rb.keyRelease(KeyEvent.VK_9);
                rb.delay(delay);
            }

            if (ch[i] == 'a') {
                rb.keyPress(KeyEvent.VK_A);
                rb.keyRelease(KeyEvent.VK_A);
                rb.delay(delay);
            }

            if (ch[i] == 'b') {
                rb.keyPress(KeyEvent.VK_B);
                rb.keyRelease(KeyEvent.VK_B);
                rb.delay(delay);
            }

            if (ch[i] == 'c') {
                rb.keyPress(KeyEvent.VK_C);
                rb.keyRelease(KeyEvent.VK_C);
                rb.delay(delay);
            }

            if (ch[i] == 'd') {
                rb.keyPress(KeyEvent.VK_D);
                rb.keyRelease(KeyEvent.VK_D);
                rb.delay(delay);
            }

            if (ch[i] == 'e') {
                rb.keyPress(KeyEvent.VK_E);
                rb.keyRelease(KeyEvent.VK_E);
                rb.delay(delay);
            }

            if (ch[i] == 'f') {
                rb.keyPress(KeyEvent.VK_F);
                rb.keyRelease(KeyEvent.VK_F);
                rb.delay(delay);
            }

            if (ch[i] == 'g') {
                rb.keyPress(KeyEvent.VK_G);
                rb.keyRelease(KeyEvent.VK_G);
                rb.delay(delay);
            }

            if (ch[i] == 'h') {
                rb.keyPress(KeyEvent.VK_H);
                rb.keyRelease(KeyEvent.VK_H);
                rb.delay(delay);
            }

            if (ch[i] == 'i') {
                rb.keyPress(KeyEvent.VK_I);
                rb.keyRelease(KeyEvent.VK_I);
                rb.delay(delay);
            }

            if (ch[i] == 'j') {
                rb.keyPress(KeyEvent.VK_J);
                rb.keyRelease(KeyEvent.VK_J);
                rb.delay(delay);
            }

            if (ch[i] == 'k') {
                rb.keyPress(KeyEvent.VK_K);
                rb.keyRelease(KeyEvent.VK_K);
                rb.delay(delay);
            }

            if (ch[i] == 'l') {
                rb.keyPress(KeyEvent.VK_L);
                rb.keyRelease(KeyEvent.VK_L);
                rb.delay(delay);
            }

            if (ch[i] == 'm') {
                rb.keyPress(KeyEvent.VK_M);
                rb.keyRelease(KeyEvent.VK_M);
                rb.delay(delay);
            }

            if (ch[i] == 'n') {
                rb.keyPress(KeyEvent.VK_N);
                rb.keyRelease(KeyEvent.VK_N);
                rb.delay(delay);
            }

            if (ch[i] == 'o') {
                rb.keyPress(KeyEvent.VK_O);
                rb.keyRelease(KeyEvent.VK_O);
                rb.delay(delay);
            }

            if (ch[i] == 'p') {
                rb.keyPress(KeyEvent.VK_P);
                rb.keyRelease(KeyEvent.VK_P);
                rb.delay(delay);
            }

            if (ch[i] == 'q') {
                rb.keyPress(KeyEvent.VK_Q);
                rb.keyRelease(KeyEvent.VK_Q);
                rb.delay(delay);
            }

            if (ch[i] == 'r') {
                rb.keyPress(KeyEvent.VK_R);
                rb.keyRelease(KeyEvent.VK_R);
                rb.delay(delay);
            }

            if (ch[i] == 's') {
                rb.keyPress(KeyEvent.VK_S);
                rb.keyRelease(KeyEvent.VK_S);
                rb.delay(delay);
            }

            if (ch[i] == 't') {
                rb.keyPress(KeyEvent.VK_T);
                rb.keyRelease(KeyEvent.VK_T);
                rb.delay(delay);
            }

            if (ch[i] == 'u') {
                rb.keyPress(KeyEvent.VK_U);
                rb.keyRelease(KeyEvent.VK_U);
                rb.delay(delay);
            }

            if (ch[i] == 'v') {
                rb.keyPress(KeyEvent.VK_V);
                rb.keyRelease(KeyEvent.VK_V);
                rb.delay(delay);
            }

            if (ch[i] == 'w') {
                rb.keyPress(KeyEvent.VK_W);
                rb.keyRelease(KeyEvent.VK_W);
                rb.delay(delay);
            }

            if (ch[i] == 'x') {
                rb.keyPress(KeyEvent.VK_X);
                rb.keyRelease(KeyEvent.VK_X);
                rb.delay(delay);
            }

            if (ch[i] == 'y') {
                rb.keyPress(KeyEvent.VK_Y);
                rb.keyRelease(KeyEvent.VK_Y);
                rb.delay(delay);
            }

            if (ch[i] == 'z') {
                rb.keyPress(KeyEvent.VK_Z);
                rb.keyRelease(KeyEvent.VK_Z);
                rb.delay(delay);
            }

            if (ch[i] == 'A') {
                rb.keyPress(KeyEvent.VK_SHIFT);
                rb.keyPress(KeyEvent.VK_A);
                rb.keyRelease(KeyEvent.VK_SHIFT);
                rb.keyRelease(KeyEvent.VK_A);
                rb.delay(delay);
            }

            if (ch[i] == 'B') {
                rb.keyPress(KeyEvent.VK_SHIFT);
                rb.keyPress(KeyEvent.VK_B);
                rb.keyRelease(KeyEvent.VK_SHIFT);
                rb.keyRelease(KeyEvent.VK_B);
                rb.delay(delay);
            }

            if (ch[i] == 'C') {
                rb.keyPress(KeyEvent.VK_SHIFT);
                rb.keyPress(KeyEvent.VK_C);
                rb.keyRelease(KeyEvent.VK_SHIFT);
                rb.keyRelease(KeyEvent.VK_C);
                rb.delay(delay);
            }

            if (ch[i] == 'D') {
                rb.keyPress(KeyEvent.VK_SHIFT);
                rb.keyPress(KeyEvent.VK_D);
                rb.keyRelease(KeyEvent.VK_SHIFT);
                rb.keyRelease(KeyEvent.VK_D);
                rb.delay(delay);
            }

            if (ch[i] == 'E') {
                rb.keyPress(KeyEvent.VK_SHIFT);
                rb.keyPress(KeyEvent.VK_E);
                rb.keyRelease(KeyEvent.VK_SHIFT);
                rb.keyRelease(KeyEvent.VK_E);
                rb.delay(delay);
            }

            if (ch[i] == 'F') {
                rb.keyPress(KeyEvent.VK_SHIFT);
                rb.keyPress(KeyEvent.VK_F);
                rb.keyRelease(KeyEvent.VK_SHIFT);
                rb.keyRelease(KeyEvent.VK_F);
                rb.delay(delay);
            }

            if (ch[i] == 'G') {
                rb.keyPress(KeyEvent.VK_SHIFT);
                rb.keyPress(KeyEvent.VK_G);
                rb.keyRelease(KeyEvent.VK_SHIFT);
                rb.keyRelease(KeyEvent.VK_G);
                rb.delay(delay);
            }

            if (ch[i] == 'H') {
                rb.keyPress(KeyEvent.VK_SHIFT);
                rb.keyPress(KeyEvent.VK_H);
                rb.keyRelease(KeyEvent.VK_SHIFT);
                rb.keyRelease(KeyEvent.VK_H);
                rb.delay(delay);
            }

            if (ch[i] == 'I') {
                rb.keyPress(KeyEvent.VK_SHIFT);
                rb.keyPress(KeyEvent.VK_I);
                rb.keyRelease(KeyEvent.VK_SHIFT);
                rb.keyRelease(KeyEvent.VK_I);
                rb.delay(delay);
            }

            if (ch[i] == 'J') {
                rb.keyPress(KeyEvent.VK_SHIFT);
                rb.keyPress(KeyEvent.VK_J);
                rb.keyRelease(KeyEvent.VK_SHIFT);
                rb.keyRelease(KeyEvent.VK_J);
                rb.delay(delay);
            }

            if (ch[i] == 'K') {
                rb.keyPress(KeyEvent.VK_SHIFT);
                rb.keyPress(KeyEvent.VK_K);
                rb.keyRelease(KeyEvent.VK_SHIFT);
                rb.keyRelease(KeyEvent.VK_K);
                rb.delay(delay);
            }

            if (ch[i] == 'L') {
                rb.keyPress(KeyEvent.VK_SHIFT);
                rb.keyPress(KeyEvent.VK_L);
                rb.keyRelease(KeyEvent.VK_SHIFT);
                rb.keyRelease(KeyEvent.VK_L);
                rb.delay(delay);
            }

            if (ch[i] == 'M') {
                rb.keyPress(KeyEvent.VK_SHIFT);
                rb.keyPress(KeyEvent.VK_M);
                rb.keyRelease(KeyEvent.VK_SHIFT);
                rb.keyRelease(KeyEvent.VK_M);
                rb.delay(delay);
            }

            if (ch[i] == 'N') {
                rb.keyPress(KeyEvent.VK_SHIFT);
                rb.keyPress(KeyEvent.VK_N);
                rb.keyRelease(KeyEvent.VK_SHIFT);
                rb.keyRelease(KeyEvent.VK_N);
                rb.delay(delay);
            }

            if (ch[i] == 'O') {
                rb.keyPress(KeyEvent.VK_SHIFT);
                rb.keyPress(KeyEvent.VK_O);
                rb.keyRelease(KeyEvent.VK_SHIFT);
                rb.keyRelease(KeyEvent.VK_O);
                rb.delay(delay);
            }

            if (ch[i] == 'P') {
                rb.keyPress(KeyEvent.VK_SHIFT);
                rb.keyPress(KeyEvent.VK_P);
                rb.keyRelease(KeyEvent.VK_SHIFT);
                rb.keyRelease(KeyEvent.VK_P);
                rb.delay(delay);
            }

            if (ch[i] == 'Q') {
                rb.keyPress(KeyEvent.VK_SHIFT);
                rb.keyPress(KeyEvent.VK_Q);
                rb.keyRelease(KeyEvent.VK_SHIFT);
                rb.keyRelease(KeyEvent.VK_Q);
                rb.delay(delay);
            }

            if (ch[i] == 'R') {
                rb.keyPress(KeyEvent.VK_SHIFT);
                rb.keyPress(KeyEvent.VK_R);
                rb.keyRelease(KeyEvent.VK_SHIFT);
                rb.keyRelease(KeyEvent.VK_R);
                rb.delay(delay);
            }

            if (ch[i] == 'S') {
                rb.keyPress(KeyEvent.VK_SHIFT);
                rb.keyPress(KeyEvent.VK_S);
                rb.keyRelease(KeyEvent.VK_SHIFT);
                rb.keyRelease(KeyEvent.VK_S);
                rb.delay(delay);
            }

            if (ch[i] == 'T') {
                rb.keyPress(KeyEvent.VK_SHIFT);
                rb.keyPress(KeyEvent.VK_T);
                rb.keyRelease(KeyEvent.VK_SHIFT);
                rb.keyRelease(KeyEvent.VK_T);
                rb.delay(delay);
            }

            if (ch[i] == 'U') {
                rb.keyPress(KeyEvent.VK_SHIFT);
                rb.keyPress(KeyEvent.VK_U);
                rb.keyRelease(KeyEvent.VK_SHIFT);
                rb.keyRelease(KeyEvent.VK_U);
                rb.delay(delay);
            }

            if (ch[i] == 'V') {
                rb.keyPress(KeyEvent.VK_SHIFT);
                rb.keyPress(KeyEvent.VK_V);
                rb.keyRelease(KeyEvent.VK_SHIFT);
                rb.keyRelease(KeyEvent.VK_V);
                rb.delay(delay);
            }

            if (ch[i] == 'W') {
                rb.keyPress(KeyEvent.VK_SHIFT);
                rb.keyPress(KeyEvent.VK_W);
                rb.keyRelease(KeyEvent.VK_SHIFT);
                rb.keyRelease(KeyEvent.VK_W);
                rb.delay(delay);
            }

            if (ch[i] == 'X') {
                rb.keyPress(KeyEvent.VK_SHIFT);
                rb.keyPress(KeyEvent.VK_X);
                rb.keyRelease(KeyEvent.VK_SHIFT);
                rb.keyRelease(KeyEvent.VK_X);
                rb.delay(delay);
            }

            if (ch[i] == 'Y') {
                rb.keyPress(KeyEvent.VK_SHIFT);
                rb.keyPress(KeyEvent.VK_Y);
                rb.keyRelease(KeyEvent.VK_SHIFT);
                rb.keyRelease(KeyEvent.VK_Y);
                rb.delay(delay);
            }

            if (ch[i] == 'Z') {
                rb.keyPress(KeyEvent.VK_SHIFT);
                rb.keyPress(KeyEvent.VK_Z);
                rb.keyRelease(KeyEvent.VK_SHIFT);
                rb.keyRelease(KeyEvent.VK_Z);
                rb.delay(delay);
            }

            if (ch[i] == '@') {
                rb.keyPress(KeyEvent.VK_ALT_GRAPH);
                rb.keyPress(KeyEvent.VK_2);
                rb.keyRelease(KeyEvent.VK_ALT_GRAPH);
                rb.keyRelease(KeyEvent.VK_2);
                rb.delay(delay);
            }

            if (ch[i] == ',') {
                rb.keyPress(KeyEvent.VK_COMMA);
                rb.keyRelease(KeyEvent.VK_COMMA);
                rb.delay(delay);
            }

            if (ch[i] == ';') {
                rb.keyPress(KeyEvent.VK_SHIFT);
                rb.keyPress(KeyEvent.VK_COMMA);
                rb.keyRelease(KeyEvent.VK_SHIFT);
                rb.keyRelease(KeyEvent.VK_COMMA);
                rb.delay(delay);
            }

            if (ch[i] == '.') {
                rb.keyPress(KeyEvent.VK_PERIOD);
                rb.keyRelease(KeyEvent.VK_PERIOD);
                rb.delay(delay);
            }

            if (ch[i] == ':') {
                rb.keyPress(KeyEvent.VK_SHIFT);
                rb.keyPress(KeyEvent.VK_PERIOD);
                rb.keyRelease(KeyEvent.VK_SHIFT);
                rb.keyRelease(KeyEvent.VK_PERIOD);
                rb.delay(delay);
            }

            if (ch[i] == '?') {
                rb.keyPress(KeyEvent.VK_SHIFT);
                rb.keyPress(KeyEvent.VK_PLUS);
                rb.keyRelease(KeyEvent.VK_SHIFT);
                rb.keyRelease(KeyEvent.VK_PLUS);
                rb.delay(delay);
            }

            if (ch[i] == '=') {
                rb.keyPress(KeyEvent.VK_SHIFT);
                rb.keyPress(KeyEvent.VK_0);
                rb.keyRelease(KeyEvent.VK_SHIFT);
                rb.keyRelease(KeyEvent.VK_0);
                rb.delay(delay);
            }

            if (ch[i] == '!') {
                rb.keyPress(KeyEvent.VK_SHIFT);
                rb.keyPress(KeyEvent.VK_1);
                rb.keyRelease(KeyEvent.VK_SHIFT);
                rb.keyRelease(KeyEvent.VK_1);
                rb.delay(delay);
            }

            if (ch[i] == '"') {
                rb.keyPress(KeyEvent.VK_SHIFT);
                rb.keyPress(KeyEvent.VK_2);
                rb.keyRelease(KeyEvent.VK_SHIFT);
                rb.keyRelease(KeyEvent.VK_2);
                rb.delay(delay);
            }

            if (ch[i] == '#') {
                rb.keyPress(KeyEvent.VK_SHIFT);
                rb.keyPress(KeyEvent.VK_3);
                rb.keyRelease(KeyEvent.VK_SHIFT);
                rb.keyRelease(KeyEvent.VK_3);
                rb.delay(delay);
            }

            if (ch[i] == '%') {
                rb.keyPress(KeyEvent.VK_SHIFT);
                rb.keyPress(KeyEvent.VK_5);
                rb.keyRelease(KeyEvent.VK_SHIFT);
                rb.keyRelease(KeyEvent.VK_5);
                rb.delay(delay);
            }

            if (ch[i] == '&') {
                rb.keyPress(KeyEvent.VK_SHIFT);
                rb.keyPress(KeyEvent.VK_6);
                rb.keyRelease(KeyEvent.VK_SHIFT);
                rb.keyRelease(KeyEvent.VK_6);
                rb.delay(delay);
            }

            if (ch[i] == '/') {
                rb.keyPress(KeyEvent.VK_SHIFT);
                rb.keyPress(KeyEvent.VK_7);
                rb.keyRelease(KeyEvent.VK_SHIFT);
                rb.keyRelease(KeyEvent.VK_7);
                rb.delay(delay);
            }

            if (ch[i] == '-') {
                rb.keyPress(KeyEvent.VK_MINUS);
                rb.keyRelease(KeyEvent.VK_MINUS);
                rb.delay(delay);
            }

            if (ch[i] == '_') {
                rb.keyPress(KeyEvent.VK_SHIFT);
                rb.keyPress(KeyEvent.VK_MINUS);
                rb.keyRelease(KeyEvent.VK_SHIFT);
                rb.keyRelease(KeyEvent.VK_MINUS);
                rb.delay(delay);
            }

            /* Template
            if (ch[i] == '') {
                rb.keyPress();
                rb.keyRelease();
                rb.delay(delay);
            }
            */
            i++;
        }

        rb.delay(3000);
        /*
        rb.keyPress(KeyEvent.VK_ALT);
        rb.keyPress(KeyEvent.VK_F4);

        rb.keyRelease(KeyEvent.VK_ALT);
        rb.keyRelease(KeyEvent.VK_F4);

        rb.keyPress(KeyEvent.VK_RIGHT);
        rb.keyRelease(KeyEvent.VK_RIGHT);
        rb.keyPress(KeyEvent.VK_ENTER);
        rb.keyRelease(KeyEvent.VK_ENTER);
        */
    }
}