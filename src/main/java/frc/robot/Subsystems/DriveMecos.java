
///////////////SUBSISTEMA DEL MANEJO DEL CHASIS MECANUM //////////////////////////

//////////////// SI SE INVIERTEN LOS EJES EN EL CONTROL, CHECAR EN EL * COMANDO DEL MECANUM (DRIVEROBOT)* /////////////////

package frc.robot.Subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;
import frc.robot.constants.driveconst;
import edu.wpi.first.cameraserver.CameraServer;

public class DriveMecos extends SubsystemBase{

    CANSparkMax FrentIzq, FrentDer, AtrasIzq, AtrasDer;

    private int frenteIzquid = driveconst.fi_id;
    private int FrenteDerid = driveconst.fd_id;
    private int AtrasIzqid = driveconst.ai_id;
    private int AtrasDerid = driveconst.ad_id;

    public DriveMecos(){

        FrentIzq = new CANSparkMax(frenteIzquid, MotorType.kBrushless);
        FrentDer = new CANSparkMax(FrenteDerid, MotorType.kBrushless);
        AtrasIzq = new CANSparkMax(AtrasIzqid, MotorType.kBrushless);
        AtrasDer = new CANSparkMax(AtrasDerid, MotorType.kBrushless);

        FrentIzq.setInverted(true);
        AtrasIzq.setInverted(true);
    

        CameraServer.startAutomaticCapture("Camera", 0);    
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

    @Override
    public void periodic(){

    }
  
}
