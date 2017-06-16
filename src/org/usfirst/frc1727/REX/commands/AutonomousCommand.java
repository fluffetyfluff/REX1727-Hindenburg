
package org.usfirst.frc1727.REX.commands;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc1727.REX.Robot;

/**
 *
 */
public class AutonomousCommand extends Command {
	
    public AutonomousCommand() {
    	requires(Robot.driveSubsystem);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.driveSubsystem.getLeftDriveEncoder().reset();
    	Robot.driveSubsystem.getRightDriveEncoder().reset();
    	
    	Robot.driveSubsystem.getLeftDriveDistancePID().enable();
    	Robot.driveSubsystem.getRightDriveDistancePID().enable();
    	
    	Robot.driveSubsystem.getLeftDriveDistancePID().setSetpoint(-12); // Negative = Forwards
    	Robot.driveSubsystem.getRightDriveDistancePID().setSetpoint(12);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns trueprotected
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}