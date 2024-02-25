package frc.robot.Subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.constants.intakeconst;

public class subpiston extends SubsystemBase{
    DoubleSolenoid Piston;

    public subpiston(){
        Piston = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, intakeconst.sforwardchn, intakeconst.sreversedchn);
    }
     public void forward(){
        Piston.set(DoubleSolenoid.Value.kForward);
    } 
    public void Reverse(){
        Piston.set(DoubleSolenoid.Value.kReverse);
    }   
}
