AUTOMATION TASK:

Main goal:
•	Write infrastructure to enable UI testing via selenium these 2 scenarios.
•	The tests should be written in Java

Scenario 1:
•	Open the following page: https://www.kmslh.com/automation-test/
•	Fill all the relevant information with random valid values
•	Submit
•	Confirmation the submit was successful

Scenario 2:
•	Open the following page: https://www.kmslh.com/automation-test/
•	on the redirected page, wait for the popup and click copy link button
•	open the copied link.
•	verify GE Healthcare: A KMS Lighthouse Success Story video is opened.


SOLUTIONS:

The implementation of the first task in the ScenarioFirstTest . 
Confirmation - the text ("Thank you for singing up! 
We will be in touch with you shortly.") is on the page.

The implementation of the second task in the ScenarioSecondTest. 
Confirmation - the text ("GE Healthcare: A KMS Lighthouse Success Story") is under the video.

Pages loaded slowly, so high wait values are set.