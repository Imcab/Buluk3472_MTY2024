//////////////SUBSISTEMA DE LA VISIÓN LIMELIGHT////////////////////////

//////////AQUI SE DA LA LECTURA Y LOS DATOS//////////////////////////////


package frc.robot.Subsystems;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class limelight extends SubsystemBase{

    NetworkTable table;

    NetworkTableEntry tx;
    NetworkTableEntry ty;
    NetworkTableEntry ta;
    NetworkTableEntry tv;
    
    public limelight(){

        table = NetworkTableInstance.getDefault().getTable("limelight");

        tx = table.getEntry("tx");
        ty = table.getEntry("ty");
        ta = table.getEntry("ta");
        tv = table.getEntry("tv");

    }

    public double getX(){
        double x = tx.getDouble(0.0);
        return x;
    }
    public  double getY(){
        double y = ty.getDouble(0.0);
        return y;
    }

    public double getArea(){
        double area = ta.getDouble(0.0);
        return area;
    }

    public double getV(){
        double v = tv.getDouble(0.0);
        return v;
    }

    public boolean targetfound(){
        if(getV() == 0.0f){  
            return false;
        }else{
            return true;
        }
    }
    @Override
    public void periodic(){

        SmartDashboard.putNumber("LimelightX", getX());
        SmartDashboard.putNumber("LimelightY",getY());
        SmartDashboard.putNumber("LimelightArea", getArea());
        SmartDashboard.putBoolean("Target", targetfound()); //:v
    }
    
}