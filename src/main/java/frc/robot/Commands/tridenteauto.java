package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Subsystems.DriveMecos;
import frc.robot.Subsystems.subintake;
import frc.robot.Subsystems.suboutake;
import frc.robot.Subsystems.subpos;

public class tridenteauto extends Command{

    DriveMecos mecanum;
    subpos posoutake;
    suboutake moutake;
    subintake intake;

    private double starttime;
    private double mytime;

    public tridenteauto(DriveMecos mecanum, subpos posoutake, suboutake moutake, subintake intake){
        this.mecanum = mecanum;
        this.posoutake = posoutake;
        this.moutake = moutake;
        this.intake = intake;

        addRequirements(mecanum,posoutake,moutake,intake);
    }

    @Override
    public void initialize(){
        starttime = System.currentTimeMillis();
        System.out.println("start time"+starttime);
    }

    @Override 
    public void execute(){
        mytime = (System.currentTimeMillis() - starttime)/1000;
        System.out.println("mytime"+mytime);
    }

    @Override
    public void end(boolean interrupted) {
    }

    @Override
    public boolean isFinished(){     
        return false;
    } 
}
