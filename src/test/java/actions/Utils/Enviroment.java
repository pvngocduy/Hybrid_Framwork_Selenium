package actions.Utils;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.Sources;
@Sources("classpath:${env}.properties")
public interface Enviroment extends Config {
    @Key("App.Url")
    String appUrl() ;
    @Key("App.User")
    String appUser();
    @Key("App.Password")
    String appPassword();
}
