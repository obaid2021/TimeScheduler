package warnings;

import java.awt.Color;

import javax.swing.JOptionPane;
import javax.swing.UIManager;

/**
 * This class generates message prompts depending on errors and information
 * messages
 * 
 * @author Muhammad Obaid Ullah ,Syed Adil Ehsan , Rao Shahan Naveed
 *
 */
public class Error {
	/**
	 * this function creates an error message window on the screen.
	 * 
	 * @param error message that will be displayed on the screen.
	 */
	public void errorMessage(String error) {

		UIManager.put("OptionPane.background", Color.GRAY);
		UIManager.put("OptionPane.messageForeground", Color.WHITE);
		Object put = UIManager.put("Panel.background", Color.GRAY);
		JOptionPane.showMessageDialog(null, "  " + error, "ERROR", JOptionPane.ERROR_MESSAGE);

	}

	/**
	 * this function creates an error warning window on the screen.
	 * 
	 * @param error warning that will be displayed on the screen.
	 */
	public void errorWarning(String error) {
		UIManager.put("OptionPane.background", Color.GRAY);
		UIManager.put("OptionPane.messageForeground", Color.WHITE);
		Object put = UIManager.put("Panel.background", Color.GRAY);
		JOptionPane.showMessageDialog(null, " " + error);

	}
}
