package companionBalls.buttonHandlers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import companionBalls.RobotContainer;

public class AddRobotsToArrayButtonHandler implements ActionListener {

	private RobotContainer rc;
	
	public AddRobotsToArrayButtonHandler(RobotContainer robotContainer)	{
		this.rc = robotContainer;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		rc.finilizeConnection();
	}

}
