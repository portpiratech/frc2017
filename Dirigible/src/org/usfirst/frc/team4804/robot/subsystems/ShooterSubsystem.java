package org.usfirst.frc.team4804.robot.subsystems;

import org.usfirst.frc.team4804.robot.RobotMap;
import org.usfirst.frc.team4804.robot.commands.ShooterCommand;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class ShooterSubsystem extends Subsystem {

	private CANTalon shooterMotor = new CANTalon(RobotMap.SHOOTINGDRIVE_ID);
	private Relay agitatorMotor = new Relay(RobotMap.AGITATOR_RELAY_ID);
	
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
    
    public void reverseShooter() {
    	shooterMotor.set(RobotMap.shooterReverseSpeed);
    }
    
    public void startAgitator() {
    	agitatorMotor.set(Relay.Value.kOn);
    	agitatorMotor.set(Relay.Value.kReverse);
    }
    
    public void stopAgitator() {
    	agitatorMotor.set(Relay.Value.kOff);
    }
}
