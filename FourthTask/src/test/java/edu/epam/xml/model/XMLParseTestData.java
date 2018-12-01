package edu.epam.xml.model;

import edu.epam.xml.model.entity.Candy;
import edu.epam.xml.model.entity.ChocolateCandy;
import edu.epam.xml.model.entity.SimpleCandy;
import edu.epam.xml.model.entity.Ingredients;
import edu.epam.xml.model.entity.Values;
import org.testng.annotations.DataProvider;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.Set;

public class XMLParseTestData {
    @DataProvider(name = "dataParsedCount")
    public static Object[][] dataParsedCount(){
        return new Object[][]{
                {"SAX", 3},
                {"StaX", 3},
                {"DOM", 3}
        };
    }

    @DataProvider(name = "dataParsedEquality")
    public static Object[][] dataParsedEquality() throws ParseException {
        SimpleCandy firstCnady = new SimpleCandy(){
            {
                setCandyId("Candy1");
                setType(SimpleCandyType.CARAMEL);
                setName("FirstCandy");
                setEnergy(42);
                setValues(new Values(){
                    {
                        setFats(42);
                        setStarches(42);
                        setProteins(42);
                    }
                });
                setIngredients(new Ingredients(){
                    {
                        setFructose(42);
                        setSugar(42);
                        setVanilla(42);
                        setWater(42);
                    }
                });
                setProduction("Komunarka");
                setProducedDate(new SimpleDateFormat("yyyy-MM-dd").parse("2002-12-24"));
            }
        };

        ChocolateCandy secondCandy = new ChocolateCandy(){
            {
                setCandyId("Candy2");
                setType(ChocolateCandyType.CHOCOLATE);
                setName("SecondCandy");
                setEnergy(10);
                setValues(new Values(){
                    {
                        setFats(10);
                        setStarches(10);
                        setProteins(10);
                    }
                });
                setIngredients(new Ingredients(){
                    {
                        setFructose(10);
                        setSugar(10);
                        setVanilla(10);
                        setWater(10);
                    }
                });
                setProduction("Komunarka");
                setProducedDate(new SimpleDateFormat("yyyy-MM-dd").parse("2010-11-18"));
                setChocolateType("dark");
            }
        };

        ChocolateCandy thirdCandy = new ChocolateCandy(){
            {
                setCandyId("Candy3");
                setType(ChocolateCandyType.CHOCOLATE_WITH_FILLING);
                setName("ThirdCandy");
                setEnergy(5);
                setValues(new Values(){
                    {
                        setFats(5);
                        setStarches(5);
                        setProteins(5);
                    }
                });
                setIngredients(new Ingredients(){
                    {
                        setFructose(5);
                        setSugar(5);
                        setVanilla(5);
                        setWater(5);
                    }
                });
                setProduction("Spartak");
                setProducedDate(new SimpleDateFormat("yyyy-MM-dd").parse("2014-11-15"));
                setChocolateType("white");
            }
        };

        Set<Candy> set = new HashSet<Candy>(){
            {
                add(firstCnady);
                add(secondCandy);
                add(thirdCandy);
            }
        };

        return new Object[][]{
                {"SAX", set},
                {"StaX", set},
                {"DOM", set}
        };
    }
}
