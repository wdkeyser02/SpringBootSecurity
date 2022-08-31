package willydekeyser.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import willydekeyser.model.Users;
import willydekeyser.repository.UsersRepository;

@Service
@Transactional
public class UsersServiceImpl implements UsersService {

	@Autowired
	private UsersRepository usersRepository;
	
	@Override
	public List<Users> usersLijst() {
		return usersRepository.findAll();
	}

}