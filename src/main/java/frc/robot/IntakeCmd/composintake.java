package frc.robot.IntakeCmd;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Subsystems.subposintake;

public class composintake extends Command{

    subposintake posintake;
    private final double speed;

    public composintake(subposintake posintake, double speed){
        
        this.posintake = posintake;
        this.speed = speed;
        addRequirements(posintake);        
    }

    @Override
    public void initialize(){
    }

    @Override
    public void execute(){
        posintake.vel(speed);
    }

    @Override
    public void end(boolean interrupted) {
        posintake.vel(0);
    }

    @Override
    public boolean isFinished(){
        return false;
    }
   
}
