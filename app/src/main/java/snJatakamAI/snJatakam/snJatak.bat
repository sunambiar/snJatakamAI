@echo off
echo.
echo.
echo " Usages :-                                                  "
echo "             snJatak   kavya.dat                            "
echo "             java snJatakam  < kavya.dat                    "
echo "             java snJatakam  < kavya.dat > kavya.err        "
echo.
if "%1"=="" goto :end
pause
java -cp snJAll.jar;rt.jar snJatakam < %1
:end

