package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Commands.autotridente;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.Commands.colgador1;
import frc.robot.Commands.colgador1inv;
import frc.robot.Commands.colgador2;
import frc.robot.Commands.colgador2inv;
import frc.robot.Commands.comintake;
import frc.robot.Commands.comout;
import frc.robot.Commands.composout;
import frc.robot.Commands.driverobot;
import frc.robot.Commands.BOOSTintake;
import frc.robot.Commands.BOOSTREintake;
import frc.robot.Commands.PIDoutake;
import frc.robot.Subsystems.subcolgador1;
import frc.robot.Subsystems.subcolgador2;
import frc.robot.Subsystems.subintake;
import frc.robot.Subsystems.DriveMecos;
import frc.robot.Subsystems.suboutake;
import frc.robot.Subsystems.subpos;
import frc.robot.Subsystems.subposintake;


public class RobotContainer {

  private final DriveMecos mecanum = new DriveMecos();

  private final suboutake moutake = new suboutake();

  private final subpos posoutake = new subpos();

  private final subintake intake = new subintake();

  private final subcolgador2 colgador2 = new subcolgador2();

  private final subcolgador1 colgador1= new subcolgador1();

  private final subposintake posintake = new subposintake();

  public CommandXboxController driverjoytick = new CommandXboxController(0);
  public CommandXboxController mechjoytick = new CommandXboxController(1);

  private final Command autotridente = new autotridente(mecanum, posoutake, intake, moutake);

  SendableChooser<Command> m_chooser = new SendableChooser<>(); //for autonomous
 
  public RobotContainer() {

    /*m_chooser.addOption("Auto left", Autoleft);
    m_chooser.addOption("Auto right", Auto_right); */
   
    SmartDashboard.putData(m_chooser);

    driverobot cmdDriverobot = new driverobot(mecanum,

      ()-> driverjoytick.getRawAxis(XboxController.Axis.kLeftX.value),
      ()-> driverjoytick.getRawAxis(XboxController.Axis.kLeftY.value),
      ()-> driverjoytick.getRawAxis(XboxController.Axis.kRightX.value));


    mecanum.setDefaultCommand(cmdDriverobot
    );

    moutake.setDefaultCommand(new comout(moutake,
  
    ()-> mechjoytick.getRawAxis(XboxController.Axis.kRightTrigger.value),
    ()-> mechjoytick.getRawAxis(XboxController.Axis.kLeftTrigger.value)
    ){

    });

    colgador1.setDefaultCommand(new colgador1inv(colgador1,
  
    ()-> driverjoytick.getRawAxis(XboxController.Axis.kRightTrigger.value)
 
    ){

    });

    colgador2.setDefaultCommand(new colgador2inv(colgador2,
  
    ()-> driverjoytick.getRawAxis(XboxController.Axis.kLeftTrigger.value)
 
    ){

    });

    posoutake.setDefaultCommand(new composout(posoutake,

    ()-> mechjoytick.getRawAxis(XboxController.Axis.kLeftY.value)){
    
    });

    configureBindings(); 

  }

  private void configureBindings() { 
 
    mechjoytick.a().whileTrue(new comintake(intake, 0.9));

    mechjoytick.x().whileTrue(new comintake(intake, -0.9));
    
    driverjoytick.rightBumper().whileTrue(new colgador1(colgador1, 1.0));

    driverjoytick.leftBumper().whileTrue(new colgador2(colgador2, 1.0));

    mechjoytick.rightBumper().whileTrue(new BOOSTREintake(posintake, 165));

    mechjoytick.leftBumper().whileTrue(new BOOSTintake(posintake, 100));

    mechjoytick.y().whileTrue(new PIDoutake(posoutake, 30.00)); //amp

    mechjoytick.b().whileTrue(new PIDoutake(posoutake, 40.00)); //espiker
      
  }
  
  public Command getAutonomousCommand() {
    return autotridente;
    /*return new SequentialCommandGroup(
      new WaitCommand(7),Autoleft
      
    );*/
  }
  
}
