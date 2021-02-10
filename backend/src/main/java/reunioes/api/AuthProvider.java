package reunioes.api;

import com.microsoft.graph.authentication.IAuthenticationProvider;
import com.microsoft.graph.http.IHttpRequest;

/**
 * SimpleAuthProvider
 */
// Add suppression here because IAuthenticationProvider
// has been marked deprecated, but is still the type expected
// by the GraphServiceClient
@SuppressWarnings( "deprecation" )
public class AuthProvider implements IAuthenticationProvider {

    private String accessToken = null;

    public AuthProvider(String accessToken) {
        this.accessToken = accessToken;
    }

    @Override
    public void authenticateRequest(IHttpRequest request) {
        // Add the access token in the Authorization header
        request.addHeader("Authorization", "Bearer " + accessToken);
    }
}
