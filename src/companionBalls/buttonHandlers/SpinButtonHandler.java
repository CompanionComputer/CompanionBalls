package companionBalls.buttonHandlers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import companionBalls.robotContainerParts.RobotController;

public class SpinButtonHandler implements ActionListener {

	private RobotController rc;

	public SpinButtonHandler(RobotController robotController) {
		this.rc=robotController;
	}

	public void actionPerformed(ActionEvent e) {			
		rc.stop();
	}

}
