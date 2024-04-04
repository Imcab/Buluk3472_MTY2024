/* 
package frc.robot.Commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Subsystems.subposintake;

public class BOOSTREintake extends Command{

    subposintake posintake;
    double angle;

    public BOOSTREintake(subposintake posintake, double angle){
        this.posintake = posintake;
        this.angle = angle;

        addRequirements(posintake);
    }

    @Override
    public void initialize(){

    }

    @Override
    public void execute(){

        if (posintake.angle() < 140) {

           posintake.position_intake(angle);
            SmartDashboard.putBoolean("Intake Ready", false);
        }
        else if (posintake.angle() > 180 && posintake.angle() < 190) {
            posintake.vel(0.0);
            SmartDashboard.putBoolean("Intake Ready", false);
        }
        else {
           posintake.vel(0);
           if (posintake.angle() > 200){
                SmartDashboard.putBoolean("Intake Ready", true);
           }

        }
        
    }

  
    @Override
    public boolean isFinished(){
        return false;
    }
}
*/