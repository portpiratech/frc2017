package org.usfirst.frc.team4804.robot.commands;

import java.text.DecimalFormat;

import org.usfirst.frc.team4804.robot.Robot;
import org.usfirst.frc.team4804.robot.subsystems.UltrasonicSubsystem;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class UltrasoundCommand extends Command {

	private UltrasonicSubsystem ultrasonic = Robot.ultrasonic;
	
    public UltrasoundCommand() {
        // Use requires() here to declare subsystem dependencies
        requires(ultrasonic);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	double voltage = ultrasonic.getVoltage();
    	SmartDashboard.putNumber("Ultrasound Voltage", voltage);
    	SmartDashboard.putNumber("Average voltage", ultrasonic.getAverageVoltage());
    	SmartDashboard.putNumber("Ultrasound Distance", getDistance());
    	
    	double distance = getDistance();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
    
    private double getDistance(){ //returns distance in meters rounded to 100th place
    	double voltage = ultrasonic.getAverageVoltage();
    	DecimalFormat d = new DecimalFormat("##.00");
    	return Double.valueOf(d.format(1024 * voltage / 1000));
    	//5 mm per (Vcc/1024)
    }
}
