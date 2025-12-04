package frc.robot;

import frc.robot.Constants.DriveConstants;

import frc.robot.commands.CommandThriftyDriveTeleop;
import frc.robot.subsystems.SubsystemThriftySwerveDrivetrain;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;

public class RobotContainer {

  private final SubsystemThriftySwerveDrivetrain m_subsystemSwerveDrivetrain =
      new SubsystemThriftySwerveDrivetrain();

  private final XboxController m_driverController = new XboxController(0);

  public RobotContainer() {
    configureBindings();

    m_subsystemSwerveDrivetrain.setDefaultCommand(
        new CommandThriftyDriveTeleop(
            m_subsystemSwerveDrivetrain,
            m_driverController
        )
    );
  }

  private void configureBindings() {
     new Trigger(() -> m_driverController.getYButtonPressed())
        .onTrue(new InstantCommand(() -> 
            m_subsystemSwerveDrivetrain.setFieldRelative(
                !m_subsystemSwerveDrivetrain.getFieldRelative()
            )
        ));
  }
}