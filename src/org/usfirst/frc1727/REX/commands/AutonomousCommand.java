
package org.usfirst.frc1727.REX.commands;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc1727.REX.Robot;

/**
 *
 */
public class AutonomousCommand extends Command {
	int timesrun = 0;
	
    public AutonomousCommand() {
    	requires(Robot.driveSubsystem);
    }
    
    //sorry but it would otherwise be complete aids to run the code
    protected void setmotorsPID(int left, int right) {
    	Robot.driveSubsystem.getLeftDriveDistancePID().setSetpoint(-left); // Negative = Forwards
    	Robot.driveSubsystem.getRightDriveDistancePID().setSetpoint(right);
    }
    
    protected void resetPID() {
    	Robot.driveSubsystem.getLeftDriveEncoder().reset();
    	Robot.driveSubsystem.getRightDriveEncoder().reset();
    	
    	Robot.driveSubsystem.getLeftDriveDistancePID().enable();
    	Robot.driveSubsystem.getRightDriveDistancePID().enable();
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	resetPID();
    	
    	setmotorsPID(12, 12);
    	
    	timesrun++;
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        if(timesrun >= 1) {timesrun = 0; return true;}
        else return false;
    }

    // Called once after isFinished returns trueprotected
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
    
}
