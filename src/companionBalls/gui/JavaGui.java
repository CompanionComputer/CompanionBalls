package companionBalls.gui;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
//import java.awt.Robot;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

import se.nicklasgavelin.sphero.macro.MacroObject;
import se.nicklasgavelin.sphero.macro.command.Delay;
import se.nicklasgavelin.sphero.macro.command.FrontLED;
import se.nicklasgavelin.sphero.macro.command.RGBSD2;
import se.nicklasgavelin.sphero.macro.command.Roll;
import se.nicklasgavelin.sphero.Robot;

import companionBalls.buttonHandlers.*;
import companionBalls.robotContainerParts.RobotController;


public class JavaGui extends JFrame {
	// Dimensions
	private static final int windowWIDTH = 700;
	private static final int windowHEIGHT =200;

	//String ButtonsMapping
	private static String ForwardMAP = 		"UP";
	private static String BackwardMAP = 	"DOWN";
	private static String RightMAP = 		"RIGHT";
	private static String LeftMAP = 		"LEFT";
	private static String StopMAP = 		"E";
	private static String PanicMAP =		"ENTER";					
	private static String SpinMAP =     	"Q";
	private static String ChangeColorMAP = 	"W";
	private static String ConnectMAP =    	"1";
	private static String DisconnectMAP = 	"2";

	//unbinded - do as above
	private static String AddrobottoArrayMAP = 	"";
	private static String B2MAP = 	"";
	private static String B3MAP = 	"";
	private static String B4MAP = 	"";

	// strings
	private static String headerstring = "The ball coordinator";
	// strings buttons, please dont mess around with spacing
	private static String Forward = "  Forward ";
	private static String Backward = "Backward";
	private static String Right = "Right";
	private static String Left = " Left";

	private static String Stop = "           Stop           ";
	private static String Panic ="         PANIC!!        ";

	private static String Spin =        "                 Spin";
	private static String ChangeColor = "Change Color";

	private static String Connect =    "Connect ALL THE THINGS      ";
	private static String Disconnect = "Disconnect ALL THE THINGS";

	//TODO: change this button so it says "Finilize Connection"
	private static String AddrobottoArray = "Initialize Robot Controller";
	private static String B2 = "Get response from gyro";
	private static String Server = "THIS IS SERVER";
	private static String Client = "ohh, and I am client";
	//end configs

	// the buttons
	private JButton ForwardB, BackwardB, RightB, LeftB,
	StopB, SpinB, ChangeColorB,
	ConnectB, DisconnectB,
	AddrobottoArrayB, B2B, ServerB, ClientB
	;

	public JavaGui(){
		createbuttons();

		JPanel panel = new JPanel();
		JPanel left = new JPanel();
		JPanel middle = new JPanel();
		JPanel right = new JPanel();
		JPanel middlehorizontal = new JPanel();

		panel.setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2));
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));

		left.setLayout(new BoxLayout(left, BoxLayout.Y_AXIS));
		middle.setLayout(new BoxLayout(middle, BoxLayout.Y_AXIS));
		right.setLayout(new BoxLayout(right, BoxLayout.Y_AXIS));
		middlehorizontal.setLayout(new BoxLayout(middlehorizontal, BoxLayout.X_AXIS));

		middle.add(Box.createRigidArea(new Dimension(300,0)));

		addbuttonsConnectDisconnect(left);
		addbuttonsforward(middle);
		addbuttonsDirections(middlehorizontal);
		middle.add(middlehorizontal);
		addbuttonsStopPanic(middle);
		addbuttonsSpinColor(right);
		addbuttonsB14(right);

		//Add listeners to keyboard
		addbuttonslistener(ForwardB, ForwardMAP);
		addbuttonslistener(LeftB, LeftMAP);
		addbuttonslistener(BackwardB, BackwardMAP);
		addbuttonslistener(RightB, RightMAP);
		addbuttonslistener(StopB, StopMAP);
