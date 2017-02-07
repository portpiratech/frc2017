package org.usfirst.frc.team4804.robot.subsystems;

import org.usfirst.frc.team4804.robot.RobotMap;
import org.usfirst.frc.team4804.robot.commands.ShooterCommand;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class ShooterSubsystem extends Subsystem {

	private CANTalon shooterMotor = new CANTalon(RobotMap.SHOOTINGDRIVE_ID);
	private CANTalon agitatorMotor = new CANTalon(RobotMap.AGITATOR_ID);
	
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new ShooterCommand());
    }
    
    public void startShooter(double speed) {
    	shooterMotor.set(speed);
    }
    
    public void stopShooter() {
    	shooterMotor.set(0);
    }
    
    public void startAgitator(double speed) {
    	agitatorMotor.set(speed);
    }
    
    public void stopAgitator() {
    	agitatorMotor.set(0);
    }
}
