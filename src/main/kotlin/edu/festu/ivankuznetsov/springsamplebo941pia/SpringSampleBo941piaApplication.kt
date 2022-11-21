package edu.festu.ivankuznetsov.springsamplebo941pia

import edu.festu.ivankuznetsov.springsamplebo941pia.entity_security.Role
import edu.festu.ivankuznetsov.springsamplebo941pia.entity_security.User
import edu.festu.ivankuznetsov.springsamplebo941pia.repository.RoleRepository
import edu.festu.ivankuznetsov.springsamplebo941pia.repository.UserRepository
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder

@SpringBootApplication
class SpringSampleBo941piaApplication(
    userRepository: UserRepository,
    repository: RoleRepository,
) {

    init {
        Companion.userRepository = userRepository
        Companion.repository = repository
    }
    companion object {
    var userRepository: UserRepository? = null
    var repository: RoleRepository? = null
}
}
    fun main(args: Array<String>) {
        runApplication<SpringSampleBo941piaApplication>(*args)

        SpringSampleBo941piaApplication.userRepository?.deleteAll()
        SpringSampleBo941piaApplication.repository?.deleteAll()

        val user = User(
            username = "admin",
            password = BCryptPasswordEncoder().encode("admin")
        )

        val role = Role(
            roleName = "ROLE_ADMIN"
        )

        SpringSampleBo941piaApplication.userRepository!!.save(user)
        SpringSampleBo941piaApplication.repository!!.save(role)

        user.roles.add(role)
        role.users.add(user)

        SpringSampleBo941piaApplication.userRepository!!.save(user)
        SpringSampleBo941piaApplication.repository!!.save(role)

    }


