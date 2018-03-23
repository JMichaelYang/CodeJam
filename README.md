# CodeJam

Framework code for the 2018 Google CodeJam

# How To Use

1. Ensure that the file paths in the `MainExec` class are accurate.

2. Create a class that implements `IChallenge` in an appropriate package (ie: "qualification").

3. Add the new challenge class to the `ChallengeFactory`.

4. Write the code to manipulate the inputs in the `apply()` method of the new class.

5. Create a run configuration that runs the `MainExec` `main()` method with the correct arguments. 
Use the `-n` flag to specify the challenge name. Optionally, use the `-fn` flag to specify the file 
names. The file name value defaults to the challenge name.

6. Find the output file wherever your output path points to with the name set in step 4.