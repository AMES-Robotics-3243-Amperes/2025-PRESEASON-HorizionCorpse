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

    public static final double kMaxObtainableModuleSpeed = 100;

      // The MAXSwerve module can be configured with one of three pinion gears: 12T,
      // 13T, or 14T. This changes the drive speed of the module (a pinion gear with
      // more teeth will result in a robot that drives faster).
      public static final int kDrivingMotorPinionTeeth = 14;

      // Calculations required for driving motor conversion factors and feed forward
      public static final double kDrivingMotorFreeSpeedRps = 5676.0 / 60.0;
      public static final double kWheelDiameterMeters = 0.0762;
      public static final double kWheelCircumferenceMeters = kWheelDiameterMeters * Math.PI;
      // 45 teeth on the wheel's bevel gear, 22 teeth on the first-stage spur gear, 15
      // teeth on the bevel pinion
      public static final double kDrivingMotorReduction = (45.0 * 22) / (kDrivingMotorPinionTeeth * 15);
      public static final double kDriveWheelFreeSpeedRps = (kDrivingMotorFreeSpeedRps * kWheelCircumferenceMeters)
          / kDrivingMotorReduction;
    
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
