
package org.usfirst.frc1727.REX;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import org.usfirst.frc1727.REX.commands.*;
import org.usfirst.frc1727.REX.subsystems.*;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

    Command autonomousCommand;

    public static OI oi;
    
    public static DriveSubsystem driveSubsystem;
    public static LiftSubsystem liftSubsystem;
    public static GearSubsystem gearSubsystem;

    public static Command driveCommand;
    public static Command liftCommand;
    public static Command gearCommand;
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
    	RobotMap.init();
        driveSubsystem = new DriveSubsystem();
        liftSubsystem = new LiftSubsystem();
        gearSubsystem = new GearSubsystem();
        
        driveCommand = new DriveCommand();
        liftCommand = new LiftCommand();
        gearCommand = new GearCommand();

        // OI must be constructed after subsystems. If the OI creates Commands
        //(which it very likely will), subsystems are not guaranteed to be
        // constructed yet. Thus, their requires() statements may grab null
        // pointers. Bad news. Don't move it.
        oi = new OI();

        // instantiate the command used for the autonomous period

        autonomousCommand = new AutonomousCommand();
    }

    /**
     * This function is called when the disabled button is hit.
     * You can use it to reset subsystems before shutting down.
     */
    public void disabledInit(){

    }

    public void disabledPeriodic() {
        Scheduler.getInstance().run();
    }

    public void autonomousInit() {
        // schedule the autonomous command (example)
        if (driveCommand.isRunning())
        	driveCommand.cancel();
        
        if (liftCommand.isRunning())
        	liftCommand.cancel();
        
        if (gearCommand.isRunning())
        	gearCommand.cancel();
        
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
        if (!driveCommand.isRunning())
        	driveCommand.start();
        
        if (!liftCommand.isRunning())
        	liftCommand.start();
        
        if (!gearCommand.isRunning())
        	gearCommand.start();
    }

    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
    }
}
