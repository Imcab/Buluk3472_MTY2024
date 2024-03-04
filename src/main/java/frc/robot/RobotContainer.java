package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.Commands.Autoleft;
import frc.robot.Commands.Automiddle;
import frc.robot.Commands.Autoright;
import frc.robot.Commands.autista;
import frc.robot.Commands.colgador1;
import frc.robot.Commands.colgador1inv;
import frc.robot.Commands.colgador2;
import frc.robot.Commands.colgador2inv;
import frc.robot.Commands.comindex;
import frc.robot.Commands.comintake;
import frc.robot.Commands.comout;
import frc.robot.Commands.pistonforward;
import frc.robot.Commands.pistonreverse;
import frc.robot.Commands.composout;
import frc.robot.Commands.conmecos;
import frc.robot.Subsystems.subcolgador1;
import frc.robot.Subsystems.subcolgador2;
import frc.robot.Subsystems.subindex;
import frc.robot.Subsystems.subintake;
import frc.robot.Subsystems.submecos;
import frc.robot.Subsystems.suboutake;
import frc.robot.Subsystems.subpiston;
import frc.robot.Subsystems.subpos;


public class RobotContainer {

  private final submecos mecosmodule = new submecos();

  private final suboutake moutake = new suboutake();

  private final subpos posoutake = new subpos();

  private final subintake intake = new subintake();

  private final subindex index = new subindex();

  private final subpiston piston = new subpiston();


  
  private final subcolgador2 colgador2 = new subcolgador2();

  private final subcolgador1 colgador1= new subcolgador1();

  public CommandXboxController driverjoytick = new CommandXboxController(0);
  public CommandXboxController mechjoytick = new CommandXboxController(1);

  private final Command Automiddle = new Automiddle(mecosmodule, posoutake, index, intake, piston, moutake);
  private final Command Autoleft =  new Autoleft(mecosmodule, posoutake, index, intake, piston, moutake);
  private final Command Auto_right = new Autoright(mecosmodule, intake, index, moutake, posoutake, piston);

  private final Command autista = new autista(mecosmodule, posoutake, index, intake, piston, moutake);

  SendableChooser<Command> m_chooser = new SendableChooser<>(); //for autonomous
 
  public RobotContainer() {

    m_chooser.setDefaultOption("AUTO", autista);
    m_chooser.addOption("Auto Middle", Automiddle); 
    /*m_chooser.addOption("Auto left", Autoleft);
    m_chooser.addOption("Auto right", Auto_right); */
   
    SmartDashboard.putData(m_chooser);

    mecosmodule.setDefaultCommand(new conmecos(mecosmodule,

      ()-> driverjoytick.getRawAxis(XboxController.Axis.kLeftX.value),
      ()-> driverjoytick.getRawAxis(XboxController.Axis.kLeftY.value),
      ()-> driverjoytick.getRawAxis(XboxController.Axis.kRightX.value)) {
      
    });

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

    mechjoytick.x().toggleOnTrue(new comindex(index, 0.53)); 

    mechjoytick.a().whileTrue(new comintake(intake, 0.9));

    mechjoytick.y().whileTrue(new ParallelCommandGroup(new comintake(intake, -0.9), new comindex(index, -0.53)));
  
    mechjoytick.start().toggleOnTrue(new comintake(intake, 0));

    mechjoytick.rightBumper().whileTrue(new pistonforward(piston));
    
    mechjoytick.leftBumper().whileTrue(new pistonreverse(piston));

    driverjoytick.rightBumper().whileTrue(new colgador1(colgador1, 1.0));

    driverjoytick.leftBumper().whileTrue(new colgador2(colgador2, 1.0));
      
  }
  
  public Command getAutonomousCommand() {
    //return m_chooser.getSelected();
    return new SequentialCommandGroup(
      new WaitCommand(7),Autoleft
      
    );
  }
  
}
