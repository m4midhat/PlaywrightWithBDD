## Web Automation Framework BDD
### Tech Stack
- Java 17
- Playwright 1.34.0
- BDD/Cucumber
- Cluecucumber Reporting 2.3.4

[![](https://res.cloudinary.com/practicaldev/image/fetch/s--M3gPfKHX--/c_imagga_scale,f_auto,fl_progressive,h_420,q_auto,w_1000/https://dev-to-uploads.s3.amazonaws.com/uploads/articles/swetkwdnkxp39lkevjea.png)](https://res.cloudinary.com/practicaldev/image/fetch/s--M3gPfKHX--/c_imagga_scale,f_auto,fl_progressive,h_420,q_auto,w_1000/https://dev-to-uploads.s3.amazonaws.com/uploads/articles/swetkwdnkxp39lkevjea.png)

### Basic Information
1. This project is designed in POM designed pattern
2. All the page objects are available under the package "deriv.pages"
3. Feature files are available under the package "deriv.Features"
4. Runner file is available under package "deriv.runners"

### How to execute
Execute the runner file if you wish to execute all the features or execute the individual feature file in case you want to execute single scenario. If the runner file is executed then it will generate the *cucumber.json* file under the *target/cucmber-report*. Then execute the following command to get the html report:
> mvn cluecumber-report:reporting

html reprort will be generated under *target/generated-report/*. Open index.html report to view the amazing cluecumber report

[![](https://static1.smartbear.co/cucumber/media/images/blog/shareablereportssample.png)](https://static1.smartbear.co/cucumber/media/images/blog/shareablereportssample.png)