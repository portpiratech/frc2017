package org.usfirst.frc.team4804.robot.subsystems;

import org.usfirst.frc.team4804.robot.commands.MecanumDriveCommand;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class MecanumDriveTrain extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	public RobotDrive drive;
	
	public MecanumDriveTrain(int frontLeftMotorID, int rearLeftMotorID, int frontRightMotorID, int rearRightMotorID){
		drive = new RobotDrive(frontLeftMotorID, rearLeftMotorID, frontRightMotorID, rearLeftMotorID);
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new MecanumDriveCommand());
    }
    
    public void mecanumDrive(double magnitude, double direction, double rotation){
    	drive.mecanumDrive_Polar(magnitude, direction, rotation);
    }
}

