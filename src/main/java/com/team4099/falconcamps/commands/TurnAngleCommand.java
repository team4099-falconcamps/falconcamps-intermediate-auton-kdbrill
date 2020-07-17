package com.team4099.falconcamps.commands;

import com.team4099.falconcamps.subsystems.Drivetrain;

import edu.wpi.first.wpilibj.controller.PIDController;

public class TurnAngleCommand {
    private double angleDegrees;
    private Drivetrain drivetrain;

    private PIDController turnAngleController = new PIDController(0, 0, 0);

    public TurnAngleCommand(double angleDegrees, Drivetrain drivetrain) {
        this.angleDegrees = angleDegrees;
        this.drivetrain = drivetrain;
    }

public void execute(){
    double power = turnAngleController.calculate(drivetrain.getGyroAngle(), angleDegrees);
}
}
