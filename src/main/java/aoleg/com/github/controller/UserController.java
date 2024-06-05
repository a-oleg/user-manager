package aoleg.com.github.controller;

import com.example.api.UsersApi;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.NativeWebRequest;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class UserController implements UsersApi {
    private final NativeWebRequest request;

    public UserController(NativeWebRequest request) {
        this.request = request;
    }

    public Optional<NativeWebRequest> getRequest() {
        return Optional.ofNullable(request);
    }
}
