package midpoint;

import static org.lwjgl.opengl.GL11.*;

import java.util.Scanner;

import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.LWJGLException;
import org.lwjgl.input.Keyboard;

public class mid {

	public static void main(String args[]) {

		try {
			Display.setDisplayMode(new DisplayMode(800, 600));
			Display.setTitle("mk : 95Coder");
			Display.create();
		} catch (LWJGLException e) {
			e.printStackTrace();
			Display.destroy();
			System.exit(1);
		}

		glMatrixMode(GL_PROJECTION);
		glOrtho(0, 640, 480, 0, 1, -1);
		glMatrixMode(GL_MODELVIEW);

		circle mk = new circle();
		// mk.midPointCircleAlgo();

		while (!Display.isCloseRequested()) {

			glClear(GL_COLOR_BUFFER_BIT);

			mk.midPointCircleAlgo();

			if (Keyboard.isKeyDown(Keyboard.KEY_ESCAPE)) {
				Display.destroy();
				System.exit(0);
			}

			Display.update();
			Display.sync(60);

		}

	}

	static class circle {
		int pntX1 = 200, pntY1 = 200, r = 100;
		Scanner sc = new Scanner(System.in);

		void plot(int x, int y) {
			glBegin(GL_POINTS);
			glVertex2i(x + pntX1, y + pntY1);
			glEnd();

		}

		void midPointCircleAlgo() {
			int x = 0;
			int y = r;
			float decision = 5 / 4 - r;

			plot(x, y);
			while (y > x) {
				if (decision < 0) {
					x++;
					decision += 2 * x + 1;
				} else {
					y--;
					x++;
					decision += 2 * (x - y) + 1;
				}
				plot(x, y);
				plot(x, -y);
				plot(-x, y);
				plot(-x, -y);
				plot(y, x);
				plot(-y, x);
				plot(y, -x);
				plot(-y, -x);
			}

		}

	}

}
