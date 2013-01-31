# Simon Says 

## Quick Start Guide

First click the connect button, the connection is established once the Sphero turns white.
If a connection error comes up (like "SEVERE: 	Failed to connect to the robot bluetooth connection") close the program and try to connect again

When the Sphero is connected to the computer hit the button Initialize Robot Controller. It should now be ready to control with the directional keys.

To control another Sphero over a network connection do the steps above and hit the server button (Named "THIS IS SERVER"). This Sphero will now act as a controller for any other Sphero that connects to it. 
(Tip: The blue LED-light shows the back of the Sphero so when you are holding it try to have it face the far back of your palm) 

To connect a Sphero to the server you first fill in the servers ip-address in the Main class, connect the Sphero to the computer with the two steps above and then lastly hit the client button. 

This is based off from: https://github.com/nicklasgav/Sphero-Desktop-API