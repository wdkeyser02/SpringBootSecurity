package willydekeyser.model;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import lombok.Singular;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "USERS")
public class Users {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@NonNull
	@Column(unique = true)
	private String username;
	@NonNull
	private String password;

	@Singular
	@ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
	@JoinTable(name = "users_authorities", joinColumns = {
			@JoinColumn(name = "USERS_ID", referencedColumnName = "ID") }, inverseJoinColumns = {
					@JoinColumn(name = "AUTHORITIES_ID", referencedColumnName = "ID") })
	private Set<Authorities> authorities;

	@Builder.Default
	private Boolean accountNonExpired = true;
	@Builder.Default
	private Boolean accountNonLocked = true;
	@Builder.Default
	private Boolean credentialsNonExpired = true;
	@Builder.Default
	private Boolean enabled = true;

	public Users(@NonNull String username, @NonNull String password, Set<Authorities> authorities,
			Boolean accountNonExpired, Boolean accountNonLocked, Boolean credentialsNonExpired, Boolean enabled) {
		super();
		this.username = username;
		this.password = password;
		this.authorities = authorities;
		this.accountNonExpired = accountNonExpired;
		this.accountNonLocked = accountNonLocked;
		this.credentialsNonExpired = credentialsNonExpired;
		this.enabled = enabled;
	}

	public Users(@NonNull String username, @NonNull String password, Boolean accountNonExpired,
			Boolean accountNonLocked, Boolean credentialsNonExpired, Boolean enabled) {
		super();
		this.username = username;
		this.password = password;
		this.accountNonExpired = accountNonExpired;
		this.accountNonLocked = accountNonLocked;
		this.credentialsNonExpired = credentialsNonExpired;
		this.enabled = enabled;
	}
}
