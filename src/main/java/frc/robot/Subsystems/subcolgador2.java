package frc.robot.Subsystems;

import com.revrobotics.CANSparkLowLevel.MotorType;
import com.revrobotics.CANSparkMax;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.constants.colgConst;

public class subcolgador2 extends SubsystemBase {
    CANSparkMax colgador1, colgador2; 
    
    private int Idcolg2 = colgConst.colg2Id;

    public subcolgador2(){

        //cold1 id 12, cold2 id 13
    
        colgador2 = new CANSparkMax(Idcolg2, MotorType.kBrushless);

         colgador2.setInverted(true);

    }

    

    public void setcolgador2(double speed2){
        colgador2.set(speed2);
    }

    @Override
    public void periodic(){
        
    }

        

    
} 
