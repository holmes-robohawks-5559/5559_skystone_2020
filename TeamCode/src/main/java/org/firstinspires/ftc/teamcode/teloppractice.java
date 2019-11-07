
package org.firstinspires.ftc.teamcode;

        import com.qualcomm.robotcore.eventloop.opmode.Disabled;
        import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
        import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
        import com.qualcomm.robotcore.hardware.DcMotor;
        import com.qualcomm.robotcore.hardware.DcMotorSimple;
        import com.qualcomm.robotcore.hardware.Servo;

@TeleOp(name = "teleoppractice (Blocks to Java)", group = "")
@Disabled
public class teleoppractice extends LinearOpMode {

    private DcMotor leftbackDT;
    private DcMotor leftfrontDT;
    private Servo foundationclamp1;

    /**
     * This function is executed when this Op Mode is selected from the Driver Station.
     */
    @Override
    public void runOpMode() {
        double tgtPower;

        leftbackDT = hardwareMap.dcMotor.get("leftbackDT");
        leftfrontDT = hardwareMap.dcMotor.get("leftfrontDT");
        foundationclamp1 = hardwareMap.servo.get("foundation clamp1");

        // Put initialization blocks here.
        leftbackDT.setDirection(DcMotorSimple.Direction.REVERSE);
        leftfrontDT.setDirection(DcMotorSimple.Direction.REVERSE);
        waitForStart();

        if (opModeIsActive()) {
            // Put loop blocks here.
            if (gamepad1.a == true) {
                foundationclamp1.setPosition(0);
            } else if ((gamepad1.x && gamepad1.b) == true) {
                foundationclamp1.setPosition(0.5);
            } else if (gamepad1.b == true) {
                foundationclamp1.setPosition(1);
            } else {
                foundationclamp1.setPosition(0.5);
            }
            while (opModeIsActive()) {
                // Put loop blocks here.
                tgtPower = -gamepad1.left_stick_y;
                leftbackDT.setPower(tgtPower);
                telemetry.addData("Target Power", tgtPower);
                telemetry.addData("Motor Power", leftbackDT.getPower());
                telemetry.addData("Servo Position", leftbackDT.getPower());
                telemetry.update();
            }
        }
    }
}
