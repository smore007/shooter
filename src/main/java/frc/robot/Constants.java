/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.util.Units;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants.  This class should not be used for any other purpose.  All constants should be
 * declared globally (i.e. public static).  Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {

    public static final int kTimeout = 100;

    public static final int kEncoderResolution = 4096; // same encoders are used everywhere, so this is ok

    public static final class DriveConstants {

        public static final int kTalonPortFrontLeft = 1;
        public static final int kTalonPortFrontRight = 2;
        public static final int kTalonPortBackLeft = 3;
        public static final int kTalonPortBackRight = 4;

        public static final double kWheelRadius = Units.feetToMeters(4.0/12.0);
        public static final double kWheelCircumference = 2.0 * Math.PI * kWheelRadius;

        /**
         * Convert from meters per second to native units per 100ms
         * @param mps
         * @return
         */
        public static int getVelocityNative(double mps) {
            return (int)((mps / kWheelCircumference) * kEncoderResolution
                / 10.0);
        }

        /**
         * Convert from native units per 100ms to meters per second
         * @param velocityNative
         * @return
         */
        public static double getVelocityMPS(int velocityNative) {
            return ((double)velocityNative / (double)kEncoderResolution)
                * kWheelCircumference * 10.0;
        }

        // TODO: use slots and name properly. refer to https://github.com/CrossTheRoadElec/Phoenix-Examples-Languages/blob/master/Java/VelocityClosedLoop_AuxStraightQuadrature/src/main/java/frc/robot/Constants.java
        public static final int kDistancePIDLoopIdx = 0;

        public static final Gains kDistanceGains = new Gains(0.0, 0.0, 0.0, 0.0);

        public static final int kTurnPIDLoopIdx = 1;

        public static final Gains kTurnGains = new Gains(0.0, 0.0, 0.0, 0.0);
    }

    public static final class ShooterConstants {

        public static final int kTalonPortLeft = 5;
        public static final int kTalonPortRight = 6;

        /**
         * Convert from native units per 100ms to rotations per minute
         * @param rpm
         * @return
         */
        public static int getVelocityNative(double rpm) {
            return (int)(rpm * (double)Constants.kEncoderResolution
                / 60.0 / 10.0);
        }

        /**
         * Convert from rotations per minute to native units per 100ms
         * @param nativeVelocity
         * @return
         */
        public static double getRPM(int velocityNative) {
            return (double)((double)velocityNative / (double)Constants.kEncoderResolution
                * 10.0 * 60.0);
        }

        public static final int kPIDLoopIdx = 0;

        public static final Gains kGains = new Gains(0.025, 0.02, 0.0, 0.0);

        public static final double kMinFireVelocityRPM = 2500;

        public static final int kMinFireVelocity = getNativeVelocity(kMinFireVelocityRPM);
        public static final double kAcceptablePercentError = 0.02;
    }
}
