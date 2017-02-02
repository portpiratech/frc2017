package org.usfirst.frc.team4804.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    //// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
    // Joystick stick = new Joystick(port);
    // Button button = new JoystickButton(stick, buttonNumber);
    
    // There are a few additional built in buttons you can use. Additionally,
    // by subclassing Button you can create custom triggers and bind those to
    // commands the same as any other Button.
    
    //// TRIGGERING COMMANDS WITH BUTTONS
    // Once you have a button, it's trivial to bind it to a button in one of
    // three ways:
    
    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenPressed(new ExampleCommand());
    
    // Run the command while the button is being held down and interrupt it once
    // the button is released.
    // button.whileHeld(new ExampleCommand());
    
    // Start the command when the button is released  and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());
	
	
	//Create driver controller and all of its associated buttons.
	public static XboxController driverController = new XboxController(RobotMap.DRIVER_CONTROLLER_ID);
	
	Button driverAButton = new JoystickButton(driverController, 0),
			driverBButton = new JoystickButton(driverController, 1),
			driverXButton = new JoystickButton(driverController, 2),
			driverYButton = new JoystickButton(driverController, 3),
			driverLeftBumper = new JoystickButton(driverController, 4),
			driverRightBumper = new JoystickButton(driverController, 5),
			driverBackButton = new JoystickButton(driverController, 6),
			driverStartButton = new JoystickButton(driverController, 7),
			driverLeftStickPress = new JoystickButton(driverController, 8),
			driverRightStickPress = new JoystickButton(driverController, 9);
			
			
	
	public OI() {
		// driverYButton.whileHeld(new DriveToDistance());
		// driverLeftBumper.whenPressed(new GyroReset());
		
		
	}
}

