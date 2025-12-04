// SwerveDriveTeleopCommand.java
package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.Constants.DriveConstants;
import frc.robot.subsystems.SubsystemThriftySwerveDrivetrain;
import frc.robot.subsystems.ThriftyModule;

public class CommandThriftyDriveTeleop extends Command {

  private final SubsystemThriftySwerveDrivetrain swerveDrivetrain;
  private XboxController m_driverController = new XboxController(0);
  
    public CommandThriftyDriveTeleop(SubsystemThriftySwerveDrivetrain swerveDrivetrain,XboxController controller) {
      this.swerveDrivetrain = swerveDrivetrain;
      this.m_driverController = controller;

    addRequirements(swerveDrivetrain);
  }

   

  @Override
  public void execute() {
    double xInput = -m_driverController.getLeftY();  
    double yInput = -m_driverController.getLeftX();  
    double rotInput = -m_driverController.getRightX(); 

    double vx = xInput * DriveConstants.kMaxSpeedMetersPerSecond;
    double vy = yInput * DriveConstants.kMaxSpeedMetersPerSecond;    
    double omega = rotInput * DriveConstants.kMaxAngularSpeedRadPerSec;

    swerveDrivetrain.drive(vx, vy, omega, swerveDrivetrain.getFieldRelative());

  }

  @Override
  public void end(boolean interrupted) {
    swerveDrivetrain.drive(0.0, 0.0, 0.0, false);
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
