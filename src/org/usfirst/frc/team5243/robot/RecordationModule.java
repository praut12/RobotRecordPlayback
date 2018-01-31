package org.usfirst.frc.team5243.robot;

import java.util.ArrayList;

import org.usfirst.frc.team5243.robot.subsystems.DriveSubsystem;
import org.usfirst.frc.team5243.robot.textfile.WriteToCSV;
import org.usfirst.frc.team5243.robot.textfile.WriteToTextFile;

import edu.wpi.first.wpilibj.Timer;

public class RecordationModule {
	
	public ArrayList<Double> frontleft;
	public ArrayList<Double> frontright;
	public ArrayList<Double> backleft;
	public ArrayList<Double> backright;
	DriveSubsystem driveSubsystem;
	
	ArrayList<Double> leftValues;
	ArrayList<Double> rightValues;
	
	public RecordationModule() {
	}
	
	public void initialize() {
		frontleft = new ArrayList<Double>();
		frontright = new ArrayList<Double>();
		backleft = new ArrayList<Double>();
		backright = new ArrayList<Double>();
		driveSubsystem = Robot.driveSubsystem;
		
		leftValues = new ArrayList<Double>();
		rightValues = new ArrayList<Double>();
	}
	
	public void record() {
		//ArrayList<Double> motors = new ArrayList<Double>();
		/*motors.add(driveSubsystem.getFrontLeftSpeed());
		motors.add(driveSubsystem.getFrontRightSpeed());
		motors.add(driveSubsystem.getBackLeftSpeed());
		motors.add(driveSubsystem.getBackRightSpeed());*/
		//Timer.delay(0.02);
		/*frontleft.add(driveSubsystem.getRightValues());
		frontright.add(driveSubsystem.getLeftValues());
		backleft.add(driveSubsystem.getRightValues());
		backright.add(driveSubsystem.getLeftValues());*/
		leftValues.add(driveSubsystem.getRightValues());
		rightValues.add(driveSubsystem.getLeftValues());
		System.out.println(Timer.getFPGATimestamp());
	}
	
	public void playback() {
		for (int i = 0; i < leftValues.size(); i++) {
			Timer.delay(0.02);
			//driveSubsystem.setFrontLeft(leftValues.get(i));
			//driveSubsystem.setFrontRight(rightValues.get(i));
			//driveSubsystem.setBackLeft(leftValues.get(i));
			//driveSubsystem.setBackRight(rightValues.get(i));
			driveSubsystem.getDrive().tankDrive(rightValues.get(i), leftValues.get(i));
		}
	}
	
	public int getSize() {
		return leftValues.size();
	}
	
	public void clearData() {
		//WriteToCSV.write(frontleft, frontright, backleft, backright, ");
		frontleft.clear();
		frontright.clear();
		backleft.clear();
		backright.clear();
		leftValues.clear();
		rightValues.clear();
	}

}
