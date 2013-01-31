package companionBalls.robotContainerParts;
public class DirectionCalculation {

	int heading=0;
	double speed=0.0;

	void calcDirection(int roll, int pitch){

		/*
		 * -roll
		 * |
		 * -pitch --------- pitch
		 * |
		 * roll
		 */
		/* HAS BEEN SHIFTED TO
		 *
		 * pitch
		 * |
		 * roll ----------- -roll
		 * |
		 * -pitch
		 * Becouse of how Math.atan2 works
		 */
		
		double a=0;

		a = Math.atan2(pitch,-roll);
		if (a<0){
			a = Math.PI+a;
			a = a+Math.PI;
		}
		heading= (int) (57.2957794*a);

		//SPEED
		speed = pitch *1.6;
		
		if (roll > speed){
			speed=roll/100f;
		}else{
			speed=speed/100f;
		}
		
		
		speed = (Math.abs(roll)+Math.abs(pitch)) /400f;

		
	}
	int getHeading(){
		return heading;
	}
	double getSpeed(){
		return speed;
	}
}