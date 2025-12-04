// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.math.util.Units;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
  
  public static class DriveConstants {

    public static final double kDriveGearRatio = 0.0;
    public static final double kDriveTurnRatio = 0.0;
    
    public static final double kWheelRadius = Units.inchesToMeters(2.0); 
    public static final double kWheelDiameter = Units.inchesToMeters(2.0)/2;

    public static final double kChassisWidth = Units.inchesToMeters(18.0);

    public static final double kDrivekP = 0.0;
    public static final double kDrivekI = 0.0;
    public static final double kDrivekD = 0.0;

    public static final double kTurnkP = 5.0;
    public static final double kTurnkI = 0.0;
    public static final double kTurnkD = 0.0;

  
    public static final double kMaxSpeedMetersPerSecond = 3.0;     
    public static final double kMaxAngularSpeedRadPerSec = Math.PI; 


  }

  public static final int kDriverControllerPort = 0;

  
}
