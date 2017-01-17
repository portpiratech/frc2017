package org.usfirst.frc.team4804.robot.subsystems;

import org.usfirst.frc.team4804.robot.RobotMap;
import org.usfirst.frc.team4804.robot.commands.JoystickDriveCommand;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class DriveTrain extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	CANTalon leftTalon = new CANTalon(RobotMap.TANKDRIVE_LEFT_ID);
	CANTalon rightTalon = new CANTalon(RobotMap.TANKDRIVE_RIGHT_ID);
	RobotDrive drive = new RobotDrive(leftTalon, rightTalon);
    
	public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new JoystickDriveCommand());
    }
    
    public void joystickDrive(double leftValue, double rightValue) {
    	drive.tankDrive(leftValue, rightValue);
    }
}

