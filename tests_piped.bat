@echo off
echo ============================================
echo Cleaning old builds... 
echo(
cmd /c "gradlew -q clean & rd /s /q .gradlew"
echo(
echo Done.
echo(
echo ============================================
echo(
echo Building the project...
echo( 
cmd /c "gradlew -q build"
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
cmd /c "type test1.sexp | gradlew -q :task1:run | gradlew -q task2:run | gradlew -q task3:run | java -classpath .\rars_46ab74d.jar .\task3/src/com/RARSInterface.java"
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
cmd /c "type test2.sexp | gradlew -q :task1:run | gradlew -q task2:run | gradlew -q task3:run | java -classpath .\rars_46ab74d.jar .\task3/src/com/RARSInterface.java"
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
cmd /c "type test3.sexp | gradlew -q :task1:run | gradlew -q task2:run | gradlew -q task3:run | java -classpath .\rars_46ab74d.jar .\task3/src/com/RARSInterface.java"
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
cmd /c "type test4.sexp | gradlew -q :task1:run | gradlew -q task2:run | gradlew -q task3:run | java -classpath .\rars_46ab74d.jar .\task3/src/com/RARSInterface.java"
echo(
echo ============================================
echo(
echo Input program:
echo(
type test5.sexp
echo(
echo ---------------------
echo(
echo Output:
echo(
cmd /c "type test5.sexp | gradlew -q :task1:run | gradlew -q task2:run | gradlew -q task3:run | java -classpath .\rars_46ab74d.jar .\task3/src/com/RARSInterface.java"
echo(
echo ============================================
echo(
echo Input program:
echo(
type test6.sexp
echo(
echo ---------------------
echo(
echo Output:
echo(
cmd /c "type test6.sexp | gradlew -q :task1:run | gradlew -q task2:run | gradlew -q task3:run | java -classpath .\rars_46ab74d.jar .\task3/src/com/RARSInterface.java"
echo(
echo ============================================
echo(
echo Input program:
echo(
type test7.sexp
echo(
echo ---------------------
echo(
echo Output:
echo(
cmd /c "type test7.sexp | gradlew -q :task1:run | gradlew -q task2:run | gradlew -q task3:run | java -classpath .\rars_46ab74d.jar .\task3/src/com/RARSInterface.java"
echo(
echo ============================================