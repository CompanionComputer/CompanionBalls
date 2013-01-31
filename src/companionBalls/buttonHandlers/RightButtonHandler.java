package companionBalls.buttonHandlers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import companionBalls.robotContainerParts.RobotController;

public class RightButtonHandler implements ActionListener {
	
	RobotController rc;
	
	public RightButtonHandler(RobotController robotController)	{
		this.rc = robotController;
	}
	
	public void actionPerformed(ActionEvent e) {
		rc.rollRight();
	}
}