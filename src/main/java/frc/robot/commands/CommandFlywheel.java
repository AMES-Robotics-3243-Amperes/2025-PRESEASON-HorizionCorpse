// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.Constants.FlyWheelConstants;
import frc.robot.subsystems.SubsystemFlywheel;

public class CommandFlywheel extends Command {
 private final SubsystemFlywheel subsystemFlywheel;
 private final CommandXboxController controller;

  public CommandFlywheel(SubsystemFlywheel subsystemFlywheel, CommandXboxController controller) {
    this.controller = controller;
    this.subsystemFlywheel = subsystemFlywheel;

    addRequirements(subsystemFlywheel);
  }

  @Override
  public void execute() {
    if (controller.b().getAsBoolean()) {
      subsystemFlywheel.setSpeed(1.0);   
    } else {
      subsystemFlywheel.setSpeed(0.0);  
    }
  }

  @Override
  public void end(boolean interrupted) {
    subsystemFlywheel.setSpeed(0.0);
  }

}
