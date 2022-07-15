package org.example.security;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashMap;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PayloadToken {
    private Long userId;
    private String userType;

    public HashMap<String, Object> toHashMap() {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("userId", getUserId());
        hashMap.put("userType", getUserType());
        return hashMap;
    }

    public static PayloadToken fromHashMap(HashMap<String, Object> hashMap) {
        return new PayloadToken(
                Long.parseLong(String.valueOf(hashMap.get("userId"))),
                String.valueOf(hashMap.get("userType"))
        );
    }
}
