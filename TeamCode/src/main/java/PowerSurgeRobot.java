import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class PowerSurgeRobot {

    private static final int COUNTS_PER_ROTATION = 1120;

    private static final int WHEEL_DIAMETER = 4;

    private static final double GEAR_RATIO = 2.0/3.0;

    private static final double COUNTS_PER_INCH = GEAR_RATIO*COUNTS_PER_ROTATION/(WHEEL_DIAMETER*Math.PI);

    private HardwareMap _hardwareMap;

    private DcMotor _leftDriveMotor;

    private DcMotor _rightDriveMotor;

    public PowerSurgeRobot (HardwareMap hardwareMap){
        _hardwareMap=hardwareMap;

        _leftDriveMotor=hardwareMap.get(DcMotor.class, "leftDriveMotor");

        _rightDriveMotor=hardwareMap.get(DcMotor.class, "rightDriveMotor");
    }

    public void cheeseBurger (double leftDistance, double rightDistance, double speed){

        private int leftTargetPosition;
        private int rightTargetPosition;
        private double leftTargetDifference=leftDistance*COUNTS_PER_INCH;
        private double rightTargetDifference=rightDistance*COUNTS_PER_INCH;

    }
}
