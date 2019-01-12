import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class PowerSurgeRobot {

    private static final int COUNTS_PER_ROTATION = 1120;

    private static final int WHEEL_DIAMETER = 4;

    private static final double GEAR_RATIO = 2.0/3.0;

    private static final double COUNTS_PER_INCH = GEAR_RATIO*COUNTS_PER_ROTATION/(WHEEL_DIAMETER*Math.PI);

    private LinearOpMode _opMode;

    private DcMotor _leftDriveMotor;

    private DcMotor _rightDriveMotor;

    public PowerSurgeRobot (LinearOpMode opMode){
        _opMode=opMode;

        _leftDriveMotor=opMode.hardwareMap.get(DcMotor.class, "leftDriveMotor");

        _rightDriveMotor=opMode.hardwareMap.get(DcMotor.class, "rightDriveMotor");
    }

    public void cheeseBurger (double leftDistance, double rightDistance, double speed){


        double leftTargetDifference=leftDistance*COUNTS_PER_INCH;
        double rightTargetDifference=rightDistance*COUNTS_PER_INCH;
        int leftTargetPosition=_leftDriveMotor.getCurrentPosition()+(int)leftTargetDifference;
        int rightTargetPosition=_rightDriveMotor.getCurrentPosition()+(int)rightTargetDifference;

        _leftDriveMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        _rightDriveMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        _leftDriveMotor.setTargetPosition(leftTargetPosition);
        _rightDriveMotor.setTargetPosition(rightTargetPosition);
        _leftDriveMotor.setPower(Math.abs(speed));
        _rightDriveMotor.setPower(Math.abs(speed));

        while(_opMode.opModeIsActive() &&_leftDriveMotor.isBusy()&&_rightDriveMotor.isBusy()){

            _opMode.telemetry.addData("Target", "Running to %7d :%7d", leftTargetPosition, rightTargetPosition);
            _opMode.telemetry.addData("Current","Running %7d :%7d", _leftDriveMotor.getCurrentPosition(), _rightDriveMotor.getCurrentPosition());

        }

        stopRobot();

        _leftDriveMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        _rightDriveMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }

    public void stopRobot (){
        _leftDriveMotor.setPower(0);
        _rightDriveMotor.setPower(0);
    }
}
