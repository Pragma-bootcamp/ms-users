package com.pragma.users.domain.usecase;

import com.pragma.users.domain.api.IUserServicePort;
import com.pragma.users.domain.constant.CodeStatus;
import com.pragma.users.domain.constant.ErrorMessage;
import com.pragma.users.domain.constant.UserConstant;
import com.pragma.users.domain.exception.UserException;
import com.pragma.users.domain.model.User;
import com.pragma.users.domain.spi.IUserPersistentPort;
import com.pragma.users.domain.utils.ApiResponseFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;

public class UserUseCase implements IUserServicePort {
    private final IUserPersistentPort userPersistentPort;

    public UserUseCase(IUserPersistentPort userPersistentPort) {
        this.userPersistentPort = userPersistentPort;
    }

    @Override
    public ApiResponseFormat<User> saveUser(User user) {
        validateUser(user);
        user.setCreatedAt(LocalDateTime.now());
        user.setUpdatedAt(LocalDateTime.now());
        return userPersistentPort.saveUser(user);
    }

    public void validateUser(User user) {
        validateNullFields(user);
        validateMatchesUser(user);
    }
    public void validateNullFields (User user){
        if (user.getName() == null) throw new UserException(CodeStatus.BAD_REQUEST, ErrorMessage.USER_NAME_NULL);
        if (user.getSurname() == null) throw new UserException(CodeStatus.BAD_REQUEST, ErrorMessage.USER_SURNAME_NULL);
        if (user.getEmail() == null) throw new UserException(CodeStatus.BAD_REQUEST, ErrorMessage.USER_EMAIL_NULL);
        if (user.getPassword() == null)
            throw new UserException(CodeStatus.BAD_REQUEST, ErrorMessage.USER_PASSWORD_NULL);
        if (user.getPhone() == null) throw new UserException(CodeStatus.BAD_REQUEST, ErrorMessage.USER_PHONE_NULL);
        if (user.getBirthDate() == null)
            throw new UserException(CodeStatus.BAD_REQUEST, ErrorMessage.USER_BIRTHDATE_NULL);

    }
    public void validateMatchesUser(User user){
        if (user.getName().length() < UserConstant.MIN_NAME_LENGTH
                || user.getName().length() > UserConstant.MAX_NAME_LENGTH)
            throw new UserException(CodeStatus.BAD_REQUEST, ErrorMessage.USER_NAME_LENGTH);
        if (user.getSurname().length() < UserConstant.MIN_NAME_LENGTH
                || user.getSurname().length() > UserConstant.MAX_NAME_LENGTH)
            throw new UserException(CodeStatus.BAD_REQUEST, ErrorMessage.USER_SURNAME_LENGTH);
        if (!user.getPhone().matches(UserConstant.REGEX_PHONE))
            throw new UserException(CodeStatus.BAD_REQUEST, ErrorMessage.USER_PHONE_NOT_VALID);
        if(!user.getEmail().matches(UserConstant.REGEX_EMAIL))
            throw  new UserException(CodeStatus.BAD_REQUEST, ErrorMessage.USER_EMAIL_NOT_VALID);
        if (user.getBirthDate().isAfter(LocalDate.now()))
            throw new UserException(CodeStatus.BAD_REQUEST, ErrorMessage.USER_BIRTHDATE_IS_FUTURE);
        if(!isAdult(user.getBirthDate())) throw new UserException(CodeStatus.BAD_REQUEST,ErrorMessage.USER_TOO_YOUNG);
    }
    public boolean isAdult(LocalDate birthdate) {
        Period age = Period.between(birthdate, LocalDate.now());
        return age.getYears() >= 18;
    }
}
