package edu.festu.ivankuznetsov.springsamplebo941pia.entity_security

import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import java.util.*
import java.util.function.Function
import java.util.function.Supplier
import java.util.stream.Collectors
import javax.persistence.*
import kotlin.math.exp

@Entity(name = "accounts")
class User(
    @Id
    var id: Long? = Random().nextLong(),
    @Column
    private var username: String,
    @Column
    private var password: String,
    @Column
    var isExpired: Boolean = false,
    @Column
    var isCredentialExpired: Boolean = false,
    @Column
    var isLocked: Boolean = false,
    @Column
    private var isEnabled: Boolean = true,
    @ManyToMany @JoinTable(
        name = "account_roles",
        joinColumns = [JoinColumn(name = "roleId")],
        inverseJoinColumns = [JoinColumn(name = "userId")]
    )
    var roles: MutableList<Role?> = mutableListOf(),
): UserDetails {

    override fun getAuthorities(): Collection<GrantedAuthority?>? {
        return roles.stream()
            .map { role: Role? -> GrantedAuthority { role?.roleName } }
            .collect( Collectors.toCollection { arrayListOf() } )
    }

    override fun getPassword(): String {
        return password
    }

    override fun getUsername(): String {
        return username
    }

    override fun isAccountNonExpired(): Boolean {
        return !isExpired
    }

    override fun isAccountNonLocked(): Boolean {
        return !isLocked
    }

    override fun isCredentialsNonExpired(): Boolean {
        return !isCredentialExpired
    }

    override fun isEnabled(): Boolean {
        return isEnabled
    }

}