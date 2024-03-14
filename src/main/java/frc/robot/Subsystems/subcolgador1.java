package frc.robot.Subsystems;

import com.revrobotics.CANSparkLowLevel.MotorType;
import com.revrobotics.CANSparkMax;

import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.constants.colgConst;

public class subcolgador1 extends SubsystemBase {
    CANSparkMax colgador1, colgador2; 
    
    private int Idcolg = colgConst.colgId;

    public subcolgador1(){

        //cold1 id 12, cold2 id 13
        colgador1 = new CANSparkMax(Idcolg, MotorType.kBrushless);
        colgador1.setInverted(true);
        CameraServer.startAutomaticCapture("Camera2", 1);
    }

    public void setcolgador1(double speed){
        colgador1.set(speed);
    }
    
    @Override
    public void periodic(){
        
    }
   
} 
