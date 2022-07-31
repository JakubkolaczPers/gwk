package pl.edu.wszib.gwk;

import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.edu.wszib.gwk.repositories.SessionRepository;
import pl.edu.wszib.gwk.service.GameService;
import pl.edu.wszib.gwk.service.MoneyService;
import pl.edu.wszib.gwk.service.impl.GameServiceImpl;

import static org.mockito.Mockito.mock;

@RequiredArgsConstructor
public class GameServiceTest {

    @Test
    public void shouldReturnGame() {
        //given
        GameServiceImpl gameService = new GameServiceImpl(mock(MoneyService.class), mock(SessionRepository.class));
        //when
        int result = gameService.startGame(1, 1);
        //then
        Assertions.assertNotNull(result);
    }
}
