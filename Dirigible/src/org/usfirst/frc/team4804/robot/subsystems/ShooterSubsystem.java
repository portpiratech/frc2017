package org.usfirst.frc.team4804.robot.subsystems;

import org.usfirst.frc.team4804.robot.RobotMap;
import org.usfirst.frc.team4804.robot.commands.ShooterCommand;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class ShooterSubsystem extends Subsystem {

	CANTalon shooterMotor = new CANTalon(RobotMap.SHOOTINGDRIVE_ID);
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new ShooterCommand());
    }
    
    public void start(double speed) {
    	shooterMotor.set(speed);
    }
    
    public void setSpeed(double speed) {
    	shooterMotor.set(speed);
    }
    
    public void stop() {
    	shooterMotor.set(0.0);
    }
}

