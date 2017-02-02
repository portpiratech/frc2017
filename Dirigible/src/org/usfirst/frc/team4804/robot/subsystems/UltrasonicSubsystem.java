package org.usfirst.frc.team4804.robot.subsystems;

import java.text.DecimalFormat;

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
    
    public double getDistance(){ //returns distance in meters rounded to 100th place
    	double voltage = ultrasonic.getAverageVoltage();
    	DecimalFormat d = new DecimalFormat("##.00");
    	return Double.valueOf(d.format(1024 * voltage / 1000));
    	//5 mm per (Vcc/1024)
    }
}

