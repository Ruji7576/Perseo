package Technical.perseo.service;

import Technical.perseo.model.ERole;
import Technical.perseo.model.User;
import Technical.perseo.repository.IUserRepository;
import Technical.perseo.dtos.request.LoginRequest;
import Technical.perseo.dtos.request.RegisterRequest;
import Technical.perseo.dtos.response.AuthResponse;
import Technical.perseo.model.ERole;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final JwtService jwtService;
    private final IUserRepository iUserRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    public AuthResponse login(LoginRequest login) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(login.getUsername(), login.getPassword()));
        UserDetails user = iUserRepository.findByUsername(login.getUsername()).orElseThrow(() -> new RuntimeException("User not found"));
        String token = jwtService.getTokenService(user);
        return AuthResponse.builder()
                .token(token)
                .build();
    }

    public AuthResponse register(RegisterRequest register) {
        ERole role = (register.getRole() != null) ? register.getRole() : ERole.USER;

        User user = User.builder()
                .username(register.getUsername())
                .email(register.getEmail())
                .password(passwordEncoder.encode(register.getPassword()))
                .role(role)
                .build();

        iUserRepository.save(user);

        String token = jwtService.getTokenService(user);

        return AuthResponse.builder()
                .token(token)
                .role(role)
                .build();
    }
}
