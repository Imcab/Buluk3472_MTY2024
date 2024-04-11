
///////////////SUBSISTEMA DEL MANEJO DEL CHASIS MECANUM //////////////////////////

//////////////// SI SE INVIERTEN LOS EJES EN EL CONTROL, CHECAR EN EL * COMANDO DEL MECANUM (DRIVEROBOT)* /////////////////

package frc.robot.Subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.CANSparkMax;
import com.kauailabs.navx.frc.AHRS;
import com.revrobotics.CANSparkLowLevel.MotorType;

import frc.robot.constants.driveconst;
import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class DriveMecos extends SubsystemBase{

    CANSparkMax FrentIzq, FrentDer, AtrasIzq, AtrasDer;

    private int frenteIzquid = driveconst.fi_id;
    private int FrenteDerid = driveconst.fd_id;
    private int AtrasIzqid = driveconst.ai_id;
    private int AtrasDerid = driveconst.ad_id;

    
    PIDController chasis_PID;
    double kP = 0.01;
    double kI = 0.0;
    double kD = 0.001;

    AHRS NavX;
    double NavxOFFSET = 182.9;

    public DriveMecos(){

        FrentIzq = new CANSparkMax(frenteIzquid, MotorType.kBrushless);
        FrentDer = new CANSparkMax(FrenteDerid, MotorType.kBrushless);
        AtrasIzq = new CANSparkMax(AtrasIzqid, MotorType.kBrushless);
        AtrasDer = new CANSparkMax(AtrasDerid, MotorType.kBrushless);

        FrentIzq.setInverted(true);
        AtrasIzq.setInverted(true);
    

        CameraServer.startAutomaticCapture("Camera", 0);  
        
        NavX = new AHRS(SPI.Port.kMXP);
        NavX.setAngleAdjustment(NavxOFFSET);

        chasis_PID = new PIDController(kP, kI, kD);

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
        FrentIzq.set(fIv);
        FrentDer.set(fDv);
        AtrasIzq.set(aIv);
        AtrasDer.set(aDv);

    }

    public void tankauto (double speedder, double speedizq){
        FrentIzq.set(speedizq);
        FrentDer.set(speedder);
        AtrasIzq.set(speedizq);
        AtrasDer.set(speedder);   
        //Este modo se ocupa para autonomo, donde les das velocidades iguales para manejarlo como tanque   
    }    

    public void mecanumauto (double speedfi, double speedfd, double speedai,double speedad){
        FrentIzq.set(speedfi);
        FrentDer.set(speedfd);
        AtrasIzq.set(speedai);
        AtrasDer.set(speedad);
        //Le das velocidades independientes a cada llanta, para modo autonomo, para moverse en cangrejo 
    }

    public double getAngle(){
        return NavX.getAngle();
    }

    public void chasis_poss (double angle, double speed){    

        if ((angle-2)< getAngle()|| (angle+2)>getAngle()){
        FrentIzq.set(-speed);
        FrentDer.set(speed);  
        AtrasIzq.set(-speed);  
        AtrasDer.set(speed);  
        
        } 
        else {
            FrentIzq.set(0);
            FrentDer.set(0);
            AtrasIzq.set(0);
            AtrasDer.set(0);
        }
    }

    @Override
    public void periodic(){
        SmartDashboard.putNumber("NavX", getAngle());
    }
  
}
