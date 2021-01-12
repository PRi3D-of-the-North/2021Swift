package frc.robot.tools;

import frc.robot.Constants;

public class UnitConversion {
    public static double convertSRXUnitsToRotations(double units) {
        return units / Constants.COUNTS_PER_REVOLUTION_ENCODER_SRX;
    }

    public static double convertRotationsToSRXUnits(double rotations) {
        return rotations * Constants.COUNTS_PER_REVOLUTION_ENCODER_SRX;
    }
}