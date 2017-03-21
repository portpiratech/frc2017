package org.usfirst.frc.team4804.robot.subsystems;

//import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.Point;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.imgproc.Imgproc;
import org.usfirst.frc.team4804.robot.Robot;
//import org.opencv.imgproc.Imgproc;
import org.usfirst.frc.team4804.robot.commands.VisionDisplay;

import edu.wpi.cscore.CvSink;
import edu.wpi.cscore.CvSource;
import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.vision.VisionThread;

/**
 * The DriveTrain subsystem incorporates the sensors and actuators attached to
 * the robots chassis. These include four drive motors, a left and right encoder
 * and a gyro.
 */
public class VisionSubsystem extends Subsystem {
	
	public double cameraHeightMeters = 0.2; //relative to floor
	
	GripPipeline grip = new GripPipeline();
	
	private static final int IMG_WIDTH = 320;
	private static final int IMG_HEIGHT = 240;
	private double centerX = 0.0;
	private final Object imgLock = new Object();
	
	public static boolean visionProcessing;
	//long lastFrameProcessTimeMs;
	//long captureIntervalMs;
	
	public VisionSubsystem() {
		visionProcessing = false;
//		lastFrameProcessTimeMs = 0;
//		captureIntervalMs = 200;
	}
	
	public void initDefaultCommand() {
		setDefaultCommand(new VisionDisplay());
	}

	/**
	 * The log method puts interesting information to the SmartDashboard.
	 */ 
	public void log() {
	}
	
	UsbCamera camera;
	CvSink cvSink;
	CvSource outputStream;
	Mat mat;
	
	public void cameraInit() {
		camera = CameraServer.getInstance().startAutomaticCapture();
		camera.setResolution(320, 240);
		
		cvSink = CameraServer.getInstance().getVideo();
		outputStream = CameraServer.getInstance().putVideo("Blur", 320, 240);
	
		mat = new Mat();
		
		Robot.visionThread = new VisionThread(camera, new GripPipeline(), gripPipeline -> {
			//mat.release();
			cvSink.grabFrame(mat);
			if (!pipeline.filterContoursOutput().isEmpty()) {
                Rect r = Imgproc.boundingRect(pipeline.filterContoursOutput().get(0));
                synchronized (imgLock) {
                    centerX = r.x + (r.width / 2);
                    
                    Point pt1 = r.tl(); //top left corner
                    Point pt2 = r.br(); //bottom right corner
                    Scalar color = new Scalar(255.0, 0.0, 0.0, 0.0);
                    Imgproc.rectangle(mat, pt1, pt2, color);
                    
                    Imgproc.rectangle(mat, new Point(100,100), new Point(200,200), color);
                    
                    SmartDashboard.putNumber("camera centerX", centerX);
                    outputStream.putFrame(mat);
                }
            }
        });
		Robot.visionThread.setDaemon(true);
	}
	
	public void frameAutoDisplay() {
		/*
		cvSink = CameraServer.getInstance().getVideo();
		outputStream = CameraServer.getInstance().putVideo("Blur", 640, 480);
	
		source = new Mat();
		output = new Mat();
		
		cvSink.grabFrame(source);
		Core.flip(source, source, -1);
		Imgproc.cvtColor(source, output, Imgproc.COLOR_BGR2GRAY);
		outputStream.putFrame(output);
		
		source.release();
		output.release();
		outputStream.free();
		//cvSink.free(); <-- Crashes the robot b/c this removes the camera from the video sink
		
		 */
	}
	
	public void frameProcess() {
		//grip.process(source);
		/* throws an exception... fix this later
		 * [org.opencv.imgproc.Imgproc.findContours_1(Native Method),
		 * org.opencv.imgproc.Imgproc.findContours(Unknown Source),
		 * org.usfirst.frc.team4804.robot.subsystems.GripPipeline.findContours(GripPipeline.java:290),
		 * org.usfirst.frc.team4804.robot.subsystems.GripPipeline.process(GripPipeline.java:66),
		 * org.usfirst.frc.team4804.robot.subsystems.VisionSubsystem.frameProcess(VisionSubsystem.java:89)]
		 */
	}
	
	public void enableProcessing() {
		visionProcessing = true;
	}
	
	public void disableProcessing() {
		visionProcessing = false;
	}
}
