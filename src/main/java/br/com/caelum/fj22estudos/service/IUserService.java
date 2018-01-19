package br.com.caelum.fj22estudos.service;


import br.com.caelum.fj22estudos.model.User;

public interface IUserService {
    public User findUserByEmail(String email);
    public void saveUser(User user);
}