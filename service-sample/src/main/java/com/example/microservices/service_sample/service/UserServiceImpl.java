package com.example.microservices.service_sample.service;

import com.example.microservices.service_sample.entity.User;
import com.example.microservices.service_sample.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.xml.bind.ValidationException;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeoutException;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public User saveUser(User usersDto) throws ValidationException, TimeoutException {
        return null;
    }

    @Override
    public void deleteUser(Integer userId) {

    }

    @Override
    public User findByLogin(String login) {
        return null;
    }

    public Optional<User> findById(Integer id) {
        return userRepository.findById(id);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }


/*    @Override
    @Transactional
    public UserDto saveUser(@NotNull UserDto userDto) throws ValidationException, TimeoutException {
        // Проверяем введенные данные на корректность
        validateUserDto(userDto);

        // Отправляем данные во внешнюю систему на проверку и ждем ответа
        if (nonNull(messagingService.doRequest(new Message<>(userDto)))) {
            // Если все успешно создаем пользователя и сохраняем в БД
            User convertedUser = userConverter.fromUserDtoToUser(userDto);
            User savedUser = userRepository.save(convertedUser);
            // И отправляем письмо пользователю
            EmailAddress toAddress = new EmailAddress(userDto.getEmail());
            EmailContent messageBody = new EmailContent("Поздравляем с успешной регистрацией");
            sendMailerStub.sendMail(toAddress, messageBody);
            return userConverter.fromUserToUserDto(savedUser);
        }
        // В случае не успешной проверки ничего не возращаем
        return null;
    }

    @Override
    public void deleteUser(Integer userId) {
        userRepository.deleteById(userId);
    }

    @Override
    public UserDto findByLogin(String login) {
        User user = userRepository.findByLogin(login);
        if (user != null) {
            return userConverter.fromUserToUserDto(user);
        }
        return null;
    }

    @Override
    public List<UserDto> findAll() {
        return userRepository.findAll()
                .stream()
                .map(userConverter::fromUserToUserDto)
                .collect(Collectors.toList());
    }

    private void validateUserDto(UserDto userDto) throws ValidationException {
        if (isNull(userDto)) {
            throw new ValidationException("Object user is null");
        }
        if (isNull(userDto.getLogin()) || userDto.getLogin().isEmpty()) {
            throw new ValidationException("Login is empty");
        }
        if (isNull(userDto.getPassword()) || userDto.getPassword().isEmpty()) {
            throw new ValidationException("Password is empty");
        }
        if (nonNull(userRepository.findByLogin(userDto.getLogin()))) {
            throw new ValidationException("Login already exists");
        }
        if (isNull(userDto.getName()) || isNull(userDto.getSurname())) {
            throw new ValidationException("Name or Surname is empty");
        }
        if (isNull(userDto.getEmail())) {
            throw new ValidationException("Email is empty");
        }
        if (!userDto.getEmail().matches("[_a-zA-Z1-9]+(\\.[A-Za-z0-9]*)*@[A-Za-z0-9]+\\.[A-Za-z0-9]+(\\.[A-Za-z0-9]*)*")) {
            throw new ValidationException("Email is not correct");
        }
    }*/
}