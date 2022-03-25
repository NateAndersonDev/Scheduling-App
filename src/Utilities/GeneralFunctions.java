package Utilities;

import javafx.scene.control.Alert;

/**
 * Alert utility functions.
 */
public class GeneralFunctions {
    /**
     * Passes in a title and header string to display them as an error.
     * @param Title title of the error
     * @param Header header of the error
     */
    public void alertError(String Title, String Header) {
        Alert general = new Alert(Alert.AlertType.ERROR);
        general.setTitle(Title);
        general.setHeaderText(Header);
        general.show();
    }
    /*
    WRITE SOME FUNCTION TO GET CONTACT ID FROM CONTACT NAME
    public long getContactID(String contactName)
    }

    WRITE SOME FUNCTION TO GET CONTACT NAME FROM CONTACT ID

    Function that takes First and Second level country data and turn it into a Division ID & Vice Versa.

    Functions that converts between all the timezones. UTC -> Local, UTC -> Eastern, System -> UTC etc.
    This will save you lots of time and headache. Make these, test these and you will save the hardest part of your project.
    Use LocalDateTime objects and ZoneID’s to do this. There are resources online.
 */

}