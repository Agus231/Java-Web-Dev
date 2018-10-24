import edu.epam.second.entity.impl.TextComposite;
import edu.epam.second.parser.impl.TextParser;
import edu.epam.second.reader.TextReader;

public class Runner {
    public static void main(String[] args) {
        TextReader reader = new TextReader();
        TextParser parser = new TextParser();
        TextComposite textCompositeSortByLexicalUnits = parser.parseTextPart(reader.fileToString("./data/testSortLexicalUnits.txt"));
        System.out.println(textCompositeSortByLexicalUnits.operation());
    }
}
