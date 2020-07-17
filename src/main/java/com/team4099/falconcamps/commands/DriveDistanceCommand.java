package com.team4099.falconcamps.commands;

import com.team4099.falconcamps.subsystems.Drivetrain;

import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class DriveDistanceCommand extends CommandBase {
    private double distanceMeters;
    private Drivetrain drivetrain;

    private PIDController controllerLeft = new PIDController(0, 0, 0);

    private PIDController controllerRight = new PIDController(0, 0, 0);

    @Override
    public void execute() {
        double calculatePowerLeft = controllerLeft.calculate (drivetrain.measurementInMetersLeft(),distanceMeters);
        double calculatePowerRight = controllerRight.calculate (drivetrain.measurementInMetersRight(),distanceMeters);
        drivetrain.setLRPower(calculatePowerLeft, calculatePowerRight);
    }

    public DriveDistanceCommand(double distanceMeters, Drivetrain drivetrain) {
        this.distanceMeters = distanceMeters;
        this.drivetrain = drivetrain;
    }
}
