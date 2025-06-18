package br.com.Investimento.agregadorinvestimentos.service;

import br.com.Investimento.agregadorinvestimentos.controller.dto.CreateAccountDto;
import br.com.Investimento.agregadorinvestimentos.controller.dto.CreaterUserDto;
import br.com.Investimento.agregadorinvestimentos.controller.dto.UpdateUserDto;
import br.com.Investimento.agregadorinvestimentos.entity.Account;
import br.com.Investimento.agregadorinvestimentos.entity.BillingAddress;
import br.com.Investimento.agregadorinvestimentos.entity.User;
import br.com.Investimento.agregadorinvestimentos.repository.AccountRepository;
import br.com.Investimento.agregadorinvestimentos.repository.BillingAddressRepository;
import br.com.Investimento.agregadorinvestimentos.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Service
public class UserService {

    private UserRepository userRepository;
    private AccountRepository accountRepository;
    private BillingAddressRepository billingAddressRepository;

    public UserService(UserRepository userRepository, AccountRepository accountRepository, BillingAddressRepository billingAddressRepository) {
        this.userRepository = userRepository;
        this.accountRepository = accountRepository;
        this.billingAddressRepository = billingAddressRepository;
    }

    public User createUserAndReturnUser(CreaterUserDto createrUserDto) {
        var entity = new User(
                createrUserDto.username(),
                createrUserDto.email(),
                createrUserDto.password(),
                Instant.now(),
                null
        );
        return userRepository.save(entity);
    }


    public Optional<User> getUserById (String userId){

       return userRepository.findById(UUID.fromString(userId));
    }

    public List<User> listUsers() {
        return userRepository.findAll();
    }

    public void updateUserById (String userId,
                                UpdateUserDto updateUserDto) {
        var id = UUID.fromString(userId);
        var userEntity = userRepository.findById(id);

        if (userEntity.isPresent()) {
            var user = userEntity.get();

            if (updateUserDto.username() != null) {
                user.setUsername(updateUserDto.username());
            }

            if (updateUserDto.password() != null) {
                user.setPassword(updateUserDto.password());
            }
            userRepository.save(user);
        }

    }

    public void deleteById(String userId) {
        var id = UUID.fromString(userId);
        var userExists = userRepository.existsById(id);

        if (userExists) {
            userRepository.deleteById(id);
        }
    }

    public void createAccount(String userId, CreateAccountDto createAccountDto) {

       var user = userRepository.findById(UUID.fromString(userId))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

       var account = new Account(
               UUID.randomUUID(),
               createAccountDto.description(),
               user,
               null,
               new ArrayList<>()
       );
        var accountCreated = accountRepository.save(account);

        var billingAddress = new BillingAddress(
             account, createAccountDto.street(), createAccountDto.number()
        );

        billingAddressRepository.save(billingAddress);

    }
}
