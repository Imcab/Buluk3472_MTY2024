package frc.robot.Subsystems;

import edu.wpi.first.wpilibj.CounterBase;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkLowLevel.MotorType;
import frc.robot.constants.outakeconst;

public class subpos extends SubsystemBase{

    CANSparkMax posout1, posout2;
    private int poutid = outakeconst.posoutid;
    private int poutid2 = outakeconst.posoutid2;

    Encoder encoder2;

    private RelativeEncoder otroencoder1;
    private RelativeEncoder otroencoder2;



    public subpos(){
        posout1 = new CANSparkMax(poutid, MotorType.kBrushless);
        posout2 = new CANSparkMax(poutid2, MotorType.kBrushless);

        encoder2 = new Encoder(1,2,true, CounterBase.EncodingType.k4X);

        encoder2.setDistancePerPulse(4.0/256.0);
        encoder2.setMinRate(10);
        encoder2.setSamplesToAverage(5);

        otroencoder1 = posout1.getEncoder();
        otroencoder2 = posout2.getEncoder();
    

    }

   /*   public void angulo1(){

        if(encoder_value <90){

            posout1.set(0.3);
            posout2.set(-0.3);

        }

        else if(encoder_value >90){

            posout1.set(-0.3);
            posout2.set(0.3);

        }
        
        else{
           posout1.set(0);
            posout2.set(0); 
        }
    }

   /*  public void angulo2(){

        if(encoderBore.getDistance()<120){

            posout1.set(0.6);
            posout2.set(0.6);
        }
    }*/



    /*    public void egoder(){
        otroencoder1.setPosition(0);
        otroencoder2.setPosition(0);
     } */

    @Override
    public void periodic(){
        
        
        
        double encoder2_value = ((encoder2.getDistance()/4096)*360); 


        SmartDashboard.putNumber("encoder2", encoder2.getRate());
        SmartDashboard.putNumber("encoder2Distance", encoder2.getDistancePerPulse());
        SmartDashboard.putNumber("encoder2Rate", encoder2.getRate());
        SmartDashboard.putNumber("encoder_value", encoder2_value);

        SmartDashboard.putNumber("Encoder outake 1", otroencoder1.getPosition());
        SmartDashboard.putNumber("Encoder outake 2", otroencoder2.getPosition());


 
        
    }
        public void setposspeed(double oposspeed){
            posout1.set(oposspeed);
            posout2.set(-oposspeed);
        }


        



}
