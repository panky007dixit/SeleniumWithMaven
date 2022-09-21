set INTERVAL=10
:loop
echo "Running script."
cd C:\SeleniumWithMaven
cd C:\SeleniumWithMaven\src\main\java\helpers
javac CSVClear.java
java CSVClear
timeout %INTERVAL%
goto:loop