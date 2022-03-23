package hooks;

import pageObject.AuthorizationPage;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesReader
{
    Properties prop;
    public String getProperty (String name)
    {
        return prop.getProperty(name);
    }
    public PropertiesReader()
    {
        try (InputStream input = AuthorizationPage.class.getClassLoader().getResourceAsStream("application.properties"))
        {
            prop = new Properties();
            prop.load(input);
        }
        catch (IOException ex)
        {
            ex.printStackTrace();
        }
    }
}
