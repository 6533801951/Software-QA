*** Settings ***
Library	SeleniumLibrary
Suite Setup         Setup Browser
Suite Teardown      Close Browser

*** Variables ***
${CHROME_BROWSER_PATH}	C:/work/softQA/robot/chromefortesting/chrome.exe
${CHROME_DRIVER_PATH}	C:/work/softQA/robot/chromefortesting/chromedriver.exe
${URL}	http://127.0.0.1:5500/Starterfiles/Starterfiles/Lab10/Registration.html
@{USER_1}   Somsri      Sodsai      CS KKU      somsri@kkumail.com      081-001-1234        1234

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

TC_002: Empty First Name:
    Input Text      id=lastname         ${USER_1}[1]
    Input Text      id=organization     ${USER_1}[2]
    Input Text      id=email            ${USER_1}[3]
    Input Text      id=phone            ${USER_1}[4]
    Click Button    id=registerButton
    Title Should Be     Event Registration
    Element Should Contain    id=errors       Please enter your first name

TC_003: Open Event Registration Page
	Go To    ${URL}   
    Title Should Be    Event Registration

TC_004: Empty Last Name:
    Input Text      id=firstname        ${USER_1}[0]
    Input Text      id=organization     ${USER_1}[2]
    Input Text      id=email            ${USER_1}[3]
    Input Text      id=phone            ${USER_1}[4]
    Click Button    id=registerButton
    Title Should Be     Event Registration
    Element Should Contain       id=errors     Please enter your last name

TC_005: Open Event Registration Page
	Go To    ${URL}   
    Title Should Be    Event Registration

TC_006: Empty Email:
    Input Text      id=firstname        ${USER_1}[0]
    Input Text      id=lastname         ${USER_1}[1]
    Input Text      id=organization     ${USER_1}[2]
    Input Text      id=phone            ${USER_1}[4]
    Click Button    id=registerButton
    Title Should Be     Event Registration
    Element Should Contain     id=errors     Please enter your email

TC_007: Open Event Registration Page
	Go To    ${URL}   
    Title Should Be    Event Registration

TC_008: Empty Email:
    Input Text      id=firstname        ${USER_1}[0]
    Input Text      id=lastname         ${USER_1}[1]
    Input Text      id=organization     ${USER_1}[2]
    Input Text      id=email            ${USER_1}[3]
    Click Button    id=registerButton
    Title Should Be     Event Registration
    Element Should Contain    id=errors   Please enter your phone number

TC_009: Open Event Registration Page
	Go To    ${URL}   
    Title Should Be    Event Registration

TC_010: Invalid Phone Number:
    Input Text      id=firstname        ${USER_1}[0]
    Input Text      id=lastname         ${USER_1}[1]
    Input Text      id=organization     ${USER_1}[2]
    Input Text      id=email            ${USER_1}[3]
    Input Text      id=phone            ${USER_1}[5]
    Click Button    id=registerButton
    Title Should Be     Event Registration
    Element Should Contain     id=errors     Please enter a valid phone number, e.g., 081-234-5678, 081 234 5678, or 081.234.5678)
