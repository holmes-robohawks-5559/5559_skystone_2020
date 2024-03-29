
package org.firstinspires.ftc.teamcode;

        import com.qualcomm.robotcore.eventloop.opmode.Disabled;
        import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
        import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
        import com.qualcomm.robotcore.hardware.Servo;


@TeleOp(name = "TheClaw (Blocks to Java)", group = "")
@Disabled
public class TheClaw extends LinearOpMode {


    private Servo wrist;
    private Servo claw;

    /**
     * This function is executed when this Op Mode is selected from the Driver Station.
     */
    @Override
    public void runOpMode() {

        wrist = hardwareMap.servo.get("wrist");
        claw = hardwareMap.servo.get("THE CLAW");

        // Put initialization blocks here.
        waitForStart();
        if (opModeIsActive()) {
            // Put run blocks here.
            while (opModeIsActive()) {
                // Put loop blocks here.
                if (gamepad2.left_bumper == true) {
                    wrist.setPosition(1);
                } else {
                    wrist.setPosition(0);
                }
                if (gamepad2.a) {
                    claw.setPosition(0);
                } else if (gamepad2.b) {
                    claw.setPosition(1);
                }
                telemetry.update();
            }
        }
    }
}
