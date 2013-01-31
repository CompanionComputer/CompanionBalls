package companionBalls;

import java.io.IOException;

import companionBalls.robotContainerParts.*;
import companionBalls.robotContainerParts.networking.ClientAndServerCreator;
import companionBalls.robotContainerParts.networking.WebsocketClient;

public class RobotContainer {

	private RobotConnector connector;
	public RobotController controller = new RobotController();
	private ClientAndServerCreator clientServerCreator;
	
	/**
	 * Starts a device search and if a Sphero is found then it's connected and stored in the RobotConnector
	 */
	public void searchAndConnectToSphero()	{
		connector = new RobotConnector();
		connector.start();
	}
	
	/**
	 * Connects to a device without doing a device search 
	 * 
	 * @param bluetoothId The id to the bluetooth device
	 */
	public void connectToSphero(String bluetoothId)	{
		connector = new RobotConnector(bluetoothId);
		connector.start();
		System.out.println("Connecting to: " + bluetoothId);
	}
	
	/**
	 * Takes the Robot object from RobotConnector and makes it controllable by adding it to the RobotController object
	 */
	//TODO(For the far future): Remove this in the future and make the search and connect methods do this instead. 
	//Need some thing that checks if all the threads started by Bluetooth discover has finished
	public void finilizeConnection()	{
		controller.addRobot(connector.getRobotArray().get(0));
		System.out.println("Robot added, ready to control");
	}
	
	public void startClient(String ipToServer)	{
		clientServerCreator = new ClientAndServerCreator(ipToServer, 1, 8080);
		controller.turnOnFrontLed();
		WebsocketClient wc = clientServerCreator.getWebsocketClient();
		while (true){
			try {
				if (wc.in.available()>0){
					controller.remoteDrive(wc.in.readInt(), wc.in.readDouble());
//					System.out.println(wc.in.readInt() + wc.in.readDouble());
				}
			} catch (IOException e1) {				}
		}
	}
	
	public void startServer()	{
		clientServerCreator = new ClientAndServerCreator("leavethisempty", 0, 8080);
		controller.addSensonListener(new RobotSensorListener(clientServerCreator.getWebsocketServer()));
		controller.getDataFromSensors();
	}
}
