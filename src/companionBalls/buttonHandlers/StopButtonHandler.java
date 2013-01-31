package companionBalls.buttonHandlers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import companionBalls.robotContainerParts.RobotController;

public class StopButtonHandler implements ActionListener {

	private RobotController rc;

	public StopButtonHandler(RobotController robotController)	{
		this.rc=robotController;
	}

	public void actionPerformed(ActionEvent e) {			
		rc.stop();
	}

}
