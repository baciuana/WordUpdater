package main;

import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.lang.reflect.InvocationTargetException;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com.jgoodies.looks.windows.WindowsLookAndFeel;

import utils.PropertyHandler;
import utils.SwingUtils;

public class MainApplication extends JFrame{
	
	private static MainApplication application = null;
	private static final PropertyHandler propertyHandler = PropertyHandler.getInstance();

	public static void main(String[] args) {
		try {
			SwingUtilities.invokeAndWait(new Runnable () {

				@Override
				public void run() {
					application = new MainApplication();
					application.setVisible(true);
					
				}});
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}

	}
	
	public MainApplication(){
		super();
		setCosmetics();
		
		initGUI();
	}
	
	private void initGUI() {
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setTitle("Retromobil Club Romania");
		getContentPane().add(new MainPanel(), BorderLayout.CENTER);
		
		setSize(700, 300);
		SwingUtils.centerOnScreen(this);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				propertyHandler.saveProperties();
				System.exit(0);
			}
		});
	}
	
	public void setCosmetics() {
		try {
			UIManager.setLookAndFeel(new WindowsLookAndFeel());
		} catch (UnsupportedLookAndFeelException ignore) {}
		
		
	}

}
