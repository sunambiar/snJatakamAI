@echo off
echo Please stop the Java Server.....
echo.
pause

copy snJM_Srv.class c:\jwsdp-1_0_01\common\classes\.
copy snJ_Srv.class c:\jwsdp-1_0_01\common\classes\.
copy snJAll.jar c:\jwsdp-1_0_01\common\lib\.
copy snJM_Srv.htm c:\jwsdp-1_0_01\webapps\root\.
copy snJ_Srv.htm c:\jwsdp-1_0_01\webapps\root\.
