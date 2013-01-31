package companionBalls.buttonHandlers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import companionBalls.RobotContainer;

public class ConnectButtonHandler implements ActionListener {
	
	private RobotContainer rb;
	private String bluetoothAddr="";
	
	public ConnectButtonHandler(RobotContainer robotContainer)	{
		this.rb = robotContainer;
	}
	
	public ConnectButtonHandler(RobotContainer robotContainer, String bluetoothAddress)	{
		this.rb = robotContainer;
		this.bluetoothAddr = bluetoothAddress;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(bluetoothAddr.isEmpty())	{
			rb.searchAndConnectToSphero();
		}
		else	{
			rb.connectToSphero(bluetoothAddr);
		}
	}
	
	
}
