package companionBalls.buttonHandlers;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import companionBalls.robotContainerParts.RobotController;

public class ChangeColorButtonHandler implements ActionListener {
	
	RobotController rc;
	
	public ChangeColorButtonHandler(RobotController robotController)	{
		this.rc = robotController;
	}
	
	public void actionPerformed(ActionEvent e) {
		rc.changeColor(new Color(new Random().nextInt(255), new Random().nextInt(255), new Random().nextInt(255)));
	}
}