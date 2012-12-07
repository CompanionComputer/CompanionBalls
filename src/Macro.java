
import java.awt.Color;

import se.nicklasgavelin.sphero.Robot;
import se.nicklasgavelin.sphero.command.SetDataStreamingCommand;
import se.nicklasgavelin.sphero.command.SpinLeftCommand;
import se.nicklasgavelin.sphero.command.SpinRightCommand;
import se.nicklasgavelin.sphero.command.*;
import se.nicklasgavelin.sphero.macro.MacroObject;
import se.nicklasgavelin.sphero.macro.command.*;

public class Macro {
	Robot r;
	private int heading=0;
	private double speed= 0.1;
	
	public Macro(Robot spheroRobot){
		this.r = spheroRobot;
	}
	public void rollfwd(){
		MacroObject m = new MacroObject();
		m.addCommand( new Roll(1,1,0) );
		r.sendCommand(m);

	}
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
		//r.roll(degree, 1);
	}
	public void changeColor(Color color)	{
//		MacroObject m = new MacroObject();
//		m.addCommand(new Delay( 2000));
//		r.sendCommand(m);
		r.setRGBLedColor(color);
	}
	public void rollForward()	{
		MacroObject m = new MacroObject();
		m.addCommand(new Roll(speed, heading,0));
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
//		heading = (heading+270)%360;
		m.addCommand(new Roll(speed, heading, 0));
		r.sendCommand(m);
	}
	public void rollRight()	{
		MacroObject m = new MacroObject();
		//heading = (heading+90)%360;
		heading = (heading+30)%360;
		m.addCommand(new Roll(speed, heading, 0));
		r.sendCommand(m);
	}
	public void spinLeftCommand()	{
		r.sendCommand(new SpinLeftCommand(200));
	}
	
	/**
	 * Gets filtered data from the IMU sensor
	 */
	
	//From forum.gosphero.com/archive/index.php/t-806.html
	//TODO: change void return type
	public void getDataFromSensors()	{
		SetDataStreamingCommand sds = new SetDataStreamingCommand(210, 1, SetDataStreamingCommand.DATA_STREAMING_MASKS.ACCELEROMETER.ALL.FILTERED, 100);
		r.sendCommand(sds);
		r.sendCommand(new FrontLEDCommand(1));
		r.sendCommand(new StabilizationCommand(false));
	}
void maze(String source){
	System.out.println(source);
		MacroObject m = new MacroObject();
		if (source.equals("forward")){
			speed=speed+0.02;
			
		} else if (source.equals("backward")){
			speed=speed-0.02;
		} else if (source.equals("left")){
			heading = heading +270;
			//m.addCommand(new SpinRightCommand(90));
			m.addCommand(new Delay(10));
		} else if (source.equals("right")){
			heading = heading +90;
		}
		heading = heading % 360;
		if (speed <0){
			speed = 0;
		}
		
		m.addCommand(new Roll(speed,heading,0));
		r.sendCommand(m);
	}
}
