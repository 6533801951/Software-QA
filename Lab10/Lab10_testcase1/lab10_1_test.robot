*** Settings ***
Library	SeleniumLibrary
Suite Setup         Setup Browser
Suite Teardown      Close Browser

*** Variables ***
${CHROME_BROWSER_PATH}	C:/work/softQA/robot/chromefortesting/chrome.exe
${CHROME_DRIVER_PATH}	C:/work/softQA/robot/chromefortesting/chromedriver.exe
${URL}	http://127.0.0.1:5500/Starterfiles/Starterfiles/Lab10/Registration.html
@{USER_1}   Somsri      Sodsai      CS KKU      somsri@kkumail.com      081-001-1234

*** Keywords ***
Setup Browser
    ${options}	Evaluate	sys.modules['selenium.webdriver'].ChromeOptions()		sys
	${options.binary_location}	Set Variable	${CHROME_BROWSER_PATH}
	${service}	Evaluate	sys.modules["selenium.webdriver.chrome.service"].Service(executable_path=r"""${CHROME_DRIVER_PATH}""")	sys
	Create Webdriver	Chrome	options=${options}	service=${service}

*** Test Cases ***
TC_001: Open Event Registration Page
	Go To    ${URL}   
    Title Should Be    Event Registration

TC_002: Register Success:
    Input Text      id=firstname        ${USER_1}[0]
    Input Text      id=lastname         ${USER_1}[1]
    Input Text      id=organization     ${USER_1}[2]
    Input Text      id=email            ${USER_1}[3]
    Input Text      id=phone            ${USER_1}[4]
    Click Button    id=registerButton
    Title Should Be     Success

TC_003: Open Event Registration Page
	Go To    ${URL}   
    Title Should Be    Event Registration

TC_004: Register Success No Organization Info
    Input Text        id=firstname        ${USER_1}[0]
    Input Text        id=lastname         ${USER_1}[1]
    Input Text        id=email            ${USER_1}[3]
    Input Text        id=phone            ${USER_1}[4]
    Click Button      id=registerButton
    Title Should Be     Success