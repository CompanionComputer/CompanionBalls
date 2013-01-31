
import java.io.IOException;
import java.sql.ClientInfoStatus;
import java.util.Iterator;


import se.nicklasgavelin.sphero.Robot;

import companionBalls.*;
import companionBalls.buttonHandlers.AddRobotsToArrayButtonHandler;
import companionBalls.buttonHandlers.BackwardButtonHandler;
import companionBalls.buttonHandlers.ChangeColorButtonHandler;
import companionBalls.buttonHandlers.ConnectButtonHandler;
import companionBalls.buttonHandlers.ForwardButtonHandler;
import companionBalls.buttonHandlers.LeftButtonHandler;
import companionBalls.buttonHandlers.MakeClientButtonHandler;
import companionBalls.buttonHandlers.MakeServerButtonHandler;
import companionBalls.buttonHandlers.RightButtonHandler;
import companionBalls.buttonHandlers.SpinButtonHandler;
import companionBalls.buttonHandlers.StopButtonHandler;
import companionBalls.gui.JavaGui;
import companionBalls.robotContainerParts.RobotController;

public class Main {
	
	
	public static void main(String[] args)	{
		JavaGui gui = new JavaGui();
		String ipToServer = "130.240.108.209";  //fill in the server ip
//		String bluetoothAddr = "";
		String bluetoothAddr = "0006664438B8"; //For Sphero-BBR
//		String bluetoothAddr = "000666440DB8"; //For Sphero-WBG
		
		RobotContainer robotContainer = new RobotContainer();
		
		//Adding the button listeners to the buttons
		if(bluetoothAddr.isEmpty())
			gui.addConnectButtonHandler(new ConnectButtonHandler(robotContainer));
		else
			gui.addConnectButtonHandler(new ConnectButtonHandler(robotContainer, bluetoothAddr));
		gui.addForwardButtonHandler(new ForwardButtonHandler(robotContainer.controller));
		gui.addBackwardButtonHandler(new BackwardButtonHandler(robotContainer.controller));
		gui.addLeftButtonHandler(new LeftButtonHandler(robotContainer.controller));
		gui.addRightButtonHandler(new RightButtonHandler(robotContainer.controller));
		gui.addChangeColorButtonHandler(new ChangeColorButtonHandler(robotContainer.controller));
		gui.addSpinButtonHandler(new SpinButtonHandler(robotContainer.controller));
		gui.addStopButtonHandler(new StopButtonHandler(robotContainer.controller));
		gui.addClientButtonHandler(new MakeClientButtonHandler(robotContainer, ipToServer));
		gui.addServerButtonHanlder(new MakeServerButtonHandler(robotContainer));
		gui.addAddRobotsToArrayButtonHandler(new AddRobotsToArrayButtonHandler(robotContainer));
	}
}

