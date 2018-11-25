package edu.epam.xml.model.parser;

import edu.epam.xml.model.exception.CustomParsingXMLException;
import edu.epam.xml.model.entity.Candy;

import java.io.InputStream;
import java.util.HashSet;
import java.util.Set;

public abstract class AbstractCandyBuilder {
    protected Set<Candy> candies;

    public AbstractCandyBuilder(){
        candies = new HashSet<>();
    }

    public Set<Candy> getCandies() {
        return candies;
    }

    abstract public void buildSetCandies(InputStream inputStream) throws CustomParsingXMLException;
}
