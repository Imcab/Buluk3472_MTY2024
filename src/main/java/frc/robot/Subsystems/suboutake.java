package frc.robot.Subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.constants.outakeconst;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;

public class suboutake extends SubsystemBase{

    CANSparkMax outake1, outake2;

    private int outakeid = outakeconst.outid;
    private int outakeid2 = outakeconst.outid2;
    
    public suboutake(){
        outake1 = new CANSparkMax(outakeid, MotorType.kBrushless);
        outake2 = new CANSparkMax(outakeid2, MotorType.kBrushless);

        outake1.setInverted(true);

        }

    @Override
    public void periodic(){

    }

        public void setoutakespeed(double outspeed){
            outake1.set(outspeed);
            outake2.set(outspeed);

        }
        public void ampspeed(double speed){
            outake1.set(speed * 0.82);
            outake2.set(speed);
        }

        
}
