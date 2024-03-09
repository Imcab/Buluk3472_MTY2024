package frc.robot.Subsystems;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkLowLevel.MotorType;
import frc.robot.constants.outakeconst;

public class subpos extends SubsystemBase{

    PIDController PID;

    Double kP = 0.0;
    Double kI = 0.0;
    Double kD = 0.0;
    Double Setpoint1 = 0.0;
    Double Setpoint2 = 0.0;


    CANSparkMax posout1, posout2;
    private int poutid = outakeconst.posoutid;
    private int poutid2 = outakeconst.posoutid2;
    AnalogPotentiometer encoderOutake = new AnalogPotentiometer(0);
    AnalogPotentiometer encoderOtro = new AnalogPotentiometer(1);



    public subpos(){
        posout1 = new CANSparkMax(poutid, MotorType.kBrushless);
        posout2 = new CANSparkMax(poutid2, MotorType.kBrushless);
        PID = new PIDController(kP, kI, kD);

        posout2.setInverted(true);
    }

    public void pos1(){
       // posout1.set(PID.calculate());
    }

    @Override
    public void periodic(){
        
    }
        public void setposspeed(double oposspeed){
            posout1.set(oposspeed);
            posout2.set(oposspeed);
        }


        



}
