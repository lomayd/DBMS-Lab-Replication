package lomayd.DBMSLabReplication.api.domain.user.service;

import lomayd.DBMSLabReplication.api.domain.user.User;
import lomayd.DBMSLabReplication.api.domain.user.dto.UserRequestDto;
import lomayd.DBMSLabReplication.api.domain.user.dto.UserResponseDto;
import lomayd.DBMSLabReplication.api.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class UserService {

    private final UserRepository userRepository;

    public void joinUser(UserRequestDto.UserJoin userJoin){
        User user = User.builder()
                .id(userJoin.getId())
                .password(userJoin.getPassword())
                .name(userJoin.getName())
                .nickname(userJoin.getNickname())
                .email(userJoin.getEmail())
                .age(userJoin.getAge())
                .build();

        userRepository.save(user);

        log.info("INSERT - {}", user.getId());
    }

    @Transactional(readOnly = true)
    public UserResponseDto.UserInfo getUser(String id) {
        User user = userRepository.findById(id).get();

        log.info("SELECT - {}", user.getId());

        return UserResponseDto.UserInfo.of(user);
    }

    public void modifyUser(String id, UserRequestDto.UserModify userModify) {
        User user = userRepository.findById(id).get();

        user.setPassword(userModify.getPassword());
        user.setName(userModify.getName());
        user.setNickname(userModify.getNickname());
        user.setEmail(userModify.getEmail());
        user.setAge(userModify.getAge());

        userRepository.save(user);

        log.info("UPDATE - {}", user.getId());
    }

    public void removeUser(String id) {
        userRepository.deleteById(id);

        log.info("DELETE - {}", id);
    }
}