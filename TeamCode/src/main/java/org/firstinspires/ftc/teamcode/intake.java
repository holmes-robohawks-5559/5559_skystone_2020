package org.firstinspires.ftc.teamcode;

        import com.qualcomm.robotcore.eventloop.opmode.Disabled;
        import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
        import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
        import com.qualcomm.robotcore.hardware.CRServo;

@TeleOp(name = "Intake (Blocks to Java)", group = "")
@Disabled
public class Intake extends LinearOpMode {

    private CRServo intake1;
    private CRServo intake2;

    /**
     * This function is executed when this Op Mode is selected from the Driver Station.
     */
    @Override
    public void runOpMode() {
        intake1 = hardwareMap.crservo.get("intake1");
        intake2 = hardwareMap.crservo.get("intake2");

        // Put initialization blocks here.
        waitForStart();
        if (opModeIsActive()) {
            // Put run blocks here.
            while (opModeIsActive()) {
                // stick buttons are in as the triggers
                if (gamepad2.right_stick_button == true) {
                    intake1.setPower(1);
                    intake2.setPower(1);
                } else if (gamepad2.left_stick_button == true) {
                    intake1.setPower(-1);
                    intake2.setPower(-1);
                } else {
                    intake1.setPower(0);
                    intake2.setPower(0);
                }
                telemetry.update();
            }
        }
    }
}
