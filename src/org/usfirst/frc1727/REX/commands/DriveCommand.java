
package org.usfirst.frc1727.REX.commands;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc1727.REX.Robot;

/**
 *
 */
public class DriveCommand extends Command {

    public DriveCommand() {
        requires(Robot.driveSubsystem);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.driveSubsystem.getLeftDriveDistancePID().disable();
    	Robot.driveSubsystem.getRightDriveDistancePID().disable();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
	    if (Robot.oi.getDriver().getRawAxis(2) > 0.25 || Robot.oi.getDriver().getRawAxis(3) > 0.25)
	    	// 0.77459666924 = sqrt(6)
	    	Robot.driveSubsystem.getRobotDrive().tankDrive(Robot.oi.getDriver().getRawAxis(5) * 0.77459666924, Robot.oi.getDriver().getRawAxis(1) * 0.77459666924, true);
    	else
	    	Robot.driveSubsystem.getRobotDrive().tankDrive(Robot.oi.getDriver().getRawAxis(5), Robot.oi.getDriver().getRawAxis(1), true);
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
}
