package frc.robot.OutakeCmd;
import java.util.function.Supplier;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Subsystems.suboutakeposicion;

public class composout extends Command{

    suboutakeposicion posoutake;
    Supplier<Double>posspeed;

    public composout(suboutakeposicion posoutake, Supplier<Double>posspeed){

        this.posoutake = posoutake;
        this.posspeed = posspeed;

        addRequirements(posoutake);
    }

    @Override
    public void initialize(){}

    @Override
    public void execute(){

        double speedpos = posspeed.get();

        if (Math.abs(speedpos) < 0.05){
            speedpos = 0;
        }

        posoutake.setposspeed(speedpos * 0.15);
    }

    @Override
    public boolean isFinished(){
        return false;
    }
}
