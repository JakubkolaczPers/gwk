package pl.edu.wszib.gwk;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.edu.wszib.gwk.model.User;
import pl.edu.wszib.gwk.repositories.UserRepository;
import pl.edu.wszib.gwk.service.SessionService;
import pl.edu.wszib.gwk.service.impl.UserServiceImpl;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class UserServiceTest {

    @Test
    public void shouldRegisteredUser() {
        //given
        UserRepository userRepository = mock(UserRepository.class);
        UserServiceImpl userService = new UserServiceImpl(userRepository, mock(SessionService.class));
        User build = User.builder()
                .balance(10)
                .build();

        //when
        when(userRepository.save(new User())).thenReturn(build);

       userService.registerUser("test", "Password1", "test@ttest.com", "1287351123", "111", 10, "true");

        //then
        Assertions.assertEquals( 10, build.getBalance());
    }

    @Test
    public void shouldReturnNullWhenAuthenticationFailed(){
        //given
        UserRepository userRepository = mock(UserRepository.class);
        UserServiceImpl userService = new UserServiceImpl(userRepository, mock(SessionService.class));

        //when:
        User test = userService.authenticate("test", null);

        //then
        Assertions.assertNull(test);
    }
}
