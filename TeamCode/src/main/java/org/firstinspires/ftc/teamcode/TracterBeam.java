
package org.firstinspires.ftc.teamcode;

        import com.qualcomm.robotcore.eventloop.opmode.Disabled;
        import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
        import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
        import com.qualcomm.robotcore.hardware.Servo;

@TeleOp(name = "TracterBeam (Blocks to Java)", group = "")
@Disabled
public class TracterBeam extends LinearOpMode {

    private Servo foundationclamp1;
    private Servo foundationclamp2;

    /**
     * This function is executed when this Op Mode is selected from the Driver Station.
     */
    @Override
    public void runOpMode() {
        foundationclamp1 = hardwareMap.servo.get("foundation clamp1");
        foundationclamp2 = hardwareMap.servo.get("foundation clamp2");

        // Put initialization blocks here.
        waitForStart();
        if (opModeIsActive()) {
            // Put run blocks here.
            while (opModeIsActive()) {
                // Put loop blocks here.
                if (gamepad1.right_stick_button == true) {
                    foundationclamp1.setPosition(0.25);
                    foundationclamp2.setPosition(-0.25);
                } else if (gamepad1.right_stick_button == false) {
                    foundationclamp1.setPosition(0);
                    foundationclamp2.setPosition(0);
                }
                telemetry.update();
            }
        }
    }
}
