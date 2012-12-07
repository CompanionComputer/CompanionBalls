package se.nicklasgavelin.sphero.macro.command;

import se.nicklasgavelin.sphero.macro.MacroCommand;
import se.nicklasgavelin.util.ByteArrayBuffer;
import se.nicklasgavelin.util.Value;


public class SpinLeftCommand extends MacroCommand
{
	private int speed; // = Integer.valueOf( 0 );
	
	public SpinLeftCommand(  int speed )
	{
		super( MACRO_COMMAND.MAC_ROLL );
		this.speed=speed;
	}


	@Override
	public byte[] getByteRepresentation()
	{
		ByteArrayBuffer bytes = new ByteArrayBuffer( getLength() );
		bytes.append( getCommandID() );
		bytes.append( (int) ( this.speed * 255.0D ) );
		
		
		return bytes.toByteArray();
	}
}