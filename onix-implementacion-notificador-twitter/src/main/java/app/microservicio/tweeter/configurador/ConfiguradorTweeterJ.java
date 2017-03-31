package app.microservicio.tweeter.configurador;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;
import twitter4j.conf.ConfigurationBuilder;
  
@Configuration
public class ConfiguradorTweeterJ 
{
    

	
	@Bean
	public Twitter instanciaTweeter()
	{
		
		ConfigurationBuilder builder = new ConfigurationBuilder();
		builder.setOAuthConsumerKey("678KCIgcndU8OBTI3TooqjOYn");
		builder.setOAuthConsumerSecret("AxzQVuzlYL2SuDjWTLnUdf2hNK38sTF0SY4kE4afiPRHFW0Ti4");
		builder.setDebugEnabled(true);
		builder.setPrettyDebugEnabled(true);
		twitter4j.conf.Configuration configuration = builder.build();
		Twitter twitter = new TwitterFactory(configuration).getInstance();
		//#yago_oz
		AccessToken accessToken = new AccessToken("732783638031568897-b3yIFYaaJdbUjreP2NxDPwP2YeXnFz7", "nkbPeqgwJ8Xq0vVlOhFylVilMVA7VFSPkcZ8mGhB400iQ");
		//#_yago_Deoz
		//AccessToken accessToken = new AccessToken("732783638031568897-Zz5VaLco4nZlza9V5N1twgrlvJQp6vP", "A3yCLRhgYQjpqUzUxvm4PagIh9eSZGW2NSOcDy5poMUip");
		twitter.setOAuthAccessToken(accessToken);
		return twitter;
	}
}
