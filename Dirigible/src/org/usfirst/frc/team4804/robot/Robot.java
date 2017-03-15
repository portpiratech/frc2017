
package org.usfirst.frc.team4804.robot;

import org.opencv.core.Rect;
import org.opencv.imgproc.Imgproc;
import org.usfirst.frc.team4804.robot.subsystems.BecciSubsystem;
import org.usfirst.frc.team4804.robot.subsystems.GripPipeline;
import org.usfirst.frc.team4804.robot.subsystems.GyroSubsystem;
import org.usfirst.frc.team4804.robot.subsystems.MecanumDriveTrain;
import org.usfirst.frc.team4804.robot.subsystems.PuobSubsystem;
import org.usfirst.frc.team4804.robot.subsystems.ServoSubsystem;
import org.usfirst.frc.team4804.robot.subsystems.ShooterSubsystem;
import org.usfirst.frc.team4804.robot.subsystems.UltrasonicSubsystem;
import org.usfirst.frc.team4804.robot.subsystems.VisionSubsystem;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.vision.VisionThread;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 * 
 * (Robot temporary code name was Dirigible.
 * Now it's S.C.A.R.L.E.T.T.: Shooting Climbing Amazing Robot Legitimately Engineered To Transcendence.)
 */
public class Robot extends IterativeRobot {

	//public static final DriveTrain driveTrain = new DriveTrain(RobotMap.TANKDRIVE_LEFT_ID, RobotMap.TANKDRIVE_RIGHT_ID);
	
	//public static final ShooterSubsystem shooter = new ShooterSubsystem();
	public static final ShooterSubsystem shooter = new ShooterSubsystem();
	public static final MecanumDriveTrain driveTrain = new MecanumDriveTrain();
	public static final GyroSubsystem gyro = new GyroSubsystem();
	public static final UltrasonicSubsystem ultrasonic = new UltrasonicSubsystem();
	public static final PuobSubsystem puob = new PuobSubsystem();
	public static final BecciSubsystem becci = new BecciSubsystem();
	public static final ServoSubsystem servo = new ServoSubsystem();
	public static final VisionSubsystem vision = new VisionSubsystem();
	public static OI oi;

	Command autonomousCommand;
    SendableChooser chooser;
    public static VisionThread visionThread;

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
    	
		oi = new OI();
        chooser = new SendableChooser();
        
        Robot.gyro.reset();
        
        //Robot.vision.cameraInit();
        
//        chooser.addObject("My Auto", new MyAutoCommand());
        SmartDashboard.putData("Auto mode", chooser);
        SmartDashboard.putNumber("Shooter Speed", RobotMap.shooterSpeedMultiplier);
        SmartDashboard.putNumber("DriveTrain Speed Mult", RobotMap.driveSpeedMultiplier);
        SmartDashboard.putNumber("DriveTrain Dpad Mult", RobotMap.driveSpeedDpadMultiplier);
        SmartDashboard.putNumber("DriveTrain Auto Approach Mult", RobotMap.autoApproachSpeedMultiplier);
        SmartDashboard.putNumber("Joystick Tolerance", RobotMap.joystickTolerance);
        SmartDashboard.putNumber("Distance Tolerance", RobotMap.distanceToleranceMeters);
        SmartDashboard.putNumber("Distance Setpoint", RobotMap.distanceSetpointMeters);
        SmartDashboard.putNumber("Becci Max Current", RobotMap.maxBecciCurrent);
        
        SmartDashboard.putNumber("PUOB Speed", RobotMap.puobSpeed);
        SmartDashboard.putNumber("BECCI Speed Mult", RobotMap.becciSpeedMultiplier);
    	
    }
    

	/**
     * This function is called once each time the robot enters Disabled mode.
     * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
     */
    public void disabledInit(){

    }
	
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select between different autonomous modes
	 * using the dashboard. The sendable chooser code works with the Java SmartDashboard. If you prefer the LabVIEW
	 * Dashboard, remove all of the chooser code and uncomment the getString code to get the auto name from the text box
	 * below the Gyro
	 *
	 * You can add additional auto modes by adding additional commands to the chooser code above (like the commented example)
	 * or additional comparisons to the switch structure below with additional strings & commands.
	 */
    public void autonomousInit() {
        autonomousCommand = (Command) chooser.getSelected();
        
		/* String autoSelected = SmartDashboard.getString("Auto Selector", "Default");
		switch(autoSelected) {
		case "My Auto":
			autonomousCommand = new MyAutoCommand();
			break;
		case "Default Auto":
		default:
			autonomousCommand = new ExampleCommand();
			break;
		} */
    	
    	// schedule the autonomous command (example)
        if (autonomousCommand != null) autonomousCommand.start();
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    public void teleopInit() {
		// This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to 
        // continue until interrupted by another command, remove
        // this line or comment it out.
        if (autonomousCommand != null) autonomousCommand.cancel();
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
    }
}
