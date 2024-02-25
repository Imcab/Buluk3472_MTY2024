package frc.robot.Subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;
import frc.robot.constants.outakeconst;

public class subpos extends SubsystemBase{

    CANSparkMax posout1, posout2;
    private int poutid = outakeconst.posoutid;
    private int poutid2 = outakeconst.posoutid2;

    DigitalInput aa = new DigitalInput(0);
    DigitalInput bb = new DigitalInput(1);
    DigitalInput cc = new DigitalInput(2);

    private Encoder encoderBore;
       //double encoder_value;

    public subpos(){
        posout1 = new CANSparkMax(poutid, MotorType.kBrushless);
        posout2 = new CANSparkMax(poutid2, MotorType.kBrushless);
        encoderBore = new Encoder(aa, bb,cc);

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


     

    @Override
    public void periodic(){

        encoderBore.setDistancePerPulse(4/256);

        double encoder_value = ((encoderBore.getDistance()/4096)*360); 
    

        SmartDashboard.putNumber("Encoder bore Encoder Encoder externo Encoder Absoluto", encoder_value);
        //SmartDashboard.putNumber("dd", encoderBore.getDistance());

       
    
    }

        public void setposspeed(double oposspeed){
            posout1.set(oposspeed);
            posout2.set(-oposspeed);
        }




}
