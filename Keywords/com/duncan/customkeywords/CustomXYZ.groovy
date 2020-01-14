package com.duncan.customkeywords

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import internal.GlobalVariable

public class CustomXYZ {
	/**
	 * Get all rows of HTML table
	 * @param table Katalon test object represent for HTML table
	 * @param outerTagName outer tag name of TR tag, usually is TBODY
	 * @return All rows inside HTML table
	 */
	@Keyword
	def List<WebElement> getHtmlTableRows(TestObject table, String outerTagName) {
		WebElement mailList = WebUiBuiltInKeywords.findWebElement(table)
		List<WebElement> selectedRows = mailList.findElements(By.xpath("./tr"))
		return selectedRows
	}

	/**
	 * Delete a specific Flight given the first name and last name
	 * @param table
	 * @param firstName
	 * @param lastName
	 * @return
	 */
	@Keyword
	def clickDeleteLink(TestObject table, String firstName, String lastName) {
		List<WebElement> selectedRows = getHtmlTableRows(table, "TBODY")

		int i = 0;
		for (WebElement z : selectedRows) {
			i = i + 1
		}
		println("i = " + i)
		println("firstName = " + firstName)
		println("lastName = " + lastName)
		println("")

		for (WebElement x : selectedRows) {

			println("===========")
			println(x.findElement(By.id("firstName")).text())
			println(x.findElement(By.id("lastName")).text())

			if (x.findElement(By.id("firstName")).equals(firstName)) {
				if (x.findElement(By.id("lastName")).equals(lastName)) {
					x.findElement(By.id("delete")).click()
				}
			}
		}
	}

	@Keyword
	def customKeywordPrintHello() {
		println("==============================================")
		println("==============================================")
		println("==============================================")
		println("Custom Keyword is printing")
		println("==============================================")
		println("==============================================")
		println("==============================================")
	
}
