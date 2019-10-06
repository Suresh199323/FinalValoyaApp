/*
package com.valoya.login.login.Entity;

import com.valoya.login.login.domain.type.RoleEnum;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
    @Entity
    @Table(name = "role")
    @Cacheable
    @Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
    public class Role extends Perpetual {
        public static final String ROLE_USER = RoleEnum.ROLE_USER.getCode();
        public static final String ROLE_ADMIN = RoleEnum.ROLE_ADMIN.getCode();
        public static final String ROLE_SUPER_ADMIN = RoleEnum.ROLE_SUPER_ADMIN.getCode();

        private static final long serialVersionUID = 1L;

        @Column(nullable = false)
        @Access(AccessType.FIELD)
        @NaturalId
        private RoleEnum role;

        protected Role() {
        }

        public Role(final RoleEnum role) {
            this.role = role;
        }

        public RoleEnum getRole() {
            return role;
        }

        @Override
        public String toString() {
            return role.name();
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = super.hashCode();
            result = prime * result + ((role == null) ? 0 : role.hashCode());
            return result;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!super.equals(obj)) {
                return false;
            }
            if (getClass() != obj.getClass()) {
                return false;
            }
            Role other = (Role) obj;
            if (role == null) {
                if (other.role != null) {
                    return false;
                }
            } else if (!role.equals(other.role)) {
                return false;
            }
            return true;
        }
    }


*/
