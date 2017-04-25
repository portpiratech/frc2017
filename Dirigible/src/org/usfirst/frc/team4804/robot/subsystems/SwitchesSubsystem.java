package org.usfirst.frc.team4804.robot.subsystems;

import org.usfirst.frc.team4804.robot.RobotMap;
import org.usfirst.frc.team4804.robot.commands.SwitchReader;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class SwitchesSubsystem extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	DigitalInput switch1;
	DigitalInput switch2;
	DigitalInput switch3;
	
	public SwitchesSubsystem() {
		switch1 = new DigitalInput(RobotMap.SWITCH_1);
		switch2 = new DigitalInput(RobotMap.SWITCH_2);
		switch3 = new DigitalInput(RobotMap.SWITCH_3);
	}
	
    public void initDefaultCommand() {
    	setDefaultCommand(new SwitchReader());
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public boolean get(int id) {
    	boolean value = false;
    	
    	switch(id) {
    	case 1: value = !switch1.get();
    	case 2: value = !switch2.get();
    	case 3: value = !switch3.get();
    	//default: value = false;
    	}
    	
    	return value;
    }
    
    public void displaySwitches() {
    	SmartDashboard.putBoolean("Switch 1", get(1));
    	SmartDashboard.putBoolean("Switch 2", get(2));
    	SmartDashboard.putBoolean("Switch 3", get(3));
    }
}

