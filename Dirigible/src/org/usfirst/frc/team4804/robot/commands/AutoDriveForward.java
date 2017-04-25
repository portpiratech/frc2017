package org.usfirst.frc.team4804.robot.commands;

import org.usfirst.frc.team4804.robot.Robot;
import org.usfirst.frc.team4804.robot.RobotMap;
import org.usfirst.frc.team4804.robot.subsystems.GyroSubsystem;
import org.usfirst.frc.team4804.robot.subsystems.MecanumDriveTrain;
import org.usfirst.frc.team4804.robot.subsystems.ServoSubsystem;
import org.usfirst.frc.team4804.robot.subsystems.ShooterSubsystem;
import org.usfirst.frc.team4804.robot.subsystems.SwitchesSubsystem;
import org.usfirst.frc.team4804.robot.subsystems.UltrasonicSubsystem;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class AutoDriveForward extends Command {

	private MecanumDriveTrain driveTrain = Robot.driveTrain;
	private GyroSubsystem gyro = Robot.gyro;
	private UltrasonicSubsystem ultrasonic = Robot.ultrasonic;
	private SwitchesSubsystem switches = Robot.switches;
	private ShooterSubsystem shooter = Robot.shooter;
	private ServoSubsystem servo = Robot.servo;
	
	double offsetDegrees;
	double timeSeconds;
	double distanceMeters;
	double startTime;
	
	enum StartPos {
		kBLUE, kRED;
	}
	
	/**
	 * @param timeSeconds		Time to drive forward at constant speed
	 * @param distanceMeters	Distance set-point from wall (set negative to ignore)
	 */
    public AutoDriveForward(double timeSeconds, double distanceMeters) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(driveTrain);
    	requires(gyro);
    	requires(ultrasonic);
    	requires(switches);
    	requires(shooter);
    	requires(servo);
    	
    	this.timeSeconds = timeSeconds;
    	this.distanceMeters = distanceMeters;
    	
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	gyro.reset();
    	
    	RobotMap.autoSpeed = SmartDashboard.getNumber("auto speed", RobotMap.autoSpeed);
    	
    	switches.displaySwitches();
    	
    	//BOILER SHOOTING + TURNING
    	/*startTime = System.currentTimeMillis();
    	while((System.currentTimeMillis() - startTime)/1000.0 < 1.5) {
    		//spin up shooter for X seconds
    		shooter.startShooter(RobotMap.shooterSpeedAuto);
    	}
    	
    	startTime = System.currentTimeMillis();
    	while((System.currentTimeMillis() - startTime)/1000.0 < 4.5) {
    		//let shooter run for X seconds
    		shooter.startShooter(RobotMap.shooterSpeedAuto);
    		shooter.startAgitator();
    		servo.dropGate();
    	}
    	
    	shooter.stopAgitator();
    	shooter.stopShooter();
    	
    	startTime = System.currentTimeMillis();
    	while((System.currentTimeMillis() - startTime)/1000.0 < 1.1) {
    		//turn for X seconds. RED = POSITIVE, BLUE = NEGATIVE
    		StartPos pos = StartPos.kRED;
    		
    		if(pos==StartPos.kBLUE) driveTrain.mecanumDriveCartesian(0, 0, -1*RobotMap.autoSpeed, 0);
    		if(pos==StartPos.kRED) driveTrain.mecanumDriveCartesian(0, 0, RobotMap.autoSpeed, 0);
    	}
    	
    	servo.liftGate();*/
    	
    	startTime = System.currentTimeMillis();
    	while ((System.currentTimeMillis() - startTime)/1000.0 < 5.0) {
    		//delay for X seconds.
    		driveTrain.mecanumDriveCartesian(0.0,-RobotMap.autoSpeed,0.0,0.0); //move straight (+ = REVERSE, - = FORWARD)
    	}
    	
    	
    	//MIDDLE GEAR???
    	/*
    	startTime = System.currentTimeMillis();
    	while ((System.currentTimeMillis() - startTime)/1000.0 < 10.0) {
    		//delay for X seconds, drive forward
    		driveTrain.mecanumDriveCartesian(0, 0.4, 0, 0);
    	}
    	
    	startTime = System.currentTimeMillis();
    	while ((System.currentTimeMillis() - startTime)/1000.0 < 2.0) {
    		//delay for X seconds, rotate
    		driveTrain.mecanumDriveCartesian(0, 0, 0.4, 0);
    	}
    	*/
    	
    	
    	//delay(5.0); //Timer.delay(5);
    	
    	/*if(switches.get(1)) {
    		offsetDegrees = 0;
    		
	    	driveTrain.mecanumDriveCartesian(0.0, RobotMap.driveSpeedDpadMultiplier, 0.0, gyro.getAngle() + offsetDegrees);
	    	Timer.delay(timeSeconds);
	    	
	    	driveTrain.stop();
	    	
	    	//driveForwardToDistance(distanceMeters);
    	}
    	
    	if(switches.get(2)) {
    		offsetDegrees = 90;
    		
    		driveTrain.mecanumDriveCartesian(-RobotMap.driveSpeedDpadMultiplier, 0.0, 0.0, gyro.getAngle() + offsetDegrees);
    		Timer.delay(timeSeconds);
    		
    		driveTrain.stop();
    	}*/
    	
    	driveTrain.stop();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
    
    void driveForwardToDistance(double distanceMeters) {
    	//Drive to distance, within a certain tolerance
    	while(ultrasonic.getDistance() - distanceMeters > RobotMap.distanceToleranceMeters) {
    		double speed = - RobotMap.driveSpeedMultiplier * (ultrasonic.getDistance() - distanceMeters) * RobotMap.autoApproachSpeedMultiplier;
    		// Speed is negated because the ultrasonic is mounted opposite to the front of the robot.
    		
    		driveTrain.mecanumDrivePolar(speed, offsetDegrees, 0);
    	}
    	
    	driveTrain.stop();
    }
    
    void delay(double seconds) {
    	double start = System.currentTimeMillis();
    	
    	while((System.currentTimeMillis() - start)/1000 < seconds) {
    		//wait
    	}
    }
}
