package org.usfirst.frc.team4804.robot.subsystems;

import org.usfirst.frc.team4804.robot.RobotMap;
import org.usfirst.frc.team4804.robot.commands.PuobCommand;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * P.U.O.B. = Picker Upper Of Balls
 */
public class PuobSubsystem extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	private CANTalon puobMotor = new CANTalon(RobotMap.PUOB_ID);

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new PuobCommand());
    }
    
    public void startPuob(double power){
    	puobMotor.set(power);
    }
    
    public void startPuob() {
    	puobMotor.set(RobotMap.puobSpeed);
    }
    
    public void stopPuob() {
    	puobMotor.set(0);
    }
}

