package edu.wpi.first.wpilibj.templates;
import edu.wpi.first.wpilibj.SimpleRobot;
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.AnalogChannel;
import edu.wpi.first.wpilibj.SimpleRobot;

public class Lowerbot extends SimpleRobot {
    RobotDrive drive = new RobotDrive (1,2);// Drive
    Joystick LeftStick = new Joystick (1);  // Left drive stick
    Joystick RightStick = new Joystick (2); // Right drive stick
    Joystick ThirdStick = new Joystick (3); // Arm joystick
  
    //Compressor mainCompressor = new Compressor(1,1); //Compressor Object
    //Solenoid piston1out = new Solenoid(1); //First Solenoid Object
    //Solenoid piston1in = new Solenoid (2); //Second Solenoid Object
    //Victor testMotor = new Victor(1);
    //RobotDrive mainDrive = new RobotDrive(1,2);
    //Talon testMotor = new Talon(1);
    //Talon testMotor2 = new Talon(2);
    /*
    public void robotinit(){
        mainCompressor.start();
    }
    */
    public void autonomous() {
    /*
       testMotor.set(.5);
       testMotor2.set(.5);
       Timer.delay(5.0);
       testMotor.set(0.0);
       testMotor2.set(0.0);
    */
    }
    
    public void operatorControl() {
        while (true && isOperatorControl() && isEnabled()){ 
        drive.tankDrive(-(LeftStick.getY(GenericHID.Hand.kLeft)),
                        -(RightStick.getY(GenericHID.Hand.kLeft)));
      
/*    if(ThirdStick.getRawButton(2) == true){
        testMotor.set(.5);
    }
    else{
        testMotor.set(0.0);
    }
    
    if(ThirdStick.getRawButton(3) == true){
        testMotor2.set(-0.5);
    }
    else{
        testMotor2.set(0.0);
    }
    */
    /*
    if(leftStick.getRawButton(6) == true){
        piston1out.set(true);
        piston1in.set(false);
    }
    else if(leftStick.getRawButton(7) == true){
        piston1in.set(true);
        piston1out.set(false);
    }
    
    else{
        piston1in.set(false);
        piston1out.set(false);
        }
        */
        }
         
    }
    
}
