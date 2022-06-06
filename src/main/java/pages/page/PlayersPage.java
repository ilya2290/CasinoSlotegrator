package pages.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.pageCore.PageCore;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class PlayersPage extends PageCore<PlayersPage> {

    public PlayersPage(WebDriver driver) {
        super(driver);
    }

    private final static By playersTable = By.xpath("//div[@id='payment-system-transaction-grid']");
    private final static By playersTableQuantityOfFields = By.xpath("//tbody//tr[@class='odd' or @class ='even']//td[@class='centered hide-mobile']");
    private final static By playersTableTitles = By.xpath("//thead//tr//.//th[@class or @id]");
    private final static By registrationDateTitleAtColumn = By.xpath("//th[@id='payment-system-transaction-grid_c9']//a");
    private final static By userRegistrationDate = By.xpath("//tr//child::td[10]");


    @Override
    protected PlayersPage self() {
        return this;
    }


    public PlayersPage checkPlayersTableAppears() {
        driver.findElement(explicitWaitOfElement(playersTable, 5)).isDisplayed();
        return this;
    }


    public PlayersPage checkUsersQuantityInOnePageByDefault() {
        List<WebElement> listOfQuantityFields;
        listOfQuantityFields = driver.findElements(explicitWaitOfElement(playersTableQuantityOfFields, 3));
        if (listOfQuantityFields.size() > 20) {
            System.out.println("Users quantity by default more than 20");
        }
        System.out.println('\n' + "Users quantity at one page : " + listOfQuantityFields.size() + '\n');
        return this;
    }


    public PlayersPage checkPlayersTablesTittlesAppears() {
        List<WebElement> listOfPlayersTableTittles = driver.findElements(playersTableTitles);
        List<String> listOfPlayersTableTittlesString = new ArrayList<>();
        for (WebElement listOfPlayersTableTittle : listOfPlayersTableTittles) {
            listOfPlayersTableTittlesString.add(listOfPlayersTableTittle.getText());
        }
        for (String s : listOfPlayersTableTittlesString) {
            if (s == null) {
                System.out.println(s + " :column is null" + '\n');
            } else System.out.println(s + " :column " + "is displayed");
        }
        return this;
    }


    public PlayersPage sortRegistrationDateByDesc() {
        driver.findElement(registrationDateTitleAtColumn).click();
        return this;
    }


    /**
     * This method checks that users Registration Date set by Desc.
     *
     * @return PlayersPage object.
     */
    public PlayersPage checkRegistrationDateIsDesc() {
        List<LocalDateTime> sortedByDescListByStream = parseRegistrationDateToLocalDateTime()
                .stream()
                .sorted()
                .collect(Collectors.toList());
        if (sortedByDescListByStream.equals(parseRegistrationDateToLocalDateTime())) {
            System.out.println("Registration date sorted by ASC." + '\n');
        } else System.out.println("Sorting Errors" + '\n');
        return this;
    }


    /**
     * This method parses users Registration Date from WebElement to LocalDateTime
     *
     * @return List<LocalDateTime> list object.
     */
    private List<LocalDateTime> parseRegistrationDateToLocalDateTime() {
        List<WebElement> listOfRegistrationDatesWebElement = driver.findElements(explicitWaitOfElement(userRegistrationDate, 2));
        List<String> listOfRegistrationDatesString = new ArrayList<>();
        List<LocalDateTime> localDateTimesList;
        for (int i = 1; i < listOfRegistrationDatesWebElement.size(); i++) {
            listOfRegistrationDatesString.add(listOfRegistrationDatesWebElement.get(i).getText().replaceAll("\\s+", "T"));
        }
        localDateTimesList = listOfRegistrationDatesString
                .stream()
                .map(LocalDateTime::parse)
                .collect(Collectors.toList());
        return localDateTimesList;
    }


    public void printParsedRegistrationDate() {
        System.out.println("Parsed date:" + '\n' + parseRegistrationDateToLocalDateTime());
    }
}
