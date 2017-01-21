package org.usfirst.frc.team4804.robot.subsystems;

import org.usfirst.frc.team4804.robot.RobotMap;
import org.usfirst.frc.team4804.robot.commands.JoystickDriveCommand;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class DriveTrain extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	RobotDrive drive;
	CANTalon leftTalon;
	CANTalon rightTalon;

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new JoystickDriveCommand());
    }
    
    public DriveTrain(int leftTalonId, int rightTalonId) {
    	leftTalon = new CANTalon(leftTalonId);
    	rightTalon = new CANTalon(rightTalonId);
    	drive = new RobotDrive(leftTalon, rightTalon);
    }
    
    public void joystickDrive(double leftValue, double rightValue) {
    	drive.tankDrive(leftValue, rightValue);
    }
    

}

