package frc.robot.Subsystems;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.constants.intakeconst;


public class subintake extends SubsystemBase {

    CANSparkMax intake;
   
    private int intkid = intakeconst.m_intake;
    


    public subintake(){
        intake = new CANSparkMax(intkid, MotorType.kBrushless);

        intake.setInverted(true);
        
    }

    public void velocities(double speed){
        intake.set(speed);
        

    }
    
}
