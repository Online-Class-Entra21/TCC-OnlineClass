package reunioes.api;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.IOException;
import java.text.ParseException;
import java.util.Properties;

import com.microsoft.graph.logger.DefaultLogger;
import com.microsoft.graph.logger.LoggerLevel;
import com.microsoft.graph.models.extensions.IGraphServiceClient;
import com.microsoft.graph.models.extensions.OnlineMeeting;
import com.microsoft.graph.models.extensions.User;
import com.microsoft.graph.requests.extensions.GraphServiceClient;
import com.microsoft.graph.serializer.CalendarSerializer;

/**
 * Classe para testes da api graph
 *
 */
public class App {
    public static void main(String[] args) throws ParseException {
        System.out.println("Java Graph Tutorial");
        System.out.println();
        final Properties oAuthProperties = new Properties();
        try {
            oAuthProperties.load(App.class.getResourceAsStream("oAuth.properties"));
        } catch (IOException e) {
            System.out.println("Unable to read OAuth configuration. Make sure you have a properly formatted oAuth.properties file. See README for details.");
            return;
        }

        final String appId = oAuthProperties.getProperty("app.id");
        final String[] appScopes = oAuthProperties.getProperty("app.scopes").split(",");
        Authentication.initialize(appId);
        String acessToken = Authentication.getUserAccessToken(appScopes);
        AuthProvider authProvider = new AuthProvider(acessToken);
        // Build a Graph client
        IGraphServiceClient graphClient = GraphServiceClient.builder().authenticationProvider(authProvider).buildClient();
        OnlineMeeting onlineMeeting = new OnlineMeeting();
        onlineMeeting.subject = "User Token Meeting";

        graphClient.me().onlineMeetings()
            .buildRequest()
            .post(onlineMeeting);
    }
}