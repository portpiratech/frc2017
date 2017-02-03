package org.usfirst.frc.team4804.robot.subsystems;

import org.usfirst.frc.team4804.robot.RobotMap;
import org.usfirst.frc.team4804.robot.commands.BecciCommand;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Climber Subsystem (B.E.C.C.I. = Ben's Extraordinary Climbing Contraption Ingenious)
 */
public class BecciSubsystem extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	CANTalon becciMotor = new CANTalon(RobotMap.CLIMB_MOTOR_1_ID);

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new BecciCommand());
    }
    
    public void climb(double power) {
    	becciMotor.set(power);
    }
    
    public void stopClimb() {
    	becciMotor.set(0);
    }
}

