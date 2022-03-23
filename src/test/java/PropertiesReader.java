import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesReader
{
    Properties prop;
    String  getProperty (String name)
    {
        return prop.getProperty(name);
    }
    PropertiesReader()
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
