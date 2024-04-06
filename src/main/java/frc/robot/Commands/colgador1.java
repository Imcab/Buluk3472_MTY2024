package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Subsystems.subcolgador1;

public class colgador1 extends Command{
    subcolgador1 colgador1;
    Double vel;

    public colgador1(subcolgador1 colgador1, Double vel){

        this.colgador1 = colgador1;
        this.vel = vel;

        addRequirements(colgador1);
    }

    @Override
    public void initialize(){   
    }

    @Override
    public void execute(){
        
        double velocity = vel;

        colgador1.setcolgador1(velocity);
    }

    @Override
    public void end(boolean interrupted) {
        colgador1.setcolgador1(0);
    }

    @Override
    public boolean isFinished(){
        return false;
    }

    
}
