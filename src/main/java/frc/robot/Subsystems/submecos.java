package frc.robot.Subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkLowLevel.MotorType;
import frc.robot.constants.driveconst;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;



public class submecos extends SubsystemBase{

    CANSparkMax FrentIzq, FrentDer, AtrasIzq, AtrasDer;

    private int frenteIzquid = driveconst.fi_id;
    private int FrenteDerid = driveconst.fd_id;
    private int AtrasIzqid = driveconst.ai_id;
    private int AtrasDerid = driveconst.ad_id;

    private RelativeEncoder EncoderFrenteIzq;
    private RelativeEncoder EncoderFrenteDer;
    private RelativeEncoder EncoderAtrasIzq;
    private RelativeEncoder EncoderAtrasDer;

    private static NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight");
    //x location of the target
    private static NetworkTableEntry tx = table.getEntry("tx");
    //y location of the target
    private static NetworkTableEntry ty = table.getEntry("ty");
    //area of the target, se usara?
    //private static NetworkTableEntry ta = table.getEntry("ta");
    //does the limelight have a target
    private static NetworkTableEntry tv = table.getEntry("tv");
    
    

    public submecos(){

        FrentIzq = new CANSparkMax(frenteIzquid, MotorType.kBrushless);
        FrentDer = new CANSparkMax(FrenteDerid, MotorType.kBrushless);
        AtrasIzq = new CANSparkMax(AtrasIzqid, MotorType.kBrushless);
        AtrasDer = new CANSparkMax(AtrasDerid, MotorType.kBrushless);

        EncoderFrenteIzq = FrentIzq.getEncoder();
        EncoderFrenteDer = FrentDer.getEncoder();
        EncoderAtrasIzq = AtrasIzq.getEncoder();
        EncoderAtrasDer = AtrasDer.getEncoder();

    }
    public static double getX(){
        return tx.getDouble(0.0);
    }

    public double getY(){ //Static??
        return ty.getDouble(0.0);
    }

    public boolean isTargetAvalible(){
        return tv.getBoolean(false);
    }


    public void driveMecos(double theta, double power, double turn){

            double sin = Math.sin(theta - Math.PI/4);
            double cos = Math.cos(theta - Math.PI/4);
            double max = Math.max(Math.abs(sin), Math.abs(cos));

            double fIv = power * cos / max + turn;
            double fDv = power * sin / max - turn;
            double aIv = power * sin / max + turn;
            double aDv = power * cos / max - turn;
            

            if ((power + Math.abs(turn)) > 1) {
                fIv /= power + Math.abs(turn);
                fDv /= power + Math.abs(turn);
                aIv /= power + Math.abs(turn);
                aDv /= power + Math.abs(turn);
                
            }

            FrentIzq.set(-fIv);
            FrentDer.set(fDv);
            AtrasIzq.set(-aIv);
            AtrasDer.set(aDv);

    }

    public void auto (double speedder, double speedizq){
        FrentIzq.set(-speedizq);
        FrentDer.set(speedder);
        AtrasIzq.set(-speedizq);
        AtrasDer.set(speedder);     
    }

    @Override
    public void periodic(){

        SmartDashboard.putNumber("Encoder Frente Izquierda", (EncoderFrenteIzq.getPosition()/9.16)*0.1524);
        SmartDashboard.putNumber("Encoder Frente Derecha", (EncoderFrenteDer.getPosition()/9.16)*0.1524);
        SmartDashboard.putNumber("Encoder Atras Izquierda", (EncoderAtrasIzq.getPosition()/9.16)*0.1524);
        SmartDashboard.putNumber("Encoder Atras Derecha", (EncoderAtrasDer.getPosition()/9.16)*0.1524);

        SmartDashboard.putNumber("limelight y", getY());
        SmartDashboard.putNumber("limelight x", getX());

        SmartDashboard.putBoolean("limelight has target", isTargetAvalible());
        
    }

    
}
