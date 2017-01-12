package org.usfirst.frc.team4804.robot.subsystems;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Shooter extends Subsystem {
	
	private CANTalon shooterMotor;
	
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	public Shooter(int motorId) {
		shooterMotor = new CANTalon(motorId);
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void shoot(double speed) {
    	shooterMotor.set(speed);
    }
    
    public void stop() {
    	shooterMotor.set(0);
    }
}

