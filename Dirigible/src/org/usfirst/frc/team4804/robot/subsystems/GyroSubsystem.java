package org.usfirst.frc.team4804.robot.subsystems;

import org.usfirst.frc.team4804.robot.commands.GyroCommand;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class GyroSubsystem extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	ADXRS450_Gyro gyro;
	
	public GyroSubsystem(){
		gyro = new ADXRS450_Gyro();
		
    	gyro.calibrate();
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new GyroCommand());
    }
    
    public void reset(){
    	gyro.reset();
    }

    
    public double getAngle(){
    	return gyro.getAngle();
    }
    public double getRate(){
    	return gyro.getRate();
    }
    
}

