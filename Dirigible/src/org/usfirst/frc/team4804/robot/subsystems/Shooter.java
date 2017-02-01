package org.usfirst.frc.team4804.robot.subsystems;

import java.text.DecimalFormat;

import org.usfirst.frc.team4804.robot.RobotMap;
import org.usfirst.frc.team4804.robot.commands.ShooterCommand;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Shooter extends Subsystem {
	
	
	 AnalogInput ultra = new AnalogInput(RobotMap.ULTRA_ANALOG_ID);
	 
	
	private CANTalon shooterMotor = new CANTalon(RobotMap.SHOOTINGDRIVE_ID);
	
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new ShooterCommand());
    }
    
    public void shoot(double speed) {
    	shooterMotor.set(speed);
    }
    
    public void stop() {
    	shooterMotor.set(0);
    }

   
    
    public double getDistance(){
    	double voltage = ultra.getAverageVoltage();
    	DecimalFormat d = new DecimalFormat("##.00");
    	return Double.valueOf(d.format(voltage));
    	
    	
    	
    }
}
