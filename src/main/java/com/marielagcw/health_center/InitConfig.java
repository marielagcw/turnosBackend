package com.marielagcw.health_center;

import com.marielagcw.health_center.model.entity.Rol;
import com.marielagcw.health_center.model.entity.User;
import com.marielagcw.health_center.repository.IUserRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class InitConfig implements ApplicationRunner {

    private final IUserRepository repo;

    public InitConfig(IUserRepository repo) {
        this.repo = repo;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        User user = new User();
        user.setName("username");
        user.setPassword("password");
        Rol rol = new Rol();
        rol.setName("USER");
        rol.setId(1L);
        user.setRoles(Set.of(rol));
        repo.save(user);
    }
}
