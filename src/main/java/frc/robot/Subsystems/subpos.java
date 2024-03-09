package frc.robot.Subsystems;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;
import frc.robot.constants.outakeconst;

public class subpos extends SubsystemBase{

    PIDController PIDOUT;

    double kP = 0.0;
    double kI = 0.0;
    double kD = 0.0;
    double Setpoint1 = 0.0;
    double Setpoint2 = 0.0;
    double Setpoint3 = 0.0;
    double encBits;
    double angulo_encoder;


    CANSparkMax posout1, posout2;
    private int poutid = outakeconst.posoutid;
    private int poutid2 = outakeconst.posoutid2;
    AnalogInput encoderOutake; 

    public subpos(){
        posout1 = new CANSparkMax(poutid, MotorType.kBrushless);
        posout2 = new CANSparkMax(poutid2, MotorType.kBrushless);
        encoderOutake = new AnalogInput(0);

        PIDOUT = new PIDController(kP, kI, kD);


        posout2.setInverted(true);
    }

    public void pos1(){
        posout1.set(PIDOUT.calculate(angulo_encoder, Setpoint1));
        posout2.set(PIDOUT.calculate(angulo_encoder, Setpoint1));
    }
    public void pos2(){
        posout1.set(PIDOUT.calculate(angulo_encoder, Setpoint2));
        posout2.set(PIDOUT.calculate(angulo_encoder, Setpoint2));
    }

    public void pos3(){
        posout1.set(PIDOUT.calculate(angulo_encoder, Setpoint3));
        posout2.set(PIDOUT.calculate(angulo_encoder, Setpoint3));
    }

    @Override
    public void periodic(){
        encBits = encoderOutake.getValue();
        angulo_encoder = (encBits*360)/4096;
    }
        public void setposspeed(double oposspeed){
            posout1.set(oposspeed);
            posout2.set(oposspeed);
        }


        



}
