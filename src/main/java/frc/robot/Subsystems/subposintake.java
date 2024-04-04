/////////////SUBSISTEMA QUE BAJA O SUBE EL INTAKE //////////////////////////



package frc.robot.Subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.constants.intakeconst;
import frc.robot.HPPMathLib;

public class subposintake extends SubsystemBase{

    CANSparkMax m_posintake;
    private int posintid = intakeconst.m_posintakeid;
    AnalogInput encoderIntake;

    PIDController PIDintake;

    double kP = 0.004;
    double kI = 0.0;
    double kD = 0.0;
    int encBits ;
    double angulo_encoder;
    double offset_encoder = 115;
    

    public subposintake(){
        m_posintake = new CANSparkMax(posintid, MotorType.kBrushless);
        encoderIntake = new AnalogInput(0);
        PIDintake = new PIDController(kP, kI, kD);
        
    }

    public void vel (double speed ){
        m_posintake.set(speed);
    }

    public void position_intake (double angle){    
        m_posintake.set(PIDintake.calculate(HPPMathLib.MinAngle(angulo_encoder, angle), 0));
    }

    public void autoreintake(){
        if (angle() < 140) {

            position_intake(145);

         }
         else if (angle() > 180 && angle() < 190) {
             vel(0.0);
             
         }
         else {
            vel(0);
            
         }
         
    }
    public void autointake(){
        if (angle() > 105) {
            position_intake(100);
   
            
        }
        else if (angle() > 25 && angle() < 35) {
            vel(0.0);
            
        }
        else {
            vel(0);
        }
    }
    

    @Override
    public void periodic(){
        encBits = encoderIntake.getValue();

        // en caso de que esté girando en sentido contrario
        // angulo_encoder = coterminal(- (encBits*360)/4096);

        angulo_encoder = HPPMathLib.coterminal( (encBits*360)/4096 - offset_encoder);
        SmartDashboard.putNumber("AngIntake", angulo_encoder);
    }

    public double angle(){
        return angulo_encoder;
    }
}

