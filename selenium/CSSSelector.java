//Primeri za nalazenje elementa po CSS Selektoru
WebElement firstName = driver.findElement(By.cssSelector("input[name='firstname']"));
WebElement submit = driver.findElement(By.cssSelector("form[action='https://www.ultimateqa.com'] input[type='submit']"));