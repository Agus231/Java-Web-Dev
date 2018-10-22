import edu.epam.second.action.TextAction;
import edu.epam.second.entity.impl.TextComposite;
import edu.epam.second.exception.TextException;
import edu.epam.second.parser.impl.TextParser;
import edu.epam.second.reader.TextReader;
import org.testng.annotations.BeforeSuite;

public class Runner {
    public static void main(String[] args) {
        TextReader reader = new TextReader();
        TextParser parser = new TextParser();

        /*TextComposite textCompositeSortByParagraph = parser.parseTextPart(reader.fileToString("./data/testSortParagraphs.txt"));
        System.out.println(textCompositeSortByParagraph.operation());
*/
        String text = reader.fileToString("./data/input.txt");
        TextComposite textComposite = parser.parseTextPart(text);

        TextAction action = TextAction.getInstance();
        try {
            TextComposite textSorted = action.sortWords(textComposite);
            System.out.println(textSorted.operation());
        } catch (TextException e) {
            e.printStackTrace();
        }
        System.out.println(textComposite.operation());
    }
}
