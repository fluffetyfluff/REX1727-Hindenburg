
package org.usfirst.frc1727.REX;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.TalonSRX;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	// Drive controllers
	public static SpeedController driveSubsystemleftDrive;
    public static SpeedController driveSubsystemrightDrive;
    public static RobotDrive driveSubsystemRobotDrive;
    
    // Lift controllers
    public static SpeedController liftSubsystemliftMotor; 
    public static DoubleSolenoid liftSubsystembrake;
    
    // Gear controllers
    public static CANTalon gearSubsystemintakeMotor;
    public static DoubleSolenoid gearSubsystemraiser;

    // Sensors
    public static Encoder driveSubsystemleftEncoder;
    public static Encoder driveSubsystemrightEncoder;
    
    // Control Structs
    public static PIDController driveDistanceLeftPID;
    public static PIDController driveDistanceRightPID;
    
    public static void init() {
    	// Constants
    	final double driveLeftKp = 0.05;
    	final double driveLeftKi = 0.00;
    	final double driveLeftKd = 0.00;
    	
       	final double driveRightKp = 0.05;
    	final double driveRightKi = 0.00;
    	final double driveRightKd = 0.00;
    	
        // Drive
    	driveSubsystemleftDrive = new Spark(0);
        
        driveSubsystemrightDrive = new Spark(1);
        
        driveSubsystemRobotDrive = new RobotDrive(driveSubsystemleftDrive, driveSubsystemrightDrive);
        
        driveSubsystemRobotDrive.setSafetyEnabled(true);
        driveSubsystemRobotDrive.setExpiration(0.1);
        driveSubsystemRobotDrive.setMaxOutput(1.0);
        
        // Lift
        liftSubsystemliftMotor = new VictorSP(3);
        
        liftSubsystembrake = new DoubleSolenoid(2, 3);
        
        // Gears
        gearSubsystemintakeMotor = new CANTalon(1);
        
        gearSubsystemraiser = new DoubleSolenoid(1, 0);
        
        // Sensors
        driveSubsystemleftEncoder = new Encoder(2, 3, false);
        driveSubsystemrightEncoder = new Encoder(0, 1, false);
        
        driveSubsystemleftEncoder.setDistancePerPulse(12.75 * 6 * Math.PI / 360);
        driveSubsystemrightEncoder.setDistancePerPulse(12.75 * 6 * Math.PI / 360);
        
        // Control Stucts
        driveDistanceLeftPID = new PIDController(driveLeftKp, driveLeftKi, driveLeftKd, driveSubsystemleftEncoder, driveSubsystemleftDrive);
        driveDistanceLeftPID.setOutputRange(-1.0, 1.0);
        driveDistanceLeftPID.setAbsoluteTolerance(40);
        driveDistanceLeftPID.disable();
        
        driveDistanceRightPID = new PIDController(driveRightKp, driveRightKi, driveRightKd, driveSubsystemrightEncoder, driveSubsystemrightDrive);
        driveDistanceRightPID.setOutputRange(-1.0, 1.0);
        driveDistanceRightPID.setAbsoluteTolerance(40);
        driveDistanceRightPID.disable();
        
        // LiveWindow
        LiveWindow.addActuator("DriveSubsystem", "rightDrive", (Spark) driveSubsystemrightDrive);
        LiveWindow.addActuator("DriveSubsystem", "leftDrive", (Spark) driveSubsystemleftDrive);
        
        LiveWindow.addActuator("LiftSubsystem", "liftMotor", (VictorSP) liftSubsystemliftMotor);
        
        LiveWindow.addSensor("DrivePIDSubsystem", "leftDriveEncoder", driveSubsystemleftEncoder);
        LiveWindow.addSensor("DrivePIDSubsystem", "rightDriveEncoder", driveSubsystemrightEncoder);
    }
}
