package org.emmutua.beyondgrain.userManagement.token;

import lombok.Builder;
import lombok.Data;
import org.bson.types.ObjectId;
import org.emmutua.beyondgrain.userManagement.model.AppUser;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
@Builder
public class Token {
    private ObjectId _id;
    private String token;
    private TokenType tokenType = TokenType.BEARER;
    public boolean revoked;
    public boolean expired;
    @DBRef(lazy = true)
    public AppUser appUser;
}
