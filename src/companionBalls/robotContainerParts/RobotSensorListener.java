package companionBalls.robotContainerParts;

import java.io.IOException;

import companionBalls.robotContainerParts.networking.WebsocketServer;

import se.nicklasgavelin.sphero.Robot;
import se.nicklasgavelin.sphero.command.CommandMessage;
import se.nicklasgavelin.sphero.response.InformationResponseMessage;
import se.nicklasgavelin.sphero.response.ResponseMessage;
import se.nicklasgavelin.sphero.response.information.DataResponse;

/**
 * For testing the sensor listener
 * 
 */

public class RobotSensorListener implements se.nicklasgavelin.sphero.RobotListener {

	DataResponse dr;
	WebsocketServer ws;

	public RobotSensorListener(WebsocketServer ws)	{
		//if (ws!=null)
		this.ws=ws;
	}

	@Override
	public void responseReceived(Robot r, ResponseMessage response,
			CommandMessage dc) {
	}

	@Override
	public void event(Robot r, EVENT_CODE code) {
		// TODO Auto-generated method stub

	}

	@Override
	public void informationResponseReceived(Robot r,
			InformationResponseMessage response) {
		dr = ( DataResponse ) response;

		byte[] data = dr.getSensorData();
		DirectionCalculation dc = new DirectionCalculation();
		dc.calcDirection((int)(data[1]), (int)(data[3]));
		int heading = dc.getHeading();
		double speed = dc.getSpeed();
		try {
			ws.sendcommands(heading, speed);
		} catch (IOException e) {
			System.out.println("lol fail in informationResponseReceived");
		}
		
		
	}
}
