@echo off
echo.
echo.
echo " Usages :-                                              "
echo "             snMatch  match.jat                         "
echo "             java snMatch  < match.jat                  "
echo "             java snMatch  < match.jat > sample.err     "
echo.
if "%1"=="" goto :end
pause
java -cp snJAll.jar;rt.jar snMatch < %1
:end

