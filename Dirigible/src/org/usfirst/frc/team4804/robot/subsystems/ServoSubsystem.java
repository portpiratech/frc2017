package org.usfirst.frc.team4804.robot.subsystems;

import org.usfirst.frc.team4804.robot.RobotMap;
import org.usfirst.frc.team4804.robot.commands.ServoCommand;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Subsystem for the ball gate servo.
 */
public class ServoSubsystem extends Subsystem {

	/*private Servo ballGate = new Servo(RobotMap.BALLGATE_SERVO_ID);
	boolean gateLifted = false;
	
    // Put methods for controlling this subsystem
    // here. Call these from Commands.*/

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new ServoCommand());
    }
    
    /*public void liftGate() {
    	ballGate.setAngle(RobotMap.servoUpPos);
    }
    
    public void closeGate() {
    	ballGate.setAngle(RobotMap.servoDownPos);
    }
    
    public void toggleGate() {
    	if(gateLifted) {
    		closeGate();
    	} else {
    		liftGate();
    	}
    }*/
}

