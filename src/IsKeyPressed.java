import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.event.KeyEvent;

public class IsKeyPressed {
	private static boolean dPressed, aPressed;
	
	public static boolean isDPressed() {
	//	synchronized (IsKeyPressed.class) {
		check();
				return dPressed;
	//}
	}
	
	public static boolean isAPressed() {
		//synchronized(IsKeyPressed.class) {
		check();
			return aPressed;
		//}
	}
	
	private static void check() {
		KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(new KeyEventDispatcher() {

            @Override
            public boolean dispatchKeyEvent(KeyEvent ke) {
               // synchronized (IsKeyPressed.class) {
                	//System.out.println(ke.getID() + " " + ke.getKeyCode());
                    switch (ke.getID()) {
                    case KeyEvent.KEY_PRESSED:
                        if (ke.getKeyCode() == KeyEvent.VK_D) {
                            dPressed = true;
                        }
                        else if(ke.getKeyCode() == KeyEvent.VK_A){
                        	aPressed = true;
                        }
                        break;

                    case KeyEvent.KEY_RELEASED:
                        if (ke.getKeyCode() == KeyEvent.VK_D) {
                            dPressed = false;
                        }
                        else if(ke.getKeyCode() == KeyEvent.VK_A) {
                        	aPressed = false;
                        }
                        break;
                    }
                    return false;
                }
           // }
        });
	}
	
}
