  # Ninja Tutorials Hybrid Automation Framework (openartV121)
  
  A hybrid test automation framework built using **Java**, **Selenium**, **TestNG**, and **Page Object Model**, designed for automated testing of the **Ninja Tutorials demo website**.
  
  ---
  
  ## 🔧 Tech Stack
  
  - Java 17
  - Selenium WebDriver 4.20.0
  - TestNG
  - Maven
  - Apache POI (for Excel data)
  - Selenium Grid
  - GitHub
  
  ---
  
  ## 🚀 Key Features
  
  - Hybrid framework (Data-driven + POM)
  - TestNG with XML suite execution
  - Parallel and cross-browser execution
  - Dynamic local/remote execution with `config.properties`
  - Page Object Model for maintainable code
  - Screenshots on failure
  - HTML reports (TestNG default)
  
  ---
  
  ## 📁 Project Structure
  ---openartV121/
  ├── src/test/java/
  │ ├── base/
  │ ├── pageObjects/
  │ ├── testCases/
  │ └── utilities/
  ├── src/test/resources/
  │ ├── config.properties
  │ └── testdata.xlsx
  ├── testng.xml
  ├── pom.xml
  └── README.md---
  
  ## 🧪 How to Run the Tests
  
  ### ➤ Local Execution
  
  1. Make sure Java, Maven, and Chrome are installed.
  2. Update `config.properties`:
  execution=local
  browser=chrome
  baseURL=https://tutorialsninja.com/demo
  
  3. Run from terminal:
  ```bash
  mvn clean test
  ➤ Remote Execution (Selenium Grid)
  Make sure the Grid is running (hubURL available).
  
  Update config.properties:
  
  
  execution=remote
  hubURL=http://localhost:4444/wd/hub
  browser=edge
  baseURL=https://tutorialsninja.com/demo
  
  Then execute:
  mvn clean test
  📊 Reports
  TestNG HTML reports will be generated in the test-output/ folder after execution.
  
  Supports screenshot capture on test failure.
  
  Easily integrable with Allure or ExtentReports.
  
  🙋 Author
  Syed Md Sadiq
  🔗 LinkedIn Profile
  📧 www.linkedin.com/in/s-md-sadiq
  
  ⭐ Support
  If you found this useful, feel free to ⭐ this repository and share it with fellow QA professionals.
  
  🤝 Contributions
  Feedback and pull requests are welcome!
  If you'd like to suggest improvements, feel free to raise an issue or fork and contribute.
  
  ---
  
  ### ✅ Final Step
  
  1. Paste the above into your open `README.md`
  2. Click **"Commit changes"**
  3. Done — your GitHub project is now clean, professional, and recruiter-ready 🎯
  
  ---
  
  Would you like me to now:
  - Write a **LinkedIn post** you can copy-paste to promote it?
  - Suggest hashtags and best posting time?
  
  Just say the word!
  
  
  
  
  
  
  
  
  
  
  
