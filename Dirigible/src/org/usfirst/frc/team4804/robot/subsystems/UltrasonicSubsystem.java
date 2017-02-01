package org.usfirst.frc.team4804.robot.subsystems;

import org.usfirst.frc.team4804.robot.RobotMap;
import org.usfirst.frc.team4804.robot.commands.UltrasonicCommand;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class UltrasonicSubsystem extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	private AnalogInput ultrasonic;

	public UltrasonicSubsystem(){
		ultrasonic = new AnalogInput(RobotMap.ULTRASONIC_ANALOG_ID);
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new UltrasonicCommand());
    }
    
    public double getVoltage(){
    	return ultrasonic.getVoltage();
    }
    public double getAverageVoltage(){
    	return ultrasonic.getAverageVoltage();
    }
}

