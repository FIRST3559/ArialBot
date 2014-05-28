/*
 * 2014 Aerial Assist
 *  Team 3559 
 *  Base Robot Code 2/1/2014
 *  Coders: Donald Bough, Griffin Park, Nick James, Fred Routson(coach)
 *  Coders-in-Training: Sam Lehmkuhler, Nathaniel Jame, Nick Bredhold, 
 *   Will Schmitt, Logan Bromm
 */
package edu.wpi.first.wpilibj.templates;
// import edu.wpi.first.wpilibj.SimpleRobot;
import edu.wpi.first.wpilibj.*;
//import edu.wpi.first.wpilibj.AnalogChannel;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.DigitalInput;

public class Lowerbot extends SimpleRobot {
    RobotDrive drive = new RobotDrive(1,2);// Drive
    Joystick LeftStick = new Joystick(1);  // Left drive stick
    Joystick RightStick = new Joystick(2); // Right drive stick
    Joystick ThirdStick = new Joystick(3); // Arm joystick
    Talon winch1 = new Talon(6);
    Talon winch2 = new Talon(7);
    Relay loader = new Relay(5,1);
    Solenoid push = new Solenoid (2);
    Solenoid pull = new Solenoid (4);
    Solenoid loaderPush = new Solenoid(1);
    Solenoid loaderPull = new Solenoid(3);
    //Compressor Compressor = new Compressor(8,2); //Compressor Object
    Compressor Compressor = new Compressor(2,8);
    double driveTime = 2.5;
    double motorPower = 0.5;
    //Solenoid piston1out = new Solenoid(1); //First Solenoid Object
    //Solenoid piston1in = new Solenoid (2); //Second Solenoid Object
    //Victor testMotor = new Victor(1);
    //RobotDrive mainDrive = new RobotDrive(1,2);
    //Talon testMotor = new Talon(1);
    //Talon testMotor2 = new Talon(2);
    DigitalInput button1 = new DigitalInput(3); //-Donald Button example
       //Look at sheet for what true & false actually mean
    int autoCounter = 0; //Starts off autonomous
    
    public void robotInit(){
        Compressor.start();
    }
    
    public void autonomous() {
        autoCounter = 0;
        while(autoCounter == 0){ 
            drive.drive(motorPower, 0.0); //This way let's the first part of the paremeter
            // be the percent of motor power, and the second is the power you want to rotate
            Timer.delay(driveTime);
            drive.drive(0.0, 0.0);
            autoCounter++;
        }
    }
    public void operatorControl() {
        
        while (true && isOperatorControl() && isEnabled()){ 
           drive.tankDrive(-(LeftStick.getY(GenericHID.Hand.kLeft)),
                        -(RightStick.getY(GenericHID.Hand.kLeft)));
           
            //Pneumatics buttons
           if (ThirdStick.getRawButton(6) == true){
               loaderPush.set(true);
               loaderPull.set(false);
           }
           
           else if(ThirdStick.getRawButton(7) == true){
               loaderPull.set(true);
               loaderPush.set(false);
           }
           else{
               loaderPull.set(false);
               loaderPush.set(false);
           }
           
           if (ThirdStick.getRawButton(11) == true){
               Compressor.setRelayValue(Relay.Value.kOff);
           }
           
           if (ThirdStick.getRawButton(10) == true) {
               Compressor.setRelayValue(Relay.Value.kOn);
           }
           
           if (ThirdStick.getRawButton(1) == true){ 
                push.set(true);                     
                pull.set(false); 
                Timer.delay(0.5);
                push.set(false);
                pull.set(true);
                Timer.delay(.5);
                push.set(false);
                pull.set(false);
           }
           
           if (ThirdStick.getRawButton(2) == true) {
               winch1.set(.3);
               winch2.set(.3);
               
               
           
               if (button1.get() == false){
                   Timer.delay(0.1);
                   winch1.set(0.0);
                   winch2.set(0.0);
                   Timer.delay(.5);
                   winch1.set(-.3);
                   winch2.set(-.3);
                   Timer.delay(2.5);
                   winch1.set(0.0);
                   winch2.set(0.0);
               }
           }
           else{
               winch1.set(0.0);
               winch2.set(0.0);
           }
           
           //Relays
           if (ThirdStick.getRawButton(4) == true) {
               loader.set(Relay.Value.kOn);
           }
           else{
               loader.set(Relay.Value.kOff);
           }
           
           if (ThirdStick.getRawButton(5) == true) {
               loader.set(Relay.Value.kReverse);
           }
           else{
               loader.set(Relay.Value.kOff);
           }
           
    
    /* Working test code for pneumatics
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