package utils;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.File;

public class SwingUtils {
	
	
	public static void centerOnScreen(Component component) {
		if (component != null) {
			Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
			Dimension compSize = component.getSize();
			if (compSize.height > screenSize.height) {
				compSize.height = screenSize.height;
			}
			if (compSize.width > screenSize.width) {
				compSize.width = screenSize.width;
			}
			component.setSize(compSize);
			component.setLocation((screenSize.width - compSize.width) / 2, (screenSize.height - compSize.height) / 2);
		}
	}
	
	public static File createDir(String key, String def) {
		File dir = null;
		String dirString = PropertyHandler.getInstance().getProperty(key);
		if (dirString != null) {
			dir = new File(dirString);
		}
		if (dir == null || !dir.isDirectory()) {
			dir = new File(def);
		}
		return dir;
	}

}
