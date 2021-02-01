package reunioes.api;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

public class GeradorToken {
	private static Algorithm algoritimo = Algorithm.HMAC256("senhaforte");
	
	public static String gerarToken(){
	    Algorithm algorithm = Algorithm.HMAC256("secret");
	    String token = JWT.create().withIssuer("jitsi").sign(algoritimo);
	    return token;
	}
	
}
