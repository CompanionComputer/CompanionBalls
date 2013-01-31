package companionBalls.robotContainerParts;


import java.awt.Color;

import se.nicklasgavelin.sphero.Robot;
import se.nicklasgavelin.sphero.RobotListener;
import se.nicklasgavelin.sphero.command.*;
import se.nicklasgavelin.sphero.macro.MacroObject;
import se.nicklasgavelin.sphero.macro.command.*;

/**
 * Controls a Spheroes movement and RGB light 
 * 
 * @author Companion Balls
 *
 */
public class RobotController {
	private Robot r;
	private int heading=0;
	private double speed= 0.1;
	private double buttonTapSpeed = 0.3; //Sets the speed for the commands started by the button presses
	private double backwardSpeed = -0.1;

	public RobotController(){}
	
	public RobotController(Robot spheroRobot){
		this.r = spheroRobot;
	}

	public RobotController(Robot spheroRobot, RobotListener robotSensorListener){
		this.r = spheroRobot;
		r.addListener(robotSensorListener);
	}
	
	public void addRobot(Robot spheroRobot)	{
		this.r = spheroRobot;
	}
	
	public void addSensonListener(RobotListener robotListener)	{
		r.addListener(robotListener);
	}

	public void remoteDrive(int heading, double speed){
		MacroObject m = new MacroObject();
		m.addCommand( new Roll(speed,heading,0) );
		r.sendCommand(m);
	}

	/**
	 * Starts a circular movement
	 */
	public void rollcircle(){
		int degree=0;
		MacroObject m = new MacroObject();
		while(degree<=359){
			m.addCommand( new Roll(speed,degree, 0) );
			m.addCommand( new Delay( 500 ) );
			degree=degree+15;
		}
		m.addCommand(new Roll(0,0,0));
		r.sendCommand(m);
	}
	public void changeColor(Color color)	{
		r.setRGBLedColor(color);
	}
	public void rollForward()	{
		MacroObject m = new MacroObject();
		m.addCommand(new Roll(buttonTapSpeed, heading,0));
		r.sendCommand(m);
	}
	public void rollBackwards()	{
		MacroObject m = new MacroObject();
		m.addCommand(new Roll(backwardSpeed, heading,0));
		r.sendCommand(m);
	}
	public void stop()	{
		MacroObject m = new MacroObject();
		m.addCommand(new Roll(0,0,0));
		r.sendCommand(m);
	}
	public void rollLeft()	{
		MacroObject m = new MacroObject();
		heading = (heading+330)%360;
		m.addCommand(new Roll(buttonTapSpeed, heading, 0));
		r.sendCommand(m);
	}
	public void rollRight()	{
		MacroObject m = new MacroObject();
		heading = (heading+30)%360;
		m.addCommand(new Roll(buttonTapSpeed, heading, 0));
		r.sendCommand(m);
	}
	public void spinLeftCommand()	{
		r.sendCommand(new SpinLeftCommand(200));
	}

	public void turnOnFrontLed()	{
		r.sendCommand(new FrontLEDCommand(1));
	}

	//From forum.gosphero.com/archive/index.php/t-806.html
	//TODO: change void return type
	public void getDataFromSensors()	{
		SetDataStreamingCommand sds = new SetDataStreamingCommand(420, 1, SetDataStreamingCommand.DATA_STREAMING_MASKS.IMU.ALL.FILTERED, 100);
		r.sendCommand(sds);
		r.sendCommand(new FrontLEDCommand(1));
		r.sendCommand(new StabilizationCommand(false));
	}

	public void maze(String source) {
		System.out.println(source);
		MacroObject m = new MacroObject();

		if (source.equals("forward")) {
			speed = speed + 0.02;

		} else if (source.equals("backward")) {
			speed = speed - 0.02;
		} else if (source.equals("left")) {
			heading = heading + 270;
			// m.addCommand(new SpinRightCommand(90));
			m.addCommand(new Delay(10));
		} else if (source.equals("right")) {
			heading = heading + 90;
		}
		heading = heading % 360;
		if (speed < 0) {
			speed = 0;
		}

		m.addCommand(new Roll(speed, heading, 0));
		r.sendCommand(m);
	}
}