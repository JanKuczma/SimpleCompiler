@echo off
echo ============================================
echo Cleaning old builds... 
echo(
cmd /c "gradle -q clean & rd /s /q .gradle"
echo(
echo Done.
echo(
echo ============================================
echo(
echo Building the project...
echo( 
cmd /c "gradle -q build"
echo(
echo Done.
echo(
echo ============================================
echo(
echo Input program:
echo(
type test1.sexp
echo(
echo ---------------------
echo(
echo Output:
echo(
cmd /c "type test1.sexp | gradle -q :task1:run | gradle -q task2:run | gradle -q task3:run | java -classpath .\rars_46ab74d.jar .\task3/src/com/RARSInterface.java"
echo(
echo ============================================
echo(
echo Input program:
echo(
type test2.sexp
echo(
echo ---------------------
echo(
echo Output:
echo(
cmd /c "type test2.sexp | gradle -q :task1:run | gradle -q task2:run | gradle -q task3:run | java -classpath .\rars_46ab74d.jar .\task3/src/com/RARSInterface.java"
echo(
echo ============================================
echo(
echo Input program:
echo(
type test3.sexp
echo(
echo ---------------------
echo(
echo Output:
echo(
cmd /c "type test3.sexp | gradle -q :task1:run | gradle -q task2:run | gradle -q task3:run | java -classpath .\rars_46ab74d.jar .\task3/src/com/RARSInterface.java"
echo(
echo ============================================
echo(
echo Input program:
echo(
type test4.sexp
echo(
echo ---------------------
echo(
echo Output:
echo(
cmd /c "type test4.sexp | gradle -q :task1:run | gradle -q task2:run | gradle -q task3:run | java -classpath .\rars_46ab74d.jar .\task3/src/com/RARSInterface.java"
echo(
echo ============================================