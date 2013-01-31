package companionBalls.buttonHandlers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import companionBalls.RobotContainer;

public class DisconnectButtonHandler implements ActionListener {

	RobotContainer rb;
	
	public DisconnectButtonHandler(RobotContainer robotContainer)	{
		this.rb = robotContainer;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		//TODO: find a way to disconnect the Sphero without halting the program
	}

}
