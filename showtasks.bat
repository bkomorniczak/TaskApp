call runcrud.bat

if "%ERRORLEVEL%" == "0" goto startchrome
echo.
echo RUNCRUD has errors - breaking work
goto fail

:startchrome
start chrome http://localhost:8080/crud/v1/task/getTasks
if "%ERRORLEVEL%" == "0" goto end
echo Cannot start CHROME
goto fail

:fail
echo.
echo There were errors

:end
echo.
echo Work is finished.