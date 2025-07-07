@echo off
echo =============================
echo Starting Selenium Framework
echo =============================

:: Change to project directory
cd /d C:\24-03-2025\OpencartV121

:: Run Maven clean test
mvn clean test

echo =============================
echo Test execution completed
echo =============================

pause
