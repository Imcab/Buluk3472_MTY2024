package frc.robot.Subsystems;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.constants.intakeconst;

public class subpiston extends SubsystemBase{
    private final DoubleSolenoid Piston;
    private final Compressor compressor;



    public subpiston(){
        Piston = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, intakeconst.sforwardchn, intakeconst.sreversedchn);
        compressor =  new Compressor(PneumaticsModuleType.CTREPCM);
        
    }
     public void forward(){
        Piston.set(DoubleSolenoid.Value.kForward);
    } 
    public void Reverse(){
        Piston.set(DoubleSolenoid.Value.kReverse);
    }   
    public void Toggle(){
        Piston.toggle();
        
    }


    @Override
    public void periodic(){
        
        double drawn = compressor.getCurrent();
      
  
        SmartDashboard.putNumber("drawn", drawn);
   

    }


}
