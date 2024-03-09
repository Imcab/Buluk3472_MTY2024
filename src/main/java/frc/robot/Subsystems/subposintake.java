package frc.robot.Subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.constants.intakeconst;

public class subposintake extends SubsystemBase{

    CANSparkMax m_posintake;
    private int posintid = intakeconst.m_posintakeid;
    AnalogInput encoderIntake;

    PIDController PIDintake;

    
    double kP = 0.0;
    double kI = 0.0;
    double kD = 0.0;
    double Setpoint1 = 0.0;
    double Setpoint2 = 0.0;
    int encBits ;
    double angulo_encoder;
    

    public subposintake(){
        m_posintake = new CANSparkMax(posintid, MotorType.kBrushless);
        encoderIntake = new AnalogInput(1);
        PIDintake = new PIDController(kP, kI, kD);
        
    }

    public void vel (double speed ){
        m_posintake.set(speed);
    }

    public void Pos1 (){
    
        m_posintake.set(PIDintake.calculate(angulo_encoder, Setpoint1));
    }

    public void Pos2 (){
         m_posintake.set(PIDintake.calculate(angulo_encoder, Setpoint2));
    }
    

    @Override
    public void periodic(){
        encBits = encoderIntake.getValue();
        angulo_encoder = (encBits*360)/4096;
    }
}

