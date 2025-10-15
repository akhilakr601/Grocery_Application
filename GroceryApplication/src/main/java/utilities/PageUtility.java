package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class PageUtility {
	public void selectDropdownWithValue(WebElement element, String value) {

		Select object = new Select(element);
		object.selectByValue(value);

	}

	public void clickElement(WebElement element) {

		element.click();
	}

	public void typeText(WebElement element, String textToEnter) {
		element.clear();
		element.sendKeys(textToEnter);
	}

	public String getElementText(WebElement element) {
		return element.getText();
	}

	public void rightClick(WebDriver driver, WebElement element) {

		Actions action = new Actions(driver);
		action.contextClick(element).build().perform();

	}

	public void mouseOver(WebDriver driver, WebElement element) {

		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();

	}

	public void dragAndDropAnElement(WebDriver driver, WebElement dragElement, WebElement dropElement) {

		Actions action = new Actions(driver);
		action.dragAndDrop(dragElement, dropElement).build().perform();

	}

	public boolean isCheckboxSelected(WebElement checkbox) {

		return checkbox.isSelected();
	}

	public void selectCheckBox(WebElement checkbox) {

		if (!isCheckboxSelected(checkbox)) {
			checkbox.click();

		}
	}

	public void deselectCheckbox(WebElement checkbox) {
		if (isCheckboxSelected(checkbox)) {
			checkbox.click();

		}
	}

	public boolean isRadioButtonSelected(WebElement radioButton) {
		return radioButton.isSelected();
	}

	public void selectRadioButton(WebElement radioButton) {
		if (!isRadioButtonSelected(radioButton)) {
			radioButton.click();

		}
	}
}
