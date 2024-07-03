package org.emmutua.beyondgrain.userManagement.token;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.emmutua.beyondgrain.userManagement.model.AppUser;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Token {
    @Id
    @SequenceGenerator(name = "token_sequence", sequenceName = "token_sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "token_sequence")
    private Long _id;
    private String token;
    private TokenType tokenType = TokenType.BEARER;
    public boolean revoked;
    public boolean expired;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id",referencedColumnName = "userId")
    public AppUser appUser;
}
