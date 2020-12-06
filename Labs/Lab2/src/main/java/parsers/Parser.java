package parsers;

import targetClasses.Orangery;

public interface Parser {
    Orangery parse(String xmlFilePath);
}
