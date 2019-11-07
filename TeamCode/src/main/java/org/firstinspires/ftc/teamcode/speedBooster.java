package org.firstinspires.ftc.teamcode;

        import com.qualcomm.robotcore.eventloop.opmode.Disabled;
        import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
        import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
        import com.qualcomm.robotcore.hardware.DcMotor;
        import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp(name = "speedbooster (Blocks to Java)", group = "")
@Disabled
public class speedbooster extends LinearOpMode {

    private DcMotor leftBackDTAsDcMotor;
    private DcMotor rightFrontDTAsDcMotor;
    private DcMotor RightBackDTAsDcMotor;
    private DcMotor leftFrontDTAsDcMotor;

    /**
     * This function is executed when this Op Mode is selected from the Driver Station.
     */
    @Override
    public void runOpMode() {
        leftBackDTAsDcMotor = hardwareMap.dcMotor.get("leftBackDTAsDcMotor");
        rightFrontDTAsDcMotor = hardwareMap.dcMotor.get("rightFrontDTAsDcMotor");
        RightBackDTAsDcMotor = hardwareMap.dcMotor.get("RightBackDTAsDcMotor");
        leftFrontDTAsDcMotor = hardwareMap.dcMotor.get("leftFrontDTAsDcMotor");

        // Reverse one of the drive motors.
        // You will have to determine which motor to reverse for your robot.
        // In this example, the right motor was reversed so that positive
        // applied power makes it move the robot in the forward direction.
        leftBackDTAsDcMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        // You will have to determine which motor to reverse for your robot.
        // In this example, the right motor was reversed so that positive
        // applied power makes it move the robot in the forward direction.
        rightFrontDTAsDcMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        waitForStart();
        if (opModeIsActive()) {
            // Put run blocks here.
            while (opModeIsActive()) {
                // Put loop blocks here.
                // Use left stick to drive and right stick to turn
                telemetry.addData("Left Pow", leftBackDTAsDcMotor.getPower());
                telemetry.addData("Right Pow", RightBackDTAsDcMotor.getPower());
                telemetry.addData("Left Pow", leftFrontDTAsDcMotor.getPower());
                telemetry.addData("Left Pow", rightFrontDTAsDcMotor.getPower());
                if (gamepad1.right_bumper == true) {
                    // The Y axis of a joystick ranges from -1 in its topmost position
                    // to +1 in its bottommost position. We negate this value so that
                    // the topmost position corresponds to maximum forward power.
                    leftBackDTAsDcMotor.setPower(-gamepad1.left_stick_y + gamepad1.right_stick_x);
                    RightBackDTAsDcMotor.setPower(-gamepad1.left_stick_y - gamepad1.right_stick_x);
                    // The Y axis of a joystick ranges from -1 in its topmost position
                    // to +1 in its bottommost position. We negate this value so that
                    // the topmost position corresponds to maximum forward power.
                    leftFrontDTAsDcMotor.setPower(-gamepad1.left_stick_y + gamepad1.right_stick_x);
                    rightFrontDTAsDcMotor.setPower(-gamepad1.left_stick_y - gamepad1.right_stick_x);
                } else if (gamepad1.right_bumper == true) {
                    // The Y axis of a joystick ranges from -1 in its topmost position
                    // to +1 in its bottommost position. We negate this value so that
                    // the topmost position corresponds to maximum forward power.
                    leftBackDTAsDcMotor.setPower(-gamepad1.left_stick_y + gamepad1.right_stick_x);
                    RightBackDTAsDcMotor.setPower(-gamepad1.left_stick_y - gamepad1.right_stick_x);
                    // The Y axis of a joystick ranges from -1 in its topmost position
                    // to +1 in its bottommost position. We negate this value so that
                    // the topmost position corresponds to maximum forward power.
                    leftFrontDTAsDcMotor.setPower(-gamepad1.left_stick_y + gamepad1.right_stick_x);
                    rightFrontDTAsDcMotor.setPower(-gamepad1.left_stick_y - gamepad1.right_stick_x);
                } else {
                    // The Y axis of a joystick ranges from -1 in its topmost position
                    // to +1 in its bottommost position. We negate this value so that
                    // the topmost position corresponds to maximum forward power.
                    leftBackDTAsDcMotor.setPower(-gamepad1.left_stick_y + gamepad1.right_stick_x);
                    RightBackDTAsDcMotor.setPower(-gamepad1.left_stick_y - gamepad1.right_stick_x);
                    // The Y axis of a joystick ranges from -1 in its topmost position
                    // to +1 in its bottommost position. We negate this value so that
                    // the topmost position corresponds to maximum forward power.
                    leftFrontDTAsDcMotor.setPower(-gamepad1.left_stick_y + gamepad1.right_stick_x);
                    rightFrontDTAsDcMotor.setPower(-gamepad1.left_stick_y - gamepad1.right_stick_x);
                }
                telemetry.update();
            }
        }
    }
}
