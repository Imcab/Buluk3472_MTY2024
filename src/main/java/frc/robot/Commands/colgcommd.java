package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Subsystems.subcolgador;
import frc.robot.Subsystems.subindex;

public class colgcommd extends Command{
    subcolgador colgador;
    Double speed;

    public colgcommd(subcolgador colgador, Double speed){

            this.colgador = colgador;
            this.speed = speed;

        addRequirements(colgador);
    }

    @Override
    public void initialize(){
        
    }

    @Override
    public void execute(){
        
        double vel = speed;

            colgador.speed(vel);

    }

    @Override
    public void end(boolean interrupted) {
        colgador.speed(0);
    }


    @Override
    public boolean isFinished(){
        
        
        return false;
    }

    
}
