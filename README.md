# Guide to rewrite 

## First steps. (always ask for help when needed) 

1. First create a new branch
2. Edit this readme file and enter your name (bottom of these instructions) 
3. commit your changes
4. push your changes (to the new branch you just created) 

5. Start working on the subsystems below

This branch belongs to: (your name here)


## Subsystems to rewrite

you can use the [2022](https://github.com/FRC-Sonic-Squirrels/2022-Robot-Code) code as a reference however a lot of it is outdated and does not follow best practices. 
Please do not copy it verbatim. If you are ever unsure about anything please ask. 

### Intake (general outline)
you can & will have more methods, objects, and variables than this. This is intended as a general outline

#### Objects you will need: 
- Talon_FX
- Solenoid

#### minimum methods to include: 
- setPercentOut(double percent)
- setVoltage(double volts)
- setVelocity(double rpm)
- deploy()
- retract()
- stop()
- getRpm();
- isDeployed();

#### intake commands
- IntakeDeployAndSpin(double rpm)
- IntakeRetractAndStop()
- IntakeDeployNoSpin()

#### Intake button bindings 
- rightTrigger (while being held down) = deploy & spin at 3000 RPM 
- rightBumper (while being held down) = just deploy

### Advantage Kit implementation
##### Please reference https://github.com/Mechanical-Advantage/AdvantageKit for help with this, they even have example robot code if needed
#### Top level layer (ex: Intake.java):
- get/set methods
- logging extra values
- tunable numbers
#### IO layer:
- pass all variables through to log and from log using toLog and fromLog:
> public void toLog(LogTable table) {
  <br />    table.put("name", value);
  <br />  }
> <br />public void fromLog(LogTable table) {
  <br />    value = table.get("name", defaultValue);
  <br />  }
- write out default forms of methods
> public default void methodName(double value) {}
#### Real layer:
- use methods you laid out in IO to reference motors
- update inputs
> @Override
  <br />public void updateInputs(IntakeIOInputs inputs) {
> <br /> inputs.value = motor.getValue();
> <br />}
