package org.usfirst.frc.team4804.robot.subsystems;

import org.usfirst.frc.team4804.robot.RobotMap;
import org.usfirst.frc.team4804.robot.commands.MecanumDriveCommand;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class MecanumDriveTrain extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	public RobotDrive drive;
	
	private CANTalon frontLeft = new CANTalon(RobotMap.FRONT_LEFT_ID); 
	private CANTalon rearLeft = new CANTalon(RobotMap.REAR_LEFT_ID);
	private CANTalon frontRight = new CANTalon(RobotMap.FRONT_RIGHT_ID);
	private CANTalon rearRight = new CANTalon(RobotMap.REAR_RIGHT_ID);
	
	public MecanumDriveTrain(){
		frontLeft.setInverted(true);
		rearLeft.setInverted(true);
		
		drive = new RobotDrive(frontLeft, rearLeft, frontRight, rearRight);
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new MecanumDriveCommand());
    }
    
    public void mecanumDrivePolar(double magnitude, double direction, double rotation){
    	drive.mecanumDrive_Polar(magnitude, direction, rotation);
    }
    
    public void mecanumDriveCartesian(double xSpeed, double ySpeed, double rotation, double gyroAngle) {
    	drive.mecanumDrive_Cartesian(xSpeed, ySpeed, rotation, gyroAngle);
    }
}

