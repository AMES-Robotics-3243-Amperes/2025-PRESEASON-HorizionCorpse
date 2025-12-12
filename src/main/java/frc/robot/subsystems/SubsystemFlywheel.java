// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.spark.SparkBase;
import com.revrobotics.spark.SparkClosedLoopController;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.config.SparkBaseConfig;
import com.revrobotics.spark.config.SparkMaxConfig;
import com.revrobotics.spark.config.ClosedLoopConfig.FeedbackSensor;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class SubsystemFlywheel extends SubsystemBase {

  private final SparkMax m_flywheelMotor; 

  public SubsystemFlywheel() {
    m_flywheelMotor = new SparkMax(Constants.FlyWheelConstants.kFlyWheelId, MotorType.kBrushless);
    
  }

  public void setSpeed(double speed){
    m_flywheelMotor.set(speed);
  }

  @Override
  public void periodic() {  
  }
}
