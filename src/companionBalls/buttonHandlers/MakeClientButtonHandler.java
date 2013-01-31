package companionBalls.buttonHandlers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import companionBalls.RobotContainer;

public class MakeClientButtonHandler implements ActionListener {

	RobotContainer rc;
	String ipToServer;
	
	public MakeClientButtonHandler(RobotContainer robotContainer, String ipToServer)	{
		this.rc = robotContainer;
		this.ipToServer = ipToServer;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		rc.startClient(ipToServer);
	}

}
