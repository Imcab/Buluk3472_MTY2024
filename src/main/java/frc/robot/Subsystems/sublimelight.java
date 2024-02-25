package frc.robot.Subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class sublimelight extends SubsystemBase {

    private static NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight");
    //x location of the target
    private static NetworkTableEntry tx = table.getEntry("tx");
    //y location of the target
    private static NetworkTableEntry ty = table.getEntry("ty");
    //area of the target, se usara?
    //private static NetworkTableEntry ta = table.getEntry("ta");
    //does the limelight have a target
    private static NetworkTableEntry tv = table.getEntry("tv");

    public static double getX(){
        return tx.getDouble(0.0);
    }

    public double getY(){ //Static??
        return ty.getDouble(0.0);
    }
    //??????? que constantes?
    public static double getDistance(){
        double heightOfCamera = 43;
        double heightOfTarget = 29;
        double angleOfCamera = -20;
        double angleofTarget =  ty.getDouble(0.0);
        return (heightOfTarget - heightOfCamera) / Math.tan(Math.toRadians(angleOfCamera + angleofTarget));
    }

    public static double height(){
        //Falta aqui, veremos si es necesario
        return 0;
    }

    public boolean isTargetAvalible(){
        return tv.getBoolean(false);
    }

    @Override
    public void periodic() {
    SmartDashboard.putNumber("limelight y", getY());
	SmartDashboard.putNumber("limelight x", getX());
	SmartDashboard.putNumber("limelight distance", getDistance());
	SmartDashboard.putBoolean("limelight has target", isTargetAvalible());

    }
    
}