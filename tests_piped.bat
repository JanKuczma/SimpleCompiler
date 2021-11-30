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
type test1.in
echo(
echo ---------------------
echo(
echo Output:
echo(
cmd /c "type test1.in | gradlew -q :task1:run | gradlew -q task2:run | gradlew -q task3:run | java -classpath .\rars_46ab74d.jar .\task3/src/com/RARSInterface.java"
echo(
echo ============================================
echo(
echo Input program:
echo(
type test2.in
echo(
echo ---------------------
echo(
echo Output:
echo(
cmd /c "type test2.in | gradlew -q :task1:run | gradlew -q task2:run | gradlew -q task3:run | java -classpath .\rars_46ab74d.jar .\task3/src/com/RARSInterface.java"
echo(
echo ============================================
echo(
echo Input program:
echo(
type test3.in
echo(
echo ---------------------
echo(
echo Output:
echo(
cmd /c "type test3.in | gradlew -q :task1:run | gradlew -q task2:run | gradlew -q task3:run | java -classpath .\rars_46ab74d.jar .\task3/src/com/RARSInterface.java"
echo(
echo ============================================
echo(
echo Input program:
echo(
type test4.in
echo(
echo ---------------------
echo(
echo Output:
echo(
cmd /c "type test4.in | gradlew -q :task1:run | gradlew -q task2:run | gradlew -q task3:run | java -classpath .\rars_46ab74d.jar .\task3/src/com/RARSInterface.java"
echo(
echo ============================================
echo(
echo Input program:
echo(
type test5.in
echo(
echo ---------------------
echo(
echo Output:
echo(
cmd /c "type test5.in | gradlew -q :task1:run | gradlew -q task2:run | gradlew -q task3:run | java -classpath .\rars_46ab74d.jar .\task3/src/com/RARSInterface.java"
echo(
echo ============================================
echo(
echo Input program:
echo(
type test6.in
echo(
echo ---------------------
echo(
echo Output:
echo(
cmd /c "type test6.in | gradlew -q :task1:run | gradlew -q task2:run | gradlew -q task3:run | java -classpath .\rars_46ab74d.jar .\task3/src/com/RARSInterface.java"
echo(
echo ============================================
echo(
echo Input program:
echo(
type test7.in
echo(
echo ---------------------
echo(
echo Output:
echo(
cmd /c "type test7.in | gradlew -q :task1:run | gradlew -q task2:run | gradlew -q task3:run | java -classpath .\rars_46ab74d.jar .\task3/src/com/RARSInterface.java"
echo(
echo ============================================
echo(
echo Input program:
echo(
type test8.in
echo(
echo ---------------------
echo(
echo Output:
echo(
cmd /c "type test8.in | gradlew -q :task1:run | gradlew -q task2:run | gradlew -q task3:run | java -classpath .\rars_46ab74d.jar .\task3/src/com/RARSInterface.java"
echo(
echo ============================================