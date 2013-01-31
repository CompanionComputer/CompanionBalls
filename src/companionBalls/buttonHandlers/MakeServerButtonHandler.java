package companionBalls.buttonHandlers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import companionBalls.RobotContainer;

public class MakeServerButtonHandler implements ActionListener {

	RobotContainer rc;
	
	public MakeServerButtonHandler(RobotContainer robotContainer)	{
		this.rc = robotContainer;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		rc.startServer();
	}

}
