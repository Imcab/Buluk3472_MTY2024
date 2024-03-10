package frc.robot.Subsystems;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;

import frc.robot.HPPMathLib;
import frc.robot.constants.outakeconst;

public class subpos extends SubsystemBase{

    PIDController PIDOUT;

    double kP = 0.016;
    double kI = 0.0;
    double kD = 0.0;
    double encBits;
    double angulo_encoder;
    double offset_encoder = 0;

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

    public void position_outake (double angle){    
        posout1.set(PIDOUT.calculate(HPPMathLib.MinAngle(angulo_encoder, angle), 0));
        posout2.set(PIDOUT.calculate(HPPMathLib.MinAngle(angulo_encoder, angle), 0));
        
    }

    @Override
    public void periodic(){
        encBits = encoderOutake.getValue();
        angulo_encoder = HPPMathLib.coterminal( (encBits*360)/4096 - offset_encoder);

        SmartDashboard.putNumber("AngOutake", angulo_encoder);
    }
    
    public void setposspeed(double oposspeed){ 
        posout1.set(oposspeed); 
        posout2.set(oposspeed);
    }
 
    public double angle(){
        return angulo_encoder; 
    }

}

// :v