package frc.robot.commands;

import frc.robot.subsystems.DriveTrainSubsystem;

import edu.wpi.first.wpilibj2.command.InstantCommand;

public class Auto extends InstantCommand {

    double startTime;
    double currentTime;
    boolean autoFinished = false;

    private final DriveTrainSubsystem DriveTrainSubsystem;

    public Auto (DriveTrainSubsystem driveTrainSubsystem) {
        DriveTrainSubsystem = driveTrainSubsystem;

        addRequirements(driveTrainSubsystem);
    }

    @Override
    public void initialize() {
        startTime = System.currentTimeMillis();
        System.out.println("Start time: " + startTime);
    }

    @Override
    public void execute() {
        double myTime = (System.currentTimeMillis() - startTime) / 1000;
        System.out.println("myTime: " + myTime);

        // Part 1 of Auto
        // What you want to do in first 5 seconds
        while ((myTime >= 0.0) && (myTime < 5.0)) {
            System.out.println("Auto Part 1");
            DriveTrainSubsystem.AutoDrive(0.25, 0.25);
        }
        // Part 2 of Auto
        // What you want to do in first 5 seconds
        while ((myTime >= 5.0) && (myTime < 10.0)) {
            System.out.println("Auto Part 1");
            DriveTrainSubsystem.AutoDrive(0.25, -0.25);
        }
        // Part 3 of Auto
        // What you want to do in first 5 seconds
        while ((myTime >= 10.0) && (myTime < 15.0)) {
            System.out.println("Auto Part 1");
            DriveTrainSubsystem.AutoDrive(-0.25, -0.25);
        }
        // End Auto
        while (myTime >= 15.0) {
            autoFinished = true;
        }
    }

    @Override
    public void end(boolean isFinished) {}

    // @Override
    // public final boolean done() {
    //     return autoFinished;
    // }
}
