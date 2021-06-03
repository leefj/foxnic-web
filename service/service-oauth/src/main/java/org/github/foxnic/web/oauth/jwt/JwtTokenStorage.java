package org.github.foxnic.web.oauth.jwt;

/**
 * jwt token storage
 *
 * @author 李方捷
 * @since  2021-06-02
 */
public interface JwtTokenStorage {


    /**
     * Put jwt token pair.
     *
     * @param jwtTokenPair the jwt token pair
     * @param userId       the user id
     * @return the jwt token pair
     */
    JwtTokenPair put(JwtTokenPair jwtTokenPair);


//    /**
//     * Expire.
//     *
//     * @param userId the user id
//     */
//    void expire(String userId);
//
//
//    /**
//     * Get jwt token pair.
//     *
//     * @param userId the user id
//     * @return the jwt token pair
//     */
//    JwtTokenPair get(String userId);

}
