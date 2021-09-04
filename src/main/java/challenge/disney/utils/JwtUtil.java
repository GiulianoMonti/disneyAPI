//package challenge.disney.utils;
//
//import io.jsonwebtoken.Claims;
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.SignatureAlgorithm;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.stereotype.Service;
//import java.util.Date;
//import java.util.HashMap;
//import java.util.Map;
//import java.util.function.Function;
//
//// koushik java brains..
//
//@Service
//public class JwtUtil {
//
//    private final String SECRET_KEY = "secret";
//
//    public String extractUsername(String token) {
//
//        return extractClaim(token, Claims::getSubject);
//
//    }
//
//    public Date extractExpiration(String token) {
//
//        return extractClaim(token, Claims::getExpiration);
//
//    }
//
//    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
//
//        final Claims claims = extractAllClaims(token);
//        return claimsResolver.apply(claims);
//
//    }
//    private Claims extractAllClaims(String token) {
//
//        return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();
//
//    }
//
//    private Boolean isTokenExpired(String token) {
//
//        return extractExpiration(token).before(new Date());
//
//    }
//
//    public String generateToken(UserDetails userDetails) {
//
//        Map<String, Object> claims = new HashMap<>();
//        return createToken(claims, userDetails.getUsername());
//
//    }
//
//    private String createToken(Map<String, Object> claims, String subject) {
//
//        int EXPIRATION_TIME = 60000 * 30; //Token expires in 30 minutes
//
//        return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis()))
//                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
//                .signWith(SignatureAlgorithm.HS256, SECRET_KEY).compact();
//
//    }
//
//    public Boolean validateToken(String token, UserDetails userDetails) {
//
//        final String username = extractUsername(token);
//        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
//
//    }
//
//}