//		addbuttonslistener(PanicB, PanicMAP);
		addbuttonslistener(SpinB, SpinMAP);
		addbuttonslistener(ChangeColorB, ChangeColorMAP);
		addbuttonslistener(ConnectB, ConnectMAP);
		addbuttonslistener(DisconnectB, DisconnectMAP);
		addbuttonslistener(AddrobottoArrayB, AddrobottoArrayMAP);
		addbuttonslistener(B2B, B2MAP);
		addbuttonslistener(ServerB, B3MAP);
		addbuttonslistener(ClientB, B4MAP);


		panel.add(left);
		panel.add(middle);
		panel.add(right);
		add(panel);

		setTitle(headerstring);
		setSize(windowWIDTH , windowHEIGHT);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
		panel.requestFocusInWindow();
	}
	//creating the buttons
	private void createbuttons(){
		// handlers for each button and ActionListeners to each button.

		ForwardB = new JButton(Forward);
		ForwardB.setAlignmentX(CENTER_ALIGNMENT);

		BackwardB = new JButton(Backward);
		BackwardB.setAlignmentX(CENTER_ALIGNMENT);

		RightB = new JButton(Forward);
		RightB.setAlignmentX(CENTER_ALIGNMENT);

		LeftB = new JButton(Left);
		LeftB.setAlignmentX(CENTER_ALIGNMENT);

		RightB = new JButton(Right);
		RightB.setAlignmentX(CENTER_ALIGNMENT);

		StopB = new JButton(Stop);
		StopB.setAlignmentX(CENTER_ALIGNMENT);

//		PanicB = new JButton(Panic);
//		PanicB.setAlignmentX(CENTER_ALIGNMENT);

		SpinB = new JButton(Spin);
		SpinB.setAlignmentX(RIGHT_ALIGNMENT);

		ChangeColorB = new JButton(ChangeColor);
		ChangeColorB.setAlignmentX(RIGHT_ALIGNMENT);

		ConnectB = new JButton(Connect);
		ConnectB.setAlignmentX(LEFT_ALIGNMENT);

		DisconnectB = new JButton(Disconnect);
		DisconnectB.setAlignmentX(LEFT_ALIGNMENT);

		AddrobottoArrayB = new JButton(AddrobottoArray);
		AddrobottoArrayB.setAlignmentX(LEFT_ALIGNMENT);

		B2B = new JButton(B2);
		B2B.setAlignmentX(RIGHT_ALIGNMENT);

		ServerB = new JButton(Server);
		ServerB.setAlignmentX(LEFT_ALIGNMENT);

		ClientB = new JButton(Client);
		ClientB.setAlignmentX(RIGHT_ALIGNMENT);
	}

	//Adds the action listeners to the buttons
	public void addForwardButtonHandler(ActionListener actionListener)	{
		ForwardB.addActionListener(actionListener);
	}
	public void addBackwardButtonHandler(ActionListener actionListener)	{
		BackwardB.addActionListener(actionListener);
	}
	public void addLeftButtonHandler(ActionListener actionListener)	{
		LeftB.addActionListener(actionListener);
	}
	public void addRightButtonHandler(ActionListener actionListener)	{
		RightB.addActionListener(actionListener);
	}
	public void addStopButtonHandler(ActionListener actionListener)	{
		StopB.addActionListener(actionListener);
	}
	public void addSpinButtonHandler(ActionListener actionListener)	{
		SpinB.addActionListener(actionListener);
	}
	public void addChangeColorButtonHandler(ActionListener actionListener)	{
		ChangeColorB.addActionListener(actionListener);
	}
	public void addConnectButtonHandler(ActionListener actionListener)	{
		ConnectB.addActionListener(actionListener);
	}
	public void addDisconnectButtonHandler(ActionListener actionListener)	{
		DisconnectB.addActionListener(actionListener);
	}
	public void addAddRobotsToArrayButtonHandler(ActionListener actionListener)		{
		AddrobottoArrayB.addActionListener(actionListener);
	}
	public void addServerButtonHanlder(ActionListener actionListener)	{
		ServerB.addActionListener(actionListener);
	}
	public void addClientButtonHandler(ActionListener actionListener)	{
		ClientB.addActionListener(actionListener);
	}


	//THESE CONTAIN THE SPACING BETWEEN THE BUTTONS, PLEASE DONT MESS AROUND WITH IT
	private void addbuttonsforward(Container C){
		C.add(ForwardB);
		C.add(Box.createRigidArea(new Dimension(0, 5)));
	}
	private void addbuttonsDirections(Container C){
		C.add(LeftB);
		C.add(Box.createRigidArea(new Dimension(5, 0)));
		C.add(BackwardB);
		C.add(Box.createRigidArea(new Dimension(5, 0)));
		C.add(RightB);	
	}
	private void addbuttonsStopPanic(Container C){
		C.add(Box.createRigidArea(new Dimension(0, 20)));
//		C.add(PanicB);
		C.add(Box.createRigidArea(new Dimension(0, 5)));
		C.add(StopB);		
	}
	private void addbuttonsSpinColor(Container C){
		C.add(SpinB);
		C.add(Box.createRigidArea(new Dimension(0, 5)));
		C.add(ChangeColorB);
	}

	private void addbuttonsConnectDisconnect(Container C){
		C.add(ConnectB);
		C.add(Box.createRigidArea(new Dimension(0, 5)));
		C.add(AddrobottoArrayB);
		C.add(Box.createRigidArea(new Dimension(0, 5)));
		C.add(DisconnectB);		
		C.add(Box.createRigidArea(new Dimension(0, 5)));
		C.add(ServerB);
	}

	private void addbuttonsB14(Container C){

		C.add(Box.createRigidArea(new Dimension(0, 5)));
		C.add(B2B);

		C.add(Box.createRigidArea(new Dimension(0, 5)));
		C.add(ClientB);
	}

	private void addbuttonslistener(JButton B, String key){
		B.getInputMap(B.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(key),"pressed");
		B.getInputMap(B.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("released "+ key), "released");
	}
}

