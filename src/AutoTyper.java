import java.awt.Robot;
import java.awt.AWTException;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.Scanner;

public class AutoTyper {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the text: ");
        String string = scanner.nextLine();

        System.out.println("Enter delay between typing in millisecond: ");
        int delay = scanner.nextInt();

        System.out.println("Program will start in 3 seconds.");

        Robot rb = null;
        try {
            rb = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
        Runtime rt = Runtime.getRuntime();
        try {
            rt.exec("notepad.exe");
        } catch (IOException e) {
            e.printStackTrace();
        }

        rb.delay(3000);

        char ch[] = string.toCharArray();

        for (int i = 0; i < ch.length; i++) {

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

            if (ch[i] == 'a' || ch[i] == 'A') {
                rb.keyPress(KeyEvent.VK_A);
                rb.keyRelease(KeyEvent.VK_A);
                rb.delay(delay);
            }

            if (ch[i] == 'b' || ch[i] == 'B') {
                rb.keyPress(KeyEvent.VK_B);
                rb.keyRelease(KeyEvent.VK_B);
                rb.delay(delay);
            }

            if (ch[i] == 'c' || ch[i] == 'C') {
                rb.keyPress(KeyEvent.VK_C);
                rb.keyRelease(KeyEvent.VK_C);
                rb.delay(delay);
            }

            if (ch[i] == 'd' || ch[i] == 'D') {
                rb.keyPress(KeyEvent.VK_D);
                rb.keyRelease(KeyEvent.VK_D);
                rb.delay(delay);
            }

            if (ch[i] == 'e' || ch[i] == 'E') {
                rb.keyPress(KeyEvent.VK_E);
                rb.keyRelease(KeyEvent.VK_E);
                rb.delay(delay);
            }

            if (ch[i] == 'f' || ch[i] == 'F') {
                rb.keyPress(KeyEvent.VK_F);
                rb.keyRelease(KeyEvent.VK_F);
                rb.delay(delay);
            }

            if (ch[i] == 'g' || ch[i] == 'G') {
                rb.keyPress(KeyEvent.VK_G);
                rb.keyRelease(KeyEvent.VK_G);
                rb.delay(delay);
            }

            if (ch[i] == 'h' || ch[i] == 'H') {
                rb.keyPress(KeyEvent.VK_H);
                rb.keyRelease(KeyEvent.VK_H);
                rb.delay(delay);
            }

            if (ch[i] == 'i' || ch[i] == 'I') {
                rb.keyPress(KeyEvent.VK_I);
                rb.keyRelease(KeyEvent.VK_I);
                rb.delay(delay);
            }

            if (ch[i] == 'j' || ch[i] == 'J') {
                rb.keyPress(KeyEvent.VK_J);
                rb.keyRelease(KeyEvent.VK_J);
                rb.delay(delay);
            }

            if (ch[i] == 'k' || ch[i] == 'K') {
                rb.keyPress(KeyEvent.VK_K);
                rb.keyRelease(KeyEvent.VK_K);
                rb.delay(delay);
            }

            if (ch[i] == 'l' || ch[i] == 'L') {
                rb.keyPress(KeyEvent.VK_L);
                rb.keyRelease(KeyEvent.VK_L);
                rb.delay(delay);
            }

            if (ch[i] == 'm' || ch[i] == 'M') {
                rb.keyPress(KeyEvent.VK_M);
                rb.keyRelease(KeyEvent.VK_M);
                rb.delay(delay);
            }

            if (ch[i] == 'n' || ch[i] == 'N') {
                rb.keyPress(KeyEvent.VK_N);
                rb.keyRelease(KeyEvent.VK_N);
                rb.delay(delay);
            }

            if (ch[i] == 'o' || ch[i] == 'O') {
                rb.keyPress(KeyEvent.VK_O);
                rb.keyRelease(KeyEvent.VK_O);
                rb.delay(delay);
            }

            if (ch[i] == 'p' || ch[i] == 'P') {
                rb.keyPress(KeyEvent.VK_P);
                rb.keyRelease(KeyEvent.VK_P);
                rb.delay(delay);
            }

            if (ch[i] == 'q' || ch[i] == 'Q') {
                rb.keyPress(KeyEvent.VK_Q);
                rb.keyRelease(KeyEvent.VK_Q);
                rb.delay(delay);
            }

            if (ch[i] == 'r' || ch[i] == 'R') {
                rb.keyPress(KeyEvent.VK_R);
                rb.keyRelease(KeyEvent.VK_R);
                rb.delay(delay);
            }

            if (ch[i] == 's' || ch[i] == 'S') {
                rb.keyPress(KeyEvent.VK_S);
                rb.keyRelease(KeyEvent.VK_S);
                rb.delay(delay);
            }

            if (ch[i] == 't' || ch[i] == 'T') {
                rb.keyPress(KeyEvent.VK_T);
                rb.keyRelease(KeyEvent.VK_T);
                rb.delay(delay);
            }

            if (ch[i] == 'u' || ch[i] == 'U') {
                rb.keyPress(KeyEvent.VK_U);
                rb.keyRelease(KeyEvent.VK_U);
                rb.delay(delay);
            }

            if (ch[i] == 'v' || ch[i] == 'V') {
                rb.keyPress(KeyEvent.VK_V);
                rb.keyRelease(KeyEvent.VK_V);
                rb.delay(delay);
            }

            if (ch[i] == 'w' || ch[i] == 'W') {
                rb.keyPress(KeyEvent.VK_W);
                rb.keyRelease(KeyEvent.VK_W);
                rb.delay(delay);
            }

            if (ch[i] == 'x' || ch[i] == 'X') {
                rb.keyPress(KeyEvent.VK_X);
                rb.keyRelease(KeyEvent.VK_X);
                rb.delay(delay);
            }

            if (ch[i] == 'y' || ch[i] == 'Y') {
                rb.keyPress(KeyEvent.VK_Y);
                rb.keyRelease(KeyEvent.VK_Y);
                rb.delay(delay);
            }

            if (ch[i] == 'z' || ch[i] == 'Z') {
                rb.keyPress(KeyEvent.VK_Z);
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

            if (ch[i] == '.') {
                rb.keyPress(KeyEvent.VK_PERIOD);
                rb.keyRelease(KeyEvent.VK_PERIOD);
                rb.delay(delay);
            }
        }

        rb.delay(3000);

        rb.keyPress(KeyEvent.VK_ALT);
        rb.keyPress(KeyEvent.VK_F4);

        rb.keyRelease(KeyEvent.VK_ALT);
        rb.keyRelease(KeyEvent.VK_F4);

        rb.keyPress(KeyEvent.VK_RIGHT);
        rb.keyRelease(KeyEvent.VK_RIGHT);
        rb.keyPress(KeyEvent.VK_ENTER);
        rb.keyRelease(KeyEvent.VK_ENTER);

    }
}