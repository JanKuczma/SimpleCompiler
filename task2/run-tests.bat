@echo off
echo ============================================
echo Cleaning old builds... 
echo(
cmd /c "gradlew -q clean & rd /s /q .gradle"
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
type 01.sexp
echo(
echo ---------------------
echo(
echo Output:
echo(
cmd /c "type 01.sexp | gradlew -q run"
echo(
echo ---------------------
echo(
echo Expected output:
echo(
type 01.out
echo(
echo ============================================
echo ============================================
echo(
echo Input program:
echo(
type 02.sexp
echo(
echo ---------------------
echo(
echo Output:
echo(
cmd /c "type 02.sexp | gradlew -q run"
echo(
echo ---------------------
echo(
echo Expected output:
echo(
type 02.out
echo(
echo ============================================
echo ============================================
echo(
echo Input program:
echo(
type 03.sexp
echo(
echo ---------------------
echo(
echo Output:
echo(
cmd /c "type 03.sexp | gradlew -q run"
echo(
echo ---------------------
echo(
echo Expected output:
echo(
type 03.out
echo(
echo ============================================
echo ============================================
echo(
echo Input program:
echo(
type 04.sexp
echo(
echo ---------------------
echo(
echo Output:
echo(
cmd /c "type 04.sexp | gradlew -q run"
echo(
echo ---------------------
echo(
echo Expected output:
echo(
type 04.out
echo(
echo ============================================
echo ============================================
echo(
echo Input program:
echo(
type 05.sexp
echo(
echo ---------------------
echo(
echo Output:
echo(
cmd /c "type 05.sexp | gradlew -q run"
echo(
echo ---------------------
echo(
echo Expected output:
echo(
type 05.out
echo(
echo ============================================
echo ============================================
echo(
echo Input program:
echo(
type 06.sexp
echo(
echo ---------------------
echo(
echo Output:
echo(
cmd /c "type 06.sexp | gradlew -q run"
echo(
echo ---------------------
echo(
echo Expected output:
echo(
type 06.out
echo(
echo ============================================
echo ============================================
echo(
echo Input program:
echo(
type 07.sexp
echo(
echo ---------------------
echo(
echo Output:
echo(
cmd /c "type 07.sexp | gradlew -q run"
echo(
echo ---------------------
echo(
echo Expected output:
echo(
type 07.out
echo(
echo ============================================
echo ============================================
echo(
echo Input program:
echo(
type 08.sexp
echo(
echo ---------------------
echo(
echo Output:
echo(
cmd /c "type 08.sexp | gradlew -q run"
echo(
echo ---------------------
echo(
echo Expected output:
echo(
type 08.out
echo(
echo ============================================
echo ============================================
echo(
echo Input program:
echo(
type 09.sexp
echo(
echo ---------------------
echo(
echo Output:
echo(
cmd /c "type 09.sexp | gradlew -q run"
echo(
echo ---------------------
echo(
echo Expected output:
echo(
type 09.out
echo(
echo ============================================
echo ============================================
echo(
echo Input program:
echo(
type 10.sexp
echo(
echo ---------------------
echo(
echo Output:
echo(
cmd /c "type 10.sexp | gradlew -q run"
echo(
echo ---------------------
echo(
echo Expected output:
echo(
type 10.out
echo(
echo ============================================
echo ============================================
echo(
echo Input program:
echo(
type 11.sexp
echo(
echo ---------------------
echo(
echo Output:
echo(
cmd /c "type 11.sexp | gradlew -q run"
echo(
echo ---------------------
echo(
echo Expected output:
echo(
type 11.out
echo(
echo ============================================
echo ============================================
echo(
echo Input program:
echo(
type 12.sexp
echo(
echo ---------------------
echo(
echo Output:
echo(
cmd /c "type 12.sexp | gradlew -q run"
echo(
echo ---------------------
echo(
echo Expected output:
echo(
type 12.out
echo(
echo ============================================
echo ============================================
echo(
echo Input program:
echo(
type 13.sexp
echo(
echo ---------------------
echo(
echo Output:
echo(
cmd /c "type 13.sexp | gradlew -q run"
echo(
echo ---------------------
echo(
echo Expected output:
echo(
type 13.out
echo(
echo ============================================
echo ============================================
echo(
echo Input program:
echo(
type 14.sexp
echo(
echo ---------------------
echo(
echo Output:
echo(
cmd /c "type 14.sexp | gradlew -q run"
echo(
echo ---------------------
echo(
echo Expected output:
echo(
type 14.out
echo(
echo ============================================
echo ============================================
echo(
echo Input program:
echo(
type 15.sexp
echo(
echo ---------------------
echo(
echo Output:
echo(
cmd /c "type 15.sexp | gradlew -q run"
echo(
echo ---------------------
echo(
echo Expected output:
echo(
type 15.out
echo(
echo ============================================
echo ============================================
echo(
echo Input program:
echo(
type 16.sexp
echo(
echo ---------------------
echo(
echo Output:
echo(
cmd /c "type 16.sexp | gradlew -q run"
echo(
echo ---------------------
echo(
echo Expected output:
echo(
type 16.out
echo(
echo ============================================
echo ============================================
echo(
echo Input program:
echo(
type 17.sexp
echo(
echo ---------------------
echo(
echo Output:
echo(
cmd /c "type 17.sexp | gradlew -q run"
echo(
echo ---------------------
echo(
echo Expected output:
echo(
type 17.out
echo(
echo ============================================
echo ============================================
echo(
echo Input program:
echo(
type 18.sexp
echo(
echo ---------------------
echo(
echo Output:
echo(
cmd /c "type 18.sexp | gradlew -q run"
echo(
echo ---------------------
echo(
echo Expected output:
echo(
type 18.out
echo(
echo ============================================
echo ============================================
echo(
echo Input program:
echo(
type 19.sexp
echo(
echo ---------------------
echo(
echo Output:
echo(
cmd /c "type 19.sexp | gradlew -q run"
echo(
echo ---------------------
echo(
echo Expected output:
echo(
type 19.out
echo(
echo ============================================
echo ============================================
