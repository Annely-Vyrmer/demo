package ee.bcs.valiit.Controller;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class LoginController {
    //Selle pihta teeme päringuid
    //Postmanis Bodys username ja password - tagastab tokeni
    //@GetMapping("/api/public/login")                                              //2 ühesugust Mapiingut ühesama URLiga
    public String login(@RequestBody LoginRequest loginRequest){                    //RequestBody eraldi Class
        Date today = new Date();
        Date tokenExpirationDate = new Date (today.getTime() + 1000*60*60*24);      //Login kehtib 24h; 1000millisekundit*60*60*24 on kokku 1 ööpäev
        JwtBuilder jwtBuilder = Jwts.builder()                                      //Tokeni genereerimine
                .setExpiration(tokenExpirationDate)                                 //kehtivus
                .setIssuedAt(new Date())                                            //issued täna ja praegu
                .signWith(SignatureAlgorithm.HS256, "dmVyeVNlY3JldFBhc3N3b3Jk")  //allkirjastada parooliga HS256 algorütm+parool sama, mis TokenFiltris
                .claim("username", loginRequest.getUsername());
        return jwtBuilder.compact();                                                //tagastame jwtBuilderi Tokeni
    }
}
