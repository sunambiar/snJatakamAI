
/*-------------------- Template for all Good Applets ------------*/
package snJatakamAI.snJatakam.sn_Jatakam.sn_Jatak;
/*---------------------------------------------------------------*/
import java.applet.*;
import java.awt.*;
/*---------------------------------------------------------------*/
public class snAppletTemplate extends Applet implements Runnable {
	Thread snThread;
	public String getAppletInfo () {
		StringBuffer s = new StringBuffer();
		s.append("snApplet Template\n");
                s.append((char) 169);          // Copyright Symbol
                //s.append((char) 0x2122);     // Trademark Symbol
		s.append("2002 ver 1.0");
		return s.toString();
	}
	public String [] [] getParameterInfo () {
		String [][] result = {
			{ " Parameter1", "int", "Iterations (default 5)" },
			{ " Parameter2", "float", "Variation (default 2.0)" },
			{ " Parameter3", "boolean", "Sea (default true)" }
		};
		return (result);
	}
	public void init () {
	}

	public void start () {
		if (snThread == null) {
			snThread = new Thread(this);
			snThread.start();
		}
	}
	public void stop () {
		if (snThread != null) {
			snThread.stop();
			snThread = null;
		}
	}
	public void destroy () {
	}
	public void paint (Graphics g) {
	}
	public void run () {
	}
	public boolean action (Event e, Object arg) {
		return (false);
	}
}
/*------------------- End of snAppletTemplate ------------------*/
