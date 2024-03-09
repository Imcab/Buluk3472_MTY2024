package frc.robot.Subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkLowLevel.MotorType;
import frc.robot.constants.driveconst;
import edu.wpi.first.math.geometry.Rotation2d;
import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.drive.MecanumDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;



public class DriveMecos extends SubsystemBase{

    CANSparkMax FrentIzq, FrentDer, AtrasIzq, AtrasDer;

    private int frenteIzquid = driveconst.fi_id;
    private int FrenteDerid = driveconst.fd_id;
    private int AtrasIzqid = driveconst.ai_id;
    private int AtrasDerid = driveconst.ad_id;

    private RelativeEncoder EncoderFrenteIzq;
    private RelativeEncoder EncoderFrenteDer;
    private RelativeEncoder EncoderAtrasIzq;
    private RelativeEncoder EncoderAtrasDer;

    private double FDENC,FIENC,AIENC,ADENC;

    Rotation2d gyroangle;

    private MecanumDrive driveMecanum;
    private AHRS navX;

    public DriveMecos(){

        FrentIzq = new CANSparkMax(frenteIzquid, MotorType.kBrushless);
        FrentDer = new CANSparkMax(FrenteDerid, MotorType.kBrushless);
        AtrasIzq = new CANSparkMax(AtrasIzqid, MotorType.kBrushless);
        AtrasDer = new CANSparkMax(AtrasDerid, MotorType.kBrushless);

        EncoderFrenteIzq = FrentIzq.getEncoder();
        EncoderFrenteDer = FrentDer.getEncoder();
        EncoderAtrasIzq = AtrasIzq.getEncoder();
        EncoderAtrasDer = AtrasDer.getEncoder();

        FrentIzq.setInverted(true);
        AtrasIzq.setInverted(true);
    
        navX = new AHRS(SPI.Port.kMXP);

        navX.setAngleAdjustment(90.00);

    }

    public void resetGyro() {
        navX.reset();
    }

    public Rotation2d anglecampo (){
        return new Rotation2d(navX.getAngle());
    }

    public double angle(){
       return navX.getAngle();
    }

    public void driveCartesian(double speedX, double speedY, double speedRotation) {
        //orientado a robot
        driveMecanum.driveCartesian(speedX, speedY, speedRotation);
    }  

    public void driveCartesian(double speedX, double speedY, double speedRotation, Rotation2d angleRotation) {
        //orientado a campo
        driveMecanum.driveCartesian(speedX, speedY, speedRotation, anglecampo());
    }

    public void tankauto (double speedder, double speedizq){
        FrentIzq.set(speedizq);
        FrentDer.set(speedder);
        AtrasIzq.set(speedizq);
        AtrasDer.set(speedder);     
    }    

    public void mecanumauto (double speedfi, double speedfd, double speedai,double speedad){
        FrentIzq.set(speedfi);
        FrentDer.set(speedfd);
        AtrasIzq.set(speedai);
        AtrasDer.set(speedad);
    }

    @Override
    public void periodic(){

        FIENC = EncoderFrenteIzq.getPosition();
        FDENC = EncoderFrenteDer.getPosition();
        AIENC = EncoderAtrasIzq.getPosition();
        ADENC = EncoderAtrasDer.getPosition();

        SmartDashboard.putNumber("Encoder Frente Izquierda", (FIENC/9.16)*0.1524);
        SmartDashboard.putNumber("Encoder Frente Derecha", (FDENC/9.16)*0.1524);
        SmartDashboard.putNumber("Encoder Atras Izquierda", (AIENC/9.16)*0.1524);
        SmartDashboard.putNumber("Encoder Atras Derecha", (ADENC/9.16)*0.1524);

        SmartDashboard.putNumber("NavX", angle());

    }
  
}
