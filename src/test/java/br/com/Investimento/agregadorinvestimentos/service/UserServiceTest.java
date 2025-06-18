package br.com.Investimento.agregadorinvestimentos.service;

import br.com.Investimento.agregadorinvestimentos.controller.dto.CreaterUserDto;
import br.com.Investimento.agregadorinvestimentos.repository.UserRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {
    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @Nested
    class createUserAndReturnUser {
        @Test
        @DisplayName("Should create a user with success")
        void shouldCreateAUserWithSuccess() {

                doReturn(null).when(userRepository).save(any());
                var input = new CreaterUserDto(
                        "Pedro test",
                        "test@gmail.com",
                        "123");

                userService.createUserAndReturnUser(input);
            }

        }

    }


