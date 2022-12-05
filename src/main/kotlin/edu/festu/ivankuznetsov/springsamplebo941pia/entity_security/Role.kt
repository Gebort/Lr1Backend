package edu.festu.ivankuznetsov.springsamplebo941pia.entity_security

import javax.persistence.*

@Entity(name = "roles")
class Role(
    @Id
    var roleName: String,
    @ManyToMany @JoinTable(
        name = "account_roles",
        joinColumns = [JoinColumn(name = "userId")],
        inverseJoinColumns = [JoinColumn(name = "roleId")]
    )
    var users: MutableList<User?> = mutableListOf()

)

