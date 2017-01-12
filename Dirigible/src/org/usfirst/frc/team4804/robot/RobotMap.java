package org.usfirst.frc.team4804.robot;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.XboxController;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    // Controller number
	public static final int DRIVER_CONTROLLER_ID = 0;
	
    // CAN Device IDs
    public static final int TANKDRIVE_RIGHT_ID = 6; //CAN Talon SRX
	public static final int TANKDRIVE_LEFT_ID = 3; //CAN Talon SRX
	
	// Axis Information
	public static final int LEFT_DRIVE_AXIS = 1;
	public static final int RIGHT_DRIVE_AXIS = 5;
    
    // If you are using multiple modules, make sure to define both the port
    // number and the module. For example you with a rangefinder:
    // public static int rangefinderPort = 1;
    // public static int rangefinderModule = 1;
}
