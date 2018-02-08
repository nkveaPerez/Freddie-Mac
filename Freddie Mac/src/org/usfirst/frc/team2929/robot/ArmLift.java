package org.usfirst.frc.team2929.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class ArmLift
{
	boolean			isLiftUp,
					isLiftDown,
					lifterGoingUp,
					lifterGoingDown,
					lifterUpQueue,
					lifterDownQueue;
	
	WPI_TalonSRX	lift;
	
	public void liftCreation(WPI_TalonSRX liftMotor)
	{
		lift = liftMotor;
		
		lifterGoingUp 	= false;
		lifterGoingDown = false;
	}
	
	public void deployLift(JoystickButton hoistButton, DigitalInput liftSwitchTop, DigitalInput liftSwitchBottom)
	{
		isLiftUp 	= liftSwitchTop.get();
		isLiftDown 	= liftSwitchBottom.get();			
		
		if(isLiftDown && !isLiftUp && !lifterGoingUp && !lifterGoingDown && hoistButton.get())
		{
			lifterUpQueue 	= true;
			lifterDownQueue	= false;
		}
		if(!isLiftDown && isLiftUp && !lifterGoingUp && !lifterGoingDown && hoistButton.get())
		{
			lifterUpQueue	= false;
			lifterDownQueue = true;
		}
		
		if(isLiftUp)
		{
			lifterUpQueue = false;
		}
		if(isLiftDown)
		{
			lifterDownQueue = false;
		}
		
		if(isLiftDown && !isLiftUp && !lifterGoingUp && !lifterGoingDown && lifterUpQueue)
		{
			lift.set(0.25);
			lifterGoingUp 	= true;
			lifterGoingDown = false;
		}
		else if(isLiftUp)
		{
			lift.set(0);
		}
		
		if(!isLiftDown && isLiftUp && !lifterGoingUp && !lifterGoingDown && lifterDownQueue)
		{
			lift.set(-0.25);
			lifterGoingUp 	= false;
			lifterGoingDown = true;
		}
		else if(isLiftDown)
		{
			lift.set(0);
		}
	}
}
