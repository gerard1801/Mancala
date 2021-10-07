@rem
@rem Copyright 2015 the original author or authors.
@rem
@rem Licensed under the Apache License, Version 2.0 (the "License");
@rem you may not use this file except in compliance with the License.
@rem You may obtain a copy of the License at
@rem
@rem      https://www.apache.org/licenses/LICENSE-2.0
@rem
@rem Unless required by applicable law or agreed to in writing, software
@rem distributed under the License is distributed on an "AS IS" BASIS,
@rem WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
@rem See the License for the specific language governing permissions and
@rem limitations under the License.
@rem

@if "%DEBUG%" == "" @echo off
@rem ##########################################################################
@rem
@rem  api startup script for Windows
@rem
@rem ##########################################################################

@rem Set local scope for the variables with windows NT shell
if "%OS%"=="Windows_NT" setlocal

set DIRNAME=%~dp0
if "%DIRNAME%" == "" set DIRNAME=.
set APP_BASE_NAME=%~n0
set APP_HOME=%DIRNAME%..

@rem Resolve any "." and ".." in APP_HOME to make it shorter.
for %%i in ("%APP_HOME%") do set APP_HOME=%%~fi

@rem Add default JVM options here. You can also use JAVA_OPTS and API_OPTS to pass JVM options to this script.
set DEFAULT_JVM_OPTS=

@rem Find java.exe
if defined JAVA_HOME goto findJavaFromJavaHome

set JAVA_EXE=java.exe
%JAVA_EXE% -version >NUL 2>&1
if "%ERRORLEVEL%" == "0" goto execute

echo.
echo ERROR: JAVA_HOME is not set and no 'java' command could be found in your PATH.
echo.
echo Please set the JAVA_HOME variable in your environment to match the
echo location of your Java installation.

goto fail

:findJavaFromJavaHome
set JAVA_HOME=%JAVA_HOME:"=%
set JAVA_EXE=%JAVA_HOME%/bin/java.exe

if exist "%JAVA_EXE%" goto execute

echo.
echo ERROR: JAVA_HOME is set to an invalid directory: %JAVA_HOME%
echo.
echo Please set the JAVA_HOME variable in your environment to match the
echo location of your Java installation.

goto fail

:execute
@rem Setup the command line

set CLASSPATH=%APP_HOME%\lib\api.jar;%APP_HOME%\lib\client;%APP_HOME%\lib\rt-2.3.0.jar;%APP_HOME%\lib\jaxws-rt-2.3.0.jar;%APP_HOME%\lib\jersey-media-json-jackson-3.0.3.jar;%APP_HOME%\lib\domain.jar;%APP_HOME%\lib\jaxws-api-2.3.0.jar;%APP_HOME%\lib\jaxb-runtime-2.3.0.jar;%APP_HOME%\lib\jaxb-core-2.3.0.jar;%APP_HOME%\lib\jaxb-api-2.3.1.jar;%APP_HOME%\lib\streambuffer-1.5.4.jar;%APP_HOME%\lib\saaj-impl-1.4.0.jar;%APP_HOME%\lib\stax-ex-1.7.8.jar;%APP_HOME%\lib\activation-1.1.jar;%APP_HOME%\lib\jaxb-impl-2.3.0.jar;%APP_HOME%\lib\jaxb-core-2.3.0.jar;%APP_HOME%\lib\jersey-container-servlet-core-3.0.3.jar;%APP_HOME%\lib\jersey-container-jetty-http-3.0.3.jar;%APP_HOME%\lib\jersey-server-3.0.3.jar;%APP_HOME%\lib\jersey-hk2-3.0.3.jar;%APP_HOME%\lib\jakarta.servlet-api-5.0.0.jar;%APP_HOME%\lib\jetty-webapp-11.0.6.jar;%APP_HOME%\lib\jetty-servlet-11.0.6.jar;%APP_HOME%\lib\jetty-security-11.0.6.jar;%APP_HOME%\lib\jetty-server-11.0.6.jar;%APP_HOME%\lib\slf4j-simple-2.0.0-alpha5.jar;%APP_HOME%\lib\jakarta.activation-api-1.2.1.jar;%APP_HOME%\lib\policy-2.7.2.jar;%APP_HOME%\lib\gmbal-api-only-3.1.0-b001.jar;%APP_HOME%\lib\mimepull-1.9.7.jar;%APP_HOME%\lib\woodstox-core-asl-4.4.1.jar;%APP_HOME%\lib\stax2-api-3.1.4.jar;%APP_HOME%\lib\resolver-20050927.jar;%APP_HOME%\lib\javax.xml.soap-api-1.4.0.jar;%APP_HOME%\lib\jsr181-api-1.0-MR1.jar;%APP_HOME%\lib\javax.annotation-api-1.3.jar;%APP_HOME%\lib\FastInfoset-1.2.13.jar;%APP_HOME%\lib\ha-api-3.1.9.jar;%APP_HOME%\lib\jersey-client-3.0.3.jar;%APP_HOME%\lib\jersey-common-3.0.3.jar;%APP_HOME%\lib\hk2-locator-3.0.1.jar;%APP_HOME%\lib\hk2-api-3.0.1.jar;%APP_HOME%\lib\hk2-utils-3.0.1.jar;%APP_HOME%\lib\jakarta.inject-api-2.0.0.jar;%APP_HOME%\lib\jersey-entity-filtering-3.0.3.jar;%APP_HOME%\lib\jakarta.ws.rs-api-3.0.0.jar;%APP_HOME%\lib\jetty-http-11.0.6.jar;%APP_HOME%\lib\jetty-io-11.0.6.jar;%APP_HOME%\lib\jetty-xml-11.0.6.jar;%APP_HOME%\lib\jetty-util-11.0.6.jar;%APP_HOME%\lib\jakarta.annotation-api-2.0.0.jar;%APP_HOME%\lib\jakarta.validation-api-3.0.0.jar;%APP_HOME%\lib\javassist-3.25.0-GA.jar;%APP_HOME%\lib\jackson-core-2.12.2.jar;%APP_HOME%\lib\jackson-module-jaxb-annotations-2.12.2.jar;%APP_HOME%\lib\jackson-databind-2.12.2.jar;%APP_HOME%\lib\jackson-annotations-2.12.2.jar;%APP_HOME%\lib\jetty-jakarta-servlet-api-5.0.2.jar;%APP_HOME%\lib\slf4j-api-2.0.0-alpha5.jar;%APP_HOME%\lib\management-api-3.0.0-b012.jar;%APP_HOME%\lib\osgi-resource-locator-1.0.3.jar;%APP_HOME%\lib\aopalliance-repackaged-3.0.1.jar;%APP_HOME%\lib\javax.activation-api-1.2.0.jar;%APP_HOME%\lib\stax-api-1.0-2.jar;%APP_HOME%\lib\txw2-2.3.0.jar;%APP_HOME%\lib\istack-commons-runtime-3.0.5.jar


@rem Execute api
"%JAVA_EXE%" %DEFAULT_JVM_OPTS% %JAVA_OPTS% %API_OPTS%  -classpath "%CLASSPATH%" mancala.App %*

:end
@rem End local scope for the variables with windows NT shell
if "%ERRORLEVEL%"=="0" goto mainEnd

:fail
rem Set variable API_EXIT_CONSOLE if you need the _script_ return code instead of
rem the _cmd.exe /c_ return code!
if  not "" == "%API_EXIT_CONSOLE%" exit 1
exit /b 1

:mainEnd
if "%OS%"=="Windows_NT" endlocal

:omega
