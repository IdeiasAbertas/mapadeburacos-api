package ao.co.mapaDeBuraco.config.security;

import ao.co.mapaDeBuraco.model.Admin;
import ao.co.mapaDeBuraco.repositories.AdminRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class UserDetailsServiceImpl implements UserDetailsService {


    final AdminRepository adminRepository;

    public UserDetailsServiceImpl(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       Admin admin = adminRepository.findByUserName(username)
                .orElseThrow(()->new UsernameNotFoundException("User Not Found: " + username));

         return
                 new User(admin.getUsername(), admin.getPassword()
                         ,true,true,true
                         ,true, admin.getAuthorities());
    }
}
