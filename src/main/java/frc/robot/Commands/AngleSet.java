package frc.robot.Commands;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Subsystems.subpos;
import frc.robot.Subsystems.sublimelight;

public class AngleSet extends Command{

    sublimelight sublimelight;
    subpos outake;
    


    public AngleSet(sublimelight sublimelight){
        
        this.sublimelight = sublimelight;
        addRequirements();        

    }

    @Override
    public void initialize(){

    }

    //Override y cambiar a execute, probar asi primero


    @Override
    public void  execute(){
        double Y = sublimelight.getY(); //Como accesar a static variables?
        boolean TargetAvaliable = sublimelight.isTargetAvalible();

        if (TargetAvaliable == true){

            if (Y < 0.0){ //Cambiar en referencia a la altitud en que este el verdadero objetivo
                outake.setposspeed(0.3);
            } else if (Y > 0.0){
                outake.setposspeed(-0.3);
            } else{
                outake.setposspeed(0.0);
            }
            
        } else{
            outake.setposspeed(0.0);
            
        }
    }

    @Override
    public boolean isFinished(){
        
        return false;
    }

}