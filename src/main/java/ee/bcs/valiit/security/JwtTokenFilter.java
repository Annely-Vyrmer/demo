package ee.bcs.valiit.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

//Loo JWT filter
public class JwtTokenFilter extends GenericFilterBean {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        String token = resolveToken((HttpServletRequest) servletRequest);
        if (token != null) {
            Authentication authentication = validateToken(token);
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }

    //Implement resolveToken
    private String resolveToken(HttpServletRequest servletRequest) {
        String attribute = servletRequest.getHeader("Authorization");
        if (attribute == null) {
            return null;
        }
        if (attribute.startsWith("Bearer ")) {
            return attribute.substring(7);  //hack: 7 tähendab BEARER+tühik, kokku 7 kohta + Korista BEARER+tühik eest ära
        }
        return attribute;
    }
    //password on verySecretPassword, mis on base64 encode-tud
    //Implement validateToken method
    private Authentication validateToken(String token) {
        Claims claims = Jwts.parser().setSigningKey("dmVyeVNlY3JldFBhc3N3b3Jk").parseClaimsJws(token).getBody();    //Valideerime, et kasutaja on valiidne
        List<GrantedAuthority> authorityList = new ArrayList<>();   //õiguste list
        authorityList.add(new SimpleGrantedAuthority("ROLE_USER")); //Kasutaja uue rollide list
        UserDetails userDetails = new User((String) claims.get("username"), "", authorityList); //Teeme uue kasutaja + lugeda Tokenist välja, mis on tema username
        return new UsernamePasswordAuthenticationToken(userDetails, "", userDetails.getAuthorities());  //info Spirngi jaoks - kasutaja kohta, kes sisse logis
    }
}
