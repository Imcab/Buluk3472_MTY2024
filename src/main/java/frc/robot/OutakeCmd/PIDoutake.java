package frc.robot.OutakeCmd;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Subsystems.suboutakeposicion;

public class PIDoutake extends Command{

    suboutakeposicion posoutake;
    double angle;

    public PIDoutake(suboutakeposicion posoutake, double angle){
        this.posoutake = posoutake;
        this.angle = angle;

        addRequirements(posoutake);
    }

    @Override
    public void initialize(){
    }

    @Override
    public void execute(){

        posoutake.position_outake(angle);

        if(posoutake.angle() == angle){
            posoutake.setposspeed(0);
        }
         
    }

    @Override
    public boolean isFinished(){
        return false;
    }
}
